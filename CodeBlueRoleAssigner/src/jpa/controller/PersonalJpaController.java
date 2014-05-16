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
import jpa.entities.Puestos;
import jpa.entities.Roles;
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
import jpa.entities.Personal;

/**
 *
 * @author Adrian
 */
public class PersonalJpaController implements Serializable {

    public PersonalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Personal personal) throws PreexistingEntityException, Exception {
        if (personal.getRolesCollection() == null) {
            personal.setRolesCollection(new ArrayList<Roles>());
        }
        if (personal.getEquipoRespuestaCollection() == null) {
            personal.setEquipoRespuestaCollection(new ArrayList<EquipoRespuesta>());
        }
        if (personal.getEquipoBaseCollection() == null) {
            personal.setEquipoBaseCollection(new ArrayList<EquipoBase>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Puestos idPuesto = personal.getIdPuesto();
            if (idPuesto != null) {
                idPuesto = em.getReference(idPuesto.getClass(), idPuesto.getIdPuesto());
                personal.setIdPuesto(idPuesto);
            }
            Collection<Roles> attachedRolesCollection = new ArrayList<Roles>();
            for (Roles rolesCollectionRolesToAttach : personal.getRolesCollection()) {
                rolesCollectionRolesToAttach = em.getReference(rolesCollectionRolesToAttach.getClass(), rolesCollectionRolesToAttach.getIdRol());
                attachedRolesCollection.add(rolesCollectionRolesToAttach);
            }
            personal.setRolesCollection(attachedRolesCollection);
            Collection<EquipoRespuesta> attachedEquipoRespuestaCollection = new ArrayList<EquipoRespuesta>();
            for (EquipoRespuesta equipoRespuestaCollectionEquipoRespuestaToAttach : personal.getEquipoRespuestaCollection()) {
                equipoRespuestaCollectionEquipoRespuestaToAttach = em.getReference(equipoRespuestaCollectionEquipoRespuestaToAttach.getClass(), equipoRespuestaCollectionEquipoRespuestaToAttach.getIdEquipoRespuesta());
                attachedEquipoRespuestaCollection.add(equipoRespuestaCollectionEquipoRespuestaToAttach);
            }
            personal.setEquipoRespuestaCollection(attachedEquipoRespuestaCollection);
            Collection<EquipoBase> attachedEquipoBaseCollection = new ArrayList<EquipoBase>();
            for (EquipoBase equipoBaseCollectionEquipoBaseToAttach : personal.getEquipoBaseCollection()) {
                equipoBaseCollectionEquipoBaseToAttach = em.getReference(equipoBaseCollectionEquipoBaseToAttach.getClass(), equipoBaseCollectionEquipoBaseToAttach.getIdEquipoBase());
                attachedEquipoBaseCollection.add(equipoBaseCollectionEquipoBaseToAttach);
            }
            personal.setEquipoBaseCollection(attachedEquipoBaseCollection);
            em.persist(personal);
            if (idPuesto != null) {
                idPuesto.getPersonalCollection().add(personal);
                idPuesto = em.merge(idPuesto);
            }
            for (Roles rolesCollectionRoles : personal.getRolesCollection()) {
                rolesCollectionRoles.getPersonalCollection().add(personal);
                rolesCollectionRoles = em.merge(rolesCollectionRoles);
            }
            for (EquipoRespuesta equipoRespuestaCollectionEquipoRespuesta : personal.getEquipoRespuestaCollection()) {
                Personal oldIdPersonalOfEquipoRespuestaCollectionEquipoRespuesta = equipoRespuestaCollectionEquipoRespuesta.getIdPersonal();
                equipoRespuestaCollectionEquipoRespuesta.setIdPersonal(personal);
                equipoRespuestaCollectionEquipoRespuesta = em.merge(equipoRespuestaCollectionEquipoRespuesta);
                if (oldIdPersonalOfEquipoRespuestaCollectionEquipoRespuesta != null) {
                    oldIdPersonalOfEquipoRespuestaCollectionEquipoRespuesta.getEquipoRespuestaCollection().remove(equipoRespuestaCollectionEquipoRespuesta);
                    oldIdPersonalOfEquipoRespuestaCollectionEquipoRespuesta = em.merge(oldIdPersonalOfEquipoRespuestaCollectionEquipoRespuesta);
                }
            }
            for (EquipoBase equipoBaseCollectionEquipoBase : personal.getEquipoBaseCollection()) {
                Personal oldIdPersonalOfEquipoBaseCollectionEquipoBase = equipoBaseCollectionEquipoBase.getIdPersonal();
                equipoBaseCollectionEquipoBase.setIdPersonal(personal);
                equipoBaseCollectionEquipoBase = em.merge(equipoBaseCollectionEquipoBase);
                if (oldIdPersonalOfEquipoBaseCollectionEquipoBase != null) {
                    oldIdPersonalOfEquipoBaseCollectionEquipoBase.getEquipoBaseCollection().remove(equipoBaseCollectionEquipoBase);
                    oldIdPersonalOfEquipoBaseCollectionEquipoBase = em.merge(oldIdPersonalOfEquipoBaseCollectionEquipoBase);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPersonal(personal.getIdPersonal()) != null) {
                throw new PreexistingEntityException("Personal " + personal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Personal personal) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Personal persistentPersonal = em.find(Personal.class, personal.getIdPersonal());
            Puestos idPuestoOld = persistentPersonal.getIdPuesto();
            Puestos idPuestoNew = personal.getIdPuesto();
            Collection<Roles> rolesCollectionOld = persistentPersonal.getRolesCollection();
            Collection<Roles> rolesCollectionNew = personal.getRolesCollection();
            Collection<EquipoRespuesta> equipoRespuestaCollectionOld = persistentPersonal.getEquipoRespuestaCollection();
            Collection<EquipoRespuesta> equipoRespuestaCollectionNew = personal.getEquipoRespuestaCollection();
            Collection<EquipoBase> equipoBaseCollectionOld = persistentPersonal.getEquipoBaseCollection();
            Collection<EquipoBase> equipoBaseCollectionNew = personal.getEquipoBaseCollection();
            List<String> illegalOrphanMessages = null;
            for (EquipoRespuesta equipoRespuestaCollectionOldEquipoRespuesta : equipoRespuestaCollectionOld) {
                if (!equipoRespuestaCollectionNew.contains(equipoRespuestaCollectionOldEquipoRespuesta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EquipoRespuesta " + equipoRespuestaCollectionOldEquipoRespuesta + " since its idPersonal field is not nullable.");
                }
            }
            for (EquipoBase equipoBaseCollectionOldEquipoBase : equipoBaseCollectionOld) {
                if (!equipoBaseCollectionNew.contains(equipoBaseCollectionOldEquipoBase)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EquipoBase " + equipoBaseCollectionOldEquipoBase + " since its idPersonal field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idPuestoNew != null) {
                idPuestoNew = em.getReference(idPuestoNew.getClass(), idPuestoNew.getIdPuesto());
                personal.setIdPuesto(idPuestoNew);
            }
            Collection<Roles> attachedRolesCollectionNew = new ArrayList<Roles>();
            for (Roles rolesCollectionNewRolesToAttach : rolesCollectionNew) {
                rolesCollectionNewRolesToAttach = em.getReference(rolesCollectionNewRolesToAttach.getClass(), rolesCollectionNewRolesToAttach.getIdRol());
                attachedRolesCollectionNew.add(rolesCollectionNewRolesToAttach);
            }
            rolesCollectionNew = attachedRolesCollectionNew;
            personal.setRolesCollection(rolesCollectionNew);
            Collection<EquipoRespuesta> attachedEquipoRespuestaCollectionNew = new ArrayList<EquipoRespuesta>();
            for (EquipoRespuesta equipoRespuestaCollectionNewEquipoRespuestaToAttach : equipoRespuestaCollectionNew) {
                equipoRespuestaCollectionNewEquipoRespuestaToAttach = em.getReference(equipoRespuestaCollectionNewEquipoRespuestaToAttach.getClass(), equipoRespuestaCollectionNewEquipoRespuestaToAttach.getIdEquipoRespuesta());
                attachedEquipoRespuestaCollectionNew.add(equipoRespuestaCollectionNewEquipoRespuestaToAttach);
            }
            equipoRespuestaCollectionNew = attachedEquipoRespuestaCollectionNew;
            personal.setEquipoRespuestaCollection(equipoRespuestaCollectionNew);
            Collection<EquipoBase> attachedEquipoBaseCollectionNew = new ArrayList<EquipoBase>();
            for (EquipoBase equipoBaseCollectionNewEquipoBaseToAttach : equipoBaseCollectionNew) {
                equipoBaseCollectionNewEquipoBaseToAttach = em.getReference(equipoBaseCollectionNewEquipoBaseToAttach.getClass(), equipoBaseCollectionNewEquipoBaseToAttach.getIdEquipoBase());
                attachedEquipoBaseCollectionNew.add(equipoBaseCollectionNewEquipoBaseToAttach);
            }
            equipoBaseCollectionNew = attachedEquipoBaseCollectionNew;
            personal.setEquipoBaseCollection(equipoBaseCollectionNew);
            personal = em.merge(personal);
            if (idPuestoOld != null && !idPuestoOld.equals(idPuestoNew)) {
                idPuestoOld.getPersonalCollection().remove(personal);
                idPuestoOld = em.merge(idPuestoOld);
            }
            if (idPuestoNew != null && !idPuestoNew.equals(idPuestoOld)) {
                idPuestoNew.getPersonalCollection().add(personal);
                idPuestoNew = em.merge(idPuestoNew);
            }
            for (Roles rolesCollectionOldRoles : rolesCollectionOld) {
                if (!rolesCollectionNew.contains(rolesCollectionOldRoles)) {
                    rolesCollectionOldRoles.getPersonalCollection().remove(personal);
                    rolesCollectionOldRoles = em.merge(rolesCollectionOldRoles);
                }
            }
            for (Roles rolesCollectionNewRoles : rolesCollectionNew) {
                if (!rolesCollectionOld.contains(rolesCollectionNewRoles)) {
                    rolesCollectionNewRoles.getPersonalCollection().add(personal);
                    rolesCollectionNewRoles = em.merge(rolesCollectionNewRoles);
                }
            }
            for (EquipoRespuesta equipoRespuestaCollectionNewEquipoRespuesta : equipoRespuestaCollectionNew) {
                if (!equipoRespuestaCollectionOld.contains(equipoRespuestaCollectionNewEquipoRespuesta)) {
                    Personal oldIdPersonalOfEquipoRespuestaCollectionNewEquipoRespuesta = equipoRespuestaCollectionNewEquipoRespuesta.getIdPersonal();
                    equipoRespuestaCollectionNewEquipoRespuesta.setIdPersonal(personal);
                    equipoRespuestaCollectionNewEquipoRespuesta = em.merge(equipoRespuestaCollectionNewEquipoRespuesta);
                    if (oldIdPersonalOfEquipoRespuestaCollectionNewEquipoRespuesta != null && !oldIdPersonalOfEquipoRespuestaCollectionNewEquipoRespuesta.equals(personal)) {
                        oldIdPersonalOfEquipoRespuestaCollectionNewEquipoRespuesta.getEquipoRespuestaCollection().remove(equipoRespuestaCollectionNewEquipoRespuesta);
                        oldIdPersonalOfEquipoRespuestaCollectionNewEquipoRespuesta = em.merge(oldIdPersonalOfEquipoRespuestaCollectionNewEquipoRespuesta);
                    }
                }
            }
            for (EquipoBase equipoBaseCollectionNewEquipoBase : equipoBaseCollectionNew) {
                if (!equipoBaseCollectionOld.contains(equipoBaseCollectionNewEquipoBase)) {
                    Personal oldIdPersonalOfEquipoBaseCollectionNewEquipoBase = equipoBaseCollectionNewEquipoBase.getIdPersonal();
                    equipoBaseCollectionNewEquipoBase.setIdPersonal(personal);
                    equipoBaseCollectionNewEquipoBase = em.merge(equipoBaseCollectionNewEquipoBase);
                    if (oldIdPersonalOfEquipoBaseCollectionNewEquipoBase != null && !oldIdPersonalOfEquipoBaseCollectionNewEquipoBase.equals(personal)) {
                        oldIdPersonalOfEquipoBaseCollectionNewEquipoBase.getEquipoBaseCollection().remove(equipoBaseCollectionNewEquipoBase);
                        oldIdPersonalOfEquipoBaseCollectionNewEquipoBase = em.merge(oldIdPersonalOfEquipoBaseCollectionNewEquipoBase);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = personal.getIdPersonal();
                if (findPersonal(id) == null) {
                    throw new NonexistentEntityException("The personal with id " + id + " no longer exists.");
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
            Personal personal;
            try {
                personal = em.getReference(Personal.class, id);
                personal.getIdPersonal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personal with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<EquipoRespuesta> equipoRespuestaCollectionOrphanCheck = personal.getEquipoRespuestaCollection();
            for (EquipoRespuesta equipoRespuestaCollectionOrphanCheckEquipoRespuesta : equipoRespuestaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Personal (" + personal + ") cannot be destroyed since the EquipoRespuesta " + equipoRespuestaCollectionOrphanCheckEquipoRespuesta + " in its equipoRespuestaCollection field has a non-nullable idPersonal field.");
            }
            Collection<EquipoBase> equipoBaseCollectionOrphanCheck = personal.getEquipoBaseCollection();
            for (EquipoBase equipoBaseCollectionOrphanCheckEquipoBase : equipoBaseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Personal (" + personal + ") cannot be destroyed since the EquipoBase " + equipoBaseCollectionOrphanCheckEquipoBase + " in its equipoBaseCollection field has a non-nullable idPersonal field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Puestos idPuesto = personal.getIdPuesto();
            if (idPuesto != null) {
                idPuesto.getPersonalCollection().remove(personal);
                idPuesto = em.merge(idPuesto);
            }
            Collection<Roles> rolesCollection = personal.getRolesCollection();
            for (Roles rolesCollectionRoles : rolesCollection) {
                rolesCollectionRoles.getPersonalCollection().remove(personal);
                rolesCollectionRoles = em.merge(rolesCollectionRoles);
            }
            em.remove(personal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Personal> findPersonalEntities() {
        return findPersonalEntities(true, -1, -1);
    }

    public List<Personal> findPersonalEntities(int maxResults, int firstResult) {
        return findPersonalEntities(false, maxResults, firstResult);
    }

    private List<Personal> findPersonalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Personal.class));
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

    public Personal findPersonal(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Personal.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Personal> rt = cq.from(Personal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
