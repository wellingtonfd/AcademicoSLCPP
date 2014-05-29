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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tipo_compatibilidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCompatibilidade.findAll", query = "SELECT t FROM TipoCompatibilidade t"),
    @NamedQuery(name = "TipoCompatibilidade.findByIdTipoCompatibilidade", query = "SELECT t FROM TipoCompatibilidade t WHERE t.idTipoCompatibilidade = :idTipoCompatibilidade"),
    @NamedQuery(name = "TipoCompatibilidade.findByEspecificacao", query = "SELECT t FROM TipoCompatibilidade t WHERE t.especificacao = :especificacao")})
public class TipoCompatibilidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_compatibilidade")
    private Integer idTipoCompatibilidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "especificacao")
    private String especificacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCompatibilidadeidTipoCompatibilidade")
    private Collection<StatusArmazem> statusArmazemCollection;
    @JoinColumn(name = "toxidadeid_toxidade", referencedColumnName = "id_toxidade")
    @ManyToOne(optional = false)
    private Toxidade toxidadeidToxidade;
    @JoinColumn(name = "tipo_movimentacaoid_tipo_movimentacao", referencedColumnName = "id_tipo_movimentacao")
    @ManyToOne(optional = false)
    private TipoMovimentacao tipoMovimentacaoidTipoMovimentacao;
    @JoinColumn(name = "pt_fulgorid_pt_fulgor", referencedColumnName = "id_pt_fulgor")
    @ManyToOne(optional = false)
    private PtFulgor ptFulgoridPtFulgor;
    @JoinColumn(name = "pt_ebulicaoid_pt_ebulicao", referencedColumnName = "id_pt_ebulicao")
    @ManyToOne(optional = false)
    private PtEbulicao ptEbulicaoidPtEbulicao;
    @JoinColumn(name = "num_onuid_num_onu", referencedColumnName = "id_num_onu")
    @ManyToOne(optional = false)
    private NumOnu numOnuidNumOnu;
    @JoinColumn(name = "classeid_classe", referencedColumnName = "id_classe")
    @ManyToOne(optional = false)
    private Classe classeidClasse;

    public TipoCompatibilidade() {
    }

    public TipoCompatibilidade(Integer idTipoCompatibilidade) {
        this.idTipoCompatibilidade = idTipoCompatibilidade;
    }

    public TipoCompatibilidade(Integer idTipoCompatibilidade, String especificacao) {
        this.idTipoCompatibilidade = idTipoCompatibilidade;
        this.especificacao = especificacao;
    }

    public Integer getIdTipoCompatibilidade() {
        return idTipoCompatibilidade;
    }

    public void setIdTipoCompatibilidade(Integer idTipoCompatibilidade) {
        this.idTipoCompatibilidade = idTipoCompatibilidade;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    @XmlTransient
    public Collection<StatusArmazem> getStatusArmazemCollection() {
        return statusArmazemCollection;
    }

    public void setStatusArmazemCollection(Collection<StatusArmazem> statusArmazemCollection) {
        this.statusArmazemCollection = statusArmazemCollection;
    }

    public Toxidade getToxidadeidToxidade() {
        return toxidadeidToxidade;
    }

    public void setToxidadeidToxidade(Toxidade toxidadeidToxidade) {
        this.toxidadeidToxidade = toxidadeidToxidade;
    }

    public TipoMovimentacao getTipoMovimentacaoidTipoMovimentacao() {
        return tipoMovimentacaoidTipoMovimentacao;
    }

    public void setTipoMovimentacaoidTipoMovimentacao(TipoMovimentacao tipoMovimentacaoidTipoMovimentacao) {
        this.tipoMovimentacaoidTipoMovimentacao = tipoMovimentacaoidTipoMovimentacao;
    }

    public PtFulgor getPtFulgoridPtFulgor() {
        return ptFulgoridPtFulgor;
    }

    public void setPtFulgoridPtFulgor(PtFulgor ptFulgoridPtFulgor) {
        this.ptFulgoridPtFulgor = ptFulgoridPtFulgor;
    }

    public PtEbulicao getPtEbulicaoidPtEbulicao() {
        return ptEbulicaoidPtEbulicao;
    }

    public void setPtEbulicaoidPtEbulicao(PtEbulicao ptEbulicaoidPtEbulicao) {
        this.ptEbulicaoidPtEbulicao = ptEbulicaoidPtEbulicao;
    }

    public NumOnu getNumOnuidNumOnu() {
        return numOnuidNumOnu;
    }

    public void setNumOnuidNumOnu(NumOnu numOnuidNumOnu) {
        this.numOnuidNumOnu = numOnuidNumOnu;
    }

    public Classe getClasseidClasse() {
        return classeidClasse;
    }

    public void setClasseidClasse(Classe classeidClasse) {
        this.classeidClasse = classeidClasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCompatibilidade != null ? idTipoCompatibilidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCompatibilidade)) {
            return false;
        }
        TipoCompatibilidade other = (TipoCompatibilidade) object;
        if ((this.idTipoCompatibilidade == null && other.idTipoCompatibilidade != null) || (this.idTipoCompatibilidade != null && !this.idTipoCompatibilidade.equals(other.idTipoCompatibilidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoCompatibilidade[ idTipoCompatibilidade=" + idTipoCompatibilidade + " ]";
    }
    
}
