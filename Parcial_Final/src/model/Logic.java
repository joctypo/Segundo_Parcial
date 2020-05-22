package model;

import java.util.LinkedList;

import exceptions.ExcepcionPrimera;
import exceptions.ExcepcionSegunda;
import processing.core.PApplet;

public class Logic {

	private LinkedList<Objeto> objetitos;
	// private LinkedList<Objeto> objetitos2;
	private String info1[];
	private PApplet apP;

	public Logic(PApplet app) {

		apP = app;
		objetitos = new LinkedList<Objeto>();
		// objetitos2 = new LinkedList<Objeto>();
		info1 = apP.loadStrings("../insumos/datos.txt");
		cargartext();
	}

	public void cargartext() {

		for (int i = 0; i < info1.length; i++) {
			String[] objeto = info1[i].split(":");
			int tam1 = Integer.parseInt(objeto[1]);

			if (objeto[0].contentEquals("sanas")) {

				int colorcito = apP.color(0, 255, 0);

				for (int j = 0; j < tam1; j++) {
					int pox = (int) (apP.random(1, 500));
					int poy = (int) (apP.random(1, 500));
					objetitos.add(new Sanas(7, 7, colorcito, pox, poy, apP));

				}
			} // llave del if sanas

			if (objeto[0].contentEquals("infectadas")) {

				int colorcito = apP.color(255, 0, 0);

				for (int j = 0; j < tam1; j++) {
					int pox = (int) (apP.random(1, 500));
					int poy = (int) (apP.random(1, 500));
					objetitos.add(new Infectadas(7, 7, colorcito, pox, poy, apP));

				}
			} // llave del if infectadas

			if (objeto[0].contentEquals("recuperadas")) {
				System.out.println("recuperada");
				int colorcito = apP.color(0, 0, 255);

				for (int j = 0; j < tam1; j++) {
					int pox = (int) (apP.random(1, 500));
					int poy = (int) (apP.random(1, 500));
					objetitos.add(new Sanas(7, 7, colorcito, pox, poy, apP));

				}
			} // llave del if recuperadas

		} // LLave for

	}

	public void draw() {

		apP.background(255);

		for (int i = 0; i < objetitos.size(); i++) {

			objetitos.get(i).draw();

			// Creación de Hilo
			Thread Nh;
			Nh = new Thread(objetitos.get(i));
			Nh.start();

		}

	}

	public void ordenamientoN() {

	}

	public void ordenamientoP() {

	}

	public void primerae() throws ExcepcionPrimera {
		// Se coloca la excepcion
		if (objetitos.size() == 0) {

			throw new ExcepcionPrimera("Perra no más");

		}

	}

	public void segundae() throws ExcepcionSegunda {
		// Se coloca la excepcion
		if (objetitos.size() == 0) {

			throw new ExcepcionSegunda("Perra no más");

		}

	}

	public void verificarchoque() {

		try {
			for (int i = 0; i < objetitos.size(); i++) {
				for (int j = 0; j < objetitos.size(); j++) {
					int dis1= objetitos.get(i).getPosx();
					int dis2= objetitos.get(i).getPosy();
					int di1=objetitos.get(j).getPosx();
					int di2=objetitos.get(j).getPosy();
					if (PApplet.dist(dis1, dis2, di1, di2) < 40) {

						if (j != objetitos.size() && i != objetitos.size()) {

							if (objetitos.get(i) != objetitos.get(j)) {
								if (objetitos.get(i) instanceof Circulo && objetitos.get(j) instanceof Circulo) {

								} else if (objetitos.get(i) instanceof Cuadrado
										&& objetitos.get(j) instanceof Cuadrado) {

								}

							}
						}
					}
				}

			}

		} catch (IndexOutOfBoundsException e) {

		}

	}

}
