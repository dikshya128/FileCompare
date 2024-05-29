import java.util.Scanner;

public abstract class CompareTexts{
	
	protected final String redText = "\u001B[31m";
    protected final String whiteBg = "\u001B[47m";
    protected final String reset = "\u001B[0m";
    

	public StringBuilder[] compareText(String text1, String text2) {
		StringBuilder text1Diff= new StringBuilder();
		StringBuilder text2Diff= new StringBuilder();
		
		 try (Scanner scanner1 = new Scanner(text1);
	             Scanner scanner2 = new Scanner(text2)) {

	            while (scanner1.hasNextLine() && scanner2.hasNextLine()) {
	                String line1 = scanner1.nextLine();
	                String line2 = scanner2.nextLine();

	                int minLength = Math.min(line1.length(), line2.length());
	                for (int i = 0; i < minLength; i++) {
	                    if (line1.charAt(i) != line2.charAt(i)) {
	                        text1Diff.append(redText).append(whiteBg).append(line1.charAt(i)).append(reset);
	                        text2Diff.append(redText).append(whiteBg).append(line2.charAt(i)).append(reset);
	                    } else {
	                        text1Diff.append(line1.charAt(i));
	                        text2Diff.append(line2.charAt(i));
	                    }
	                }

	                if (line1.length() > minLength) {
	                    text1Diff.append(redText).append(whiteBg).append(line1.substring(minLength)).append(reset);
	                }
	                if (line2.length() > minLength) {
	                    text2Diff.append(redText).append(whiteBg).append(line2.substring(minLength)).append(reset);
	                }

	                text1Diff.append('\n'); 
	                text2Diff.append('\n');
	            }

	        }

	        return new StringBuilder[]{text1Diff, text2Diff};
	    
}
	public abstract void printResult();
}
