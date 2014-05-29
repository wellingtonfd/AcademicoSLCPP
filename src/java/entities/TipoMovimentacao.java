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
@Table(name = "tipo_movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMovimentacao.findAll", query = "SELECT t FROM TipoMovimentacao t"),
    @NamedQuery(name = "TipoMovimentacao.findByIdTipoMovimentacao", query = "SELECT t FROM TipoMovimentacao t WHERE t.idTipoMovimentacao = :idTipoMovimentacao"),
    @NamedQuery(name = "TipoMovimentacao.findByTipoMovimentacao", query = "SELECT t FROM TipoMovimentacao t WHERE t.tipoMovimentacao = :tipoMovimentacao")})
public class TipoMovimentacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_movimentacao")
    private Integer idTipoMovimentacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_movimentacao")
    private int tipoMovimentacao;
    @JoinColumn(name = "usuarioid_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMovimentacaoidTipoMovimentacao")
    private Collection<TipoCompatibilidade> tipoCompatibilidadeCollection;

    public TipoMovimentacao() {
    }

    public TipoMovimentacao(Integer idTipoMovimentacao) {
        this.idTipoMovimentacao = idTipoMovimentacao;
    }

    public TipoMovimentacao(Integer idTipoMovimentacao, int tipoMovimentacao) {
        this.idTipoMovimentacao = idTipoMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Integer getIdTipoMovimentacao() {
        return idTipoMovimentacao;
    }

    public void setIdTipoMovimentacao(Integer idTipoMovimentacao) {
        this.idTipoMovimentacao = idTipoMovimentacao;
    }

    public int getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(int tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
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
        hash += (idTipoMovimentacao != null ? idTipoMovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMovimentacao)) {
            return false;
        }
        TipoMovimentacao other = (TipoMovimentacao) object;
        if ((this.idTipoMovimentacao == null && other.idTipoMovimentacao != null) || (this.idTipoMovimentacao != null && !this.idTipoMovimentacao.equals(other.idTipoMovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TipoMovimentacao[ idTipoMovimentacao=" + idTipoMovimentacao + " ]";
    }
    
}
