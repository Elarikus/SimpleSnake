
public class Position {

	//Largeur puis hauteur
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position() {
		
	}
	
	
	//Getters
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	//Setters
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setPos(Position newPos) {
		this.x = newPos.getX();
		this.y = newPos.getY();
	}
}
