
import java.util.*;

public class Game {

	public static void main(String[] args) {
		Game test = new Game(true);
		test.runGame();
		System.out.println(test.guessesTaken);
		System.out.println(test.testMode);
	}

	boolean testMode;
	int guessesTaken = 0;
	GameConfiguration config;

	public Game() {
		this.testMode = false;

	}

	public Game(boolean test) {
		this.testMode = test;
	}

	public void runGame() {
		GameBoard board = new GameBoard();
		Codes code = new Codes();
		PegSet pegs = new PegSet();
		printIntro();
		Scanner input = new Scanner(System.in);
		String start = input.next();
		start = checkStart(start);
		if (start.equals("N")) {
			return;
		}
		System.out.println("\n");
		System.out.println("Generating secret code ....\n");
		Vector<Character> generatedCode = code.generateSecretCode();
		code.secretCode = generatedCode;
		while ((config.guessNumber - guessesTaken) > 0) {
			System.out.print("You have " + (config.guessNumber - guessesTaken) + " guesses left.\n"
					+ "What is your next guess?\n" + "Type in the characters for your guess and press enter.\n"
					+ "Enter guess: ");
			String guessInput = input.next();
			Vector<Character> guess = new Vector<Character>();
			for (int i = 0; i < guessInput.length(); i++) {
				char putInGuess = guessInput.charAt(i);
				guess.add(putInGuess);
			}
			boolean validGuess = code.checkValidGuess(guess);
			if (!validGuess) {
				System.out.print("\n");
				for (int i = 0; i < guess.size(); i++){
					System.out.print(guess.get(i));
				}
				System.out.println("  ->  INVALID GUESS\n");
			}
		}

	}

	public String checkStart(String yesOrNo) {
		boolean invalidInput = true;
		while (invalidInput) {
			if (!(yesOrNo.equals("Y")) && !(yesOrNo.equals("N"))) {
				System.out.println("Error: Invalid Input");
				System.out.print("Are you ready to play? (Y/N): ");
				Scanner startInput = new Scanner(System.in);
				yesOrNo = startInput.next();
			} else {
				invalidInput = false;
			}
		}
		return yesOrNo;
	}

	public void printIntro() {
		System.out.print("Welcome to Mastermind. Here are the rules.\n\n"
				+ "This is a text version of the classic board game Mastermind.\n"
				+ "The computer will think of a secret code. The code consists of 4\n" + "colored pegs.\n"
				+ "The pegs MUST be one of six colors: blue, green, orange, purple,\n"
				+ "red, or yellow. A color may appear more than once in the code. You\n"
				+ "try to guess what colored pegs are in the code and what order they\n"
				+ "are in. After you make a valid guess the result (feedback) will be\n" + "displayed.\n"
				+ "The result consists of a black peg for each peg you have guessed\n"
				+ "exactly correct (color and position) in your guess. For each peg in\n"
				+ "the guess that is the correct color, but is out of position, you get\n"
				+ "a white peg. For each peg that is fully incorrect, you get no\n" + "feedback.\n"
				+ "Only the first letter of the color is displayed. B for Blue, R for\n" + "Red, and so forth.\n"
				+ "When entering guesses you only need to enter the first character of\n"
				+ "each color as a capital letter.\n\n"
				+ "You have 12 guesses to figure out the secret code or you lose the\n"
				+ "game. Are you ready to play? (Y/N): ");
	}
}
