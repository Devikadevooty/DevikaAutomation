package utility;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utility {
	public static String getCellValue(String x1,String Sheet,int r,int c)
	{
		try
		{
			File F=new File(x1);
			FileInputStream Fi=new FileInputStream(F);
			XSSFWorkbook wb=new XSSFWorkbook(Fi);
			XSSFCell data= (XSSFCell)wb .getSheet(Sheet).getRow(r).getCell(c);
				if(data.getCellType()== CellType.STRING)	
				{
					return data.getStringCellValue();
				} 
				else {
					return data.getRawValue();
				}
		}
		catch(Exception e) {
			return "";
			
		}
	}
	public static int getRowCount(String x1,String Sheet) {
		try {
			File F =new File(x1);
			FileInputStream Fi=new FileInputStream(F);
			XSSFWorkbook wb= new XSSFWorkbook(Fi);
			return wb.getSheet(Sheet).getLastRowNum();
		}
		catch(Exception e) {
			return 0;
		}
		
	}




}



