/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.bluecode.businessObjects.Area;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Equipo;
import com.bluecode.businessObjects.Grafo;
import com.bluecode.businessObjects.Map;
import com.bluecode.businessObjects.Position;
import com.bluecode.businessObjects.RolPersonal;
import com.bluecode.businessObjects.Role;
import com.bluecode.businessObjects.Zone;
import exceptions.PersistenciaException;
import java.util.List;
import persistence.Schedules;

/**
 *
 * @author QUINTERO
 */
public interface IDAOs {

//    public List<City> searchCitys() throws PersistenciaException;
//    public List<Subscriber> searchSubscribersByCity(int city) throws PersistenciaException;
//    public List<Location> searchLocationsBySub(int city, int subscriber) throws PersistenciaException;
//    public BillBoard searchBillBoardByLocation(int location) throws PersistenciaException;
    public List<Map> getMapAll() throws PersistenciaException;

    public void updateCharacterOnZone(int idemploye, int idzona) throws PersistenciaException;

    public List<Zone> getZoneAll() throws PersistenciaException;

    public List<Employe> getEmployeAll() throws PersistenciaException;

    public List<Employe> getTeamResponse() throws PersistenciaException;

    public Zone getZoneByEmploye(int idEmploye) throws PersistenciaException;

    public void blueCodeAlert(int idPatient, int idzona) throws PersistenciaException;

    public Zone getZoneById(int idZone) throws PersistenciaException;

    public Area getAreaNombre(String nombreArea) throws PersistenciaException;

    public List<Zone> getZonaArea(int idArea) throws PersistenciaException;

    public Employe getPersonal(int idPersonal) throws PersistenciaException;

    public Role getRol(int idRol) throws PersistenciaException;

    public Position getPuesto(int idPuesto) throws PersistenciaException;

    public List<RolPersonal> getRolesPersonal() throws PersistenciaException;

    public List<Equipo> getListaEquipoRol(int idRol) throws PersistenciaException;

    public double getFactorGrafo(int idZonaOrig, int idZonaDest) throws PersistenciaException;

    public void eliminarEquipoBase() throws PersistenciaException;

    public boolean agregarEquipoRespuesta(List<Equipo> equipoBase) throws PersistenciaException;

    public List<RolPersonal> getRolesEquipoCB() throws PersistenciaException;
    
    public List<Grafo> getListaGrafos() throws PersistenciaException;

}
