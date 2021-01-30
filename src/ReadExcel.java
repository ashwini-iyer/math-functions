import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class ReadExcel  
{  
     public static void main(String[] args)   
     {  
		try  
		{  
		File file = new File("C:\\cts\\pages.xlsx");   //creating a new file instance  
		FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
		Iterator<Row> itr = sheet.iterator(); 
		itr.next();
		//iterating over excel file  
		 
		 
		Row row = itr.next(); 
		Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
		while (cellIterator.hasNext())   
		{  
		Cell cell = cellIterator.next();  
		switch (cell.getCellType())               
		{  
		case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
		System.out.print(cell.getStringCellValue() + "\t\t\t");  
		break;  
		case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
		System.out.print(cell.getNumericCellValue() + "\t\t\t");  
		break;  
		default:  
		}  
		}  
		
		
		 
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  
    }  
}  