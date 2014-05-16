/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.entities.Personal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.controller.exceptions.IllegalOrphanException;
import jpa.controller.exceptions.NonexistentEntityException;
import jpa.controller.exceptions.PreexistingEntityException;
import jpa.entities.Puestos;

/**
 *
 * @author Adrian
 */
public class PuestosJpaController implements Serializable {

    public PuestosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puestos puestos) throws PreexistingEntityException, Exception {
        if (puestos.getPersonalCollection() == null) {
            puestos.setPersonalCollection(new ArrayList<Personal>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Personal> attachedPersonalCollection = new ArrayList<Personal>();
            for (Personal personalCollectionPersonalToAttach : puestos.getPersonalCollection()) {
                personalCollectionPersonalToAttach = em.getReference(personalCollectionPersonalToAttach.getClass(), personalCollectionPersonalToAttach.getIdPersonal());
                attachedPersonalCollection.add(personalCollectionPersonalToAttach);
            }
            puestos.setPersonalCollection(attachedPersonalCollection);
            em.persist(puestos);
            for (Personal personalCollectionPersonal : puestos.getPersonalCollection()) {
                Puestos oldIdPuestoOfPersonalCollectionPersonal = personalCollectionPersonal.getIdPuesto();
                personalCollectionPersonal.setIdPuesto(puestos);
                personalCollectionPersonal = em.merge(personalCollectionPersonal);
                if (oldIdPuestoOfPersonalCollectionPersonal != null) {
                    oldIdPuestoOfPersonalCollectionPersonal.getPersonalCollection().remove(personalCollectionPersonal);
                    oldIdPuestoOfPersonalCollectionPersonal = em.merge(oldIdPuestoOfPersonalCollectionPersonal);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPuestos(puestos.getIdPuesto()) != null) {
                throw new PreexistingEntityException("Puestos " + puestos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puestos puestos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puestos persistentPuestos = em.find(Puestos.class, puestos.getIdPuesto());
            Collection<Personal> personalCollectionOld = persistentPuestos.getPersonalCollection();
            Collection<Personal> personalCollectionNew = puestos.getPersonalCollection();
            List<String> illegalOrphanMessages = null;
            for (Personal personalCollectionOldPersonal : personalCollectionOld) {
                if (!personalCollectionNew.contains(personalCollectionOldPersonal)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Personal " + personalCollectionOldPersonal + " since its idPuesto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Personal> attachedPersonalCollectionNew = new ArrayList<Personal>();
            for (Personal personalCollectionNewPersonalToAttach : personalCollectionNew) {
                personalCollectionNewPersonalToAttach = em.getReference(personalCollectionNewPersonalToAttach.getClass(), personalCollectionNewPersonalToAttach.getIdPersonal());
                attachedPersonalCollectionNew.add(personalCollectionNewPersonalToAttach);
            }
            personalCollectionNew = attachedPersonalCollectionNew;
            puestos.setPersonalCollection(personalCollectionNew);
            puestos = em.merge(puestos);
            for (Personal personalCollectionNewPersonal : personalCollectionNew) {
                if (!personalCollectionOld.contains(personalCollectionNewPersonal)) {
                    Puestos oldIdPuestoOfPersonalCollectionNewPersonal = personalCollectionNewPersonal.getIdPuesto();
                    personalCollectionNewPersonal.setIdPuesto(puestos);
                    personalCollectionNewPersonal = em.merge(personalCollectionNewPersonal);
                    if (oldIdPuestoOfPersonalCollectionNewPersonal != null && !oldIdPuestoOfPersonalCollectionNewPersonal.equals(puestos)) {
                        oldIdPuestoOfPersonalCollectionNewPersonal.getPersonalCollection().remove(personalCollectionNewPersonal);
                        oldIdPuestoOfPersonalCollectionNewPersonal = em.merge(oldIdPuestoOfPersonalCollectionNewPersonal);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = puestos.getIdPuesto();
                if (findPuestos(id) == null) {
                    throw new NonexistentEntityException("The puestos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puestos puestos;
            try {
                puestos = em.getReference(Puestos.class, id);
                puestos.getIdPuesto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puestos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Personal> personalCollectionOrphanCheck = puestos.getPersonalCollection();
            for (Personal personalCollectionOrphanCheckPersonal : personalCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Puestos (" + puestos + ") cannot be destroyed since the Personal " + personalCollectionOrphanCheckPersonal + " in its personalCollection field has a non-nullable idPuesto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(puestos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Puestos> findPuestosEntities() {
        return findPuestosEntities(true, -1, -1);
    }

    public List<Puestos> findPuestosEntities(int maxResults, int firstResult) {
        return findPuestosEntities(false, maxResults, firstResult);
    }

    private List<Puestos> findPuestosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Puestos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Puestos findPuestos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puestos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuestosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Puestos> rt = cq.from(Puestos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
