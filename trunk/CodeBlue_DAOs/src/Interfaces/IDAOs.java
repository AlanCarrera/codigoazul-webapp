/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Map;
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
    
}
