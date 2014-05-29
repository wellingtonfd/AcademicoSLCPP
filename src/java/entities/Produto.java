/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByNomeProduto", query = "SELECT p FROM Produto p WHERE p.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "Produto.findByNomegenerico", query = "SELECT p FROM Produto p WHERE p.nomegenerico = :nomegenerico"),
    @NamedQuery(name = "Produto.findByOrigem", query = "SELECT p FROM Produto p WHERE p.origem = :origem"),
    @NamedQuery(name = "Produto.findByNumcas", query = "SELECT p FROM Produto p WHERE p.numcas = :numcas"),
    @NamedQuery(name = "Produto.findByRotuloproduto", query = "SELECT p FROM Produto p WHERE p.rotuloproduto = :rotuloproduto"),
    @NamedQuery(name = "Produto.findByPainelseg", query = "SELECT p FROM Produto p WHERE p.painelseg = :painelseg"),
    @NamedQuery(name = "Produto.findByRisco", query = "SELECT p FROM Produto p WHERE p.risco = :risco"),
    @NamedQuery(name = "Produto.findByAcoesemergencia", query = "SELECT p FROM Produto p WHERE p.acoesemergencia = :acoesemergencia"),
    @NamedQuery(name = "Produto.findByNumlote", query = "SELECT p FROM Produto p WHERE p.numlote = :numlote"),
    @NamedQuery(name = "Produto.findByDtfabricacao", query = "SELECT p FROM Produto p WHERE p.dtfabricacao = :dtfabricacao"),
    @NamedQuery(name = "Produto.findByDtvalidade", query = "SELECT p FROM Produto p WHERE p.dtvalidade = :dtvalidade")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produto")
    private Integer idProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nomegenerico")
    private String nomegenerico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "origem")
    private String origem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numcas")
    private String numcas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "rotuloproduto")
    private String rotuloproduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "painelseg")
    private String painelseg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "risco")
    private String risco;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "acoesemergencia")
    private String acoesemergencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "numlote")
    private String numlote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtfabricacao")
    @Temporal(TemporalType.DATE)
    private Date dtfabricacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtvalidade")
    @Temporal(TemporalType.DATE)
    private Date dtvalidade;
    @JoinColumn(name = "rum_onuid_num_onu", referencedColumnName = "id_num_onu")
    @ManyToOne(optional = false)
    private NumOnu rumOnuidNumOnu;
    @JoinColumn(name = "fornecedorid_fornecedor", referencedColumnName = "id_fornecedor")
    @ManyToOne(optional = false)
    private Fornecedor fornecedoridFornecedor;
    @JoinColumn(name = "composprodutotipoproduto", referencedColumnName = "tipoproduto")
    @ManyToOne(optional = false)
    private Composproduto composprodutotipoproduto;
    @JoinColumn(name = "classeid_classe", referencedColumnName = "id_classe")
    @ManyToOne(optional = false)
    private Classe classeidClasse;

    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String nomeProduto, String nomegenerico, String origem, String numcas, String rotuloproduto, String painelseg, String risco, String acoesemergencia, String numlote, Date dtfabricacao, Date dtvalidade) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.nomegenerico = nomegenerico;
        this.origem = origem;
        this.numcas = numcas;
        this.rotuloproduto = rotuloproduto;
        this.painelseg = painelseg;
        this.risco = risco;
        this.acoesemergencia = acoesemergencia;
        this.numlote = numlote;
        this.dtfabricacao = dtfabricacao;
        this.dtvalidade = dtvalidade;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomegenerico() {
        return nomegenerico;
    }

    public void setNomegenerico(String nomegenerico) {
        this.nomegenerico = nomegenerico;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getNumcas() {
        return numcas;
    }

    public void setNumcas(String numcas) {
        this.numcas = numcas;
    }

    public String getRotuloproduto() {
        return rotuloproduto;
    }

    public void setRotuloproduto(String rotuloproduto) {
        this.rotuloproduto = rotuloproduto;
    }

    public String getPainelseg() {
        return painelseg;
    }

    public void setPainelseg(String painelseg) {
        this.painelseg = painelseg;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public String getAcoesemergencia() {
        return acoesemergencia;
    }

    public void setAcoesemergencia(String acoesemergencia) {
        this.acoesemergencia = acoesemergencia;
    }

    public String getNumlote() {
        return numlote;
    }

    public void setNumlote(String numlote) {
        this.numlote = numlote;
    }

    public Date getDtfabricacao() {
        return dtfabricacao;
    }

    public void setDtfabricacao(Date dtfabricacao) {
        this.dtfabricacao = dtfabricacao;
    }

    public Date getDtvalidade() {
        return dtvalidade;
    }

    public void setDtvalidade(Date dtvalidade) {
        this.dtvalidade = dtvalidade;
    }

    public NumOnu getRumOnuidNumOnu() {
        return rumOnuidNumOnu;
    }

    public void setRumOnuidNumOnu(NumOnu rumOnuidNumOnu) {
        this.rumOnuidNumOnu = rumOnuidNumOnu;
    }

    public Fornecedor getFornecedoridFornecedor() {
        return fornecedoridFornecedor;
    }

    public void setFornecedoridFornecedor(Fornecedor fornecedoridFornecedor) {
        this.fornecedoridFornecedor = fornecedoridFornecedor;
    }

    public Composproduto getComposprodutotipoproduto() {
        return composprodutotipoproduto;
    }

    public void setComposprodutotipoproduto(Composproduto composprodutotipoproduto) {
        this.composprodutotipoproduto = composprodutotipoproduto;
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
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produto[ idProduto=" + idProduto + " ]";
    }
    
}
