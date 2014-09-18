package com.dicaspet.MB;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.fachada.Fachada;
import com.dicaspet.util.Constants;
import com.dicaspet.util.FacesContextUtil;

@ManagedBean
@SessionScoped
public class ServicoMB {

	private Servico servico;
	private Fachada fachada;

	private Servico servicoSelecionado;
	private List<Servico> servicosSelecionados;
	private List<Servico> servicosFiltrados;
	private Usuario prestador;
	private Usuario usuarioLogado;



	public ServicoMB() {
		
		usuarioLogado=(Usuario) FacesContextUtil.getSessionAttribute("usuario");
        prestador = new Usuario();
		servico = new Servico();
		fachada = Fachada.getInstance();
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
	
	public List<Servico> getServicos() {

	return fachada.controladorServico().listar();
}
	
	public List<Servico> getServicosInativos() {

	return fachada.controladorServico().listarInativos();
}

	public void cadastrar() {

		prestador = (Usuario) FacesContextUtil.getSessionAttribute("usuario");
		servico.setSrv_id_prtsrv(prestador);
		fachada.controladorServico().cadastrar(servico);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Cadastrado com Sucesso!",
				"O servico " + servico.getSrv_descricao()
						+ " foi cadastrado com sucesso.");

		FacesContext.getCurrentInstance().addMessage(null, message);
		limpar();
	}

	private void limpar() {
		servico = new Servico();
	
	}

//	public void onRowSelect(SelectEvent event) {
//		FacesMessage msg = new FacesMessage("Serviço selecionado",
//				((Servico) event.getObject()).getSrv_id_string());
//		FacesContext.getCurrentInstance().addMessage(null, msg);
//	}
//
//	public void onRowUnselect(UnselectEvent event) {
//		FacesMessage msg = new FacesMessage("Serviço desselecionado",
//				((Servico) event.getObject()).getSrv_id_string());
//		FacesContext.getCurrentInstance().addMessage(null, msg);
//	}

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

	public String editarServicoRedirect(Servico servico) {

		this.servico = servico;

		return "editar-servico?faces-redirect=true";
		//FacesContext.getCurrentInstance().getExternalContext().redirect("/fafica.dicaspet/admin/editar-servico.xhtml");

	}

	public void editar() {

		fachada.controladorServico().atualizar(servico);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Editado com Sucesso!",
				"O serviço " + servico.getSrv_descricao()
						+ " foi editado com sucesso.");

		FacesContext.getCurrentInstance().addMessage(null, message);
		servico = new Servico();
	}

	public void deletar(Servico servico) {

		fachada.controladorServico().remover(servico);
		
	}

	public List<Servico> getServicosFiltrados() {
		return servicosFiltrados;
	}

	public void setServicosFiltrados(List<Servico> servicosFiltrados) {
		this.servicosFiltrados = servicosFiltrados;
	}

	@SuppressWarnings("unchecked")
	public boolean filterByPrice(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim();
		if (filterText == null || filterText.equals("")) {
			return true;
		}

		if (value == null) {
			return false;
		}

		return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
	}

	public String redirectPerfilServico(Servico s) {
		
		prestador=s.getSrv_id_prtsrv();
		servico = s;
		
		
		return "empresa?faces-redirect=true";
	}
	
	public void confirmarAgendamento(Servico s){
		
		s.setSrv_confirmacao(Constants.Confirmado);
		
		fachada.controladorServico().atualizar(s);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Confirmado com Sucesso!",
				"O serviço " + servico.getSrv_descricao()
						+ " foi confirmado com sucesso.");

		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void agendarServico(){
		
	    Set<Usuario>lu = new HashSet<Usuario>();
		lu.add(usuarioLogado);
		
		servico.setUsuarios(lu);
		servico.setSrv_confirmacao(Constants.Pendente);
		
		fachada.controladorServico().atualizar(servico);
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Agendado com Sucesso!",
				"O serviço " + servico.getSrv_descricao()
						+ " foi agendado com sucesso.");

		FacesContext.getCurrentInstance().addMessage(null, message);
		
		
	}
	
	public void ativar(Servico s){
		
		s.setSrv_status(Constants.ATIVO);
		fachada.controladorServico().atualizar(s);
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Ativado com Sucesso!",
				"O serviço " + servico.getSrv_descricao()
						+ " foi ativado com sucesso.");

		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void mData(){
		
		System.out.println(servico.getSrv_dt_agenda()+"--------------------------------------------------------------");
	}

}
