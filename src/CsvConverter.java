import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CsvConverter extends txtFileCompare{
	CsvConverter(String file1,String file2){
		super(file1,file2);
	}

	public void csvFile(){

        try {
            String text1 = extractTextFromCSV(file1);
            String text2 = extractTextFromCSV(file2);
            
            Scanner scanner1 = new Scanner(text1);
            Scanner scanner2 = new Scanner(text2);
            
            addNextLine(scanner1,scanner2);
            
            printResult();
            
        } catch(CsvValidationException e) {
        	System.err.println("The file doesnot validate the CSV file format!");
            e.printStackTrace();
        }catch (IOException  e) {
        	System.err.println("The file doesnot exist or is replaced!");
            e.printStackTrace();
        }
	}

    private String extractTextFromCSV(String filePath) throws IOException, CsvValidationException {
        StringBuilder text = new StringBuilder();
        CSVReader reader = new CSVReader(new FileReader(filePath)); 
            String[] line;
            while ((line = reader.readNext()) != null) {
                for (int i=0;i<line.length;i++) {
                	String field = line[i];
                    text.append(field+"\n");
                }
                text.append("\n");
	        }
            reader.close();
	        return text.toString();
	}


}
