/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "detalhe_nota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalheNota.findAll", query = "SELECT d FROM DetalheNota d"),
    @NamedQuery(name = "DetalheNota.findByIdDetalheNota", query = "SELECT d FROM DetalheNota d WHERE d.idDetalheNota = :idDetalheNota"),
    @NamedQuery(name = "DetalheNota.findByNumNota", query = "SELECT d FROM DetalheNota d WHERE d.numNota = :numNota"),
    @NamedQuery(name = "DetalheNota.findByValorUnitario", query = "SELECT d FROM DetalheNota d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "DetalheNota.findByDtPedido", query = "SELECT d FROM DetalheNota d WHERE d.dtPedido = :dtPedido"),
    @NamedQuery(name = "DetalheNota.findByValorTotal", query = "SELECT d FROM DetalheNota d WHERE d.valorTotal = :valorTotal")})
public class DetalheNota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalhe_nota")
    private Integer idDetalheNota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_nota")
    private int numNota;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_pedido")
    @Temporal(TemporalType.DATE)
    private Date dtPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @JoinColumn(name = "tipo_equipamentoid_tipo_equipamento", referencedColumnName = "id_tipo_equipamento")
    @ManyToOne(optional = false)
    private TipoEquipamento tipoEquipamentoidTipoEquipamento;
    @JoinColumn(name = "fornecedorid_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedoridFornecedor;
    @JoinColumn(name = "embalagemid_embalgem", referencedColumnName = "id_embalgem")
    @ManyToOne(optional = false)
    private Embalagem embalagemidEmbalgem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalheNotaidDetalheNota")
    private Collection<TipoPedido> tipoPedidoCollection;

    public DetalheNota() {
    }

    public DetalheNota(Integer idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public DetalheNota(Integer idDetalheNota, int numNota, BigDecimal valorUnitario, Date dtPedido, BigDecimal valorTotal) {
        this.idDetalheNota = idDetalheNota;
        this.numNota = numNota;
        this.valorUnitario = valorUnitario;
        this.dtPedido = dtPedido;
        this.valorTotal = valorTotal;
    }

    public Integer getIdDetalheNota() {
        return idDetalheNota;
    }

    public void setIdDetalheNota(Integer idDetalheNota) {
        this.idDetalheNota = idDetalheNota;
    }

    public int getNumNota() {
        return numNota;
    }

    public void setNumNota(int numNota) {
        this.numNota = numNota;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Date getDtPedido() {
        return dtPedido;
    }

    public void setDtPedido(Date dtPedido) {
        this.dtPedido = dtPedido;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TipoEquipamento getTipoEquipamentoidTipoEquipamento() {
        return tipoEquipamentoidTipoEquipamento;
    }

    public void setTipoEquipamentoidTipoEquipamento(TipoEquipamento tipoEquipamentoidTipoEquipamento) {
        this.tipoEquipamentoidTipoEquipamento = tipoEquipamentoidTipoEquipamento;
    }

    public Fornecedor getFornecedoridFornecedor() {
        return fornecedoridFornecedor;
    }

    public void setFornecedoridFornecedor(Fornecedor fornecedoridFornecedor) {
        this.fornecedoridFornecedor = fornecedoridFornecedor;
    }

    public Embalagem getEmbalagemidEmbalgem() {
        return embalagemidEmbalgem;
    }

    public void setEmbalagemidEmbalgem(Embalagem embalagemidEmbalgem) {
        this.embalagemidEmbalgem = embalagemidEmbalgem;
    }

    @XmlTransient
    public Collection<TipoPedido> getTipoPedidoCollection() {
        return tipoPedidoCollection;
    }

    public void setTipoPedidoCollection(Collection<TipoPedido> tipoPedidoCollection) {
        this.tipoPedidoCollection = tipoPedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalheNota != null ? idDetalheNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalheNota)) {
            return false;
        }
        DetalheNota other = (DetalheNota) object;
        if ((this.idDetalheNota == null && other.idDetalheNota != null) || (this.idDetalheNota != null && !this.idDetalheNota.equals(other.idDetalheNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetalheNota[ idDetalheNota=" + idDetalheNota + " ]";
    }
    
}
