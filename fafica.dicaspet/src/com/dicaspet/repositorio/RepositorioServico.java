package com.dicaspet.repositorio;

import java.util.List;

import com.dicaspet.dao.Dao;
import com.dicaspet.entidade.Servico;
import com.dicaspet.util.Constants;

public class RepositorioServico {

	private Dao dao;
	
	public RepositorioServico(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(Servico novo){
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Servico atual){
		dao.atualizarObjeto(atual);
	}
	
	@SuppressWarnings("unchecked")
	public List<Servico> listar(){
		return (List<Servico>) dao.criarQuery("FROM servico WHERE status = '" + Constants.ATIVO + "'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Servico> listarInativos(){
		return (List<Servico>) dao.criarQuery("FROM servico WHERE status = '" + Constants.Pendente + "'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Servico> listarPorPontuacao(){
		return (List<Servico>) dao.criarQuery("FROM servico order by pontuacao desc");
	}
	
	@SuppressWarnings("unchecked")
	public List<Servico> buscarNome(String nome){
		return (List<Servico>) dao.buscarPorLikeIgnoreCase("nome", nome, Servico.class);
	}
	
	
	public void remover(Servico del){
		del.setSrv_status(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}
	
	
	public Servico buscarServico(Long id){
		Servico servico = (Servico) dao.buscarPorId(Servico.class, id);
		return servico;
	}
	

}
