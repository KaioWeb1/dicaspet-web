package com.dicaspet.MB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.fachada.Fachada;

@ManagedBean(name="rankingMB")
@ApplicationScoped
public class RankingMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
	private List<Servico> servicos;
	private Usuario usuarioSelecionado;
	private List<Usuario> rankingUserFull;
	
	public RankingMB(){
	
		usuarios = new ArrayList<Usuario>(); 
		servicos = new ArrayList<Servico>();
	}

	public List<Usuario> getUsuarios() {
		
		usuarios = Fachada.getInstance().controladorUsuario().listarPorPontuacaoResumida();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Servico> getServicos() {
		
		servicos = Fachada.getInstance().controladorServico().listarPorPontuacao();
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getRankingUserFull() {
		rankingUserFull = Fachada.getInstance().controladorUsuario().listarPorPontuacao();
		
		return rankingUserFull;
	}

	public void setRankingUserFull(List<Usuario> rankingUserFull) {
		this.rankingUserFull = rankingUserFull;
	}
}
