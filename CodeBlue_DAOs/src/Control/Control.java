/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import persistence.Citys;
import persistence.Movies;
import persistence.Conexion;
import persistence.Subscribers;
import persistence.Locations;
import exceptions.PersistenciaException;
import Interfaces.IDAOs;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Map;
import com.bluecode.businessObjects.Zone;
import java.util.List;
import persistence.*;

/**
 *
 * @author AlanCarrera
 */
public class Control implements IDAOs {

    private Conexion conexion;
    private String url;
    private String usr;
    private String pas;

    public Control() {
        url = "jdbc:mysql://10.1.4.33:3306/codigo_azul";
        usr = "userCodigoAzul";
        pas = "codigoazul";
//        url = "jdbc:mysql://localhost:3306/codigo_azul";
//        usr = "root";
//        pas = "itson";
    }

    private void prepararConexion() throws PersistenciaException {
        conexion = new Conexion(url, usr, pas);
    }

    @Override
    public List<Map> getMapAll() throws PersistenciaException {
        prepararConexion();
        Maps maps = new Maps();
        maps.setConnection(conexion.getConexion());
        return maps.getMapsAll();
    }

    @Override
    public void updateCharacterOnZone(int idemploye, int idzona) throws PersistenciaException {
        prepararConexion();
        Teams teams = new Teams();
        teams.setConnection(conexion.getConexion());
        teams.updateCharacterOnZone(idemploye, idzona);
    }

    @Override
    public void blueCodeAlert(int idPatient, int idzona) throws PersistenciaException {
        prepararConexion();
        Teams teams = new Teams();
        teams.setConnection(conexion.getConexion());
        teams.updateCharacterOnZone(idPatient, idzona);
    }

    @Override
    public List<Zone> getZoneAll() throws PersistenciaException {
        prepararConexion();
        Zones zones = new Zones();
        zones.setConnection(conexion.getConexion());
        return zones.getZoneAll();
    }

    @Override
    public List<Employe> getEmployeAll() throws PersistenciaException {
        prepararConexion();
        Employes employes = new Employes();
        employes.setConnection(conexion.getConexion());
        List<Employe> employeList = employes.getEmployeAll();
        return employeList;
    }

    @Override
    public Zone getZoneByEmploye(int idEmploye) throws PersistenciaException {
        prepararConexion();
        Teams teams = new Teams();
        teams.setConnection(conexion.getConexion());
        int idZona = teams.getIdZoneByEmploye(idEmploye);
        prepararConexion();
        Zones zones = new Zones();
        zones.setConnection(conexion.getConexion());
        Zone zone = zones.getZoneByEmploye(idZona);
        return zone;
    }

    @Override
    public Zone getZoneById(int idZone) throws PersistenciaException {
        prepararConexion();
        Zones zones = new Zones();
        zones.setConnection(conexion.getConexion());
        Zone zone = zones.getZoneById(idZone);
        prepararConexion();
        return zone;
    }

    @Override
    public List<Employe> getTeamResponse() throws PersistenciaException {
        prepararConexion();
        Employes employes = new Employes();
        employes.setConnection(conexion.getConexion());
        List<Employe> employeList = employes.getTeamResponse();
        return employeList;
    }

//    @Override
//    public List<City> searchCitys() throws PersistenciaException {
//        prepararConexion();
//        Citys citys = new Citys();
//        citys.setConnection(conexion.getConexion());
//        return citys.searchCitys();
//    }
//
//    @Override
//    public List<Subscriber> searchSubscribersByCity(int city) throws PersistenciaException {
//        prepararConexion();
//        Subscribers subs = new Subscribers();
//        subs.setConnection(conexion.getConexion());
//        return subs.searchSubscribersByCity(city);
//    }
//
//    @Override
//    public List<Location> searchLocationsBySub(int city, int subscriber) throws PersistenciaException {
//        prepararConexion();
//        Locations locations = new Locations();
//        locations.setConnection(conexion.getConexion());
//        List<Location> locationsCity = locations.searchLocationsByCity(subscriber, city);
//        return locationsCity;
//    }
//
//    @Override
//    public BillBoard searchBillBoardByLocation(int location) throws PersistenciaException {
//        prepararConexion();
//        BillBoards bbs = new BillBoards();
//        bbs.setConnection(conexion.getConexion());
//        BillBoard bb = bbs.searchBillboardByLocation(location);
//        System.out.println(bb.toString());
//        //Recupera Schedules
//        prepararConexion();
//        Schedules schedules = new Schedules();
//        schedules.setConnection(conexion.getConexion());
//        List<Schedule> schedulesList = schedules.searchSchedulesByBillboard(bb.getId());
////        bb.setSchedules(schedulesList);
//        //Recupera Movie por schedule
//        for (Schedule s : schedulesList) {
//            prepararConexion();
//            Movies movies = new Movies();
//            movies.setConnection(conexion.getConexion());
//            Movie movie = movies.searchMovie(s.getMovie().getId());
//            s.setMovie(movie);
//        }
//        bb.setSchedules(schedulesList);
//        return bb;
//    }
}
