package model;

import processing.core.PApplet;

public class Sanas extends Objeto {

	private PApplet app2;
	private int posx;
	private int posy;
	private int colorc;
	private int tamx;
	private int tamy;
	private int direcx;
	private int direcy;
	
	
	public Sanas(int tam1, int tam2, int colorcito, int pox, int poy, PApplet apP) {
		super(tam1, tam2, colorcito, pox, poy, apP);
		// TODO Auto-generated constructor stub
		this.posx=(int) (apP.random(1, 500));;
		this.posy=(int) (apP.random(1, 500));;
		this.colorc=colorcito;
		this.tamx=tam1;
		this.tamy=tam2;
		this.app2=apP;
		direcx=(int)app2.random(1,4);
		direcy=(int)app2.random(1,4);
	}

	public void mover() {

		
		posx=posx+direcx;
		posy=posy+direcy;
		
		if (posx<5 || posx>595) {
			
			direcx = direcx*(-1);
			
		}
		if (posy<5 || posy>595) {
			
			direcy= direcy*(-1);
			
		}
		setPosx(posx);
		setPosy(posy);
		
		
		
	}
	
    public void draw() {
		
		app2.fill(colorc);
		app2.ellipse(posx,posy,tamx,tamy);
	}
	
	
	
	@Override
	public int compareTo(Objeto o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
