package cat.juli.marcianitos;

import acm.graphics.GImage;

public class Objecte {
	GImage imatge;

	public Objecte(double d, double e, String img) {
		this.imatge = new GImage(img, d, e);
		

	}
	
	public GImage getImatge(){
		return imatge;
	}

	public void setPosicio(double x, double y) {
		imatge.setLocation(x, y);
	}

	public double retornarX() {
		return imatge.getX();
	}

	public double retornarY() {
		return imatge.getY();
	}
}
