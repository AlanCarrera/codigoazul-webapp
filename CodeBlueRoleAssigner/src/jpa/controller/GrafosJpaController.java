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
import jpa.entities.Grafos;
import jpa.entities.Zonas;

/**
 *
 * @author Adrian
 */
public class GrafosJpaController implements Serializable {

    public GrafosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Grafos grafos) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Zonas idZonaDest = grafos.getIdZonaDest();
            if (idZonaDest != null) {
                idZonaDest = em.getReference(idZonaDest.getClass(), idZonaDest.getIdZona());
                grafos.setIdZonaDest(idZonaDest);
            }
            Zonas idZonaOrig = grafos.getIdZonaOrig();
            if (idZonaOrig != null) {
                idZonaOrig = em.getReference(idZonaOrig.getClass(), idZonaOrig.getIdZona());
                grafos.setIdZonaOrig(idZonaOrig);
            }
            em.persist(grafos);
            if (idZonaDest != null) {
                idZonaDest.getGrafosCollection().add(grafos);
                idZonaDest = em.merge(idZonaDest);
            }
            if (idZonaOrig != null) {
                idZonaOrig.getGrafosCollection().add(grafos);
                idZonaOrig = em.merge(idZonaOrig);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGrafos(grafos.getIdGrafo()) != null) {
                throw new PreexistingEntityException("Grafos " + grafos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Grafos grafos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Grafos persistentGrafos = em.find(Grafos.class, grafos.getIdGrafo());
            Zonas idZonaDestOld = persistentGrafos.getIdZonaDest();
            Zonas idZonaDestNew = grafos.getIdZonaDest();
            Zonas idZonaOrigOld = persistentGrafos.getIdZonaOrig();
            Zonas idZonaOrigNew = grafos.getIdZonaOrig();
            if (idZonaDestNew != null) {
                idZonaDestNew = em.getReference(idZonaDestNew.getClass(), idZonaDestNew.getIdZona());
                grafos.setIdZonaDest(idZonaDestNew);
            }
            if (idZonaOrigNew != null) {
                idZonaOrigNew = em.getReference(idZonaOrigNew.getClass(), idZonaOrigNew.getIdZona());
                grafos.setIdZonaOrig(idZonaOrigNew);
            }
            grafos = em.merge(grafos);
            if (idZonaDestOld != null && !idZonaDestOld.equals(idZonaDestNew)) {
                idZonaDestOld.getGrafosCollection().remove(grafos);
                idZonaDestOld = em.merge(idZonaDestOld);
            }
            if (idZonaDestNew != null && !idZonaDestNew.equals(idZonaDestOld)) {
                idZonaDestNew.getGrafosCollection().add(grafos);
                idZonaDestNew = em.merge(idZonaDestNew);
            }
            if (idZonaOrigOld != null && !idZonaOrigOld.equals(idZonaOrigNew)) {
                idZonaOrigOld.getGrafosCollection().remove(grafos);
                idZonaOrigOld = em.merge(idZonaOrigOld);
            }
            if (idZonaOrigNew != null && !idZonaOrigNew.equals(idZonaOrigOld)) {
                idZonaOrigNew.getGrafosCollection().add(grafos);
                idZonaOrigNew = em.merge(idZonaOrigNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = grafos.getIdGrafo();
                if (findGrafos(id) == null) {
                    throw new NonexistentEntityException("The grafos with id " + id + " no longer exists.");
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
            Grafos grafos;
            try {
                grafos = em.getReference(Grafos.class, id);
                grafos.getIdGrafo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grafos with id " + id + " no longer exists.", enfe);
            }
            Zonas idZonaDest = grafos.getIdZonaDest();
            if (idZonaDest != null) {
                idZonaDest.getGrafosCollection().remove(grafos);
                idZonaDest = em.merge(idZonaDest);
            }
            Zonas idZonaOrig = grafos.getIdZonaOrig();
            if (idZonaOrig != null) {
                idZonaOrig.getGrafosCollection().remove(grafos);
                idZonaOrig = em.merge(idZonaOrig);
            }
            em.remove(grafos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Grafos> findGrafosEntities() {
        return findGrafosEntities(true, -1, -1);
    }

    public List<Grafos> findGrafosEntities(int maxResults, int firstResult) {
        return findGrafosEntities(false, maxResults, firstResult);
    }

    private List<Grafos> findGrafosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Grafos.class));
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

    public Grafos findGrafos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Grafos.class, id);
        } finally {
            em.close();
        }
    }

    public int getGrafosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Grafos> rt = cq.from(Grafos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
