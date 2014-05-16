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
import jpa.entities.EquipoRespuesta;
import jpa.entities.Roles;
import jpa.entities.Personal;
import jpa.entities.Zonas;

/**
 *
 * @author Adrian
 */
public class EquipoRespuestaJpaController implements Serializable {

    public EquipoRespuestaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EquipoRespuesta equipoRespuesta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Roles idRol = equipoRespuesta.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getIdRol());
                equipoRespuesta.setIdRol(idRol);
            }
            Personal idPersonal = equipoRespuesta.getIdPersonal();
            if (idPersonal != null) {
                idPersonal = em.getReference(idPersonal.getClass(), idPersonal.getIdPersonal());
                equipoRespuesta.setIdPersonal(idPersonal);
            }
            Zonas idZona = equipoRespuesta.getIdZona();
            if (idZona != null) {
                idZona = em.getReference(idZona.getClass(), idZona.getIdZona());
                equipoRespuesta.setIdZona(idZona);
            }
            em.persist(equipoRespuesta);
            if (idRol != null) {
                idRol.getEquipoRespuestaCollection().add(equipoRespuesta);
                idRol = em.merge(idRol);
            }
            if (idPersonal != null) {
                idPersonal.getEquipoRespuestaCollection().add(equipoRespuesta);
                idPersonal = em.merge(idPersonal);
            }
            if (idZona != null) {
                idZona.getEquipoRespuestaCollection().add(equipoRespuesta);
                idZona = em.merge(idZona);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEquipoRespuesta(equipoRespuesta.getIdEquipoRespuesta()) != null) {
                throw new PreexistingEntityException("EquipoRespuesta " + equipoRespuesta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EquipoRespuesta equipoRespuesta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EquipoRespuesta persistentEquipoRespuesta = em.find(EquipoRespuesta.class, equipoRespuesta.getIdEquipoRespuesta());
            Roles idRolOld = persistentEquipoRespuesta.getIdRol();
            Roles idRolNew = equipoRespuesta.getIdRol();
            Personal idPersonalOld = persistentEquipoRespuesta.getIdPersonal();
            Personal idPersonalNew = equipoRespuesta.getIdPersonal();
            Zonas idZonaOld = persistentEquipoRespuesta.getIdZona();
            Zonas idZonaNew = equipoRespuesta.getIdZona();
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getIdRol());
                equipoRespuesta.setIdRol(idRolNew);
            }
            if (idPersonalNew != null) {
                idPersonalNew = em.getReference(idPersonalNew.getClass(), idPersonalNew.getIdPersonal());
                equipoRespuesta.setIdPersonal(idPersonalNew);
            }
            if (idZonaNew != null) {
                idZonaNew = em.getReference(idZonaNew.getClass(), idZonaNew.getIdZona());
                equipoRespuesta.setIdZona(idZonaNew);
            }
            equipoRespuesta = em.merge(equipoRespuesta);
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getEquipoRespuestaCollection().remove(equipoRespuesta);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getEquipoRespuestaCollection().add(equipoRespuesta);
                idRolNew = em.merge(idRolNew);
            }
            if (idPersonalOld != null && !idPersonalOld.equals(idPersonalNew)) {
                idPersonalOld.getEquipoRespuestaCollection().remove(equipoRespuesta);
                idPersonalOld = em.merge(idPersonalOld);
            }
            if (idPersonalNew != null && !idPersonalNew.equals(idPersonalOld)) {
                idPersonalNew.getEquipoRespuestaCollection().add(equipoRespuesta);
                idPersonalNew = em.merge(idPersonalNew);
            }
            if (idZonaOld != null && !idZonaOld.equals(idZonaNew)) {
                idZonaOld.getEquipoRespuestaCollection().remove(equipoRespuesta);
                idZonaOld = em.merge(idZonaOld);
            }
            if (idZonaNew != null && !idZonaNew.equals(idZonaOld)) {
                idZonaNew.getEquipoRespuestaCollection().add(equipoRespuesta);
                idZonaNew = em.merge(idZonaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = equipoRespuesta.getIdEquipoRespuesta();
                if (findEquipoRespuesta(id) == null) {
                    throw new NonexistentEntityException("The equipoRespuesta with id " + id + " no longer exists.");
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
            EquipoRespuesta equipoRespuesta;
            try {
                equipoRespuesta = em.getReference(EquipoRespuesta.class, id);
                equipoRespuesta.getIdEquipoRespuesta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipoRespuesta with id " + id + " no longer exists.", enfe);
            }
            Roles idRol = equipoRespuesta.getIdRol();
            if (idRol != null) {
                idRol.getEquipoRespuestaCollection().remove(equipoRespuesta);
                idRol = em.merge(idRol);
            }
            Personal idPersonal = equipoRespuesta.getIdPersonal();
            if (idPersonal != null) {
                idPersonal.getEquipoRespuestaCollection().remove(equipoRespuesta);
                idPersonal = em.merge(idPersonal);
            }
            Zonas idZona = equipoRespuesta.getIdZona();
            if (idZona != null) {
                idZona.getEquipoRespuestaCollection().remove(equipoRespuesta);
                idZona = em.merge(idZona);
            }
            em.remove(equipoRespuesta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EquipoRespuesta> findEquipoRespuestaEntities() {
        return findEquipoRespuestaEntities(true, -1, -1);
    }

    public List<EquipoRespuesta> findEquipoRespuestaEntities(int maxResults, int firstResult) {
        return findEquipoRespuestaEntities(false, maxResults, firstResult);
    }

    private List<EquipoRespuesta> findEquipoRespuestaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EquipoRespuesta.class));
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

    public EquipoRespuesta findEquipoRespuesta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EquipoRespuesta.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipoRespuestaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EquipoRespuesta> rt = cq.from(EquipoRespuesta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
