package com.dicaspet.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Um Filtro é um componente da arquitetura JEE que intercepta requisições HTTP. Desta forma,
 * quando você acessa qualquer página antes da requisição chegar a ela, o filtro é acionado e
 * nele é possível definir se a requisição vai chegar ao destino final ou vai ser desviada para
 * alguma outra página. 
 * O método chain.doFilter(request, response); em um filtro indica que o filtro vai passar a requisição 
 * para o próximo recurso (uma página ou um recurso).
 * @author Edilson
 */
@WebFilter(servletNames = { "Faces Servlet" })
public class ControleDeAcesso implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if (session.getAttribute("usuario") != null
				|| !req.getRequestURI().endsWith("adotar.xhtml") 
				&& !req.getRequestURI().endsWith("usuario.xhtml")
				&& !req.getRequestURI().endsWith("animal.xhtml")
				&& !req.getRequestURI().endsWith("cadastro-animal.xhtml")
				&& !req.getRequestURI().endsWith("lista-animal.xhtml")
				&& !req.getRequestURI().endsWith("ranking-user.xhtml")
				) {
			// se existe um atributo na sessão chamado "usuario" é porque existe 
			// usuário logado, logo, o filtro deixa que a requisição "passe" para a próxima página
			chain.doFilter(request, response);
		} else {
			// o usuário está tentando acessar uma página protegida sem está logado, logo,
			// o filtro redireciona para a página de login
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("../index.xhtml");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}