package cat.juli.marcianitos;

public class NauEnemiga extends Nau {

	public NauEnemiga(int x, int y, String img) {
		super(x, y, img);
		
	}
	
	
	public void moure(int x){
		imatge.move(x, 0);
	}

}
