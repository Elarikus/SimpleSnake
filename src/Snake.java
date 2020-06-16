import java.util.*;

public class Snake {

	
	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		ArrayList<ArrayList<Integer>> snake = new ArrayList<ArrayList<Integer>>();
		
		int height = 12;
		int width = 20;
		
		
		//Initial snake positions
		ArrayList<Integer> pos1 = new ArrayList<Integer>();
		pos1.add(5);
		pos1.add(5);
		ArrayList<Integer> pos2 = new ArrayList<Integer>();
		pos2.add(6);
		pos2.add(5);
		ArrayList<Integer> pos3 = new ArrayList<Integer>();
		pos3.add(7);
		pos3.add(5);
		
		snake.add(pos1);
		snake.add(pos2);
		snake.add(pos3);
		
		ArrayList<Integer> fruit = new ArrayList<Integer>(); 
		fruit.add(2);
		fruit.add(3);
		
		boolean loose = false;
		
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object

	    
	    System.out.println("Flag a");
	    
		// The game
		while(!loose) {
			
			String laneBorder = "H";
			for(int i = 0 ; i < width-2 ; i++) {
				laneBorder = laneBorder + "-";
			}
			laneBorder = laneBorder + "H";
			
			System.out.println(laneBorder);
			
			ArrayList<Integer> currentPos = new ArrayList<Integer>();
			currentPos.add(0);
			currentPos.add(0);
			
			currentPos.set(1, 0);
			
			for(int i= 0 ; i < height-2 ; i++) {
				currentPos.set(0, 0);
				
				String laneClassic = "|";
				for(int j = 0 ; j < width-2 ; j++) {
					
					boolean isSnakePart = false;
					int k = 0;
					while(k < snake.size() && (isSnakePart == false)) {
						isSnakePart = ((currentPos.get(0) == snake.get(k).get(0)) && (currentPos.get(1) == snake.get(k).get(1)));
						k++;
					}
					
			
					
					// We check if the current position is a fruit or a snake part
					if(currentPos.get(0) == fruit.get(0) && currentPos.get(1) == fruit.get(1)) {
						laneClassic = laneClassic + "o";
					} else if(isSnakePart) {
						laneClassic = laneClassic + "x";
					} else {					
						laneClassic = laneClassic + " ";
					}
					
					currentPos.set(0, currentPos.get(0) + 1);
				}
				
				laneClassic = laneClassic + "|";
				System.out.println(laneClassic);
				currentPos.set(1, currentPos.get(1) + 1);
				
			}
			

			System.out.println(laneBorder);
			
			
			String movement = scanner.nextLine();  // Read user input
			System.out.println("Movement is: " + movement);  // Output user input
			
			switch(movement) {
			  case "q":
				  // Move left
				  
				  break;
			  case "z":
				  // Move up
				  break;
			  case "s":
				  // Move down
				  break;
			  case "d":
				  // Move right
				  break;
			  default:
				  // We do nothing
			}

		}
		
		System.out.println("That's all folks");
		scanner.close();
	}
}
