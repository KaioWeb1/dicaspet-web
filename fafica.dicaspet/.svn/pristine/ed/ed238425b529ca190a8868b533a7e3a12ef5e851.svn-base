package com.dicaspet.controlador;

import java.util.ArrayList;
import java.util.List;

import com.dicaspet.entidade.Servico;
import com.dicaspet.repositorio.RepositorioServico;
import com.dicaspet.util.Constants;

public class ControladorServico {

	private RepositorioServico rep;

	public ControladorServico(RepositorioServico rep) {
		this.rep = rep;
	}

	public void cadastrar(Servico novo) {
		novo.setSrv_status(Constants.Pendente);
		rep.inserir(novo);
	}

	public void atualizar(Servico atual) {

		rep.atualizar(atual);
	}

	public void remover(Servico deletado) {
		rep.remover(deletado);
	}

	public List<Servico> listar() {
		return rep.listar();
	}
	
	public List<Servico> listarInativos() {
		return rep.listarInativos();
	}
	
	public List<Servico> listarPorPontuacao(){
		
		List<Servico>servicosRank = new ArrayList<Servico>();
		List<Servico> servicos = rep.listarPorPontuacao();
		if(servicos!=null){
		for (int i = 0; i < 3; i++) {
			
			servicosRank.add(servicos.get(i));
		}
		}
		
		return servicosRank;
	}

	public List<Servico> buscaNome(String nome) {
		return rep.buscarNome(nome);
	}

	public Servico buscarServico(Long id) {
		return rep.buscarServico(id);
	}

}
