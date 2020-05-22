package model;

import java.util.Collections;
import java.util.LinkedList;
import exceptions.ExcepcionPrimera;
import exceptions.ExcepcionSegunda;
import processing.core.PApplet;

public class Logic {

	private LinkedList<Objeto> objetitos;
	// private LinkedList<Objeto> objetitos2;
	private String info1[];
	private PApplet apP;
	private Value_Compare vc;
	private int contadorsanas,contadorinfectadas,contadorrecuperadas;
	private boolean infecto;
	private boolean infeccion;
	
	
	public Logic(PApplet app) {

		apP = app;
		objetitos = new LinkedList<Objeto>();
		vc = new Value_Compare();
		// objetitos2 = new LinkedList<Objeto>();
		info1 = apP.loadStrings("../insumos/datos.txt");
		cargartext();
		infecto=false;
		infeccion=true;
	}

	public void cargartext() {

		for (int i = 0; i < info1.length; i++) {
			String[] objeto = info1[i].split(":");
			int tam1 = Integer.parseInt(objeto[1]);

			if (objeto[0].contentEquals("sanas")) {

				int colorcito = apP.color(0, 255, 0);

				for (int j = 0; j < tam1; j++) {
					int pox = (int) (apP.random(1, 500));
					int poy = (int) (apP.random(100, 500));
					objetitos.add(new Sanas(7, 7, colorcito, pox, poy, apP));

				}
			} // llave del if sanas

			if (objeto[0].contentEquals("infectadas")) {

				int colorcito = apP.color(255, 0, 0);

				for (int j = 0; j < tam1; j++) {
					int pox = (int) (apP.random(1, 500));
					int poy = (int) (apP.random(100, 500));
					objetitos.add(new Infectadas(7, 7, colorcito, pox, poy,infeccion, apP));

				}
			} // llave del if infectadas

			if (objeto[0].contentEquals("recuperadas")) {
				System.out.println("recuperada");
				int colorcito = apP.color(0, 0, 255);

				for (int j = 0; j < tam1; j++) {
					int pox = (int) (apP.random(1, 500));
					int poy = (int) (apP.random(100, 500));
					objetitos.add(new Recuperadas(7, 7, colorcito, pox, poy, apP));

				}
			} // llave del if recuperadas

		} // LLave for

	}

	public void draw() {

		apP.background(255);

		for (int i = 0; i < objetitos.size(); i++) {

			objetitos.get(i).draw();
			
			// Creaci�n de Hilo
			Thread Nh;
			Nh = new Thread(objetitos.get(i));
			Nh.start();
			
		}
		
		contadores();
		
		System.out.println(contadorsanas);
	System.out.println(contadorrecuperadas);
		
	}

	public void ordenamientoN() {

		
		
		
	}

	public void ordenamientoP() {
		
		Collections.sort(objetitos,vc);
		
		
	}

	public void primerae() throws ExcepcionPrimera {
		// Se coloca la excepcion
		if (getContadorinfectadas()>=30) {

			throw new ExcepcionPrimera("M�s del 30% estan infectados");

		}

	}

	public void segundae() throws ExcepcionSegunda {
		// Se coloca la excepcion
		if (infecto==true) {
			infecto=false;
			throw new ExcepcionSegunda("Se contagio alguien m�s");
		}

	}

	public void verificarchoque() {


			for (int i = 0; i < objetitos.size(); i++) {
				for (int j = 0; j < objetitos.size(); j++) {
					int dis1= objetitos.get(i).getPosx();
					int dis2= objetitos.get(i).getPosy();
					int di1=objetitos.get(j).getPosx();
					int di2=objetitos.get(j).getPosy();
					if (PApplet.dist(dis1, dis2, di1, di2) < 10) {

						//if (j != objetitos.size() && i != objetitos.size()) {
							

							if (objetitos.get(i) != objetitos.get(j)) {
								//System.out.println("toco");
								
								int direccion= objetitos.get(j).getDirecx();
								//System.out.println(direccion);
								int direccion2=objetitos.get(j).getDirecy();
								objetitos.get(j).setDirecx(direccion*(-1));
								objetitos.get(j).setDirecy(direccion2*(-1));
								
								
								int direccion12= objetitos.get(i).getDirecx();
								//System.out.println(direccion12);
								int direccion22=objetitos.get(i).getDirecy();
								objetitos.get(i).setDirecx(direccion12*(-1));
								objetitos.get(i).setDirecy(direccion22*(-1));
								
								
								
								
								if (objetitos.get(i) instanceof Sanas && objetitos.get(j) instanceof Infectadas) {

									int inf= (int) apP.random(1,11);
									
									if (inf>1 && inf<9) {
										int colorcito= apP.color(255,0,0);
										objetitos.add(new Infectadas(7, 7, colorcito,objetitos.get(i).getPosx(), objetitos.get(i).getPosy(),infeccion, apP));
										objetitos.remove(i);
										
									}	
										
										
										
										
											
									
								}

							}
						
					}
				}

			}

		
	}

	
	public void contadores() {
		contadorsanas=0;
		contadorrecuperadas=0;
		contadorinfectadas=0;
		for (int j=0;j<objetitos.size();j++) {
			
			if(objetitos.get(j) instanceof Sanas) {
				
				contadorsanas=contadorsanas+1;
				
			}
			
			if(objetitos.get(j) instanceof Infectadas) {
				
				contadorinfectadas=contadorinfectadas+1;
				
			}
			
			if(objetitos.get(j) instanceof Recuperadas) {
				
				contadorrecuperadas=contadorrecuperadas+1;
				
			}
			
		}
		
	}

	public int getContadorsanas() {
		return contadorsanas;
	}

	public void setContadorsanas(int contadorsanas) {
		this.contadorsanas = contadorsanas;
	}

	public int getContadorinfectadas() {
		return contadorinfectadas;
	}

	public void setContadorinfectadas(int contadorinfectadas) {
		this.contadorinfectadas = contadorinfectadas;
	}

	public int getContadorrecuperadas() {
		return contadorrecuperadas;
	}

	public void setContadorrecuperadas(int contadorrecuperadas) {
		this.contadorrecuperadas = contadorrecuperadas;
	}
	
	

	
}
