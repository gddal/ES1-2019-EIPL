/**
*
* Trabalho final de Engenharia de Software I 2019/20
* 
* Grupo 85
* 
* Projecto Analise de erros de software.
*
* @author Miguel Diaz Gonçalves 82493
* @author Gonçalo Dias do Amaral 83380
* @author Miguel Carriço 73745
* @author André Freitas 82361
* @author Pedro Jones 82946
* @version 0.01
*
*/
package pt.iul.ista.esi.exemplos;

	package pt.iul.ista.poo.farm;

	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Observable;
	import java.util.Observer;
	import java.util.PriorityQueue;
	import java.util.Queue;
	import java.util.Random;
	import java.util.Scanner;

public class Teste {

		// Minimum farm size
		private static final int MIN_X = 5;
		private static final int MIN_Y = 5;

		// Startup configuration file
		private static final String STARTUP_CFG = "config/startup.cfg";

		// Save game file
		private static final String SAVE_FNAME = "config/savedgame.sav";

		// Default key to make the farmer interact with objects
		private static final int INTERACT_KEY = KeyEvent.VK_SPACE;
		// Default key to save the game to file
		private static final int SAVE_KEY = KeyEvent.VK_S;
		// Default key to restore the game from the save file
		private static final int RESTORE_KEY = KeyEvent.VK_L;
		// Default key to restart the game
		private static final int RESTART_KEY = KeyEvent.VK_R;

		// Layer for the land objects
		public static final int LAND_LAYER = 0;

		// Probability for the land to be rocky
		public static final int PERCENTAGE_ROCKY = 10;

		// Default farmer startup position
		public static final Point2D FARMER_POSITION = new Point2D(0, 0);

		// Default number of objects
		private static final int SHEEP_NUMBER = 2;
		private static final int CHICKEN_NUMBER = 2;

		// Farm object instance
		private static Farm INSTANCE;

		// Farm size
		private int max_x;
		private int max_y;

		// Game score
		private int score;

		// List of all interactable farm objects
		private final List<Interactable> farmList = new ArrayList<>();

		// Auxiliary list of objects to remove at the end of the cycle
		private final List<Interactable> objectsToRemove = new ArrayList<>();

		// Auxiliary list of objects to add at the end of the cycle
		private final List<Interactable> objectsToAdd = new ArrayList<>();

		private void farmConfig() {

			Scanner fs = null;

			try {
				fs = new Scanner(new File(STARTUP_CFG));
				String line = fs.nextLine();
				String info[] = line.split(" ");
				max_x = Integer.parseInt(info[0]);
				max_y = Integer.parseInt(info[1]);
				if (max_x < MIN_X || max_y < MIN_Y)
					throw new IllegalArgumentException();

			} catch (IllegalArgumentException e) {
				System.err.println("The farm area is too small. Using size: " + MIN_X + "x" + MIN_Y);
				max_x = MIN_X;
				max_y = MIN_Y;
			} catch (FileNotFoundException e) {
				System.err.println("Error. File " + STARTUP_CFG + " not found. Using size: " + MIN_X + "x" + MIN_Y);
				max_x = MIN_X;
				max_y = MIN_Y;
			} finally {
				assert fs != null;
				fs.close();
			}

		}

		private void saveGame() {

			PrintWriter printwriter = null;

			try {
				printwriter = new PrintWriter(new File(SAVE_FNAME));
				printwriter.println(this.max_x + " " + this.max_y);
				printwriter.println(this.score);
				printwriter.println("Farmer;" + Farmer.getInstance().getPosition().toString());
				for (Interactable object : farmList) {
					printwriter.println(object.getClass().getSimpleName() + ";" + ((FarmObject) object).getPosition().toString() + ";"
							+ object.state());
				}
				printwriter.flush();
			} catch (FileNotFoundException e) {
				System.out.println("Error. File " + SAVE_FNAME + " not found.");
			} finally {
				assert printwriter != null;
				printwriter.close();
			}

		}

		private void loadGame() {

			Scanner scanner = null;
			Interactable object;

			try {
				scanner = new Scanner(new File(SAVE_FNAME));

				// Farm size
				String line = scanner.nextLine();
				String info[] = line.split(" ");
				if (Integer.parseInt(info[0]) != max_x || Integer.parseInt(info[1]) != max_y) {
					throw new IllegalArgumentException("size");
				}

				// Clear current Farm
				clearFarm();

				// Game score
				line = scanner.nextLine();
				this.score = Integer.parseInt(line);

				// Farmer object
				line = scanner.nextLine();
				info = line.split(";");
				if (!isValidPosition(toPosition(info[1]))) {
					throw new IllegalArgumentException("farmer");
				}
				Farmer.getInstance().setPosition(toPosition(info[1]));

				while (scanner.hasNextLine()) {

					line = scanner.nextLine();
					info = line.split(";");
					object = ObjectFactory.createObject(info[0].toLowerCase(), toPosition(info[1]));
					object.restore(line);
					addObject(object);
					// farmList.add(object);
				}

			} catch (FileNotFoundException e1) {
				System.out.println("Error. File " + SAVE_FNAME + " not found.");
			} catch (IllegalArgumentException e2) {
				switch (e2.getMessage()) {
				case "size":
					System.out.println("Error loading saved game. Size don't match");
					break;
				case "farmer":
					System.out.println("Error loading saved game. Farmer position is invalid");
					break;
				default:
					System.out.println(
							"Error in configuration file" + SAVE_FNAME + ". Invalid object type " + e2.getMessage());
					break;
				}
			} finally {
				assert scanner != null;
				scanner.close();
			}

		}

}
