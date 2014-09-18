package com.dicaspet.util;

import java.util.Date;

import javax.swing.JOptionPane;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.dicaspet.entidade.Mensagem;
import com.dicaspet.entidade.Servico;
import com.dicaspet.entidade.Usuario;
import com.dicaspet.fachada.Fachada;



public class GeraBanco {
    public static void main (String [] args){
    	try {
    		Configuration cfg = new Configuration();
            cfg.configure();
            SchemaExport se = new SchemaExport(cfg);
            se.create(true, true);
            
            //cadastrar usuario padrao
           Usuario f = new Usuario();
    		f.setUsu_nome("Administrador");
    		f.setUsu_nivel_acesso("adm");
    		f.setUsu_email("1@gmail.com");
    		f.setUsu_senha("1");
    		f.setUsu_status("A");
    		f.setData_cadastro(new Date());
    		f.setUsu_pontuacao(100);
    		
            Usuario f1 = new Usuario();
     		f1.setUsu_nome("Usuario");
     		f1.setUsu_nivel_acesso("usuario");
     		f1.setUsu_email("2@gmail.com");
     		f1.setUsu_senha("2");
     		f1.setUsu_status("A");
     		f1.setData_cadastro(new Date());
     		f1.setUsu_pontuacao(100);
     		
            Usuario f2 = new Usuario();
     		f2.setUsu_nome("Prestador de Servi�o");
     		f2.setUsu_nivel_acesso("prestador");
     		f2.setUsu_email("3@gmail.com");
     		f2.setUsu_senha("3");
     		f2.setUsu_status("A");
     		f2.setData_cadastro(new Date());
     		f2.setUsu_pontuacao(100);
    		
    		Mensagem m = new Mensagem();
 
            m.setMsg_cod_msg(1);
            m.setMsg_conteudo("Mensagem 1");
            m.setMsg_data_cadastro(new Date());
            m.setMsg_id_usu(f);
            m.setMsg_isPergunta(true);
            m.setMsg_status(Constants.ATIVO);
            m.setMsg_tipo_animal("Gato");
            m.setMsg_titulo("Mensagem 1");
            
    		Mensagem m1 = new Mensagem();
    		 
            m1.setMsg_cod_msg(1);
            m1.setMsg_conteudo("Mensagem 2");
            m1.setMsg_data_cadastro(new Date());
            m1.setMsg_id_usu(f);
            m1.setMsg_isPergunta(true);
            m1.setMsg_status(Constants.ATIVO);
            m1.setMsg_tipo_animal("Gato");
            m1.setMsg_titulo("Mensagem 2");
            
    		Mensagem m2 = new Mensagem();
   		 
            m2.setMsg_cod_msg(1);
            m2.setMsg_conteudo("Mensagem 3");
            m2.setMsg_data_cadastro(new Date());
            m2.setMsg_id_usu(f);
            m2.setMsg_isPergunta(true);
            m2.setMsg_status(Constants.ATIVO);
            m2.setMsg_tipo_animal("Gato");
            m2.setMsg_titulo("Mensagem 3");
            
        	Mensagem m3 = new Mensagem();
   		 
            m3.setMsg_cod_msg(1);
            m3.setMsg_conteudo("Mensagem 3");
            m3.setMsg_data_cadastro(new Date());
            m3.setMsg_id_usu(f);
            m3.setMsg_isPergunta(true);
            m3.setMsg_status(Constants.ATIVO);
            m3.setMsg_tipo_animal("Gato");
            m3.setMsg_titulo("Mensagem 3");
            
    		Mensagem m4 = new Mensagem();
   		 
            m4.setMsg_cod_msg(1);
            m4.setMsg_conteudo("Mensagem 4");
            m4.setMsg_data_cadastro(new Date());
            m4.setMsg_id_usu(f);
            m4.setMsg_isPergunta(true);
            m4.setMsg_status(Constants.ATIVO);
            m4.setMsg_tipo_animal("Gato");
            m4.setMsg_titulo("Mensagem 4");
            
            Servico s = new Servico();
     		s.setSrv_descricao("Servi�o 1");
     		s.setSrv_id_prtsrv(f);
     		s.setSrv_categoria("Veterinaria");
     		s.setSrv_preco(20);
     		s.setSrv_dt_agenda(new Date());
     		s.setSrv_status("A");
     		s.setSrv_pontuacao(100);
     		

            Servico s1 = new Servico();
     		s1.setSrv_descricao("Servi�o 2");
     		s1.setSrv_id_prtsrv(f1);
     		s1.setSrv_preco(10);
     		s1.setSrv_dt_agenda(new Date());
     		s1.setSrv_categoria("Pet-shop");
     		s1.setSrv_status("A");
     		s1.setSrv_pontuacao(101);
     		
            Servico s2 = new Servico();
     		s2.setSrv_descricao("Servi�o 3");
     		s2.setSrv_id_prtsrv(f2);
     		s2.setSrv_preco(30);
     		s2.setSrv_dt_agenda(new Date());
     		s2.setSrv_categoria("Pet-shop");
     		s2.setSrv_status("A");
     		s2.setSrv_pontuacao(103);
            
           Fachada fachada = Fachada.getInstance();
            fachada.controladorUsuario().cadastrar(f);
            fachada.controladorUsuario().cadastrar(f1);
            fachada.controladorUsuario().cadastrar(f2);
            fachada.controladorMensagem().cadastrar(m);
            fachada.controladorMensagem().cadastrar(m1);
            fachada.controladorMensagem().cadastrar(m2);
            fachada.controladorMensagem().cadastrar(m3);
            fachada.controladorMensagem().cadastrar(m4);
            fachada.controladorServico().cadastrar(s);
            fachada.controladorServico().cadastrar(s1);
            fachada.controladorServico().cadastrar(s2);

            
            JOptionPane.showMessageDialog(null, "O Banco de Dados foi gerado com sucesso!",
            		"Fafica .:. Alerta",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Base de Dados!",
            	"Fafica .:. Alerta",JOptionPane.ERROR_MESSAGE);
		}
    }
}