
import java.util.*;

public class PegSet {
	int whitePegs;
	int blackPegs;
	
	public int generateBlackPegs(Vector<Character> guess, Vector<Character> code){
		int black = 0;
		for(int i = 0; i < guess.size(); i++){
			char guessSlot = guess.get(i);
			char codeSlot = code.get(i);
			if (guessSlot == codeSlot){
				black++;
				guess.set(i, '_');
				code.set(i, '_');
			}
		}
		return black;
	}
	public int generateWhitePegs(Vector<Character> guess, Vector<Character> code){
		int white = 0;
		for(int i = 0; i < guess.size(); i++){
			char guessSlot = guess.get(i);
			if (code.contains(guessSlot) && guessSlot != '_'){
				white++;
				int toRemove = code.indexOf(guessSlot);
				guess.set(i, '_');
				code.set(toRemove, '_');
			}
		}
		return white;
	}
}
