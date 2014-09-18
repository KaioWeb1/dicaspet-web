package com.dicaspet.MB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "pesoIdealMB")
@RequestScoped
public class PesoIdealMB {

	private String porte;
	private String sexo;
	private double pesoAtual;
	private String msg; 


	public void calcularPesoIdeal() {

		System.out.println("entrou");
		if (porte.equals("pequeno")) {

			if (sexo.equals("femea")) {
				if(pesoAtual>1.5 && pesoAtual<=9){
					msg="Seu animal esta no peso médio ideal";
				}
				else if(pesoAtual>9){
					
					if(pesoAtual<=(9*1.1)){
						msg="Seu animal esta acima do peso, o peso médio ideal seria entre 1.5 a 9 Kg";
					}
					else{
						msg="Seu animal esta obeso, o peso médio ideal seria entre 1.5 a 9 Kg";
					}
				}
				else{
					msg="Animal desnutrido";
				}
				
			} else {
				if(pesoAtual>2.7 && pesoAtual<10){
					msg="Seu animal esta no peso médio ideal";
				}
				else if(pesoAtual>10){
					
					if(pesoAtual<=(10*1.1)){
						msg="Seu animal esta acima do peso, o peso médio ideal seria entre 2.7 a 9.9 Kg";
					}
					else{
						msg="Seu animal esta obeso, o peso médio ideal seria entre 2.7 a 9.9 Kg";
					}
				}
				else{
					msg="Animal desnutrido";
				}
			}
		}
		if (porte.equals("medio")) {

			if (sexo.equals("femea")) {
				if(pesoAtual>9 && pesoAtual<=30){
					msg="Seu animal esta no peso médio ideal";
				}
				else if(pesoAtual>30){
					
					if(pesoAtual<=(30*1.1)){
						msg="Seu animal esta acima do peso, o peso médio ideal seria entre 9 a 30 Kg";
					}
					else{
						msg="Seu animal esta obeso, o peso médio ideal seria entre 9 a 30 Kg";
					}
				}
				else{
					msg="Animal desnutrido";
				}
				
			} else {
				if(pesoAtual>10 && pesoAtual<35){
					msg="Seu animal esta no peso médio ideal";
				}
				else if(pesoAtual>35){
					
					if(pesoAtual<=(35*1.1)){
						msg="Seu animal esta acima do peso, o peso médio ideal seria entre 10 a 35 Kg";
					}
					else{
						msg="Seu animal esta obeso, o peso médio ideal seria entre 10 a 35 Kg";
					}
				}
				else{
					msg="Animal desnutrido";
				}
			}
		}

		if (porte.equals("grande")) {
			
			if (sexo.equals("femea")) {
				if(pesoAtual>30 && pesoAtual<=75){
					msg="Seu animal esta no peso médio ideal";
				}
				else if(pesoAtual>75){
					
					if(pesoAtual<=(75*1.1)){
						msg="Seu animal esta acima do peso, o peso médio ideal seria entre 30 a 75 Kg";
					}
					else{
						msg="Seu animal esta obeso, o peso médio ideal seria entre 30 a 75 Kg";
					}
				}
				else{
					msg="Animal desnutrido";
				}
				
			} else {
				if(pesoAtual>35 && pesoAtual<90){
					msg="Seu animal esta no peso médio ideal";
				}
				else if(pesoAtual>90){
					
					if(pesoAtual<=(90*1.1)){
						msg="Seu animal esta acima do peso, o peso médio ideal seria entre 35 a 90 Kg";
					}
					else{
						msg="Seu animal esta obeso, o peso médio ideal seria entre 35 a 90 Kg";
					}
				}
				else{
					msg="Animal desnutrido";
				}
			}
		}

	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public double getPesoAtual() {
		return pesoAtual;
	}

	public void setPesoAtual(double pesoAtual) {
		this.pesoAtual = pesoAtual;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
