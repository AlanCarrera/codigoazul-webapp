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
@Table(name = "zonas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zonas.findAll", query = "SELECT z FROM Zonas z"),
    @NamedQuery(name = "Zonas.findByIdZona", query = "SELECT z FROM Zonas z WHERE z.idZona = :idZona"),
    @NamedQuery(name = "Zonas.findByNombre", query = "SELECT z FROM Zonas z WHERE z.nombre = :nombre"),
    @NamedQuery(name = "Zonas.findByXesi", query = "SELECT z FROM Zonas z WHERE z.xesi = :xesi"),
    @NamedQuery(name = "Zonas.findByYesi", query = "SELECT z FROM Zonas z WHERE z.yesi = :yesi"),
    @NamedQuery(name = "Zonas.findByXeid", query = "SELECT z FROM Zonas z WHERE z.xeid = :xeid"),
    @NamedQuery(name = "Zonas.findByYeid", query = "SELECT z FROM Zonas z WHERE z.yeid = :yeid")})
public class Zonas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_zona")
    private Integer idZona;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "xesi")
    private Double xesi;
    @Column(name = "yesi")
    private Double yesi;
    @Column(name = "xeid")
    private Double xeid;
    @Column(name = "yeid")
    private Double yeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZona")
    private Collection<EquipoRespuesta> equipoRespuestaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZonaDest")
    private Collection<Grafos> grafosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZonaOrig")
    private Collection<Grafos> grafosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idZona")
    private Collection<EquipoBase> equipoBaseCollection;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private Areas idArea;

    public Zonas() {
    }

    public Zonas(Integer idZona) {
        this.idZona = idZona;
    }

    public Zonas(Integer idZona, String nombre) {
        this.idZona = idZona;
        this.nombre = nombre;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getXesi() {
        return xesi;
    }

    public void setXesi(Double xesi) {
        this.xesi = xesi;
    }

    public Double getYesi() {
        return yesi;
    }

    public void setYesi(Double yesi) {
        this.yesi = yesi;
    }

    public Double getXeid() {
        return xeid;
    }

    public void setXeid(Double xeid) {
        this.xeid = xeid;
    }

    public Double getYeid() {
        return yeid;
    }

    public void setYeid(Double yeid) {
        this.yeid = yeid;
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
    public Collection<Grafos> getGrafosCollection() {
        return grafosCollection;
    }

    public void setGrafosCollection(Collection<Grafos> grafosCollection) {
        this.grafosCollection = grafosCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Grafos> getGrafosCollection1() {
        return grafosCollection1;
    }

    public void setGrafosCollection1(Collection<Grafos> grafosCollection1) {
        this.grafosCollection1 = grafosCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<EquipoBase> getEquipoBaseCollection() {
        return equipoBaseCollection;
    }

    public void setEquipoBaseCollection(Collection<EquipoBase> equipoBaseCollection) {
        this.equipoBaseCollection = equipoBaseCollection;
    }

    public Areas getIdArea() {
        return idArea;
    }

    public void setIdArea(Areas idArea) {
        this.idArea = idArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZona != null ? idZona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zonas)) {
            return false;
        }
        Zonas other = (Zonas) object;
        if ((this.idZona == null && other.idZona != null) || (this.idZona != null && !this.idZona.equals(other.idZona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Zonas[ idZona=" + idZona + " ]";
    }
    
}
