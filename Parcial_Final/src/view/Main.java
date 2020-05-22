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
			//coloco el txt
			
		}else if (mensaje2==true) {
			
			
		}
		
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
