//sonar lint in eclipse

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Welcome to Text Comparing System:");
		System.out.println("What would you like to compare?\n1. Input text\n2. "
				+ ".txt file\n3. .pdf file\n4. .xls file\n5. .csv file");
		Scanner input=new Scanner(System.in);
		
		int n=input.nextInt();
		
		switch(n){
		case 1: 
			String[] texts=textInput();
			String text1=texts[0];
			String text2=texts[1];
			
			inputTextCompare t=new inputTextCompare(text1,text2);
			t.printResult();
			break;
			
		case 2: 
			String[] files=fileInput();
			String file1=files[0];
			String file2=files[1];
			
			txtFileCompare f=new txtFileCompare(file1,file2);
			f.compareFile();
			break;

		case 3:
			String[] pdfs=fileInput();
			String pdf1=pdfs[0];
			String pdf2=pdfs[1];
			
			PDFconverter pdf=new PDFconverter(pdf1, pdf2);
			pdf.converter();
			break;
		
		case 4:
			String[] excels=fileInput();
			String excel1=excels[0];
			String excel2=excels[1];
			
			String[] sheets=sheetName();
			String sheet1=sheets[0];
			String sheet2=sheets[1];			
			
			XlsConverter excel=new XlsConverter(excel1,excel2);
			excel.readExcel(sheet1,sheet2);
			break;
			
		case 5: 
			String[] csvs=fileInput();
			String csv1=csvs[0];
			String csv2=csvs[1];
			
			CsvConverter csv=new CsvConverter(csv1,csv2);
			csv.csvFile();
			break;
		}
		input.close();
		
	}
	private static String[] textInput() {
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the first text:");
		String text1=s.nextLine();
		
		System.out.println("Enter the second text:");
		String text2=s.nextLine();
		return new String[] {text1,text2};
	}
	
	private static String[] fileInput() {
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the first file path");
		String file1=s.nextLine();
		file1=pathFormat(file1);

		
		System.out.println("Enter the second file path");
		String file2=s.nextLine();
		file2=pathFormat(file2);
		
		return new String[] {file1,file2};
	}
	private static String[] sheetName() {
		Scanner s=new Scanner(System.in);

		System.out.println("Enter the sheet name for first file:");
		String s1=s.nextLine();
		System.out.println("Enter the sheet name for second file:");
		String s2=s.nextLine();
		return new String[] {s1,s2};
	}
	
	private static String pathFormat(String file) {
		file=file.replace("\\", "/");
		if (file.startsWith("\"") && file.endsWith("\"")) {
			file= file.substring(1,file.length()-1);
		}
		return file;
	}

}
