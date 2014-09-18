package com.dicaspet.MB;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.codehaus.groovy.tools.shell.commands.ShowCommand;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.dicaspet.entidade.Animal;
import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.fachada.Fachada;
import com.dicaspet.util.Constants;
import com.dicaspet.util.FacesContextUtil;
import com.dicaspet.util.FacesMessageUtil;


@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Animal animal;
	private Usuario usuario;
	private Fachada fachada;
	private Usuario user;
	private List<Animal>animaisSelecionados;
	private Animal animalSelecionado;
	private Usuario usuarioSelecionado;
	private List<Usuario>usuariosSelecionados;
	private Servico servicoSelecionado;
	private List<Servico>servicosSelecionados;

	public UsuarioMB() {
        user = new Usuario();
        user.setAtivo(true);
        
        animal = new Animal();
		
		usuario = new Usuario();
		fachada = Fachada.getInstance();
		
	}

	
	public Set<Animal>getMeusPets(){
		usuario=(Usuario) FacesContextUtil.getSessionAttribute("usuario");
		System.out.println("Buscou meus pets");
		return usuario.getAnimais();
	}
	
	public Set<Servico>getMeusServicos(){
		usuario = (Usuario) FacesContextUtil.getSessionAttribute("usuario");
		System.out.println("Buscou meus servi�os");
		return usuario.getServicos();
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public List<Usuario> getUsuarios() {
	
		return fachada.controladorUsuario().listar();
	}


	public String cadastrar() {
		
		// cadastrar o usu�rio
		// recuperar o usuario da base (com o id)
		// atualizar o objeto do usu�rio no objeto animal
		// cadasrar animal
		usuario.setUsu_nivel_acesso("usuario");
		usuario.setAtivo(true);
		usuario.setUsu_pontuacao(100);
		
		if( fachada.controladorUsuario().existeLogin(usuario.getUsu_email()) ){
			
			FacesMessage message2 = new FacesMessage(FacesMessage.SEVERITY_WARN, "E-mail já cadastrado","E-mail j� cadastrado");
			FacesContext.getCurrentInstance().addMessage(null, message2);
		}
		
		
		else{
		
		fachada.controladorUsuario().cadastrar(usuario);
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso.","Usuario "+usuario.getUsu_nome()+" cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, message);

		//FacesContextUtil.setSessionAttribute("usuario", usuario);
		limpar();
		}
		return "index?faces-redirect=true";

	}
	
	public void autenticar(){
		try {
			user = fachada.controladorUsuario().logar(user.getUsu_email(), user.getUsu_senha());
		} catch (Exception e) {

			FacesMessage messageWarn = new FacesMessage(FacesMessage.SEVERITY_WARN,"Login e/ou Senha inv�lido exception",
					"Login e/ou Senha inv�lidos exception!");

			FacesContext.getCurrentInstance().addMessage("form_autenticar", messageWarn);
		}
		
		if(user==null){
			System.out.println("------------------------------------------------------------------------------------------------");
			user = new Usuario();
			user.setAtivo(true);
			/*
			FacesMessage messageWarn = new FacesMessage(FacesMessage.SEVERITY_WARN,"Login e/ou Senha inv�lido",
					"Login e/ou Senha inv�lidos!");
			
			FacesContext.getCurrentInstance().addMessage(null, messageWarn);
		*/
			FacesContext.getCurrentInstance().addMessage("form_autenticar",new FacesMessage(FacesMessage.SEVERITY_WARN,"Login e/ou Senha inv�lido",
					"Login e/ou Senha inv�slidos!"));
		}else{
			
			
			if(user.getUsu_nivel_acesso().equals("adm")){
				user.setAtivo(false);
				try {
					FacesContextUtil.setSessionAttribute("usuario", user);
					FacesContextUtil.setSessionAttribute("tipo","adm");
					FacesContext.getCurrentInstance().getExternalContext().redirect("/fafica.dicaspet/admin/admin.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(user.getUsu_nivel_acesso().equals("usuario")){
				user.setAtivo(false);
			try {
				FacesContextUtil.setSessionAttribute("usuario", user);
				FacesContextUtil.setSessionAttribute("tipo","usuario");
				FacesContext.getCurrentInstance().getExternalContext().redirect("/fafica.dicaspet/admin/usuario.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			}
	         else{
	        	 user.setAtivo(false);
	 			try {
	 				FacesContextUtil.setSessionAttribute("usuario", user);
	 				FacesContextUtil.setSessionAttribute("tipo","prestador");
	 				FacesContext.getCurrentInstance().getExternalContext().redirect("/fafica.dicaspet/admin/lista-agendamento.xhtml");
	 			} catch (IOException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
			}
		}
			
		
		
	}
	
	public String logoff(){
		FacesContextUtil.setSessionAttribute("usuario", null);
		FacesContextUtil.logout();
		System.out.println("Saiu");
		return "index?faces-redirect=true";
	}
	
	
	private void limpar(){
		usuario = new Usuario();
		
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<Animal> getAnimaisSelecionados() {
		return animaisSelecionados;
	}

	public void setAnimaisSelecionados(List<Animal> animaisSelecionados) {
		this.animaisSelecionados = animaisSelecionados;
	}

	public Animal getAnimalSelecionado() {
		return animalSelecionado;
	}

	public void setAnimalSelecionado(Animal animalSelecionado) {
		this.animalSelecionado = animalSelecionado;
	}
	
	 public void onRowSelect(SelectEvent event) {
	        FacesMessage msg = new FacesMessage("Animal selecionado", ((Animal) event.getObject()).getAni_id_string());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	 
	    public void onRowUnselect(UnselectEvent event) {
	        FacesMessage msg = new FacesMessage("Animal desselecionado", ((Animal) event.getObject()).getAni_id_string());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }


		public Usuario getUsuarioSelecionado() {
			return usuarioSelecionado;
		}


		public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
			this.usuarioSelecionado = usuarioSelecionado;
		}


		public List<Usuario> getUsuariosSelecionados() {
			return usuariosSelecionados;
		}


		public void setUsuariosSelecionados(List<Usuario> usuariosSelecionados) {
			this.usuariosSelecionados = usuariosSelecionados;
		}
		
		public void deletar(Usuario u){
			fachada.controladorUsuario().remover(u);
		}
		
		public void editarUsuarioRedirect(Usuario usuario) throws IOException {

			this.usuario = usuario;

			FacesContext.getCurrentInstance().getExternalContext().redirect("/fafica.dicaspet/admin/editar-usuario.xhtml");

		}
		public void editar() {

			
			fachada.controladorUsuario().atualizar(usuario);
			FacesMessage message = FacesMessageUtil.criarMensagemInfo(
					"Editado com Sucesso!", "O usuario " + usuario.getUsu_nome()
							+ " foi editado com sucesso.");

			FacesContext.getCurrentInstance().addMessage(null, message);
			usuario = new Usuario();
		}
		
		public void adotar(Animal animal){
			
			
//			if(usuario.getUsu_nome().equals(animal.getAni_id_usu().getUsu_nome())){
//				FacesMessage messageWarn = new FacesMessage(FacesMessage.SEVERITY_WARN,"Este animal lhe pertence",
//						"Este animal lhe pertence.");
//
//				FacesContext.getCurrentInstance().addMessage(null, messageWarn);
//				
//			}else{
			Animal adotado = new Animal();
			
			adotado=animal;

			animal.setAni_status_animal(Constants.ADOTADO);
			animal.setAni_status(Constants.INATIVO);
			Fachada.getInstance().controladorAnimal().atualizar(animal);
			
			adotado.setAni_id_usu(usuario);
			adotado.setAni_status_animal(Constants.ADOTADO);
			adotado.setAni_id(0);
			
			
			Fachada.getInstance().controladorAnimal().cadastrar(adotado);
			
			
			FacesMessage message = FacesMessageUtil.criarMensagemInfo(
					"Adotado com Sucesso!", "voc� adotou um "+adotado.getAni_especie() +" parabens!");

			FacesContext.getCurrentInstance().addMessage(null, message);
			//}
		
		}


		public Servico getServicoSelecionado() {
			return servicoSelecionado;
		}


		public void setServicoSelecionado(Servico servicoSelecionado) {
			this.servicoSelecionado = servicoSelecionado;
		}


		public List<Servico> getServicosSelecionados() {
			return servicosSelecionados;
		}


		public void setServicosSelecionados(List<Servico> servicosSelecionados) {
			this.servicosSelecionados = servicosSelecionados;
		}

}
