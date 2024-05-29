import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XlsConverter extends txtFileCompare{
	public XlsConverter(String file1,String file2) {
		super(file1,file2);
	}
	
	public void readExcel(String sheet1Name,String sheet2Name){
		
		try (FileInputStream readFile1=new FileInputStream(file1);
		FileInputStream readFile2=new FileInputStream(file2)){

			Workbook wb1= WorkbookFactory.create(readFile1);
			Workbook wb2= WorkbookFactory.create(readFile2);
		
			Sheet s1=wb1.getSheet(sheet1Name);
			Sheet s2=wb2.getSheet(sheet2Name);
			
			int numRows=Math.min(s1.getPhysicalNumberOfRows(), s2.getPhysicalNumberOfRows());
			for(int r=0;r<numRows;r++) {
				Row r1=s1.getRow(r);
				Row r2=s2.getRow(r);
				int numCols=Math.min(r1.getPhysicalNumberOfCells(), r2.getPhysicalNumberOfCells());

				for(int c=0;c<numCols;c++) {
					Cell c1=r1.getCell(c);
					Cell c2=r2.getCell(c);

					String data1=checkType(c1);
					String data2=checkType(c2);
					
					Scanner scanner1 = new Scanner(data1);
		            Scanner scanner2 = new Scanner(data2);            	
		     
		            addNextLine(scanner1,scanner2);
		            }

			}
			if (s1.getLastRowNum()!=s2.getLastRowNum()) {
				System.out.println("These files are different!!");
				System.exit(0);
			}
		    printResult();   
			
		}catch(IOException e){
            System.err.println("One of the files doesn't exist or is replaced!");
			e.printStackTrace();
		}		
	}
	
	private String checkType(Cell c) {
		String data="";
		if(c==null) {
			data="";
		}else if (c.getCellType() == CellType.NUMERIC) {
            data = String.valueOf((int)c.getNumericCellValue());
        } else if (c.getCellType() == CellType.STRING) {
            data = c.getStringCellValue();
        } else {
            data = "Unsupported Cell Type";
        }
		return data;
	}

		
}

