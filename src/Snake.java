import java.util.ArrayList;

public class Snake {

	//Largeur puis hauteur
	public ArrayList<Position> listPos;
	
	public Snake() {
		Position pos = new Position(5,5);
		listPos.add(pos);
		pos = new Position(6,5);
		listPos.add(pos);
		pos = new Position(7,5);
		listPos.add(pos);
		
	}
	
	public void moveLeft() {
		Position newHead = new Position();
		
		newHead.setX(listPos.get(0).getX() - 1);
		newHead.setY(listPos.get(0).getY());
		
		for(int i = listPos.size()-1 ; i > 0 ; i = i-1) {
			listPos.get(i).setPos(listPos.get(i-1));
		}
		listPos.get(0).setPos(newHead);
		
	}
			
}
