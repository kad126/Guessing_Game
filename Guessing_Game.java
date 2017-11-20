import java.util.Scanner;
import java.util.Random;

public class Guessing_Game {
	public static void main(String args[]) {
		
	int user_selection;
		int random_number = -1;
		
		user_selection = menu();//save user selection
		
		switch(user_selection) {
		case 1: //easy (between 1-50)
			random_number = generated_number(50);
			break;
		case 2: //medium (between 1-100)
			random_number = generated_number(100);
			break;
		case 3: //easy (between 1-1000)
			random_number = generated_number(1000);
			break;
		default:
			System.out.println("Something went wrong :/");
			break;
		}
		game(random_number);
	}
		// if they select easy , then return 1 for easy
		// if they select medium, then return 2 for medium
		// if they select hard, then return 3 for hard
	public static int menu() {
		boolean valid = false;
		Scanner data = new Scanner(System.in);
		int user_selection;

		while (!valid) {
			System.out.println("Menu");
			System.out.println("Please select\n1:Easy\n2:Medium\n3:Hard");
			user_selection = data.nextInt();

			switch (user_selection) {
			case 1:
				valid = true;
				return 1;
			case 2:
				valid = true;
				return 2;
			case 3:
				valid = true;
				return 3;
			default:
				System.out.println("Sorry, please try again.");
				break;
			}
		}
		return -1;
	}

	public static int generated_number(int number) {
		return new Random().nextInt(number) + 1;
	}

	// if their guess is too low, then return 1 to go higher
	// if their guess is too high, then return -1 to go lower
	// if their guess is correct, then return 0
	public static int number_checker(int random_number, int number) {
		if (number < random_number)
			return 1;
		else if (number > random_number)
			return -1;
		else
			return 0;
	}
	
	public static void game(int random_number) {
		int score = 0;
		int their_guess;
		boolean still_guessing = true;
		Scanner data = new Scanner(System.in);
		
		while (still_guessing) {
			System.out.println("Please make a guess");
			their_guess = data.nextInt();
			
			switch(number_checker(random_number, their_guess)) {
			case 1:
				System.out.println("Go higher");
				score ++;
				break;
			case -1:
				System.out.println("Go lower");
				score ++;
				break;
			case 0:
				System.out.println("Congratulations, you have won!");
				score ++;
				still_guessing = false;
				break;
			}
		}
		System.out.println("Your score is " + score);
	}
}
