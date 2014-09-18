package com.dicaspet.controlador;

import java.io.Serializable;
import java.util.List;

import com.dicaspet.entidade.Animal;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.repositorio.RepositorioAnimal;
import com.dicaspet.util.Constants;

public class ControladorAnimal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RepositorioAnimal rep;

	public ControladorAnimal(RepositorioAnimal rep) {
		this.rep = rep;
	}

	public void cadastrar(Animal novo) {
		novo.setAni_status(Constants.ATIVO);

		rep.inserir(novo);
	}

	public void atualizar(Animal atual) {

		rep.atualizar(atual);
	}

	public void remover(Animal deletado) {
		rep.remover(deletado);
	}

	public List<Animal> listar() {
		return rep.listar();
	}
	
	public List<Animal> listaAdocao(Usuario usuario){
		
		return rep.listaAdocao(usuario);
	}

	public List<Animal> buscaNome(String nome) {
		return rep.buscarNome(nome);
	}

	public Animal buscarAnimal(Long id) {
		return rep.buscarAnimal(id);
	}

}
