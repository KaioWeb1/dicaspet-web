package com.dicaspet.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="servico")
public class Servico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long srv_id;
	
	@Column(name="confirmacao",nullable=true)
	private String srv_confirmacao;
	
	@Column(name="status",nullable=false)
	private String srv_status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	@JoinColumn(name = "id_prt_srv")
	private Usuario srv_id_prtsrv;
	
	@ManyToMany(mappedBy = "servicos")  
	private Set<Usuario>usuarios = new HashSet<Usuario>();  
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@Cascade(org.hibernate.annotations.CascadeType.MERGE)
	@JoinColumn(name = "id_ani")
	private Animal srv_id_ani;
	
	@Column(name="descricao",length=500,nullable=false)
	private String srv_descricao;
	
	@Column(name="preco",nullable=true)
	private double srv_preco;
	
	@Column(name="pontuacao",nullable=true)
	private int srv_pontuacao;
	
	@Column(name="categoria",nullable=true)
	private String srv_categoria;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_agenda",nullable=true)
	private Date srv_dt_agenda;
	
	
	public String getSrv_id_string() {
		return Long.toString(srv_id);
	}
	
	public long getSrv_id() {
		return srv_id;
	}

	public void setSrv_id(long srv_id) {
		this.srv_id = srv_id;
	}

	public String getSrv_status() {
		return srv_status;
	}

	public void setSrv_status(String srv_status) {
		this.srv_status = srv_status;
	}

	public Usuario getSrv_id_prtsrv() {
		return srv_id_prtsrv;
	}

	public void setSrv_id_prtsrv(Usuario srv_id_prtsrv) {
		this.srv_id_prtsrv = srv_id_prtsrv;
	}

	public Animal getSrv_id_ani() {
		return srv_id_ani;
	}

	public void setSrv_id_ani(Animal srv_id_ani) {
		this.srv_id_ani = srv_id_ani;
	}

	public String getSrv_descricao() {
		return srv_descricao;
	}

	public void setSrv_descricao(String srv_descricao) {
		this.srv_descricao = srv_descricao;
	}

	public double getSrv_preco() {
		return srv_preco;
	}

	public void setSrv_preco(double srv_preco) {
		this.srv_preco = srv_preco;
	}

	public String getSrv_categoria() {
		return srv_categoria;
	}

	public void setSrv_categoria(String srv_categoria) {
		this.srv_categoria = srv_categoria;
	}

	public Date getSrv_dt_agenda() {
		return srv_dt_agenda;
	}

	public void setSrv_dt_agenda(Date srv_dt_agenda) {
		this.srv_dt_agenda = srv_dt_agenda;
	}

	public int getSrv_pontuacao() {
		return srv_pontuacao;
	}

	public void setSrv_pontuacao(int srv_pontuacao) {
		this.srv_pontuacao = srv_pontuacao;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> srv_usuarios) {
		this.usuarios = srv_usuarios;
	}

	public String getSrv_confirmacao() {
		return srv_confirmacao;
	}

	public void setSrv_confirmacao(String srv_confirmacao) {
		this.srv_confirmacao = srv_confirmacao;
	}

}
