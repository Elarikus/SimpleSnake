import java.util.*;

public class Snake {

	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> snake = new ArrayList<ArrayList<Integer>>();
		
		int width = 15;
		int height = 8;
		
		
		Random rand = new Random();
		
		//Initial snake positions
		//Largeur puis hauteur
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
		fruit.add(-1);
		fruit.add(-1);
		creationfruit(rand, width, height, fruit, snake);
		
		boolean loose = false;
		
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object

	    
		// The game
		while(!loose) {
			
			affichage(width, height, snake, fruit);
			
			String movement = scanner.nextLine();  // Read user input
			System.out.println("Movement is: " + movement);  // Output user input
			
			ArrayList<Integer> head = snake.get(0);
			Integer coordonee0 = head.get(0);
			Integer coordonee1 = head.get(1);
			switch(movement) {
			  case "q":
				  coordonee0 = coordonee0 - 1;
				  // Move left
				  
				  break;
			  case "z":
				  coordonee1 = coordonee1 - 1;
				  // Move up
				  break;
			  case "s":
				  coordonee1 = coordonee1 + 1;
				  // Move down
				  break;
			  case "d":
				  coordonee0 = coordonee0 + 1;
				  // Move right
				  break;
			  default:
				  // We do nothing
			}
			ArrayList<Integer> newHead = new ArrayList<Integer>();
			newHead.add(0, coordonee0);
			newHead.add(1, coordonee1);
			
			//Verification mangeage fruit
			if(newHead.get(0) == fruit.get(0) && newHead.get(1) == fruit.get(1)) {
				snake.add(snake.get(snake.size()- 1));
				
				creationfruit(rand, width, height, fruit, snake);
			}
			
				
			//Deplacement du serpent
			for(int i = snake.size()-1 ; i > 0 ; i--) {
				snake.set(i, snake.get(i-1));
			}
			
			snake.set(0, newHead);


		}
		
		System.out.println("That's all folks");
		scanner.close();
	}
	
	
	
	
	
	public static void creationfruit(Random rand, int width, int height, ArrayList<Integer> fruit, ArrayList<ArrayList<Integer>> snake  ) {
		
		int newXfruit = 0;
		int newYfruit = 0;
		boolean inSnake = true;
		
		while(inSnake) {
			inSnake = false;
			newXfruit = rand.nextInt(width);
			newYfruit = rand.nextInt(height);
			
			if(newXfruit == fruit.get(0) && newYfruit == fruit.get(1)) {
				inSnake = true;
			}
			
			System.out.println("newXfruit " + newXfruit);
			System.out.println("newYfruit: " + newYfruit);
			
			for(int i = 0 ; i < snake.size() ; i++) {
				if(newXfruit == snake.get(i).get(0) && newYfruit == snake.get(i).get(1)) {
					inSnake = true;
				}
			}
		}
		
		
		fruit.set(0, newXfruit);
		fruit.set(1, newYfruit);
	}
	
	
	
	
	public static void affichage(int w, int h, ArrayList<ArrayList<Integer>> snake, ArrayList<Integer> fruit) {
		String laneBorder = "H";
		for(int i = 0 ; i < w ; i++) {
			laneBorder = laneBorder + "-";
		}
		laneBorder = laneBorder + "H";
		
		System.out.println(laneBorder);
		
		ArrayList<Integer> currentPos = new ArrayList<Integer>();
		currentPos.add(0);
		currentPos.add(0);
		
		currentPos.set(1, 0);
		
		for(int i= 0 ; i < h ; i++) {
			currentPos.set(0, 0);
			
			String laneClassic = "|";
			for(int j = 0 ; j < w ; j++) {
				
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
	}
}
