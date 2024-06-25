import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.Loader; 

public class PDFconverter extends txtFileCompare{
	
	public PDFconverter(String file1,String file2){

		super(file1,file2);
	}
	public void converter(){
        File pdf1 = new File(file1);
        File pdf2 = new File(file2);        
        
        try (PDDocument loaderpdf1 = Loader.loadPDF(pdf1); // load PDF document
        		PDDocument loaderpdf2 = Loader.loadPDF(pdf2)) {
        	
            PDFTextStripper textStripper = new PDFTextStripper(); //to extract text from pdf
            String text1 = textStripper.getText(loaderpdf1);
            String text2 = textStripper.getText(loaderpdf2);
            Scanner scanner1 = new Scanner(text1);
            Scanner scanner2 = new Scanner(text2);            	
            
            addNextLine(scanner1,scanner2);
                
            printResult();   
            
        }catch (IOException e) {
            System.err.println("One of the files doesn't exist or is replaced!");
            e.printStackTrace();
        }
    }

}
