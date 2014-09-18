package com.dicaspet.repositorio;

import java.io.Serializable;
import java.util.List;

import com.dicaspet.dao.Dao;
import com.dicaspet.entidade.Animal;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.util.Constants;

public class RepositorioAnimal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	public RepositorioAnimal(){
		if(dao == null){
			dao = Dao.getInstance();
		}
	}
	
	public void inserir(Animal novo){
		dao.salvarObjeto(novo);
	}
	
	public void atualizar(Animal atual){
		dao.atualizarObjeto(atual);
	}
	
	@SuppressWarnings("unchecked")
	public List<Animal> listar(){
		return (List<Animal>) dao.criarQuery("FROM animal WHERE status <> '" + Constants.INATIVO + "'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Animal> listaAdocao(Usuario usuario){
		return (List<Animal>) dao.criarQuery("FROM animal WHERE status_animal = 'D' and id_usuario != '"+usuario.getUsu_id()+"'");
	}
	
	@SuppressWarnings("unchecked")
	public List<Animal> buscarNome(String nome){
		return (List<Animal>) dao.buscarPorLikeIgnoreCase("nome", nome, Animal.class);
	}
	
	
	public void remover(Animal del){
		del.setAni_status(Constants.INATIVO);
		dao.atualizarObjeto(del);
	}
	
	
	public Animal buscarAnimal(Long id){
		Animal animal = (Animal) dao.buscarPorId(Animal.class, id);
		return animal;
	}
	

}
