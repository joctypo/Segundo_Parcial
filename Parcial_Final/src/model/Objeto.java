package model;

import processing.core.PApplet;

public abstract class Objeto implements Runnable,Comparable<Objeto>{

	private int posx,posy,tamx,tamy,colorete,direcx,direcy;
	//private PApplet app2;
	
	
	public Objeto(int tam1, int tam2, int colorcito, int pox, int poy, PApplet apP) {
		posx=pox;
		posy=poy;
		tamx=tam1;
		tamy=tam2;
		colorcito=colorete;
		//this.app2=apP;
		
	}
	
	public void draw() {
		
		
	}
	
	public void mover() {
		
		
		
	}
	
	
	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getTamx() {
		return tamx;
	}

	public void setTamx(int tamx) {
		this.tamx = tamx;
	}

	public int getTamy() {
		return tamy;
	}

	public void setTamy(int tamy) {
		this.tamy = tamy;
	}

	public int getColorete() {
		return colorete;
	}

	public void setColorete(int colorete) {
		this.colorete = colorete;
	}

	public int getDirecx() {
		return direcx;
	}

	public void setDirecx(int direcx) {
		this.direcx = direcx;
	}

	public int getDirecy() {
		return direcy;
	}

	public void setDirecy(int direcy) {
		this.direcy = direcy;
	}

	@Override
	public void run() {
		mover();
		
		
	}

	
	
	
}


