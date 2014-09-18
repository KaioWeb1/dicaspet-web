package com.dicaspet.MB;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.dicaspet.entidade.Animal;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.fachada.Fachada;
import com.dicaspet.util.FacesContextUtil;
import com.dicaspet.util.FacesMessageUtil;
import com.dicaspet.util.UploadArquivo;

@ManagedBean
@SessionScoped
public class AnimalMB {

	private Animal animal;
	private Fachada fachada;
	private List<Animal> animais;
	private List<Animal> animaisAdocao;
	private UploadArquivo arquivo = new UploadArquivo();	

	public AnimalMB() {

		
		animal = new Animal();
		fachada = Fachada.getInstance();
	}
	
	public void uploadAction (FileUploadEvent event){
		this.arquivo.fileUpload(event, ".jpg", "/image/");
		this.animal.setAni_foto(this.arquivo.getNome());
		
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public List<Animal> getAnimals() {
		if (animais == null) {
			try {
				animais = fachada.controladorAnimal().listar();
			} catch (Exception e) {
				animais = new ArrayList<Animal>();
			}
		}

		return animais;
	}

	public void setAnimals(List<Animal> animals) {
		this.animais = animals;
	}

	public void deletar(Animal animal) {

		fachada.controladorAnimal().remover(animal);
	}

	public String cadastrar() {

		if (animal.getAni_peso() < 5) {
			animal.setAni_qtdInicAlimento(110);
			animal.setAni_qtdFimAlimento(110 * 1.2);
		}

		else if (animal.getAni_peso() >= 5) {
			animal.setAni_qtdInicAlimento(190);
			animal.setAni_qtdFimAlimento(190 * 1.2);
		}

		else if (animal.getAni_peso() >= 10) {
			animal.setAni_qtdInicAlimento(250);
			animal.setAni_qtdFimAlimento(250 * 1.2);
		}

		else if (animal.getAni_peso() >= 15) {
			animal.setAni_qtdInicAlimento(310);
			animal.setAni_qtdFimAlimento(310 * 1.2);
		}

		else if (animal.getAni_peso() >= 20) {
			animal.setAni_qtdInicAlimento(530);
			animal.setAni_qtdFimAlimento(530 * 1.2);
		}

		else if (animal.getAni_peso() >= 40) {
			animal.setAni_qtdInicAlimento(720);
			animal.setAni_qtdFimAlimento(720 * 1.2);
		}

		Usuario usu = (Usuario) FacesContextUtil.getSessionAttribute("usuario");

		animal.setAni_id_usu(usu);

		fachada.controladorAnimal().cadastrar(animal);
		
		this.arquivo.gravar();
		this.arquivo = new UploadArquivo();
		FacesMessage message = FacesMessageUtil.criarMensagemInfo(
				"Cadastro com Sucesso!", "O animal " + animal.getAni_nome()
						+ " foi cadastrado com sucesso.");

		FacesContext.getCurrentInstance().addMessage("form_cadastro_animal", message);
		
		limpar();
		
		return "lista-animal?faces-redirect=true";
		
		
		
	}

	private void limpar() {
		animal = new Animal();
	}

	public List<Animal> getAnimaisAdocao() {
		
		Usuario usuario = (Usuario)FacesContextUtil.getSessionAttribute("usuario");
		
		if (animaisAdocao == null) {
			try {
				animaisAdocao = fachada.controladorAnimal().listaAdocao(usuario);
			} catch (Exception e) {
				animaisAdocao = new ArrayList<Animal>();
			}
		}
		return animaisAdocao;
	}

	public void setAnimaisAdocao(List<Animal> animaisAdocao) {
		this.animaisAdocao = animaisAdocao;
	}

	public String editarAnimalRedirect(Animal animal) {

		this.animal = animal;

		return "editar-animal?faces-redirect=true";

	}

	public String perfilAnimalRedirect(Animal animal) {

		this.animal = animal;
		FacesContextUtil.setSessionAttribute("animal",animal);

		return "animal?faces-redirect=true";

	}

	public void editar() {

		fachada.controladorAnimal().atualizar(animal);
		FacesMessage message = FacesMessageUtil.criarMensagemInfo(
				"Editado com Sucesso!", "O animal " + animal.getAni_nome()
						+ " foi editado com sucesso.");

		FacesContext.getCurrentInstance().addMessage(null, message);
		animal = new Animal();
	}

}
