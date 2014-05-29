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
@Table(name = "pt_fulgor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PtFulgor.findAll", query = "SELECT p FROM PtFulgor p"),
    @NamedQuery(name = "PtFulgor.findByIdPtFulgor", query = "SELECT p FROM PtFulgor p WHERE p.idPtFulgor = :idPtFulgor"),
    @NamedQuery(name = "PtFulgor.findByPtFulgMin", query = "SELECT p FROM PtFulgor p WHERE p.ptFulgMin = :ptFulgMin"),
    @NamedQuery(name = "PtFulgor.findByPtFulgMax", query = "SELECT p FROM PtFulgor p WHERE p.ptFulgMax = :ptFulgMax"),
    @NamedQuery(name = "PtFulgor.findByDescricao", query = "SELECT p FROM PtFulgor p WHERE p.descricao = :descricao")})
public class PtFulgor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pt_fulgor")
    private Integer idPtFulgor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pt_fulg_min")
    private int ptFulgMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pt_fulg_max")
    private int ptFulgMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ptFulgoridPtFulgor")
    private Collection<TipoCompatibilidade> tipoCompatibilidadeCollection;

    public PtFulgor() {
    }

    public PtFulgor(Integer idPtFulgor) {
        this.idPtFulgor = idPtFulgor;
    }

    public PtFulgor(Integer idPtFulgor, int ptFulgMin, int ptFulgMax, String descricao) {
        this.idPtFulgor = idPtFulgor;
        this.ptFulgMin = ptFulgMin;
        this.ptFulgMax = ptFulgMax;
        this.descricao = descricao;
    }

    public Integer getIdPtFulgor() {
        return idPtFulgor;
    }

    public void setIdPtFulgor(Integer idPtFulgor) {
        this.idPtFulgor = idPtFulgor;
    }

    public int getPtFulgMin() {
        return ptFulgMin;
    }

    public void setPtFulgMin(int ptFulgMin) {
        this.ptFulgMin = ptFulgMin;
    }

    public int getPtFulgMax() {
        return ptFulgMax;
    }

    public void setPtFulgMax(int ptFulgMax) {
        this.ptFulgMax = ptFulgMax;
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
        hash += (idPtFulgor != null ? idPtFulgor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PtFulgor)) {
            return false;
        }
        PtFulgor other = (PtFulgor) object;
        if ((this.idPtFulgor == null && other.idPtFulgor != null) || (this.idPtFulgor != null && !this.idPtFulgor.equals(other.idPtFulgor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PtFulgor[ idPtFulgor=" + idPtFulgor + " ]";
    }
    
}
