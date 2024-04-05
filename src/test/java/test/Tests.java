package test;
import org.testng.annotations.Test;

import base.Base;
import page.Project;
import utility.Utility;

public class Tests extends Base {
	
	@Test
	
	public void tests() throws Exception
	{
		Project ob = new Project(driver);
		String x1 ="D:\\devuproject.xlsx"; 
		String Sheet="Sheet1";
		int rowCount = Utility.getRowCount(x1, Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			String FullName=Utility.getCellValue(x1, Sheet, i,0);
			System.out.println("FullName---"+FullName);
			String Email=Utility.getCellValue(x1, Sheet, i, 1);
			System.out.println("Email---"+Email);
			String Password=Utility.getCellValue(x1, Sheet, i,2);
			System.out.println("Password---"+Password);
			ob.register(FullName,Email,Password);
			ob.perform1();
			ob.Titleverification();
			ob.Textverification();
			ob.Linkvalidation();
			ob.Logoverification();
			ob.Contentverification();
		    ob.Responsecode();
		    ob.Pageverification();
		    ob.Singlescreenshot();
		    ob.Screenshot();
		    ob.Scrolldown();
		    ob.Windowandtab();
		}
	}



}
