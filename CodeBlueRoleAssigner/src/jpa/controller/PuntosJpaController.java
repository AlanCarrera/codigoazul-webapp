/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.controller.exceptions.NonexistentEntityException;
import jpa.controller.exceptions.PreexistingEntityException;
import jpa.entities.Areas;
import jpa.entities.Puntos;

/**
 *
 * @author Adrian
 */
public class PuntosJpaController implements Serializable {

    public PuntosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Puntos puntos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Areas idArea = puntos.getIdArea();
            if (idArea != null) {
                idArea = em.getReference(idArea.getClass(), idArea.getIdArea());
                puntos.setIdArea(idArea);
            }
            em.persist(puntos);
            if (idArea != null) {
                idArea.getPuntosCollection().add(puntos);
                idArea = em.merge(idArea);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPuntos(puntos.getIdPunto()) != null) {
                throw new PreexistingEntityException("Puntos " + puntos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Puntos puntos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puntos persistentPuntos = em.find(Puntos.class, puntos.getIdPunto());
            Areas idAreaOld = persistentPuntos.getIdArea();
            Areas idAreaNew = puntos.getIdArea();
            if (idAreaNew != null) {
                idAreaNew = em.getReference(idAreaNew.getClass(), idAreaNew.getIdArea());
                puntos.setIdArea(idAreaNew);
            }
            puntos = em.merge(puntos);
            if (idAreaOld != null && !idAreaOld.equals(idAreaNew)) {
                idAreaOld.getPuntosCollection().remove(puntos);
                idAreaOld = em.merge(idAreaOld);
            }
            if (idAreaNew != null && !idAreaNew.equals(idAreaOld)) {
                idAreaNew.getPuntosCollection().add(puntos);
                idAreaNew = em.merge(idAreaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = puntos.getIdPunto();
                if (findPuntos(id) == null) {
                    throw new NonexistentEntityException("The puntos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puntos puntos;
            try {
                puntos = em.getReference(Puntos.class, id);
                puntos.getIdPunto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The puntos with id " + id + " no longer exists.", enfe);
            }
            Areas idArea = puntos.getIdArea();
            if (idArea != null) {
                idArea.getPuntosCollection().remove(puntos);
                idArea = em.merge(idArea);
            }
            em.remove(puntos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Puntos> findPuntosEntities() {
        return findPuntosEntities(true, -1, -1);
    }

    public List<Puntos> findPuntosEntities(int maxResults, int firstResult) {
        return findPuntosEntities(false, maxResults, firstResult);
    }

    private List<Puntos> findPuntosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Puntos.class));
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

    public Puntos findPuntos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Puntos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPuntosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Puntos> rt = cq.from(Puntos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
