package cat.juli.marcianitos;

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
	public boolean matar(double x, double y){
		double xBala = imatge.getX();
		double yBala = imatge.getY();
		double ampladaBala = imatge.getWidth();
		double alcadaBala = imatge.getHeight();
		if(x>=xBala && x<=xBala+ampladaBala){
			return true;
		}
		return false;
		
	}


	
	
	
	
	

}
