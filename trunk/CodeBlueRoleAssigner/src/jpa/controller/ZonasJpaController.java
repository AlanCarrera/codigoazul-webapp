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
import jpa.entities.Areas;
import jpa.entities.EquipoRespuesta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.controller.exceptions.IllegalOrphanException;
import jpa.controller.exceptions.NonexistentEntityException;
import jpa.controller.exceptions.PreexistingEntityException;
import jpa.entities.Grafos;
import jpa.entities.EquipoBase;
import jpa.entities.Zonas;

/**
 *
 * @author Adrian
 */
public class ZonasJpaController implements Serializable {

    public ZonasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Zonas zonas) throws PreexistingEntityException, Exception {
        if (zonas.getEquipoRespuestaCollection() == null) {
            zonas.setEquipoRespuestaCollection(new ArrayList<EquipoRespuesta>());
        }
        if (zonas.getGrafosCollection() == null) {
            zonas.setGrafosCollection(new ArrayList<Grafos>());
        }
        if (zonas.getGrafosCollection1() == null) {
            zonas.setGrafosCollection1(new ArrayList<Grafos>());
        }
        if (zonas.getEquipoBaseCollection() == null) {
            zonas.setEquipoBaseCollection(new ArrayList<EquipoBase>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Areas idArea = zonas.getIdArea();
            if (idArea != null) {
                idArea = em.getReference(idArea.getClass(), idArea.getIdArea());
                zonas.setIdArea(idArea);
            }
            Collection<EquipoRespuesta> attachedEquipoRespuestaCollection = new ArrayList<EquipoRespuesta>();
            for (EquipoRespuesta equipoRespuestaCollectionEquipoRespuestaToAttach : zonas.getEquipoRespuestaCollection()) {
                equipoRespuestaCollectionEquipoRespuestaToAttach = em.getReference(equipoRespuestaCollectionEquipoRespuestaToAttach.getClass(), equipoRespuestaCollectionEquipoRespuestaToAttach.getIdEquipoRespuesta());
                attachedEquipoRespuestaCollection.add(equipoRespuestaCollectionEquipoRespuestaToAttach);
            }
            zonas.setEquipoRespuestaCollection(attachedEquipoRespuestaCollection);
            Collection<Grafos> attachedGrafosCollection = new ArrayList<Grafos>();
            for (Grafos grafosCollectionGrafosToAttach : zonas.getGrafosCollection()) {
                grafosCollectionGrafosToAttach = em.getReference(grafosCollectionGrafosToAttach.getClass(), grafosCollectionGrafosToAttach.getIdGrafo());
                attachedGrafosCollection.add(grafosCollectionGrafosToAttach);
            }
            zonas.setGrafosCollection(attachedGrafosCollection);
            Collection<Grafos> attachedGrafosCollection1 = new ArrayList<Grafos>();
            for (Grafos grafosCollection1GrafosToAttach : zonas.getGrafosCollection1()) {
                grafosCollection1GrafosToAttach = em.getReference(grafosCollection1GrafosToAttach.getClass(), grafosCollection1GrafosToAttach.getIdGrafo());
                attachedGrafosCollection1.add(grafosCollection1GrafosToAttach);
            }
            zonas.setGrafosCollection1(attachedGrafosCollection1);
            Collection<EquipoBase> attachedEquipoBaseCollection = new ArrayList<EquipoBase>();
            for (EquipoBase equipoBaseCollectionEquipoBaseToAttach : zonas.getEquipoBaseCollection()) {
                equipoBaseCollectionEquipoBaseToAttach = em.getReference(equipoBaseCollectionEquipoBaseToAttach.getClass(), equipoBaseCollectionEquipoBaseToAttach.getIdEquipoBase());
                attachedEquipoBaseCollection.add(equipoBaseCollectionEquipoBaseToAttach);
            }
            zonas.setEquipoBaseCollection(attachedEquipoBaseCollection);
            em.persist(zonas);
            if (idArea != null) {
                idArea.getZonasCollection().add(zonas);
                idArea = em.merge(idArea);
            }
            for (EquipoRespuesta equipoRespuestaCollectionEquipoRespuesta : zonas.getEquipoRespuestaCollection()) {
                Zonas oldIdZonaOfEquipoRespuestaCollectionEquipoRespuesta = equipoRespuestaCollectionEquipoRespuesta.getIdZona();
                equipoRespuestaCollectionEquipoRespuesta.setIdZona(zonas);
                equipoRespuestaCollectionEquipoRespuesta = em.merge(equipoRespuestaCollectionEquipoRespuesta);
                if (oldIdZonaOfEquipoRespuestaCollectionEquipoRespuesta != null) {
                    oldIdZonaOfEquipoRespuestaCollectionEquipoRespuesta.getEquipoRespuestaCollection().remove(equipoRespuestaCollectionEquipoRespuesta);
                    oldIdZonaOfEquipoRespuestaCollectionEquipoRespuesta = em.merge(oldIdZonaOfEquipoRespuestaCollectionEquipoRespuesta);
                }
            }
            for (Grafos grafosCollectionGrafos : zonas.getGrafosCollection()) {
                Zonas oldIdZonaDestOfGrafosCollectionGrafos = grafosCollectionGrafos.getIdZonaDest();
                grafosCollectionGrafos.setIdZonaDest(zonas);
                grafosCollectionGrafos = em.merge(grafosCollectionGrafos);
                if (oldIdZonaDestOfGrafosCollectionGrafos != null) {
                    oldIdZonaDestOfGrafosCollectionGrafos.getGrafosCollection().remove(grafosCollectionGrafos);
                    oldIdZonaDestOfGrafosCollectionGrafos = em.merge(oldIdZonaDestOfGrafosCollectionGrafos);
                }
            }
            for (Grafos grafosCollection1Grafos : zonas.getGrafosCollection1()) {
                Zonas oldIdZonaOrigOfGrafosCollection1Grafos = grafosCollection1Grafos.getIdZonaOrig();
                grafosCollection1Grafos.setIdZonaOrig(zonas);
                grafosCollection1Grafos = em.merge(grafosCollection1Grafos);
                if (oldIdZonaOrigOfGrafosCollection1Grafos != null) {
                    oldIdZonaOrigOfGrafosCollection1Grafos.getGrafosCollection1().remove(grafosCollection1Grafos);
                    oldIdZonaOrigOfGrafosCollection1Grafos = em.merge(oldIdZonaOrigOfGrafosCollection1Grafos);
                }
            }
            for (EquipoBase equipoBaseCollectionEquipoBase : zonas.getEquipoBaseCollection()) {
                Zonas oldIdZonaOfEquipoBaseCollectionEquipoBase = equipoBaseCollectionEquipoBase.getIdZona();
                equipoBaseCollectionEquipoBase.setIdZona(zonas);
                equipoBaseCollectionEquipoBase = em.merge(equipoBaseCollectionEquipoBase);
                if (oldIdZonaOfEquipoBaseCollectionEquipoBase != null) {
                    oldIdZonaOfEquipoBaseCollectionEquipoBase.getEquipoBaseCollection().remove(equipoBaseCollectionEquipoBase);
                    oldIdZonaOfEquipoBaseCollectionEquipoBase = em.merge(oldIdZonaOfEquipoBaseCollectionEquipoBase);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findZonas(zonas.getIdZona()) != null) {
                throw new PreexistingEntityException("Zonas " + zonas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Zonas zonas) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Zonas persistentZonas = em.find(Zonas.class, zonas.getIdZona());
            Areas idAreaOld = persistentZonas.getIdArea();
            Areas idAreaNew = zonas.getIdArea();
            Collection<EquipoRespuesta> equipoRespuestaCollectionOld = persistentZonas.getEquipoRespuestaCollection();
            Collection<EquipoRespuesta> equipoRespuestaCollectionNew = zonas.getEquipoRespuestaCollection();
            Collection<Grafos> grafosCollectionOld = persistentZonas.getGrafosCollection();
            Collection<Grafos> grafosCollectionNew = zonas.getGrafosCollection();
            Collection<Grafos> grafosCollection1Old = persistentZonas.getGrafosCollection1();
            Collection<Grafos> grafosCollection1New = zonas.getGrafosCollection1();
            Collection<EquipoBase> equipoBaseCollectionOld = persistentZonas.getEquipoBaseCollection();
            Collection<EquipoBase> equipoBaseCollectionNew = zonas.getEquipoBaseCollection();
            List<String> illegalOrphanMessages = null;
            for (EquipoRespuesta equipoRespuestaCollectionOldEquipoRespuesta : equipoRespuestaCollectionOld) {
                if (!equipoRespuestaCollectionNew.contains(equipoRespuestaCollectionOldEquipoRespuesta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EquipoRespuesta " + equipoRespuestaCollectionOldEquipoRespuesta + " since its idZona field is not nullable.");
                }
            }
            for (Grafos grafosCollectionOldGrafos : grafosCollectionOld) {
                if (!grafosCollectionNew.contains(grafosCollectionOldGrafos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Grafos " + grafosCollectionOldGrafos + " since its idZonaDest field is not nullable.");
                }
            }
            for (Grafos grafosCollection1OldGrafos : grafosCollection1Old) {
                if (!grafosCollection1New.contains(grafosCollection1OldGrafos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Grafos " + grafosCollection1OldGrafos + " since its idZonaOrig field is not nullable.");
                }
            }
            for (EquipoBase equipoBaseCollectionOldEquipoBase : equipoBaseCollectionOld) {
                if (!equipoBaseCollectionNew.contains(equipoBaseCollectionOldEquipoBase)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EquipoBase " + equipoBaseCollectionOldEquipoBase + " since its idZona field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idAreaNew != null) {
                idAreaNew = em.getReference(idAreaNew.getClass(), idAreaNew.getIdArea());
                zonas.setIdArea(idAreaNew);
            }
            Collection<EquipoRespuesta> attachedEquipoRespuestaCollectionNew = new ArrayList<EquipoRespuesta>();
            for (EquipoRespuesta equipoRespuestaCollectionNewEquipoRespuestaToAttach : equipoRespuestaCollectionNew) {
                equipoRespuestaCollectionNewEquipoRespuestaToAttach = em.getReference(equipoRespuestaCollectionNewEquipoRespuestaToAttach.getClass(), equipoRespuestaCollectionNewEquipoRespuestaToAttach.getIdEquipoRespuesta());
                attachedEquipoRespuestaCollectionNew.add(equipoRespuestaCollectionNewEquipoRespuestaToAttach);
            }
            equipoRespuestaCollectionNew = attachedEquipoRespuestaCollectionNew;
            zonas.setEquipoRespuestaCollection(equipoRespuestaCollectionNew);
            Collection<Grafos> attachedGrafosCollectionNew = new ArrayList<Grafos>();
            for (Grafos grafosCollectionNewGrafosToAttach : grafosCollectionNew) {
                grafosCollectionNewGrafosToAttach = em.getReference(grafosCollectionNewGrafosToAttach.getClass(), grafosCollectionNewGrafosToAttach.getIdGrafo());
                attachedGrafosCollectionNew.add(grafosCollectionNewGrafosToAttach);
            }
            grafosCollectionNew = attachedGrafosCollectionNew;
            zonas.setGrafosCollection(grafosCollectionNew);
            Collection<Grafos> attachedGrafosCollection1New = new ArrayList<Grafos>();
            for (Grafos grafosCollection1NewGrafosToAttach : grafosCollection1New) {
                grafosCollection1NewGrafosToAttach = em.getReference(grafosCollection1NewGrafosToAttach.getClass(), grafosCollection1NewGrafosToAttach.getIdGrafo());
                attachedGrafosCollection1New.add(grafosCollection1NewGrafosToAttach);
            }
            grafosCollection1New = attachedGrafosCollection1New;
            zonas.setGrafosCollection1(grafosCollection1New);
            Collection<EquipoBase> attachedEquipoBaseCollectionNew = new ArrayList<EquipoBase>();
            for (EquipoBase equipoBaseCollectionNewEquipoBaseToAttach : equipoBaseCollectionNew) {
                equipoBaseCollectionNewEquipoBaseToAttach = em.getReference(equipoBaseCollectionNewEquipoBaseToAttach.getClass(), equipoBaseCollectionNewEquipoBaseToAttach.getIdEquipoBase());
                attachedEquipoBaseCollectionNew.add(equipoBaseCollectionNewEquipoBaseToAttach);
            }
            equipoBaseCollectionNew = attachedEquipoBaseCollectionNew;
            zonas.setEquipoBaseCollection(equipoBaseCollectionNew);
            zonas = em.merge(zonas);
            if (idAreaOld != null && !idAreaOld.equals(idAreaNew)) {
                idAreaOld.getZonasCollection().remove(zonas);
                idAreaOld = em.merge(idAreaOld);
            }
            if (idAreaNew != null && !idAreaNew.equals(idAreaOld)) {
                idAreaNew.getZonasCollection().add(zonas);
                idAreaNew = em.merge(idAreaNew);
            }
            for (EquipoRespuesta equipoRespuestaCollectionNewEquipoRespuesta : equipoRespuestaCollectionNew) {
                if (!equipoRespuestaCollectionOld.contains(equipoRespuestaCollectionNewEquipoRespuesta)) {
                    Zonas oldIdZonaOfEquipoRespuestaCollectionNewEquipoRespuesta = equipoRespuestaCollectionNewEquipoRespuesta.getIdZona();
                    equipoRespuestaCollectionNewEquipoRespuesta.setIdZona(zonas);
                    equipoRespuestaCollectionNewEquipoRespuesta = em.merge(equipoRespuestaCollectionNewEquipoRespuesta);
                    if (oldIdZonaOfEquipoRespuestaCollectionNewEquipoRespuesta != null && !oldIdZonaOfEquipoRespuestaCollectionNewEquipoRespuesta.equals(zonas)) {
                        oldIdZonaOfEquipoRespuestaCollectionNewEquipoRespuesta.getEquipoRespuestaCollection().remove(equipoRespuestaCollectionNewEquipoRespuesta);
                        oldIdZonaOfEquipoRespuestaCollectionNewEquipoRespuesta = em.merge(oldIdZonaOfEquipoRespuestaCollectionNewEquipoRespuesta);
                    }
                }
            }
            for (Grafos grafosCollectionNewGrafos : grafosCollectionNew) {
                if (!grafosCollectionOld.contains(grafosCollectionNewGrafos)) {
                    Zonas oldIdZonaDestOfGrafosCollectionNewGrafos = grafosCollectionNewGrafos.getIdZonaDest();
                    grafosCollectionNewGrafos.setIdZonaDest(zonas);
                    grafosCollectionNewGrafos = em.merge(grafosCollectionNewGrafos);
                    if (oldIdZonaDestOfGrafosCollectionNewGrafos != null && !oldIdZonaDestOfGrafosCollectionNewGrafos.equals(zonas)) {
                        oldIdZonaDestOfGrafosCollectionNewGrafos.getGrafosCollection().remove(grafosCollectionNewGrafos);
                        oldIdZonaDestOfGrafosCollectionNewGrafos = em.merge(oldIdZonaDestOfGrafosCollectionNewGrafos);
                    }
                }
            }
            for (Grafos grafosCollection1NewGrafos : grafosCollection1New) {
                if (!grafosCollection1Old.contains(grafosCollection1NewGrafos)) {
                    Zonas oldIdZonaOrigOfGrafosCollection1NewGrafos = grafosCollection1NewGrafos.getIdZonaOrig();
                    grafosCollection1NewGrafos.setIdZonaOrig(zonas);
                    grafosCollection1NewGrafos = em.merge(grafosCollection1NewGrafos);
                    if (oldIdZonaOrigOfGrafosCollection1NewGrafos != null && !oldIdZonaOrigOfGrafosCollection1NewGrafos.equals(zonas)) {
                        oldIdZonaOrigOfGrafosCollection1NewGrafos.getGrafosCollection1().remove(grafosCollection1NewGrafos);
                        oldIdZonaOrigOfGrafosCollection1NewGrafos = em.merge(oldIdZonaOrigOfGrafosCollection1NewGrafos);
                    }
                }
            }
            for (EquipoBase equipoBaseCollectionNewEquipoBase : equipoBaseCollectionNew) {
                if (!equipoBaseCollectionOld.contains(equipoBaseCollectionNewEquipoBase)) {
                    Zonas oldIdZonaOfEquipoBaseCollectionNewEquipoBase = equipoBaseCollectionNewEquipoBase.getIdZona();
                    equipoBaseCollectionNewEquipoBase.setIdZona(zonas);
                    equipoBaseCollectionNewEquipoBase = em.merge(equipoBaseCollectionNewEquipoBase);
                    if (oldIdZonaOfEquipoBaseCollectionNewEquipoBase != null && !oldIdZonaOfEquipoBaseCollectionNewEquipoBase.equals(zonas)) {
                        oldIdZonaOfEquipoBaseCollectionNewEquipoBase.getEquipoBaseCollection().remove(equipoBaseCollectionNewEquipoBase);
                        oldIdZonaOfEquipoBaseCollectionNewEquipoBase = em.merge(oldIdZonaOfEquipoBaseCollectionNewEquipoBase);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = zonas.getIdZona();
                if (findZonas(id) == null) {
                    throw new NonexistentEntityException("The zonas with id " + id + " no longer exists.");
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
            Zonas zonas;
            try {
                zonas = em.getReference(Zonas.class, id);
                zonas.getIdZona();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The zonas with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<EquipoRespuesta> equipoRespuestaCollectionOrphanCheck = zonas.getEquipoRespuestaCollection();
            for (EquipoRespuesta equipoRespuestaCollectionOrphanCheckEquipoRespuesta : equipoRespuestaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Zonas (" + zonas + ") cannot be destroyed since the EquipoRespuesta " + equipoRespuestaCollectionOrphanCheckEquipoRespuesta + " in its equipoRespuestaCollection field has a non-nullable idZona field.");
            }
            Collection<Grafos> grafosCollectionOrphanCheck = zonas.getGrafosCollection();
            for (Grafos grafosCollectionOrphanCheckGrafos : grafosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Zonas (" + zonas + ") cannot be destroyed since the Grafos " + grafosCollectionOrphanCheckGrafos + " in its grafosCollection field has a non-nullable idZonaDest field.");
            }
            Collection<Grafos> grafosCollection1OrphanCheck = zonas.getGrafosCollection1();
            for (Grafos grafosCollection1OrphanCheckGrafos : grafosCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Zonas (" + zonas + ") cannot be destroyed since the Grafos " + grafosCollection1OrphanCheckGrafos + " in its grafosCollection1 field has a non-nullable idZonaOrig field.");
            }
            Collection<EquipoBase> equipoBaseCollectionOrphanCheck = zonas.getEquipoBaseCollection();
            for (EquipoBase equipoBaseCollectionOrphanCheckEquipoBase : equipoBaseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Zonas (" + zonas + ") cannot be destroyed since the EquipoBase " + equipoBaseCollectionOrphanCheckEquipoBase + " in its equipoBaseCollection field has a non-nullable idZona field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Areas idArea = zonas.getIdArea();
            if (idArea != null) {
                idArea.getZonasCollection().remove(zonas);
                idArea = em.merge(idArea);
            }
            em.remove(zonas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Zonas> findZonasEntities() {
        return findZonasEntities(true, -1, -1);
    }

    public List<Zonas> findZonasEntities(int maxResults, int firstResult) {
        return findZonasEntities(false, maxResults, firstResult);
    }

    private List<Zonas> findZonasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Zonas.class));
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

    public Zonas findZonas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Zonas.class, id);
        } finally {
            em.close();
        }
    }

    public int getZonasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Zonas> rt = cq.from(Zonas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
