/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "equipo_base")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoBase.findAll", query = "SELECT e FROM EquipoBase e"),
    @NamedQuery(name = "EquipoBase.findByIdEquipoBase", query = "SELECT e FROM EquipoBase e WHERE e.idEquipoBase = :idEquipoBase"),
    @NamedQuery(name = "EquipoBase.findByDisponible", query = "SELECT e FROM EquipoBase e WHERE e.disponible = :disponible"),
    @NamedQuery(name = "EquipoBase.findByRol", query = "SELECT e FROM EquipoBase e WHERE e.idRol = :rolesIdrol")})
public class EquipoBase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_equipo_base")
    private Integer idEquipoBase;
    @Column(name = "disponible")
    private Boolean disponible;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Roles idRol;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal")
    @ManyToOne(optional = false)
    private Personal idPersonal;
    @JoinColumn(name = "id_zona", referencedColumnName = "id_zona")
    @ManyToOne(optional = false)
    private Zonas idZona;

    public EquipoBase() {
    }

    public EquipoBase(Integer idEquipoBase) {
        this.idEquipoBase = idEquipoBase;
    }

    public Integer getIdEquipoBase() {
        return idEquipoBase;
    }

    public void setIdEquipoBase(Integer idEquipoBase) {
        this.idEquipoBase = idEquipoBase;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    public Personal getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Personal idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Zonas getIdZona() {
        return idZona;
    }

    public void setIdZona(Zonas idZona) {
        this.idZona = idZona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoBase != null ? idEquipoBase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoBase)) {
            return false;
        }
        EquipoBase other = (EquipoBase) object;
        if ((this.idEquipoBase == null && other.idEquipoBase != null) || (this.idEquipoBase != null && !this.idEquipoBase.equals(other.idEquipoBase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EquipoBase[ idEquipoBase=" + idEquipoBase + " ]";
    }
    
}
