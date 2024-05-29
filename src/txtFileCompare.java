import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class txtFileCompare extends CompareTexts{
    protected String file1;
    protected String file2;

    StringBuilder file1Content = new StringBuilder();
    StringBuilder file2Content = new StringBuilder();


    public txtFileCompare(String file1, String file2) {
        this.file1 = file1;
        this.file2 = file2;
    }

    public void compareFile(){


        try (Scanner fileScanner1 = new Scanner(new File(file1));
             Scanner fileScanner2 = new Scanner(new File(file2))) {
        	
        	addNextLine(fileScanner1,fileScanner2);

            printResult();


        } catch (IOException e) {
            System.err.println("One of the files doesn't exist or is replaced!");
            e.printStackTrace();
        } 
    }
    protected void addNextLine(Scanner fileScanner1,Scanner fileScanner2) {
		while (fileScanner1.hasNextLine()) {
	        file1Content.append(fileScanner1.nextLine()).append("\n");
	    }
	    while (fileScanner2.hasNextLine()) {
	        file2Content.append(fileScanner2.nextLine()).append("\n");
	    }
	
	}
   @Override
   public void printResult() {
       StringBuilder[] textDiff=compareText(file1Content.toString(), file2Content.toString());
       StringBuilder text1Diff= textDiff[0];
       StringBuilder text2Diff= textDiff[1];
       
       System.out.println("\nDifference in file1 is: \n" + text1Diff);
       System.out.println("Difference in file2 is: \n" + text2Diff);
   }
	
}
