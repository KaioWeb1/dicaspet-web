package com.dicaspet.util;

public class Constants {

	//indica se a tupla está ou não ativa.
	public static final String ATIVO = "A";
	public static final String INATIVO = "I";
	public static final String DISPONIVEL = "D";
	
	//status do animal
	public static final String ADOTADO = "A";
	public static final String INDISPONIVEL = "N";
	
	//confirmação de serviço
	public static final String Pendente = "Pendente";
	public static final String Confirmado = "Confirmado";
	
	
	//siglas dos estados brasileiros
	public static String [] listaEstados = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
		"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
	
	
	//caminho fotos
	public static String CAMINHO_FOTO = "C:/dicaspet/fotos/";

	
	
	public static int getPosicaoEstado(String estado){
		int retorno = -1;
		for(int i = 0; i < listaEstados.length; i++){
			if(listaEstados[i].equals(estado)){
				retorno = i;
				break;
			}
		}
		return retorno;
	}
}
