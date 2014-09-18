package com.dicaspet.MB;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.Timer;

@ManagedBean
@SessionScoped
public class ReporThread implements Runnable{
	Random timer= new Random();
	Timer t;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ActionListener action = new ActionListener() {  
			
			public void actionPerformed(ActionEvent a) {
				
				if(ReporAlimentoMB.quantAlimentoAtual>1){
				ReporAlimentoMB.quantAlimentoAtual=(int) (ReporAlimentoMB.quantAlimentoAtual-15);
	            System.out.println(ReporAlimentoMB.quantAlimentoAtual);
				
				} else if(ReporAlimentoMB.quantAlimentoAtual<0){
					ReporAlimentoMB.quantAlimentoAtual=0;
					System.out.println(ReporAlimentoMB.quantAlimentoAtual);
				}
				
				else{
					
					 System.out.println(ReporAlimentoMB.quantAlimentoAtual);
	            }
			
			}
			
			
	};
    	this.t= new Timer(timer.nextInt(100000),action);
		t.start();
		
	}
	
	

}
