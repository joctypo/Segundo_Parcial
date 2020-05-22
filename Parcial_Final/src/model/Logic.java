package model;

import java.util.LinkedList;


import exceptions.ExcepcionPrimera;
import exceptions.ExcepcionSegunda;
import processing.core.PApplet;

public class Logic {

	private LinkedList<Objeto> objetitos;
	//private LinkedList<Objeto> objetitos2;
	private String info1[];
	private PApplet apP;
	
	
	public Logic(PApplet app) {
	
		apP=app;
		objetitos = new LinkedList<Objeto>();
		//objetitos2 = new LinkedList<Objeto>();
		info1= apP.loadStrings("../insumos/datos.txt");
		
		
	}
	
	public void cargartext() {
		     
		for (int i=0; i<info1.length;i++) {
			String[] objeto= info1[i].split(",");
			
			int tam1=Integer.parseInt(objeto[1]);
			int tam2=Integer.parseInt(objeto[2]);
			
			
			if(objeto[0].contentEquals("Cuadrado")) {
				
				
			int r= (int)(apP.random(0, 255));
			int g =(int)(apP.random(0, 255));
			int b =(int)(apP.random(0, 255));
			int colorcito = apP.color(r,g, b);
			int pox=(int)(apP.random(0,500));
			int poy=(int)(apP.random(0,500));
			
			objetitos.add(new Cuadrado(tam1,tam2,colorcito,pox,poy,apP));
			
			}//llave del if cuadrado 
			
			if (objeto[1].contentEquals("Circulo")) {
				
			int r= (int)(apP.random(0, 255));
			int g =(int)(apP.random(0, 255));
			int b =(int)(apP.random(0, 255));
			int colorcito = apP.color(r,g, b);
			int pox=(int)(apP.random(0,500));
			int poy=(int)(apP.random(0,500));
				
			objetitos.add(new Circulo(tam1,tam2,colorcito,pox,poy,apP));	
				
				
				
				
				
			}// llave del if circulo 
			
			
			
			
		}//LLave for
		 
	}

	public void draw() {
		
		
		apP.background(255);
		
		for (int i=0; i<objetitos.size();i++) {
			
			objetitos.get(i).draw();
		
			
			
			//Creación de Hilo 
			Thread Nh;
			Nh=new Thread(objetitos.get(i));
			Nh.start();
			
			
			
		
		}
		
		
		
	}

	public void ordenamientoN() {
		
		
		
		
		
	}

	public void ordenamientoP() {
	
		
		
		
	}

	public void mouseClicked() {

		
		
		
		
		
	}
	
	
	public void primerae() throws ExcepcionPrimera {
		// Se coloca la excepcion
		if (objetitos.size()==0) {
			
			throw new ExcepcionPrimera ("Perra no más");
			
			
		}	
		
	}
	
	public void segundae() throws ExcepcionSegunda {
		// Se coloca la excepcion
		if (objetitos.size()==0) {
			
			throw new ExcepcionSegunda ("Perra no más");
			
			
		}	
		
	}
	

}
