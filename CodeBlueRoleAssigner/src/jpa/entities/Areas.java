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
@Table(name = "areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a"),
    @NamedQuery(name = "Areas.findByIdArea", query = "SELECT a FROM Areas a WHERE a.idArea = :idArea"),
    @NamedQuery(name = "Areas.findByNombre", query = "SELECT a FROM Areas a WHERE a.nombre = :nombre")})
public class Areas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
    private Collection<Puntos> puntosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
    private Collection<Zonas> zonasCollection;

    public Areas() {
    }

    public Areas(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Puntos> getPuntosCollection() {
        return puntosCollection;
    }

    public void setPuntosCollection(Collection<Puntos> puntosCollection) {
        this.puntosCollection = puntosCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Zonas> getZonasCollection() {
        return zonasCollection;
    }

    public void setZonasCollection(Collection<Zonas> zonasCollection) {
        this.zonasCollection = zonasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Areas[ idArea=" + idArea + " ]";
    }
    
}
