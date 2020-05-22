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
	private int signo;
	private int signo2;
	
	public Sanas(int tam1, int tam2, int colorcito, int pox, int poy, PApplet apP) {
		super(tam1, tam2, colorcito, pox, poy, apP);
		// TODO Auto-generated constructor stub
		this.posx=(int) (apP.random(1, 500));;
		this.posy=(int) (apP.random(100, 500));;
		this.colorc=colorcito;
		this.tamx=tam1;
		this.tamy=tam2;
		this.app2=apP;
		
		signo=(int)app2.random(1,3);
		direcx=(int)app2.random(1,4);
		if (signo==2) {
			
			direcx= direcx*(-1);
		}
		
		signo2=(int)app2.random(1,3);
		
		direcy=(int)app2.random(1,4);
		if (signo==2) {
			
			direcy= direcy*(-1);
		}
	}

	public void mover() {

		
		posx=posx+direcx;
		posy=posy+direcy;
		
		if (posx<1 || posx>599) {
			
			direcx = direcx*(-1);
			
		}
		if (posy<100 || posy>599) {
			
			direcy= direcy*(-1);
			
		}
		setPosx(posx);
		setPosy(posy);
		setDirecx(direcx);
		setDirecy(direcy);
		
		
		
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
