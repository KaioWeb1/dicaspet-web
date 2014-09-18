package com.dicaspet.MB;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import com.dicaspet.entidade.Mensagem;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.fachada.Fachada;
import com.dicaspet.util.Constants;
import com.dicaspet.util.FacesContextUtil;

@ManagedBean(name = "mensagemMB")
@SessionScoped
public class MensagemMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuarioMSG;
	private Mensagem mensagem;
	private Mensagem resposta;
	private Mensagem atual;
	private Fachada fachada;
	private List<Mensagem> mensagens;
	private Usuario usuario;

	public MensagemMB() {

		usuario = new Usuario();
		atual = new Mensagem();
		usuarioMSG = new Usuario();
		mensagem = new Mensagem();
		resposta = new Mensagem();
		fachada = Fachada.getInstance();
	}

	public void avaliarMSG(Mensagem m, int i) {

		usuario=m.getMsg_id_usu();
		usuario.setUsu_pontuacao(usuario.getUsu_pontuacao()+i);
		Fachada.getInstance().controladorUsuario().atualizar(usuario);

	}

	public List<Mensagem> getListaResposta() {

		System.out.println(mensagem.getMsg_cod_msg());
		return Fachada.getInstance().controladorMensagem()
				.listarResposta(mensagem.getMsg_cod_msg());
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}

	public List<Mensagem> getMensagems() {
		if (mensagens == null) {
			try {
				mensagens = fachada.controladorMensagem().listar();
			} catch (Exception e) {
				mensagens = new ArrayList<Mensagem>();
				for (Mensagem m : mensagens) {
					System.out.println(m.getMsg_titulo());
				}
			}
		}

		return mensagens;
	}

	public void setMensagems(List<Mensagem> mensagems) {
		this.mensagens = mensagems;
	}

	public void cadastrarPergunta() {

		atual.setMsg_data_cadastro(new Date());
		atual.setMsg_isPergunta(true);
		atual.setMsg_status(Constants.ATIVO);
		Usuario usuario = (Usuario) FacesContextUtil
				.getSessionAttribute("usuario");
		atual.setMsg_id_usu(usuario);

		fachada.controladorMensagem().cadastrar(atual);
		// FacesMessage message;
		//
		// message = FacesMessageUtil.criarMensagemInfo("Cadastro com Sucesso!",
		// "O mensagem " + mensagem.getUsu_nome()
		// + " foi cadastrado com sucesso.");
		atual=new Mensagem();
	}

	public void cadastrarResposta() {

		resposta.setMsg_data_cadastro(new Date());
		resposta.setMsg_isPergunta(false);
		resposta.setMsg_status(Constants.ATIVO);
		Usuario usuario = (Usuario) FacesContextUtil
				.getSessionAttribute("usuario");
		resposta.setMsg_id_usu(usuario);
		resposta.setMsg_cod_msg(mensagem.getMsg_cod_msg());
		resposta.setMsg_tipo_animal(mensagem.getMsg_tipo_animal());

		fachada.controladorMensagem().cadastrarResposta(resposta);
		// FacesMessage message;
		//
		// message = FacesMessageUtil.criarMensagemInfo("Cadastro com Sucesso!",
		// "O mensagem " + mensagem.getUsu_nome()
		// + " foi cadastrado com sucesso.");

		resposta = new Mensagem();
		refresh();
	}

	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context
				.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}

	public void responderMSG(Mensagem msg) throws IOException {

		mensagem = msg;

		usuarioMSG = mensagem.getMsg_id_usu();
		FacesContextUtil.setSessionAttribute("mensagem", mensagem);

		
		//return "resposta?faces-redirect=true";
		FacesContext.getCurrentInstance().getExternalContext().redirect("/fafica.dicaspet/resposta.xhtml");

	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public List<Mensagem> getUltimasMSG() {

		return fachada.controladorMensagem().listarRecente();

	}

	public Usuario getUsuarioMSG() {
		return usuarioMSG;
	}

	public void setUsuarioMSG(Usuario usuarioMSG) {
		this.usuarioMSG = usuarioMSG;
	}

	public Mensagem getAtual() {
		return atual;
	}

	public void setAtual(Mensagem atual) {
		this.atual = atual;
	}

	public Mensagem getResposta() {
		return resposta;
	}

	public void setResposta(Mensagem resposta) {
		this.resposta = resposta;
	}
	
	public boolean podeAvaliar(){
		
		//Usuario u = m.getMsg_id_usu();
		Usuario u2 = (Usuario)FacesContextUtil.getSessionAttribute("usuario");
		
		if(u2==null){
			return true;
		}
		if(usuarioMSG.getUsu_nome().equals(u2.getUsu_nome())){
			return false;
		}
		else{
			return true;
		}
		
	}

}
