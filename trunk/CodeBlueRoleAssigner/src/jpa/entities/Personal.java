/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p"),
    @NamedQuery(name = "Personal.findByIdPersonal", query = "SELECT p FROM Personal p WHERE p.idPersonal = :idPersonal"),
    @NamedQuery(name = "Personal.findByNombre", query = "SELECT p FROM Personal p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Personal.findByDispositivo", query = "SELECT p FROM Personal p WHERE p.dispositivo = :dispositivo")})
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_personal")
    private Integer idPersonal;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dispositivo")
    private Integer dispositivo;
    @JoinTable(name = "roles_personal", joinColumns = {
        @JoinColumn(name = "id_personal", referencedColumnName = "id_personal")}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")})
    @ManyToMany
    private Collection<Roles> rolesCollection;
    @JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
    @ManyToOne(optional = false)
    private Puestos idPuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonal")
    private Collection<EquipoRespuesta> equipoRespuestaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersonal")
    private Collection<EquipoBase> equipoBaseCollection;

    public Personal() {
    }

    public Personal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Integer dispositivo) {
        this.dispositivo = dispositivo;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    public Puestos getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(Puestos idPuesto) {
        this.idPuesto = idPuesto;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<EquipoRespuesta> getEquipoRespuestaCollection() {
        return equipoRespuestaCollection;
    }

    public void setEquipoRespuestaCollection(Collection<EquipoRespuesta> equipoRespuestaCollection) {
        this.equipoRespuestaCollection = equipoRespuestaCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<EquipoBase> getEquipoBaseCollection() {
        return equipoBaseCollection;
    }

    public void setEquipoBaseCollection(Collection<EquipoBase> equipoBaseCollection) {
        this.equipoBaseCollection = equipoBaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Personal[ idPersonal=" + idPersonal + " ]";
    }
    
}
