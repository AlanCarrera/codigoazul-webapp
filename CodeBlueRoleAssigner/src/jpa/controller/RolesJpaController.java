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
import jpa.entities.EquipoRespuesta;
import jpa.entities.EquipoBase;
import jpa.entities.Roles;

/**
 *
 * @author Adrian
 */
public class RolesJpaController implements Serializable {

    public RolesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Roles roles) throws PreexistingEntityException, Exception {
        if (roles.getPersonalCollection() == null) {
            roles.setPersonalCollection(new ArrayList<Personal>());
        }
        if (roles.getEquipoRespuestaCollection() == null) {
            roles.setEquipoRespuestaCollection(new ArrayList<EquipoRespuesta>());
        }
        if (roles.getEquipoBaseCollection() == null) {
            roles.setEquipoBaseCollection(new ArrayList<EquipoBase>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Personal> attachedPersonalCollection = new ArrayList<Personal>();
            for (Personal personalCollectionPersonalToAttach : roles.getPersonalCollection()) {
                personalCollectionPersonalToAttach = em.getReference(personalCollectionPersonalToAttach.getClass(), personalCollectionPersonalToAttach.getIdPersonal());
                attachedPersonalCollection.add(personalCollectionPersonalToAttach);
            }
            roles.setPersonalCollection(attachedPersonalCollection);
            Collection<EquipoRespuesta> attachedEquipoRespuestaCollection = new ArrayList<EquipoRespuesta>();
            for (EquipoRespuesta equipoRespuestaCollectionEquipoRespuestaToAttach : roles.getEquipoRespuestaCollection()) {
                equipoRespuestaCollectionEquipoRespuestaToAttach = em.getReference(equipoRespuestaCollectionEquipoRespuestaToAttach.getClass(), equipoRespuestaCollectionEquipoRespuestaToAttach.getIdEquipoRespuesta());
                attachedEquipoRespuestaCollection.add(equipoRespuestaCollectionEquipoRespuestaToAttach);
            }
            roles.setEquipoRespuestaCollection(attachedEquipoRespuestaCollection);
            Collection<EquipoBase> attachedEquipoBaseCollection = new ArrayList<EquipoBase>();
            for (EquipoBase equipoBaseCollectionEquipoBaseToAttach : roles.getEquipoBaseCollection()) {
                equipoBaseCollectionEquipoBaseToAttach = em.getReference(equipoBaseCollectionEquipoBaseToAttach.getClass(), equipoBaseCollectionEquipoBaseToAttach.getIdEquipoBase());
                attachedEquipoBaseCollection.add(equipoBaseCollectionEquipoBaseToAttach);
            }
            roles.setEquipoBaseCollection(attachedEquipoBaseCollection);
            em.persist(roles);
            for (Personal personalCollectionPersonal : roles.getPersonalCollection()) {
                personalCollectionPersonal.getRolesCollection().add(roles);
                personalCollectionPersonal = em.merge(personalCollectionPersonal);
            }
            for (EquipoRespuesta equipoRespuestaCollectionEquipoRespuesta : roles.getEquipoRespuestaCollection()) {
                Roles oldIdRolOfEquipoRespuestaCollectionEquipoRespuesta = equipoRespuestaCollectionEquipoRespuesta.getIdRol();
                equipoRespuestaCollectionEquipoRespuesta.setIdRol(roles);
                equipoRespuestaCollectionEquipoRespuesta = em.merge(equipoRespuestaCollectionEquipoRespuesta);
                if (oldIdRolOfEquipoRespuestaCollectionEquipoRespuesta != null) {
                    oldIdRolOfEquipoRespuestaCollectionEquipoRespuesta.getEquipoRespuestaCollection().remove(equipoRespuestaCollectionEquipoRespuesta);
                    oldIdRolOfEquipoRespuestaCollectionEquipoRespuesta = em.merge(oldIdRolOfEquipoRespuestaCollectionEquipoRespuesta);
                }
            }
            for (EquipoBase equipoBaseCollectionEquipoBase : roles.getEquipoBaseCollection()) {
                Roles oldIdRolOfEquipoBaseCollectionEquipoBase = equipoBaseCollectionEquipoBase.getIdRol();
                equipoBaseCollectionEquipoBase.setIdRol(roles);
                equipoBaseCollectionEquipoBase = em.merge(equipoBaseCollectionEquipoBase);
                if (oldIdRolOfEquipoBaseCollectionEquipoBase != null) {
                    oldIdRolOfEquipoBaseCollectionEquipoBase.getEquipoBaseCollection().remove(equipoBaseCollectionEquipoBase);
                    oldIdRolOfEquipoBaseCollectionEquipoBase = em.merge(oldIdRolOfEquipoBaseCollectionEquipoBase);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRoles(roles.getIdRol()) != null) {
                throw new PreexistingEntityException("Roles " + roles + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Roles roles) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Roles persistentRoles = em.find(Roles.class, roles.getIdRol());
            Collection<Personal> personalCollectionOld = persistentRoles.getPersonalCollection();
            Collection<Personal> personalCollectionNew = roles.getPersonalCollection();
            Collection<EquipoRespuesta> equipoRespuestaCollectionOld = persistentRoles.getEquipoRespuestaCollection();
            Collection<EquipoRespuesta> equipoRespuestaCollectionNew = roles.getEquipoRespuestaCollection();
            Collection<EquipoBase> equipoBaseCollectionOld = persistentRoles.getEquipoBaseCollection();
            Collection<EquipoBase> equipoBaseCollectionNew = roles.getEquipoBaseCollection();
            List<String> illegalOrphanMessages = null;
            for (EquipoRespuesta equipoRespuestaCollectionOldEquipoRespuesta : equipoRespuestaCollectionOld) {
                if (!equipoRespuestaCollectionNew.contains(equipoRespuestaCollectionOldEquipoRespuesta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EquipoRespuesta " + equipoRespuestaCollectionOldEquipoRespuesta + " since its idRol field is not nullable.");
                }
            }
            for (EquipoBase equipoBaseCollectionOldEquipoBase : equipoBaseCollectionOld) {
                if (!equipoBaseCollectionNew.contains(equipoBaseCollectionOldEquipoBase)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EquipoBase " + equipoBaseCollectionOldEquipoBase + " since its idRol field is not nullable.");
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
            roles.setPersonalCollection(personalCollectionNew);
            Collection<EquipoRespuesta> attachedEquipoRespuestaCollectionNew = new ArrayList<EquipoRespuesta>();
            for (EquipoRespuesta equipoRespuestaCollectionNewEquipoRespuestaToAttach : equipoRespuestaCollectionNew) {
                equipoRespuestaCollectionNewEquipoRespuestaToAttach = em.getReference(equipoRespuestaCollectionNewEquipoRespuestaToAttach.getClass(), equipoRespuestaCollectionNewEquipoRespuestaToAttach.getIdEquipoRespuesta());
                attachedEquipoRespuestaCollectionNew.add(equipoRespuestaCollectionNewEquipoRespuestaToAttach);
            }
            equipoRespuestaCollectionNew = attachedEquipoRespuestaCollectionNew;
            roles.setEquipoRespuestaCollection(equipoRespuestaCollectionNew);
            Collection<EquipoBase> attachedEquipoBaseCollectionNew = new ArrayList<EquipoBase>();
            for (EquipoBase equipoBaseCollectionNewEquipoBaseToAttach : equipoBaseCollectionNew) {
                equipoBaseCollectionNewEquipoBaseToAttach = em.getReference(equipoBaseCollectionNewEquipoBaseToAttach.getClass(), equipoBaseCollectionNewEquipoBaseToAttach.getIdEquipoBase());
                attachedEquipoBaseCollectionNew.add(equipoBaseCollectionNewEquipoBaseToAttach);
            }
            equipoBaseCollectionNew = attachedEquipoBaseCollectionNew;
            roles.setEquipoBaseCollection(equipoBaseCollectionNew);
            roles = em.merge(roles);
            for (Personal personalCollectionOldPersonal : personalCollectionOld) {
                if (!personalCollectionNew.contains(personalCollectionOldPersonal)) {
                    personalCollectionOldPersonal.getRolesCollection().remove(roles);
                    personalCollectionOldPersonal = em.merge(personalCollectionOldPersonal);
                }
            }
            for (Personal personalCollectionNewPersonal : personalCollectionNew) {
                if (!personalCollectionOld.contains(personalCollectionNewPersonal)) {
                    personalCollectionNewPersonal.getRolesCollection().add(roles);
                    personalCollectionNewPersonal = em.merge(personalCollectionNewPersonal);
                }
            }
            for (EquipoRespuesta equipoRespuestaCollectionNewEquipoRespuesta : equipoRespuestaCollectionNew) {
                if (!equipoRespuestaCollectionOld.contains(equipoRespuestaCollectionNewEquipoRespuesta)) {
                    Roles oldIdRolOfEquipoRespuestaCollectionNewEquipoRespuesta = equipoRespuestaCollectionNewEquipoRespuesta.getIdRol();
                    equipoRespuestaCollectionNewEquipoRespuesta.setIdRol(roles);
                    equipoRespuestaCollectionNewEquipoRespuesta = em.merge(equipoRespuestaCollectionNewEquipoRespuesta);
                    if (oldIdRolOfEquipoRespuestaCollectionNewEquipoRespuesta != null && !oldIdRolOfEquipoRespuestaCollectionNewEquipoRespuesta.equals(roles)) {
                        oldIdRolOfEquipoRespuestaCollectionNewEquipoRespuesta.getEquipoRespuestaCollection().remove(equipoRespuestaCollectionNewEquipoRespuesta);
                        oldIdRolOfEquipoRespuestaCollectionNewEquipoRespuesta = em.merge(oldIdRolOfEquipoRespuestaCollectionNewEquipoRespuesta);
                    }
                }
            }
            for (EquipoBase equipoBaseCollectionNewEquipoBase : equipoBaseCollectionNew) {
                if (!equipoBaseCollectionOld.contains(equipoBaseCollectionNewEquipoBase)) {
                    Roles oldIdRolOfEquipoBaseCollectionNewEquipoBase = equipoBaseCollectionNewEquipoBase.getIdRol();
                    equipoBaseCollectionNewEquipoBase.setIdRol(roles);
                    equipoBaseCollectionNewEquipoBase = em.merge(equipoBaseCollectionNewEquipoBase);
                    if (oldIdRolOfEquipoBaseCollectionNewEquipoBase != null && !oldIdRolOfEquipoBaseCollectionNewEquipoBase.equals(roles)) {
                        oldIdRolOfEquipoBaseCollectionNewEquipoBase.getEquipoBaseCollection().remove(equipoBaseCollectionNewEquipoBase);
                        oldIdRolOfEquipoBaseCollectionNewEquipoBase = em.merge(oldIdRolOfEquipoBaseCollectionNewEquipoBase);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = roles.getIdRol();
                if (findRoles(id) == null) {
                    throw new NonexistentEntityException("The roles with id " + id + " no longer exists.");
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
            Roles roles;
            try {
                roles = em.getReference(Roles.class, id);
                roles.getIdRol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The roles with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<EquipoRespuesta> equipoRespuestaCollectionOrphanCheck = roles.getEquipoRespuestaCollection();
            for (EquipoRespuesta equipoRespuestaCollectionOrphanCheckEquipoRespuesta : equipoRespuestaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Roles (" + roles + ") cannot be destroyed since the EquipoRespuesta " + equipoRespuestaCollectionOrphanCheckEquipoRespuesta + " in its equipoRespuestaCollection field has a non-nullable idRol field.");
            }
            Collection<EquipoBase> equipoBaseCollectionOrphanCheck = roles.getEquipoBaseCollection();
            for (EquipoBase equipoBaseCollectionOrphanCheckEquipoBase : equipoBaseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Roles (" + roles + ") cannot be destroyed since the EquipoBase " + equipoBaseCollectionOrphanCheckEquipoBase + " in its equipoBaseCollection field has a non-nullable idRol field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Personal> personalCollection = roles.getPersonalCollection();
            for (Personal personalCollectionPersonal : personalCollection) {
                personalCollectionPersonal.getRolesCollection().remove(roles);
                personalCollectionPersonal = em.merge(personalCollectionPersonal);
            }
            em.remove(roles);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Roles> findRolesEntities() {
        return findRolesEntities(true, -1, -1);
    }

    public List<Roles> findRolesEntities(int maxResults, int firstResult) {
        return findRolesEntities(false, maxResults, firstResult);
    }

    private List<Roles> findRolesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Roles.class));
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

    public Roles findRoles(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Roles.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Roles> rt = cq.from(Roles.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
