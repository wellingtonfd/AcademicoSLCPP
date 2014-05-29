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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByIdFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedor.findByRazaosocial", query = "SELECT f FROM Fornecedor f WHERE f.razaosocial = :razaosocial"),
    @NamedQuery(name = "Fornecedor.findByNomefantasia", query = "SELECT f FROM Fornecedor f WHERE f.nomefantasia = :nomefantasia")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cnpj")
    private int cnpj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "razaosocial")
    private int razaosocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nomefantasia")
    private int nomefantasia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedoridFornecedor")
    private Collection<Produto> produtoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedoridFornecedor")
    private Collection<DetalheNota> detalheNotaCollection;
    @JoinColumn(name = "enderecoid_endereco", referencedColumnName = "id_endereco")
    @ManyToOne(optional = false)
    private Endereco enderecoidEndereco;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Fornecedor(Integer idFornecedor, int cnpj, int razaosocial, int nomefantasia) {
        this.idFornecedor = idFornecedor;
        this.cnpj = cnpj;
        this.razaosocial = razaosocial;
        this.nomefantasia = nomefantasia;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public int getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(int razaosocial) {
        this.razaosocial = razaosocial;
    }

    public int getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(int nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @XmlTransient
    public Collection<DetalheNota> getDetalheNotaCollection() {
        return detalheNotaCollection;
    }

    public void setDetalheNotaCollection(Collection<DetalheNota> detalheNotaCollection) {
        this.detalheNotaCollection = detalheNotaCollection;
    }

    public Endereco getEnderecoidEndereco() {
        return enderecoidEndereco;
    }

    public void setEnderecoidEndereco(Endereco enderecoidEndereco) {
        this.enderecoidEndereco = enderecoidEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fornecedor[ idFornecedor=" + idFornecedor + " ]";
    }
    
}
