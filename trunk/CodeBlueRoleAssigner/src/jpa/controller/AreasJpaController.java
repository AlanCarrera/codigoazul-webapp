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
import jpa.entities.Puntos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.controller.exceptions.IllegalOrphanException;
import jpa.controller.exceptions.NonexistentEntityException;
import jpa.controller.exceptions.PreexistingEntityException;
import jpa.entities.Areas;
import jpa.entities.Zonas;

/**
 *
 * @author Adrian
 */
public class AreasJpaController implements Serializable {

    public AreasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Areas areas) throws PreexistingEntityException, Exception {
        if (areas.getPuntosCollection() == null) {
            areas.setPuntosCollection(new ArrayList<Puntos>());
        }
        if (areas.getZonasCollection() == null) {
            areas.setZonasCollection(new ArrayList<Zonas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Puntos> attachedPuntosCollection = new ArrayList<Puntos>();
            for (Puntos puntosCollectionPuntosToAttach : areas.getPuntosCollection()) {
                puntosCollectionPuntosToAttach = em.getReference(puntosCollectionPuntosToAttach.getClass(), puntosCollectionPuntosToAttach.getIdPunto());
                attachedPuntosCollection.add(puntosCollectionPuntosToAttach);
            }
            areas.setPuntosCollection(attachedPuntosCollection);
            Collection<Zonas> attachedZonasCollection = new ArrayList<Zonas>();
            for (Zonas zonasCollectionZonasToAttach : areas.getZonasCollection()) {
                zonasCollectionZonasToAttach = em.getReference(zonasCollectionZonasToAttach.getClass(), zonasCollectionZonasToAttach.getIdZona());
                attachedZonasCollection.add(zonasCollectionZonasToAttach);
            }
            areas.setZonasCollection(attachedZonasCollection);
            em.persist(areas);
            for (Puntos puntosCollectionPuntos : areas.getPuntosCollection()) {
                Areas oldIdAreaOfPuntosCollectionPuntos = puntosCollectionPuntos.getIdArea();
                puntosCollectionPuntos.setIdArea(areas);
                puntosCollectionPuntos = em.merge(puntosCollectionPuntos);
                if (oldIdAreaOfPuntosCollectionPuntos != null) {
                    oldIdAreaOfPuntosCollectionPuntos.getPuntosCollection().remove(puntosCollectionPuntos);
                    oldIdAreaOfPuntosCollectionPuntos = em.merge(oldIdAreaOfPuntosCollectionPuntos);
                }
            }
            for (Zonas zonasCollectionZonas : areas.getZonasCollection()) {
                Areas oldIdAreaOfZonasCollectionZonas = zonasCollectionZonas.getIdArea();
                zonasCollectionZonas.setIdArea(areas);
                zonasCollectionZonas = em.merge(zonasCollectionZonas);
                if (oldIdAreaOfZonasCollectionZonas != null) {
                    oldIdAreaOfZonasCollectionZonas.getZonasCollection().remove(zonasCollectionZonas);
                    oldIdAreaOfZonasCollectionZonas = em.merge(oldIdAreaOfZonasCollectionZonas);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAreas(areas.getIdArea()) != null) {
                throw new PreexistingEntityException("Areas " + areas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Areas areas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Areas persistentAreas = em.find(Areas.class, areas.getIdArea());
            Collection<Puntos> puntosCollectionOld = persistentAreas.getPuntosCollection();
            Collection<Puntos> puntosCollectionNew = areas.getPuntosCollection();
            Collection<Zonas> zonasCollectionOld = persistentAreas.getZonasCollection();
            Collection<Zonas> zonasCollectionNew = areas.getZonasCollection();
            List<String> illegalOrphanMessages = null;
            for (Puntos puntosCollectionOldPuntos : puntosCollectionOld) {
                if (!puntosCollectionNew.contains(puntosCollectionOldPuntos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Puntos " + puntosCollectionOldPuntos + " since its idArea field is not nullable.");
                }
            }
            for (Zonas zonasCollectionOldZonas : zonasCollectionOld) {
                if (!zonasCollectionNew.contains(zonasCollectionOldZonas)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Zonas " + zonasCollectionOldZonas + " since its idArea field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Puntos> attachedPuntosCollectionNew = new ArrayList<Puntos>();
            for (Puntos puntosCollectionNewPuntosToAttach : puntosCollectionNew) {
                puntosCollectionNewPuntosToAttach = em.getReference(puntosCollectionNewPuntosToAttach.getClass(), puntosCollectionNewPuntosToAttach.getIdPunto());
                attachedPuntosCollectionNew.add(puntosCollectionNewPuntosToAttach);
            }
            puntosCollectionNew = attachedPuntosCollectionNew;
            areas.setPuntosCollection(puntosCollectionNew);
            Collection<Zonas> attachedZonasCollectionNew = new ArrayList<Zonas>();
            for (Zonas zonasCollectionNewZonasToAttach : zonasCollectionNew) {
                zonasCollectionNewZonasToAttach = em.getReference(zonasCollectionNewZonasToAttach.getClass(), zonasCollectionNewZonasToAttach.getIdZona());
                attachedZonasCollectionNew.add(zonasCollectionNewZonasToAttach);
            }
            zonasCollectionNew = attachedZonasCollectionNew;
            areas.setZonasCollection(zonasCollectionNew);
            areas = em.merge(areas);
            for (Puntos puntosCollectionNewPuntos : puntosCollectionNew) {
                if (!puntosCollectionOld.contains(puntosCollectionNewPuntos)) {
                    Areas oldIdAreaOfPuntosCollectionNewPuntos = puntosCollectionNewPuntos.getIdArea();
                    puntosCollectionNewPuntos.setIdArea(areas);
                    puntosCollectionNewPuntos = em.merge(puntosCollectionNewPuntos);
                    if (oldIdAreaOfPuntosCollectionNewPuntos != null && !oldIdAreaOfPuntosCollectionNewPuntos.equals(areas)) {
                        oldIdAreaOfPuntosCollectionNewPuntos.getPuntosCollection().remove(puntosCollectionNewPuntos);
                        oldIdAreaOfPuntosCollectionNewPuntos = em.merge(oldIdAreaOfPuntosCollectionNewPuntos);
                    }
                }
            }
            for (Zonas zonasCollectionNewZonas : zonasCollectionNew) {
                if (!zonasCollectionOld.contains(zonasCollectionNewZonas)) {
                    Areas oldIdAreaOfZonasCollectionNewZonas = zonasCollectionNewZonas.getIdArea();
                    zonasCollectionNewZonas.setIdArea(areas);
                    zonasCollectionNewZonas = em.merge(zonasCollectionNewZonas);
                    if (oldIdAreaOfZonasCollectionNewZonas != null && !oldIdAreaOfZonasCollectionNewZonas.equals(areas)) {
                        oldIdAreaOfZonasCollectionNewZonas.getZonasCollection().remove(zonasCollectionNewZonas);
                        oldIdAreaOfZonasCollectionNewZonas = em.merge(oldIdAreaOfZonasCollectionNewZonas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = areas.getIdArea();
                if (findAreas(id) == null) {
                    throw new NonexistentEntityException("The areas with id " + id + " no longer exists.");
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
            Areas areas;
            try {
                areas = em.getReference(Areas.class, id);
                areas.getIdArea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The areas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Puntos> puntosCollectionOrphanCheck = areas.getPuntosCollection();
            for (Puntos puntosCollectionOrphanCheckPuntos : puntosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Areas (" + areas + ") cannot be destroyed since the Puntos " + puntosCollectionOrphanCheckPuntos + " in its puntosCollection field has a non-nullable idArea field.");
            }
            Collection<Zonas> zonasCollectionOrphanCheck = areas.getZonasCollection();
            for (Zonas zonasCollectionOrphanCheckZonas : zonasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Areas (" + areas + ") cannot be destroyed since the Zonas " + zonasCollectionOrphanCheckZonas + " in its zonasCollection field has a non-nullable idArea field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(areas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Areas> findAreasEntities() {
        return findAreasEntities(true, -1, -1);
    }

    public List<Areas> findAreasEntities(int maxResults, int firstResult) {
        return findAreasEntities(false, maxResults, firstResult);
    }

    private List<Areas> findAreasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Areas.class));
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

    public Areas findAreas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Areas.class, id);
        } finally {
            em.close();
        }
    }

    public int getAreasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Areas> rt = cq.from(Areas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
