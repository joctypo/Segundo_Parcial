package view;

import controller.Main_Controller;
import exceptions.ExcepcionPrimera;
import exceptions.ExcepcionSegunda;
import processing.core.PApplet;

public class Main extends PApplet {

	private Main_Controller mc;
	boolean mensaje1,mensaje2;
	
	
	public static void main(String[] args) {
	
		PApplet.main("view.Main");

	}

	public void settings() {
		
		size(600,600);
		
	}
	
	public void setup() {
		
		mc=new Main_Controller(this);
		mensaje1=false;
		mensaje2=false;
		
		
	}
	
	public void draw() {
		
		mc.draw();
		verficarchoque();
		if (mensaje1==true) {
			fill(255,0,0);
			textSize(50);
			text("Mas del 30% estan infectados",20,250);
			
		}else if (mensaje2==true) {
			
			
		}
		fill(255);
		noStroke();
		
		rect(0,0,600,100);
		
		
		fill (15);
		textSize(10);
		text("Sanos:       " + mc.contadors(),10,10);
		text("Infectados:       " + mc.contadori(),10,30);
		text("Recuperados:       " + mc.contadorr(),10,50);
		
	}
	

	
	public void keyPressed() {
		
		
		mc.keyPressed(key);
		
	}
	
	public void excepcionPrimer() {
		try {
			mc.excepciones1();
		} catch (ExcepcionPrimera e) {
			// TODO Auto-generated catch block
			mensaje1=true;
			e.printStackTrace();
		}
		
	}
	
	public void excepcionSegun() {
		
		try {
			mc.excepciones2();
		} catch (ExcepcionSegunda e) {
			// TODO Auto-generated catch block
			mensaje2=true;
			e.printStackTrace();
		}
		
	}
	
	
	public void verficarchoque() {
		
		mc.verificarchoque();
		
		
	}
	
	
}//llave del final
