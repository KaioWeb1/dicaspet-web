package com.dicaspet.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dicaspet.entidade.Mensagem;
import com.dicaspet.repositorio.RepositorioMensagem;

public class ControladorMensagem {

	private RepositorioMensagem rep;

	public ControladorMensagem(RepositorioMensagem rep) {
		this.rep = rep;
	}

	public void cadastrar(Mensagem novo) {
		novo.setMsg_data_cadastro(new Date());
		novo.setMsg_cod_msg(proximoCodMSG());
		rep.inserir(novo);
	}
	
	public void cadastrarResposta(Mensagem novo){
		rep.inserir(novo);
	}

	public void atualizar(Mensagem atual) {

		rep.atualizar(atual);
	}

	public void remover(Mensagem deletado) {
		rep.remover(deletado);
	}

	public List<Mensagem> listar() {
		return rep.listar();
	}

	public List<Mensagem> listarRecente() {

		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		List<Mensagem> msgsRencentes = rep.listarRecente();
		if (!msgsRencentes.isEmpty()) {
			for (int i = 0; i < 5; i++) {

				mensagens.add(msgsRencentes.get(i));

			}
		}

		return mensagens;
	}

	
	public List<Mensagem> listarResposta(long cod){
		return rep.listarResposta(cod);
		
	}
	
	public Long proximoCodMSG() {
		 long cod=0;
		try {
			cod = rep.maiorCod() + 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cod;
	}

	public Mensagem buscarMensagem(Long id) {
		return rep.buscarMensagem(id);
	}

}
