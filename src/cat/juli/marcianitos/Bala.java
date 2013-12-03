package cat.juli.marcianitos;

import acm.graphics.GRectangle;

public class Bala extends Objecte {

	public Bala(double d, double e) {
		super(d, e, "bala.gif");
	}
	
	
	public void moure(int y){
		imatge.move(0, y);
		
	}
	/*
	 * Rep on es troba la bala en aquell moment
	 * ERRONI!!!
	 */
	public boolean matar(GRectangle nau){
		
		return getRectangle().intersects(nau);
		
		
	}


	
	
	
	
	

}
