/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "toxidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Toxidade.findAll", query = "SELECT t FROM Toxidade t"),
    @NamedQuery(name = "Toxidade.findByIdToxidade", query = "SELECT t FROM Toxidade t WHERE t.idToxidade = :idToxidade"),
    @NamedQuery(name = "Toxidade.findByToxMin", query = "SELECT t FROM Toxidade t WHERE t.toxMin = :toxMin"),
    @NamedQuery(name = "Toxidade.findByToxMax", query = "SELECT t FROM Toxidade t WHERE t.toxMax = :toxMax"),
    @NamedQuery(name = "Toxidade.findByDescricao", query = "SELECT t FROM Toxidade t WHERE t.descricao = :descricao")})
public class Toxidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_toxidade")
    private Integer idToxidade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tox_min")
    private int toxMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tox_max")
    private int toxMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toxidadeidToxidade")
    private Collection<TipoCompatibilidade> tipoCompatibilidadeCollection;

    public Toxidade() {
    }

    public Toxidade(Integer idToxidade) {
        this.idToxidade = idToxidade;
    }

    public Toxidade(Integer idToxidade, int toxMin, int toxMax, String descricao) {
        this.idToxidade = idToxidade;
        this.toxMin = toxMin;
        this.toxMax = toxMax;
        this.descricao = descricao;
    }

    public Integer getIdToxidade() {
        return idToxidade;
    }

    public void setIdToxidade(Integer idToxidade) {
        this.idToxidade = idToxidade;
    }

    public int getToxMin() {
        return toxMin;
    }

    public void setToxMin(int toxMin) {
        this.toxMin = toxMin;
    }

    public int getToxMax() {
        return toxMax;
    }

    public void setToxMax(int toxMax) {
        this.toxMax = toxMax;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<TipoCompatibilidade> getTipoCompatibilidadeCollection() {
        return tipoCompatibilidadeCollection;
    }

    public void setTipoCompatibilidadeCollection(Collection<TipoCompatibilidade> tipoCompatibilidadeCollection) {
        this.tipoCompatibilidadeCollection = tipoCompatibilidadeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idToxidade != null ? idToxidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Toxidade)) {
            return false;
        }
        Toxidade other = (Toxidade) object;
        if ((this.idToxidade == null && other.idToxidade != null) || (this.idToxidade != null && !this.idToxidade.equals(other.idToxidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Toxidade[ idToxidade=" + idToxidade + " ]";
    }
    
}
