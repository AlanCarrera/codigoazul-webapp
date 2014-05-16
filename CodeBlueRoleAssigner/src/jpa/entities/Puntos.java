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
@Table(name = "puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntos.findAll", query = "SELECT p FROM Puntos p"),
    @NamedQuery(name = "Puntos.findByIdPunto", query = "SELECT p FROM Puntos p WHERE p.idPunto = :idPunto"),
    @NamedQuery(name = "Puntos.findByX", query = "SELECT p FROM Puntos p WHERE p.x = :x"),
    @NamedQuery(name = "Puntos.findByY", query = "SELECT p FROM Puntos p WHERE p.y = :y")})
public class Puntos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_punto")
    private Integer idPunto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "x")
    private Double x;
    @Column(name = "y")
    private Double y;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private Areas idArea;

    public Puntos() {
    }

    public Puntos(Integer idPunto) {
        this.idPunto = idPunto;
    }

    public Integer getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(Integer idPunto) {
        this.idPunto = idPunto;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
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
        hash += (idPunto != null ? idPunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntos)) {
            return false;
        }
        Puntos other = (Puntos) object;
        if ((this.idPunto == null && other.idPunto != null) || (this.idPunto != null && !this.idPunto.equals(other.idPunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Puntos[ idPunto=" + idPunto + " ]";
    }
    
}
