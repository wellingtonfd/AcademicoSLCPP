/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findBySobrenome", query = "SELECT f FROM Funcionario f WHERE f.sobrenome = :sobrenome"),
    @NamedQuery(name = "Funcionario.findByMatricula", query = "SELECT f FROM Funcionario f WHERE f.matricula = :matricula"),
    @NamedQuery(name = "Funcionario.findByFuncao", query = "SELECT f FROM Funcionario f WHERE f.funcao = :funcao"),
    @NamedQuery(name = "Funcionario.findByEspecializacao", query = "SELECT f FROM Funcionario f WHERE f.especializacao = :especializacao"),
    @NamedQuery(name = "Funcionario.findByDtadmissao", query = "SELECT f FROM Funcionario f WHERE f.dtadmissao = :dtadmissao"),
    @NamedQuery(name = "Funcionario.findByCpf", query = "SELECT f FROM Funcionario f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Funcionario.findByRg", query = "SELECT f FROM Funcionario f WHERE f.rg = :rg"),
    @NamedQuery(name = "Funcionario.findByDtnasc", query = "SELECT f FROM Funcionario f WHERE f.dtnasc = :dtnasc"),
    @NamedQuery(name = "Funcionario.findByCargo", query = "SELECT f FROM Funcionario f WHERE f.cargo = :cargo"),
    @NamedQuery(name = "Funcionario.findByNivel", query = "SELECT f FROM Funcionario f WHERE f.nivel = :nivel"),
    @NamedQuery(name = "Funcionario.findByLotacao", query = "SELECT f FROM Funcionario f WHERE f.lotacao = :lotacao")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "sobrenome")
    private String sobrenome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricula")
    private int matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "funcao")
    private String funcao;
    @Size(max = 100)
    @Column(name = "especializacao")
    private String especializacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtadmissao")
    @Temporal(TemporalType.DATE)
    private Date dtadmissao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dtnasc")
    @Temporal(TemporalType.DATE)
    private Date dtnasc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lotacao")
    private String lotacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsavel")
    private Collection<Movimentacao> movimentacaoCollection;
    @JoinColumn(name = "usuarioid_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;
    @JoinColumn(name = "enderecoid_endereco", referencedColumnName = "id_endereco")
    @ManyToOne(optional = false)
    private Endereco enderecoidEndereco;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(Integer idFuncionario, String nome, String sobrenome, int matricula, String funcao, Date dtadmissao, String cpf, String rg, Date dtnasc, String cargo, String nivel, String lotacao) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.funcao = funcao;
        this.dtadmissao = dtadmissao;
        this.cpf = cpf;
        this.rg = rg;
        this.dtnasc = dtnasc;
        this.cargo = cargo;
        this.nivel = nivel;
        this.lotacao = lotacao;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Date getDtadmissao() {
        return dtadmissao;
    }

    public void setDtadmissao(Date dtadmissao) {
        this.dtadmissao = dtadmissao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getLotacao() {
        return lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
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
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
