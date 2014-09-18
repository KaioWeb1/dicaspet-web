package com.dicaspet.MB;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.swing.Timer;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.dicaspet.entidade.Animal;
import com.dicaspet.util.FacesContextUtil;
 
@ManagedBean
@SessionScoped
public class ReporAlimentoMB implements Serializable{
 
	/**
	 * 
	 */
	static int quantAlimentoAtual=0;
	static SimpleDateFormat teste2 = new SimpleDateFormat("HH");
	
	private static final long serialVersionUID = 1L;
	private Animal animal;
    private LineChartModel zoomModel;
    public Timer t;
    private Random timer;
    int um = 0;
    private GregorianCalendar teste;
   
    private  LineChartSeries series2;
    private LineChartModel model; 
   // ReporThread reporThread;
    
    public ReporAlimentoMB(){
    	
    	
    	//reporThread = new ReporThread();
    	teste = new GregorianCalendar();  
    	  
    	animal = (Animal) FacesContextUtil.getSessionAttribute("animal");
    	quantAlimentoAtual = (int) animal.getAni_qtdInicAlimento();
    	timer= new Random();
    	series2 = new LineChartSeries();
    	model = new LineChartModel();
    	
    }
 
    @PostConstruct
    public void init() {
        createZoomModel();
        //reporThread.run();
      
    }
    
   public void getRepor(){
    	um++;
    	quantAlimentoAtual=(int) animal.getAni_qtdInicAlimento();
    	createZoomModel();
    
    	
    	System.out.println(quantAlimentoAtual+"repos---------------------------------------------------------");
    	
    }
 
    public LineChartModel getZoomModel() {
        return zoomModel;
    }
     
    private void createZoomModel() {
        zoomModel = initLinearModel();
        zoomModel.setTitle("Verificar níveis de alimentação");
        zoomModel.setZoom(false);
        zoomModel.setLegendPosition("e");
        Axis yAxis = zoomModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(animal.getAni_qtdFimAlimento());
        Axis xAxis = zoomModel.getAxis(AxisType.X);
        xAxis.setMin(0);
        xAxis.setMax(23);
       
    }
     
    public LineChartModel initLinearModel() {
        //LineChartModel model = new LineChartModel();

//       LineChartSeries series1 = new LineChartSeries();
//       series1.setLabel("Água");
// 
//       series1.set(1, 2);
//       series1.set(2, 1);
//       series1.set(3, 3);
//       series1.set(4, 6);
//       series1.set(5, 8);
//teste2.format(teste.getTime())
       //LineChartSeries series2 = new LineChartSeries();
       series2.setLabel("Alimento");
       

       series2.set(um,quantAlimentoAtual);
       
       System.out.println(um +"-------------"+quantAlimentoAtual+"montando__________________________________----------------------- ");
       

      // model.addSeries(series1);
       
       if(model.getSeries()!=null){
    	   model.clear();
       }
       model.addSeries(series2);
       
       
  	 return model;
	}; 
   

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	
	/*public void run() {
	   
		ActionListener action = new ActionListener() {  
			
				public void actionPerformed(ActionEvent a) {
					
					quantAlimentoAtual=(int) (quantAlimentoAtual-(quantAlimentoAtual-0.5));
					//series2.set(teste2.format(teste.getTime()),quantAlimentoAtual-20);	
					series2.set(7,quantAlimentoAtual-20);
					series2.set(8,quantAlimentoAtual-20);
					model.addSeries(series2);
					refresh();
				}
				
				
		};
	    	//this.t= new Timer(timer.nextInt(900000),action);
			this.t= new Timer(timer.nextInt(3000),action);
	};
	*/
	public void refresh() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		ViewHandler viewHandler = application.getViewHandler();
		UIViewRoot viewRoot = viewHandler.createView(context, context
				.getViewRoot().getViewId());
		context.setViewRoot(viewRoot);
		context.renderResponse();
	}
};

