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
@Table(name = "armazem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Armazem.findAll", query = "SELECT a FROM Armazem a"),
    @NamedQuery(name = "Armazem.findByIdArmazem", query = "SELECT a FROM Armazem a WHERE a.idArmazem = :idArmazem"),
    @NamedQuery(name = "Armazem.findByTipo", query = "SELECT a FROM Armazem a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Armazem.findByCapacidade", query = "SELECT a FROM Armazem a WHERE a.capacidade = :capacidade"),
    @NamedQuery(name = "Armazem.findByEspecificacao", query = "SELECT a FROM Armazem a WHERE a.especificacao = :especificacao"),
    @NamedQuery(name = "Armazem.findByCertificacao", query = "SELECT a FROM Armazem a WHERE a.certificacao = :certificacao")})
public class Armazem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_armazem")
    private Integer idArmazem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidade")
    private int capacidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "especificacao")
    private String especificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "certificacao")
    private String certificacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armazemidArmazem")
    private Collection<EndArmazem> endArmazemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "armazemidArmazem")
    private Collection<StatusArmazem> statusArmazemCollection;

    public Armazem() {
    }

    public Armazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public Armazem(Integer idArmazem, String tipo, int capacidade, String especificacao, String certificacao) {
        this.idArmazem = idArmazem;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.especificacao = especificacao;
        this.certificacao = certificacao;
    }

    public Integer getIdArmazem() {
        return idArmazem;
    }

    public void setIdArmazem(Integer idArmazem) {
        this.idArmazem = idArmazem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getCertificacao() {
        return certificacao;
    }

    public void setCertificacao(String certificacao) {
        this.certificacao = certificacao;
    }

    @XmlTransient
    public Collection<EndArmazem> getEndArmazemCollection() {
        return endArmazemCollection;
    }

    public void setEndArmazemCollection(Collection<EndArmazem> endArmazemCollection) {
        this.endArmazemCollection = endArmazemCollection;
    }

    @XmlTransient
    public Collection<StatusArmazem> getStatusArmazemCollection() {
        return statusArmazemCollection;
    }

    public void setStatusArmazemCollection(Collection<StatusArmazem> statusArmazemCollection) {
        this.statusArmazemCollection = statusArmazemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArmazem != null ? idArmazem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Armazem)) {
            return false;
        }
        Armazem other = (Armazem) object;
        if ((this.idArmazem == null && other.idArmazem != null) || (this.idArmazem != null && !this.idArmazem.equals(other.idArmazem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Armazem[ idArmazem=" + idArmazem + " ]";
    }
    
}
