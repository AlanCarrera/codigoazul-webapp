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
import javax.persistence.GeneratedValue;
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
@Table(name = "equipo_respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipoRespuesta.findAll", query = "SELECT e FROM EquipoRespuesta e"),
//    @NamedQuery(name = "EquipoRespuesta.deleteAll", query = "TRUNCATE TABLE EquipoRespuesta"),
    @NamedQuery(name = "EquipoRespuesta.findByIdEquipoRespuesta", query = "SELECT e FROM EquipoRespuesta e WHERE e.idEquipoRespuesta = :idEquipoRespuesta")})
public class EquipoRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_equipo_respuesta")
    private Integer idEquipoRespuesta;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Roles idRol;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal")
    @ManyToOne(optional = false)
    private Personal idPersonal;
    @JoinColumn(name = "id_zona", referencedColumnName = "id_zona")
    @ManyToOne(optional = false)
    private Zonas idZona;

    public EquipoRespuesta() {
    }

    public EquipoRespuesta(Integer idEquipoRespuesta) {
        this.idEquipoRespuesta = idEquipoRespuesta;
    }

    public Integer getIdEquipoRespuesta() {
        return idEquipoRespuesta;
    }

    public void setIdEquipoRespuesta(Integer idEquipoRespuesta) {
        this.idEquipoRespuesta = idEquipoRespuesta;
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
        hash += (idEquipoRespuesta != null ? idEquipoRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoRespuesta)) {
            return false;
        }
        EquipoRespuesta other = (EquipoRespuesta) object;
        if ((this.idEquipoRespuesta == null && other.idEquipoRespuesta != null) || (this.idEquipoRespuesta != null && !this.idEquipoRespuesta.equals(other.idEquipoRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EquipoRespuesta[ idEquipoRespuesta=" + idEquipoRespuesta + " ]";
    }
    
}
