package cat.juli.marcianitos;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Pantalla extends GraphicsProgram {
	NauAmiga amiga;
	int WIDTH = 900;
	int HEIGHT = 500;
	int numNaus = 12;
	CopyOnWriteArrayList<Bala> bales = new CopyOnWriteArrayList<Bala>();
	CopyOnWriteArrayList<NauEnemiga> enemigues = new CopyOnWriteArrayList<NauEnemiga>();

	public void init() {
		// Crear pantalla
		setSize(WIDTH, HEIGHT);
		// Indicar que ha d'escoltar les tecles del teclat, si toquen una tecla
		// es dispara
		// la funció keyPressed
		addKeyListeners(this);
	}

	public void run() {
		// FOns
		GImage fons = new GImage("fons.jpg", 0, 0);
		fons.setSize(900, 500);
		fons.sendBackward();
		add(fons);
		// Nau Amiga
		amiga = new NauAmiga(300, 440, "nauAmiga.gif");
		amiga.getImatge().sendToFront();
		// amiga.setPosicio(300,450);
		amiga.getImatge().setSize(40, 50);
		add(amiga.getImatge());
		// Nau Enemiga
		int x = 0;
		for (int i = 0; i < numNaus; i++) {
			NauEnemiga enemiga1 = new NauEnemiga(x, 0, "nauEnemiga.gif");
			enemiga1.getImatge().setSize(40, 50);
			add(enemiga1.getImatge());
			enemigues.add(enemiga1);
			x = x + 45;
		}
		boolean mort = false;
		String direccio = "dreta";
		for (;;) {
			// Es mouen totes les naus i despres comprovo si han xocat amb la
			// vora
			for (NauEnemiga nauEn : enemigues) {
				if (direccio.equals("dreta")) {
					nauEn.moure(20);

				} else {
					nauEn.moure(-20);
				}
			}
			// Un cop mogudes totes les naus es comprova si hi ha alguna que
			// xoca amb la vora. Si es aixi es canvia la direcció
			double midaEnemiga = enemigues.get(enemigues.size() - 1)
					.getImatge().getWidth();
			double posicioEnemigaFi = enemigues.get(enemigues.size() - 1)
					.getImatge().getX()
					+ midaEnemiga;
			double posicioEnemigaInici = enemigues.get(0).getImatge().getX();

			if (posicioEnemigaFi >= WIDTH) {
				direccio = "esquerra";
			} else if (posicioEnemigaInici <= 0) {
				direccio = "dreta";

			}
			/*
			 * Matar. Erroni...
			 */
			//Reseguir array bales
			for (Bala tir : bales) {
				//Moure bala
				tir.moure(-20);
				//recorre totes les naus enemigues si alguna xoca amb la nau morta
				for (int i = 0; i < enemigues.size(); i++) {
					//Comprovar si mata enviant la posicio de la nau
					mort = tir.matar(enemigues.get(i).getRectangle());
					if (mort == true) {
						System.out.println(mort);
						/*if (enemigues.get(i).getImatge().getX() <= tir.retornarX() 	&& enemigues.get(i).getImatge().getX() >= tir
										.retornarX()
										+ tir.getImatge().getWidth()) {*/
						remove(enemigues.get(i).getImatge());	
						enemigues.remove(i);
							
						//}
					}
				}

			}

			pause(100);
		}

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		int tecla = arg0.getKeyCode();
		switch (tecla) {
		case KeyEvent.VK_LEFT:
			amiga.moure(-10);
			break;
		case KeyEvent.VK_RIGHT:
			amiga.moure(10);
			break;
		case KeyEvent.VK_UP:

			Bala bala1 = new Bala(amiga.retornarX(), amiga.retornarY() - 10);
			bala1.getImatge().setSize(20, 30);
			// bala1.getImatge().sendToFront();
			add(bala1.getImatge());
			bales.add(bala1);
			break;
		default:
			break;
		}

	}
}
