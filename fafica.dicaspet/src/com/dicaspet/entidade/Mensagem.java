package com.dicaspet.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity(name="mensagem")
public class Mensagem implements Serializable{

	@Id
	@GeneratedValue
	private long msg_id;
	
	@Column(name="status",nullable=false)
	private String msg_status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.MERGE)
	@JoinColumn(name = "id_usu")
	private Usuario msg_id_usu;
	
	@Column(name="titulo",length=50,nullable=true)
	private String msg_titulo;
	
	@Column(name="conteudo",length=500,nullable=false)
	private String msg_conteudo;
	
	
	@Column(name="cod_msg",nullable=false)
	private long msg_cod_msg;
	
	@Column(name="pergunta",nullable=false)
	private boolean msg_isPergunta;
	
	@Column(name="avaliacao",nullable=true)
	private int msg_avaliacao;

	@Column(name="data_cadastro" , nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date msg_data_cadastro;
	
	@Column(name="tipo_animal",length=500,nullable=false)
	private String msg_tipo_animal;

	
	public Date getMsg_data_cadastro() {
		return msg_data_cadastro;
	}

	public void setMsg_data_cadastro(Date msg_data_cadastro) {
		this.msg_data_cadastro = msg_data_cadastro;
	}

	public void setMsg_id(long msg_id) {
		this.msg_id = msg_id;
	}

	public long getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(int msg_id) {
		this.msg_id = msg_id;
	}

	public String getMsg_status() {
		return msg_status;
	}

	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}

	public Usuario getMsg_id_usu() {
		return msg_id_usu;
	}

	public void setMsg_id_usu(Usuario msg_id_usu) {
		this.msg_id_usu = msg_id_usu;
	}

	public String getMsg_titulo() {
		return msg_titulo;
	}

	public void setMsg_titulo(String msg_titulo) {
		this.msg_titulo = msg_titulo;
	}

	public String getMsg_conteudo() {
		return msg_conteudo;
	}

	public void setMsg_conteudo(String msg_conteudo) {
		this.msg_conteudo = msg_conteudo;
	}

	public long getMsg_cod_msg() {
		return msg_cod_msg;
	}

	public void setMsg_cod_msg(long msg_cod_msg) {
		this.msg_cod_msg = msg_cod_msg;
	}

	public int getMsg_avaliacao() {
		return msg_avaliacao;
	}

	public void setMsg_avaliacao(int msg_avaliacao) {
		this.msg_avaliacao = msg_avaliacao;
	}
	public boolean isMsg_isPergunta() {
		return msg_isPergunta;
	}

	public void setMsg_isPergunta(boolean msg_isPergunta) {
		this.msg_isPergunta = msg_isPergunta;
	}

	public String getMsg_tipo_animal() {
		return msg_tipo_animal;
	}

	public void setMsg_tipo_animal(String msg_tipo_animal) {
		this.msg_tipo_animal = msg_tipo_animal;
	}
	
}
