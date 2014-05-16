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
import jpa.entities.EquipoBase;
import jpa.entities.Roles;
import jpa.entities.Personal;
import jpa.entities.Zonas;

/**
 *
 * @author Adrian
 */
public class EquipoBaseJpaController implements Serializable {

    public EquipoBaseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EquipoBase equipoBase) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Roles idRol = equipoBase.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getIdRol());
                equipoBase.setIdRol(idRol);
            }
            Personal idPersonal = equipoBase.getIdPersonal();
            if (idPersonal != null) {
                idPersonal = em.getReference(idPersonal.getClass(), idPersonal.getIdPersonal());
                equipoBase.setIdPersonal(idPersonal);
            }
            Zonas idZona = equipoBase.getIdZona();
            if (idZona != null) {
                idZona = em.getReference(idZona.getClass(), idZona.getIdZona());
                equipoBase.setIdZona(idZona);
            }
            em.persist(equipoBase);
            if (idRol != null) {
                idRol.getEquipoBaseCollection().add(equipoBase);
                idRol = em.merge(idRol);
            }
            if (idPersonal != null) {
                idPersonal.getEquipoBaseCollection().add(equipoBase);
                idPersonal = em.merge(idPersonal);
            }
            if (idZona != null) {
                idZona.getEquipoBaseCollection().add(equipoBase);
                idZona = em.merge(idZona);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEquipoBase(equipoBase.getIdEquipoBase()) != null) {
                throw new PreexistingEntityException("EquipoBase " + equipoBase + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EquipoBase equipoBase) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EquipoBase persistentEquipoBase = em.find(EquipoBase.class, equipoBase.getIdEquipoBase());
            Roles idRolOld = persistentEquipoBase.getIdRol();
            Roles idRolNew = equipoBase.getIdRol();
            Personal idPersonalOld = persistentEquipoBase.getIdPersonal();
            Personal idPersonalNew = equipoBase.getIdPersonal();
            Zonas idZonaOld = persistentEquipoBase.getIdZona();
            Zonas idZonaNew = equipoBase.getIdZona();
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getIdRol());
                equipoBase.setIdRol(idRolNew);
            }
            if (idPersonalNew != null) {
                idPersonalNew = em.getReference(idPersonalNew.getClass(), idPersonalNew.getIdPersonal());
                equipoBase.setIdPersonal(idPersonalNew);
            }
            if (idZonaNew != null) {
                idZonaNew = em.getReference(idZonaNew.getClass(), idZonaNew.getIdZona());
                equipoBase.setIdZona(idZonaNew);
            }
            equipoBase = em.merge(equipoBase);
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getEquipoBaseCollection().remove(equipoBase);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getEquipoBaseCollection().add(equipoBase);
                idRolNew = em.merge(idRolNew);
            }
            if (idPersonalOld != null && !idPersonalOld.equals(idPersonalNew)) {
                idPersonalOld.getEquipoBaseCollection().remove(equipoBase);
                idPersonalOld = em.merge(idPersonalOld);
            }
            if (idPersonalNew != null && !idPersonalNew.equals(idPersonalOld)) {
                idPersonalNew.getEquipoBaseCollection().add(equipoBase);
                idPersonalNew = em.merge(idPersonalNew);
            }
            if (idZonaOld != null && !idZonaOld.equals(idZonaNew)) {
                idZonaOld.getEquipoBaseCollection().remove(equipoBase);
                idZonaOld = em.merge(idZonaOld);
            }
            if (idZonaNew != null && !idZonaNew.equals(idZonaOld)) {
                idZonaNew.getEquipoBaseCollection().add(equipoBase);
                idZonaNew = em.merge(idZonaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = equipoBase.getIdEquipoBase();
                if (findEquipoBase(id) == null) {
                    throw new NonexistentEntityException("The equipoBase with id " + id + " no longer exists.");
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
            EquipoBase equipoBase;
            try {
                equipoBase = em.getReference(EquipoBase.class, id);
                equipoBase.getIdEquipoBase();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The equipoBase with id " + id + " no longer exists.", enfe);
            }
            Roles idRol = equipoBase.getIdRol();
            if (idRol != null) {
                idRol.getEquipoBaseCollection().remove(equipoBase);
                idRol = em.merge(idRol);
            }
            Personal idPersonal = equipoBase.getIdPersonal();
            if (idPersonal != null) {
                idPersonal.getEquipoBaseCollection().remove(equipoBase);
                idPersonal = em.merge(idPersonal);
            }
            Zonas idZona = equipoBase.getIdZona();
            if (idZona != null) {
                idZona.getEquipoBaseCollection().remove(equipoBase);
                idZona = em.merge(idZona);
            }
            em.remove(equipoBase);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EquipoBase> findEquipoBaseEntities() {
        return findEquipoBaseEntities(true, -1, -1);
    }

    public List<EquipoBase> findEquipoBaseEntities(int maxResults, int firstResult) {
        return findEquipoBaseEntities(false, maxResults, firstResult);
    }

    private List<EquipoBase> findEquipoBaseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EquipoBase.class));
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

    public EquipoBase findEquipoBase(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EquipoBase.class, id);
        } finally {
            em.close();
        }
    }

    public int getEquipoBaseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EquipoBase> rt = cq.from(EquipoBase.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
