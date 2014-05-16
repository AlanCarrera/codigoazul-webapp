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
import javax.persistence.ManyToMany;
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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByIdRol", query = "SELECT r FROM Roles r WHERE r.idRol = :idRol"),
    @NamedQuery(name = "Roles.findByNombre", query = "SELECT r FROM Roles r WHERE r.nombre = :nombre")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_rol")
    private Integer idRol;
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "rolesCollection")
    private Collection<Personal> personalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private Collection<EquipoRespuesta> equipoRespuestaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private Collection<EquipoBase> equipoBaseCollection;

    public Roles() {
    }

    public Roles(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Personal> getPersonalCollection() {
        return personalCollection;
    }

    public void setPersonalCollection(Collection<Personal> personalCollection) {
        this.personalCollection = personalCollection;
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
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Roles[ idRol=" + idRol + " ]";
    }
    
}
