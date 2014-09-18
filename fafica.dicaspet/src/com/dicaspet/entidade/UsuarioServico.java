package com.dicaspet.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="usuario_servico")
public class UsuarioServico {
	
	@Column(name="usu_id")
	private Usuario usu_id;
	
	@Column(name="srv_id")
	private Servico srv_id;

	public Usuario getUsu_id() {
		return usu_id;
	}

	public void setUsu_id(Usuario usu_id) {
		this.usu_id = usu_id;
	}

	public Servico getSrv_id() {
		return srv_id;
	}

	public void setSrv_id(Servico srv_id) {
		this.srv_id = srv_id;
	}

}
