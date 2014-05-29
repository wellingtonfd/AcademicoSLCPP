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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "composproduto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Composproduto.findAll", query = "SELECT c FROM Composproduto c"),
    @NamedQuery(name = "Composproduto.findByTipoproduto", query = "SELECT c FROM Composproduto c WHERE c.tipoproduto = :tipoproduto"),
    @NamedQuery(name = "Composproduto.findByFormulaproduto", query = "SELECT c FROM Composproduto c WHERE c.formulaproduto = :formulaproduto"),
    @NamedQuery(name = "Composproduto.findByFormaproduto", query = "SELECT c FROM Composproduto c WHERE c.formaproduto = :formaproduto"),
    @NamedQuery(name = "Composproduto.findByOdorproduto", query = "SELECT c FROM Composproduto c WHERE c.odorproduto = :odorproduto"),
    @NamedQuery(name = "Composproduto.findByPh", query = "SELECT c FROM Composproduto c WHERE c.ph = :ph"),
    @NamedQuery(name = "Composproduto.findByEstfisico", query = "SELECT c FROM Composproduto c WHERE c.estfisico = :estfisico"),
    @NamedQuery(name = "Composproduto.findBySolibilidadeagua", query = "SELECT c FROM Composproduto c WHERE c.solibilidadeagua = :solibilidadeagua"),
    @NamedQuery(name = "Composproduto.findByLimiteexplosivo", query = "SELECT c FROM Composproduto c WHERE c.limiteexplosivo = :limiteexplosivo"),
    @NamedQuery(name = "Composproduto.findByDensidade", query = "SELECT c FROM Composproduto c WHERE c.densidade = :densidade"),
    @NamedQuery(name = "Composproduto.findByPressavapor", query = "SELECT c FROM Composproduto c WHERE c.pressavapor = :pressavapor"),
    @NamedQuery(name = "Composproduto.findBySinonimos", query = "SELECT c FROM Composproduto c WHERE c.sinonimos = :sinonimos"),
    @NamedQuery(name = "Composproduto.findByTramentodisposicao", query = "SELECT c FROM Composproduto c WHERE c.tramentodisposicao = :tramentodisposicao"),
    @NamedQuery(name = "Composproduto.findByRegulamentacao", query = "SELECT c FROM Composproduto c WHERE c.regulamentacao = :regulamentacao"),
    @NamedQuery(name = "Composproduto.findByDecomposicao", query = "SELECT c FROM Composproduto c WHERE c.decomposicao = :decomposicao")})
public class Composproduto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoproduto")
    private Integer tipoproduto;
    @Size(max = 45)
    @Column(name = "formulaproduto")
    private String formulaproduto;
    @Size(max = 45)
    @Column(name = "formaproduto")
    private String formaproduto;
    @Size(max = 45)
    @Column(name = "odorproduto")
    private String odorproduto;
    @Size(max = 45)
    @Column(name = "ph")
    private String ph;
    @Size(max = 35)
    @Column(name = "estfisico")
    private String estfisico;
    @Size(max = 35)
    @Column(name = "solibilidadeagua")
    private String solibilidadeagua;
    @Size(max = 35)
    @Column(name = "limiteexplosivo")
    private String limiteexplosivo;
    @Size(max = 35)
    @Column(name = "densidade")
    private String densidade;
    @Size(max = 35)
    @Column(name = "pressavapor")
    private String pressavapor;
    @Size(max = 30)
    @Column(name = "sinonimos")
    private String sinonimos;
    @Size(max = 255)
    @Column(name = "tramentodisposicao")
    private String tramentodisposicao;
    @Size(max = 100)
    @Column(name = "regulamentacao")
    private String regulamentacao;
    @Size(max = 100)
    @Column(name = "decomposicao")
    private String decomposicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "composprodutotipoproduto")
    private Collection<Produto> produtoCollection;

    public Composproduto() {
    }

    public Composproduto(Integer tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public Integer getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(Integer tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public String getFormulaproduto() {
        return formulaproduto;
    }

    public void setFormulaproduto(String formulaproduto) {
        this.formulaproduto = formulaproduto;
    }

    public String getFormaproduto() {
        return formaproduto;
    }

    public void setFormaproduto(String formaproduto) {
        this.formaproduto = formaproduto;
    }

    public String getOdorproduto() {
        return odorproduto;
    }

    public void setOdorproduto(String odorproduto) {
        this.odorproduto = odorproduto;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getEstfisico() {
        return estfisico;
    }

    public void setEstfisico(String estfisico) {
        this.estfisico = estfisico;
    }

    public String getSolibilidadeagua() {
        return solibilidadeagua;
    }

    public void setSolibilidadeagua(String solibilidadeagua) {
        this.solibilidadeagua = solibilidadeagua;
    }

    public String getLimiteexplosivo() {
        return limiteexplosivo;
    }

    public void setLimiteexplosivo(String limiteexplosivo) {
        this.limiteexplosivo = limiteexplosivo;
    }

    public String getDensidade() {
        return densidade;
    }

    public void setDensidade(String densidade) {
        this.densidade = densidade;
    }

    public String getPressavapor() {
        return pressavapor;
    }

    public void setPressavapor(String pressavapor) {
        this.pressavapor = pressavapor;
    }

    public String getSinonimos() {
        return sinonimos;
    }

    public void setSinonimos(String sinonimos) {
        this.sinonimos = sinonimos;
    }

    public String getTramentodisposicao() {
        return tramentodisposicao;
    }

    public void setTramentodisposicao(String tramentodisposicao) {
        this.tramentodisposicao = tramentodisposicao;
    }

    public String getRegulamentacao() {
        return regulamentacao;
    }

    public void setRegulamentacao(String regulamentacao) {
        this.regulamentacao = regulamentacao;
    }

    public String getDecomposicao() {
        return decomposicao;
    }

    public void setDecomposicao(String decomposicao) {
        this.decomposicao = decomposicao;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoproduto != null ? tipoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Composproduto)) {
            return false;
        }
        Composproduto other = (Composproduto) object;
        if ((this.tipoproduto == null && other.tipoproduto != null) || (this.tipoproduto != null && !this.tipoproduto.equals(other.tipoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Composproduto[ tipoproduto=" + tipoproduto + " ]";
    }
    
}
