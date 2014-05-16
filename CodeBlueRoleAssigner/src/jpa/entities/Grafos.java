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
@Table(name = "grafos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grafos.findAll", query = "SELECT g FROM Grafos g"),
    @NamedQuery(name = "Grafos.findByIdGrafo", query = "SELECT g FROM Grafos g WHERE g.idGrafo = :idGrafo"),
    @NamedQuery(name = "Grafos.findByDistancia", query = "SELECT g FROM Grafos g WHERE g.distancia = :distancia"),
    @NamedQuery(name = "Grafos.findByFactor", query = "SELECT g.factor FROM Grafos g WHERE g.idZonaOrig = :idzonaOrig AND g.idZonaDest = :idzonaDest")})
public class Grafos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_grafo")
    private Integer idGrafo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "distancia")
    private Double distancia;
    @Column(name = "factor")
    private Double factor;
    @JoinColumn(name = "id_zona_dest", referencedColumnName = "id_zona")
    @ManyToOne(optional = false)
    private Zonas idZonaDest;
    @JoinColumn(name = "id_zona_orig", referencedColumnName = "id_zona")
    @ManyToOne(optional = false)
    private Zonas idZonaOrig;

    public Grafos() {
    }

    public Grafos(Integer idGrafo) {
        this.idGrafo = idGrafo;
    }

    public Integer getIdGrafo() {
        return idGrafo;
    }

    public void setIdGrafo(Integer idGrafo) {
        this.idGrafo = idGrafo;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public Zonas getIdZonaDest() {
        return idZonaDest;
    }

    public void setIdZonaDest(Zonas idZonaDest) {
        this.idZonaDest = idZonaDest;
    }

    public Zonas getIdZonaOrig() {
        return idZonaOrig;
    }

    public void setIdZonaOrig(Zonas idZonaOrig) {
        this.idZonaOrig = idZonaOrig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrafo != null ? idGrafo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grafos)) {
            return false;
        }
        Grafos other = (Grafos) object;
        if ((this.idGrafo == null && other.idGrafo != null) || (this.idGrafo != null && !this.idGrafo.equals(other.idGrafo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Grafos[ idGrafo=" + idGrafo + " ]";
    }
    
}
