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
@Table(name = "nivelusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivelusuario.findAll", query = "SELECT n FROM Nivelusuario n"),
    @NamedQuery(name = "Nivelusuario.findByIdNivelusuario", query = "SELECT n FROM Nivelusuario n WHERE n.idNivelusuario = :idNivelusuario"),
    @NamedQuery(name = "Nivelusuario.findByNomenivel", query = "SELECT n FROM Nivelusuario n WHERE n.nomenivel = :nomenivel")})
public class Nivelusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivelusuario")
    private Long idNivelusuario;
    @Size(max = 20)
    @Column(name = "nomenivel")
    private String nomenivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivelusuarioidNivelusuario")
    private Collection<Usuario> usuarioCollection;

    public Nivelusuario() {
    }

    public Nivelusuario(Long idNivelusuario) {
        this.idNivelusuario = idNivelusuario;
    }

    public Long getIdNivelusuario() {
        return idNivelusuario;
    }

    public void setIdNivelusuario(Long idNivelusuario) {
        this.idNivelusuario = idNivelusuario;
    }

    public String getNomenivel() {
        return nomenivel;
    }

    public void setNomenivel(String nomenivel) {
        this.nomenivel = nomenivel;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelusuario != null ? idNivelusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivelusuario)) {
            return false;
        }
        Nivelusuario other = (Nivelusuario) object;
        if ((this.idNivelusuario == null && other.idNivelusuario != null) || (this.idNivelusuario != null && !this.idNivelusuario.equals(other.idNivelusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Nivelusuario[ idNivelusuario=" + idNivelusuario + " ]";
    }
    
}
