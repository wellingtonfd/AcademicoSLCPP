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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findByIdClasse", query = "SELECT c FROM Classe c WHERE c.idClasse = :idClasse"),
    @NamedQuery(name = "Classe.findByClasse", query = "SELECT c FROM Classe c WHERE c.classe = :classe"),
    @NamedQuery(name = "Classe.findBySubclasse", query = "SELECT c FROM Classe c WHERE c.subclasse = :subclasse")})
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_classe")
    private Integer idClasse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "classe")
    private int classe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subclasse")
    private int subclasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeidClasse")
    private Collection<Produto> produtoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeidClasse")
    private Collection<Embalagem> embalagemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeidClasse")
    private Collection<TipoCompatibilidade> tipoCompatibilidadeCollection;

    public Classe() {
    }

    public Classe(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public Classe(Integer idClasse, int classe, int subclasse) {
        this.idClasse = idClasse;
        this.classe = classe;
        this.subclasse = subclasse;
    }

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public int getSubclasse() {
        return subclasse;
    }

    public void setSubclasse(int subclasse) {
        this.subclasse = subclasse;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @XmlTransient
    public Collection<Embalagem> getEmbalagemCollection() {
        return embalagemCollection;
    }

    public void setEmbalagemCollection(Collection<Embalagem> embalagemCollection) {
        this.embalagemCollection = embalagemCollection;
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
        hash += (idClasse != null ? idClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idClasse == null && other.idClasse != null) || (this.idClasse != null && !this.idClasse.equals(other.idClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Classe[ idClasse=" + idClasse + " ]";
    }
    
}
