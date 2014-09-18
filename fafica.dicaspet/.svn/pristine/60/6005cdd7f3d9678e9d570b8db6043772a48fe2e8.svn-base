package com.dicaspet.repositorio;

import java.sql.SQLException;
import java.util.List;

import com.dicaspet.dao.Dao;
import com.dicaspet.entidade.Mensagem;
import com.dicaspet.util.Constants;

public class RepositorioMensagem {

	private Dao dao;
	
	public RepositorioMensagem(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(Mensagem novo){
		novo.setMsg_status(Constants.ATIVO);
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Mensagem atual){
		dao.atualizarObjeto(atual);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mensagem> listar(){
		return (List<Mensagem>) dao.criarQuery("FROM mensagem WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Mensagem> listarRecente(){
		return (List<Mensagem>) dao.criarQuery("FROM mensagem where pergunta = 1 order by data_cadastro desc");
	}
	
	@SuppressWarnings("unchecked")
	public List<Mensagem> listarResposta(long cod){
		return (List<Mensagem>) dao.criarQuery("FROM mensagem where pergunta = 0 and cod_msg ="+cod+" order by data_cadastro asc");
	}
	

	public long maiorCod2(){
		long cod=0;
		Mensagem msgTemp = (Mensagem) dao.selectObjeto(",max(cod_msg) from mensagem");
		System.out.println(msgTemp.getMsg_cod_msg());
		cod = msgTemp.getMsg_cod_msg();
		
		return cod;
		
	}
	

	public long maiorCod() throws SQLException{
		long cod=0;
		cod = (Long) dao.maiorCodMSG();
		System.out.println(cod);
		
		return cod;
		
	}
	
	
	public void remover(Mensagem del){
		del.setMsg_status(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}
	
	
	public Mensagem buscarMensagem(Long id){
		Mensagem mensagem = (Mensagem) dao.buscarPorId(Mensagem.class, id);
		return mensagem;
	}
	

}
