package cat.juli.marcianitos;

public abstract class Nau extends Objecte {
	String direccio;
	public Nau(int x, int y, String img) {
		super(x, y, img);
	}
	
	public void setDireccio(String dir){
		direccio = dir;
	}
	public String getDireccio(){
		return direccio;
	}
	
	
	
	public abstract void moure(int x);
		
	
	
	
	

}
