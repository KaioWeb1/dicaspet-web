package com.dicaspet.dao;



import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.dicaspet.util.Constants;
import com.dicaspet.util.HibernateUtil;

public class Dao implements Serializable{
	
	private static Dao instance;
	private Session sessao;
	private Transaction tx;
	private static Connection con;
	
	private Dao(){
		
	}
	
	public static Dao getInstance(){
		if(instance == null) {
			instance = new Dao();
			try {
				con = ConnectionFactory.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	
	public <T> Object buscarPorId(Class<T> clazz, Long id){
		try{
			sessao = HibernateUtil.getSession();
			Object object = sessao.get(clazz, id);
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public <T> Object buscarPorChaveUnicaLong(Class<T> clazz, Long longo, String coluna){
		try{
			sessao = HibernateUtil.getSession();
			Object object = sessao.createCriteria(clazz).add(Restrictions.eq(coluna, longo)).uniqueResult();
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	//metodo alterado para retornar apenas entradas ativas.
	public <T> Object listarPorChaveString(Class<T> clazz, String stringi, String coluna){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq(coluna, stringi));
			c.add(Restrictions.eq("status", Constants.ATIVO));
			List<?> objects = c.list();
			return objects;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public <T> Object listar(Class<T> clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq("status", Constants.ATIVO));
			List<?> objects = c.list();
			return objects;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	//metodo alterado para retornar apenas entradas ativas.
		public <T> Object buscarPorChaveUnicaString(Class<T> clazz, String stringi, String coluna){
			try{
				sessao = HibernateUtil.getSession();
				Criteria c = sessao.createCriteria(clazz);
				c.add(Restrictions.eq(coluna, stringi));
				c.add(Restrictions.eq("status", Constants.ATIVO));
				Object object = c.uniqueResult();
				return object;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				sessao.close();
			}
		}
	
	public <T> Object buscarPorChaveEstrangeira(Class<T> clazz, Object objetoEstrangeiro, String colunaEstrangeira){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq(colunaEstrangeira, objetoEstrangeiro));
			c.add(Restrictions.eq("status", Constants.ATIVO));
			Object object = c.uniqueResult();
			return object;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> buscarListaPorChaveEstrangeira(Class clazz, Object objetoEstrangeiro, String colunaEstrangeira){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq(colunaEstrangeira, objetoEstrangeiro));
			c.add(Restrictions.eq("status", Constants.ATIVO));
			List<?> list = c.list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> listarInativos(Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq("status", Constants.INATIVO));
			List<?> objects = c.list();
			return objects;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
		
	}
	
	public List<?> listarAtivos(Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq("status", Constants.ATIVO));
			List<?> objects = c.list();
			return objects;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
		
	}
	
	public List<?> buscarListPorChaveEstrangeira(Class clazz, Object objetoEstrangeiro, String colunaEstrangeira){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.eq(colunaEstrangeira, objetoEstrangeiro));
			List<?> objects = c.list();
			return objects;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
		
	}
	
	public <T> boolean salvarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.save(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			if(sessao!=null)
			sessao.close();
		}
	}
	
	public <T> boolean salvarOuAtualizarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.saveOrUpdate(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}

	public <T> boolean atualizarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			//sessao.setCacheMode(CacheMode.IGNORE);
			tx = sessao.beginTransaction();
			sessao.update(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public <T> boolean mesclarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.merge(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public <T> boolean deletarObjeto(T objeto){
		try{
			sessao = HibernateUtil.getSession();
			tx = sessao.beginTransaction();
			sessao.delete(objeto);
			tx.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> listarObjetos(Class<?> classe){
		try{
			sessao = HibernateUtil.getSession();
			Criteria criteria = sessao.createCriteria(classe);
			return criteria.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
		
	public List<?> criarQuery(String query){
		try{
			sessao = HibernateUtil.getSession();
			Query select = sessao.createQuery(query);
			return select.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public Object selectObjeto(String query){
		try{
			sessao = HibernateUtil.getSession();
			Object obj = sessao.createQuery(query).uniqueResult();
			return obj;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> buscarPorLike(String coluna, String queryPart, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.like(coluna, queryPart, MatchMode.ANYWHERE));
			c.add(Restrictions.like("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> buscarPorLikeInativos(String coluna, String queryPart, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.like(coluna, queryPart, MatchMode.ANYWHERE));
			c.add(Restrictions.like("status", Constants.INATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	// metodo alterado para buscar somente ativos
	public List<?> buscarPorLikeIlimitado(String [] colunas, String [] querys, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			for(int i = 0; i < colunas.length; i++){
				c.add(Restrictions.like(colunas[i], querys[i], MatchMode.ANYWHERE));
			}
			c.add(Restrictions.eq("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	// metodo alterado para buscar somente ativos
	public List<?> buscarPorLikeIgnoreCase(String coluna, String queryPart, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.ilike(coluna, queryPart, MatchMode.ANYWHERE));
			c.add(Restrictions.eq("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> buscarData(String coluna, Date inicio, Date fim, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.between(coluna, inicio, fim));
			c.add(Restrictions.like("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> buscarDataVencimento(String coluna,Date inicio, Date fim, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.between(coluna, inicio,fim ));
			c.add(Restrictions.like("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public List<?> buscarDataVencimento2(String coluna,DateFormat inicio, DateFormat fim, Class clazz){
		try{
			sessao = HibernateUtil.getSession();
			Criteria c = sessao.createCriteria(clazz);
			c.add(Restrictions.between(coluna, inicio,fim ));
			c.add(Restrictions.like("status", Constants.ATIVO));
			List<?> objets = c.list();
			return objets;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			sessao.close();
		}
	}
	
	public long maiorCodMSG() throws SQLException{
		
		PreparedStatement stmt = con.prepareStatement("SELECT max(cod_msg) as cod_msg from mensagem");
		ResultSet rs = stmt.executeQuery();
		rs.next();
		long cod_msg = rs.getLong("cod_msg");
		stmt.close();
		rs.close();
		
		return cod_msg;
		
	}
	
	
	public List<String> buscarEnderecoTotal(String cep) {
		List<String> enderecoTotal = new ArrayList<String>();
		
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT id_cidade AS cidadeGET FROM cep_tend_endereco WHERE cep = '"+cep+"'");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int idCidade = rs.getInt("cidadeGET");
			stmt.close();
			rs.close();
			
			PreparedStatement stmt2 = con.prepareStatement("SELECT id_bairro AS bairroGET FROM cep_tend_endereco WHERE cep = '"+cep+"'");
			ResultSet rs2 = stmt2.executeQuery();
			rs2.next();
			int idBairro = rs2.getInt("bairroGET");
			stmt2.close();
			rs2.close();
			
			PreparedStatement stmt3 = con.prepareStatement("SELECT id_estado AS estadoGET FROM cep_tend_cidade WHERE id_cidade = "+idCidade);
			ResultSet rs3 = stmt3.executeQuery();
			rs3.next();
			int idEstado = rs3.getInt("estadoGET");
			stmt3.close();
			rs3.close();
			
			PreparedStatement stmt4 = con.prepareStatement("SELECT endereco_completo AS enderecoGET FROM cep_tend_endereco WHERE cep = '"+cep+"'");
			ResultSet rs4 = stmt4.executeQuery();
			rs4.next();
			String enderecoCompleto = rs4.getString("enderecoGET");
			stmt4.close();
			rs4.close();
			
			PreparedStatement stmt5 = con.prepareStatement("SELECT bairro AS bairroGET FROM cep_tend_bairro WHERE id_bairro = "+idBairro);
			ResultSet rs5 = stmt5.executeQuery();
			rs5.next();
			String bairro = rs5.getString("bairroGET");
			stmt5.close();
			rs5.close();
			
			PreparedStatement stmt6 = con.prepareStatement("SELECT cidade AS cidadeGET FROM cep_tend_cidade WHERE id_cidade = "+idCidade);
			ResultSet rs6 = stmt6.executeQuery();
			rs6.next();
			String cidade = rs6.getString("cidadeGET");
			stmt6.close();
			rs6.close();
			
			enderecoTotal.add(0, enderecoCompleto);
			enderecoTotal.add(1, bairro);
			enderecoTotal.add(2, cidade);
			enderecoTotal.add(3, "" + (idEstado - 1));
			
			return enderecoTotal;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
