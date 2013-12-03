package cat.juli.marcianitos;

public class NauAmiga extends Nau {

	public NauAmiga(int x, int y, String img) {
		super(x, y, img);
		
		
	}
	
	

	@Override
	public void moure(int x) {
		// TODO Auto-generated method stub
		imatge.move(x, 0);
	}
	
	

}
