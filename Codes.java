
import java.util.*;

public class Codes {

	Vector<Character> secretCode;
	GameConfiguration codeConfig;

	public Vector<Character> generateSecretCode() {
		Vector<Character> secretCode = new Vector<Character>();
		Random r = new Random();
		String[] colorList = codeConfig.colors;
		int mod = colorList.length;

		for (int i = 0; i < codeConfig.pegNumber; i++) {
			int index = r.nextInt(1000000);
			index = index % mod;
			String chosenColorString = colorList[index];
			char chosenColor = chosenColorString.charAt(0);
			secretCode.add(chosenColor);
		}
		return secretCode;
	}

	public boolean checkValidGuess(Vector<Character> toCheck, String historyCheck) {
		if(historyCheck.equals("history")){
			return true;
		}
		String[] colorString = codeConfig.colors;
		int colorNumber = colorString.length;
		Vector<Character> colorList = new Vector<Character>();
		
		for (int i = 0; i < colorNumber; i++){
			String color = colorString[i];
			colorList.add(color.charAt(0));
			}
		if (toCheck.size() != codeConfig.pegNumber){
			return false;
		}
		for (int i = 0; i < toCheck.size(); i++){
			char checking = toCheck.get(i);
			boolean validEntry = colorList.contains(checking);
			if(!(validEntry)) return false;
		}
		return true;
	}
}
