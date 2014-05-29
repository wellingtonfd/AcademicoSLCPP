/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "end_armazem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EndArmazem.findAll", query = "SELECT e FROM EndArmazem e"),
    @NamedQuery(name = "EndArmazem.findByIdEnderecamento", query = "SELECT e FROM EndArmazem e WHERE e.idEnderecamento = :idEnderecamento"),
    @NamedQuery(name = "EndArmazem.findByIdentificacao", query = "SELECT e FROM EndArmazem e WHERE e.identificacao = :identificacao"),
    @NamedQuery(name = "EndArmazem.findByCor", query = "SELECT e FROM EndArmazem e WHERE e.cor = :cor"),
    @NamedQuery(name = "EndArmazem.findByCodAreaArmazem", query = "SELECT e FROM EndArmazem e WHERE e.codAreaArmazem = :codAreaArmazem"),
    @NamedQuery(name = "EndArmazem.findByRuaArmazem", query = "SELECT e FROM EndArmazem e WHERE e.ruaArmazem = :ruaArmazem"),
    @NamedQuery(name = "EndArmazem.findByNumPortaPalete", query = "SELECT e FROM EndArmazem e WHERE e.numPortaPalete = :numPortaPalete"),
    @NamedQuery(name = "EndArmazem.findByNumPrateleiraEstante", query = "SELECT e FROM EndArmazem e WHERE e.numPrateleiraEstante = :numPrateleiraEstante"),
    @NamedQuery(name = "EndArmazem.findByPosVertical", query = "SELECT e FROM EndArmazem e WHERE e.posVertical = :posVertical"),
    @NamedQuery(name = "EndArmazem.findByPosHorizontal", query = "SELECT e FROM EndArmazem e WHERE e.posHorizontal = :posHorizontal")})
public class EndArmazem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enderecamento")
    private Integer idEnderecamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "identificacao")
    private String identificacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cor")
    private String cor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cod_area_armazem")
    private String codAreaArmazem;
    @Size(max = 15)
    @Column(name = "rua_armazem")
    private String ruaArmazem;
    @Size(max = 15)
    @Column(name = "num_porta_palete")
    private String numPortaPalete;
    @Column(name = "num_prateleira_estante")
    private Integer numPrateleiraEstante;
    @Size(max = 80)
    @Column(name = "pos_vertical")
    private String posVertical;
    @Size(max = 80)
    @Column(name = "pos_horizontal")
    private String posHorizontal;
    @JoinColumn(name = "armazemid_armazem", referencedColumnName = "id_armazem")
    @ManyToOne(optional = false)
    private Armazem armazemidArmazem;

    public EndArmazem() {
    }

    public EndArmazem(Integer idEnderecamento) {
        this.idEnderecamento = idEnderecamento;
    }

    public EndArmazem(Integer idEnderecamento, String identificacao, String cor, String codAreaArmazem) {
        this.idEnderecamento = idEnderecamento;
        this.identificacao = identificacao;
        this.cor = cor;
        this.codAreaArmazem = codAreaArmazem;
    }

    public Integer getIdEnderecamento() {
        return idEnderecamento;
    }

    public void setIdEnderecamento(Integer idEnderecamento) {
        this.idEnderecamento = idEnderecamento;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCodAreaArmazem() {
        return codAreaArmazem;
    }

    public void setCodAreaArmazem(String codAreaArmazem) {
        this.codAreaArmazem = codAreaArmazem;
    }

    public String getRuaArmazem() {
        return ruaArmazem;
    }

    public void setRuaArmazem(String ruaArmazem) {
        this.ruaArmazem = ruaArmazem;
    }

    public String getNumPortaPalete() {
        return numPortaPalete;
    }

    public void setNumPortaPalete(String numPortaPalete) {
        this.numPortaPalete = numPortaPalete;
    }

    public Integer getNumPrateleiraEstante() {
        return numPrateleiraEstante;
    }

    public void setNumPrateleiraEstante(Integer numPrateleiraEstante) {
        this.numPrateleiraEstante = numPrateleiraEstante;
    }

    public String getPosVertical() {
        return posVertical;
    }

    public void setPosVertical(String posVertical) {
        this.posVertical = posVertical;
    }

    public String getPosHorizontal() {
        return posHorizontal;
    }

    public void setPosHorizontal(String posHorizontal) {
        this.posHorizontal = posHorizontal;
    }

    public Armazem getArmazemidArmazem() {
        return armazemidArmazem;
    }

    public void setArmazemidArmazem(Armazem armazemidArmazem) {
        this.armazemidArmazem = armazemidArmazem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnderecamento != null ? idEnderecamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EndArmazem)) {
            return false;
        }
        EndArmazem other = (EndArmazem) object;
        if ((this.idEnderecamento == null && other.idEnderecamento != null) || (this.idEnderecamento != null && !this.idEnderecamento.equals(other.idEnderecamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.EndArmazem[ idEnderecamento=" + idEnderecamento + " ]";
    }
    
}
