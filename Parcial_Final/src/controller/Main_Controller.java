package controller;

import exceptions.ExcepcionPrimera;
import exceptions.ExcepcionSegunda;
import model.Logic;
import processing.core.PApplet;
import view.Main;

public class Main_Controller {

	private PApplet app;
	private Logic lo;
	
	
	public Main_Controller(Main main) {
		
		app=main;
		lo = new Logic(app);		
	}

	public void draw() {
		
		lo.draw();
		
	}



	public void keyPressed(char key) {
		
		if (key=='n') {
			
			lo.ordenamientoN();
			
		}else if (key=='p') {
			
			lo.ordenamientoP();
			
		}
		
		
	}
	
	
	public void excepciones1() throws ExcepcionPrimera {
		
		lo.primerae();
		
		
	}
	
	public void excepciones2() throws ExcepcionSegunda {
		
		lo.segundae();
		
		
	}

}
