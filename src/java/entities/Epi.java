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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "epi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Epi.findAll", query = "SELECT e FROM Epi e"),
    @NamedQuery(name = "Epi.findByIdEpi", query = "SELECT e FROM Epi e WHERE e.idEpi = :idEpi"),
    @NamedQuery(name = "Epi.findByGrupoEpi", query = "SELECT e FROM Epi e WHERE e.grupoEpi = :grupoEpi"),
    @NamedQuery(name = "Epi.findByEspecificacao", query = "SELECT e FROM Epi e WHERE e.especificacao = :especificacao")})
public class Epi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_epi")
    private Integer idEpi;
    @Column(name = "grupo_epi")
    private Integer grupoEpi;
    @Column(name = "especificacao")
    private Integer especificacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "epiidEpi")
    private Collection<TipoEquipamento> tipoEquipamentoCollection;

    public Epi() {
    }

    public Epi(Integer idEpi) {
        this.idEpi = idEpi;
    }

    public Integer getIdEpi() {
        return idEpi;
    }

    public void setIdEpi(Integer idEpi) {
        this.idEpi = idEpi;
    }

    public Integer getGrupoEpi() {
        return grupoEpi;
    }

    public void setGrupoEpi(Integer grupoEpi) {
        this.grupoEpi = grupoEpi;
    }

    public Integer getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(Integer especificacao) {
        this.especificacao = especificacao;
    }

    @XmlTransient
    public Collection<TipoEquipamento> getTipoEquipamentoCollection() {
        return tipoEquipamentoCollection;
    }

    public void setTipoEquipamentoCollection(Collection<TipoEquipamento> tipoEquipamentoCollection) {
        this.tipoEquipamentoCollection = tipoEquipamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEpi != null ? idEpi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epi)) {
            return false;
        }
        Epi other = (Epi) object;
        if ((this.idEpi == null && other.idEpi != null) || (this.idEpi != null && !this.idEpi.equals(other.idEpi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Epi[ idEpi=" + idEpi + " ]";
    }
    
}
