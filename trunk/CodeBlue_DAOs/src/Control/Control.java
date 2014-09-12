/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interfaces.IDAOs;
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
import persistence.*;
import persistence.Citys;
import persistence.Conexion;
import persistence.Locations;
import persistence.Movies;
import persistence.Subscribers;

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

    @Override
    public Area getAreaNombre(String nombreArea) throws PersistenciaException {
        prepararConexion();
        Areas areas = new Areas();
        areas.setConnection(conexion.getConexion());
        Area area = areas.getAreaNombre(nombreArea);
        return area;
    }

    @Override
    public List<Zone> getZonaArea(int idArea) throws PersistenciaException {
        prepararConexion();
        Zones zones = new Zones();
        zones.setConnection(conexion.getConexion());
        List<Zone> zone = zones.getZoneArea(idArea);
        return zone;
    }

    @Override
    public Employe getPersonal(int idPersonal) throws PersistenciaException {
        prepararConexion();
        Employes employes = new Employes();
        employes.setConnection(conexion.getConexion());
        Employe personal = employes.getPersonal(idPersonal);
        return personal;
    }

    @Override
    public Role getRol(int idRol) throws PersistenciaException {
        prepararConexion();
        Employes employes = new Employes();
        employes.setConnection(conexion.getConexion());
        int idRolResult = employes.getRolPersonal(idRol);
        prepararConexion();
        employes.setConnection(conexion.getConexion());
        Role rol = employes.getRol(idRolResult);
        return rol;
    }

    @Override
    public Position getPuesto(int idPuesto) throws PersistenciaException {
        prepararConexion();
        Employes employes = new Employes();
        employes.setConnection(conexion.getConexion());
        Position puesto = employes.getPuesto(idPuesto);
        return puesto;
    }

    @Override
    public List<RolPersonal> getRolesPersonal() throws PersistenciaException {
        prepararConexion();
        Roles roles = new Roles();
        roles.setConnection(conexion.getConexion());
        List<RolPersonal> rolesPersonal = roles.getListaRolesPersonal();
        return rolesPersonal;
    }

    @Override
    public List<Equipo> getListaEquipoRol(int idRol) throws PersistenciaException {
        prepararConexion();
        Teams teams = new Teams();
        teams.setConnection(conexion.getConexion());
        List<Equipo> equipoBase = teams.getListaEquipoRol(idRol);
        return equipoBase;
    }

    @Override
    public double getFactorGrafo(int idZonaOrig, int idZonaDest) throws PersistenciaException {
        prepararConexion();
        Grafos grafos = new Grafos();
        grafos.setConnection(conexion.getConexion());
        return grafos.getFactorGrafo(idZonaOrig, idZonaDest);
    }

    @Override
    public void eliminarEquipoBase() throws PersistenciaException {
        prepararConexion();
        Teams teams = new Teams();
        teams.setConnection(conexion.getConexion());
        teams.eliminarEquipoBase();
    }

    @Override
    public boolean agregarEquipoRespuesta(List<Equipo> equipoBase) throws PersistenciaException {
        prepararConexion();
        Teams teams = new Teams();
        teams.setConnection(conexion.getConexion());
        teams.agregarEquipoRespuesta(equipoBase);
        return true;
    }

    @Override
    public List<RolPersonal> getRolesEquipoCB() throws PersistenciaException {
        prepararConexion();
        Roles roles = new Roles();
        roles.setConnection(conexion.getConexion());
        List<RolPersonal> rolesPersonal = roles.getRolesEquipoCB();
        return rolesPersonal;
    }

    @Override
    public List<Grafo> getListaGrafos() throws PersistenciaException {
        prepararConexion();
        Grafos grafos = new Grafos();
        grafos.setConnection(conexion.getConexion());
        List<Grafo> listaGrafos = grafos.getListaGrafos();
        return listaGrafos;
    }
}
