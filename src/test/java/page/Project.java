package page;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Project

{
	
WebDriver driver;
By fullname=By.xpath("/html/body/div[1]/main/div/div/div/div/div/div/div/form/div[1]/div/input");
By email=By.xpath("/html/body/div[1]/main/div/div/div/div/div/div/div/form/div[2]/div/input");
By password=By.xpath("/html/body/div[1]/main/div/div/div/div/div/div/div/form/div[3]/div/input");
By signup=By.xpath("//*[@id=\"root\"]/main/div/div/div/div/div/div/div/form/button");
	
public Project(WebDriver driver) 

{
	this.driver=driver;
}

public void register(String FullName,String Email,String Password) 

{
	
driver.findElement(fullname).sendKeys(FullName);
driver.findElement(email).sendKeys(Email);
driver.findElement(password).sendKeys(Password);
driver.findElement(signup).click();

}

public void perform1()throws Exception

{ 
	
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"root\"]/header/div[3]/div/a[3]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div/div[2]/div/div/a/div")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"root\"]/main/div/div[1]/div[2]/div[2]/div/div[5]/div[2]/div/div/button")).click();
driver.navigate().back();
driver.navigate().back();

}

public void Titleverification ()

{
	String actualtitle =driver.getTitle();
	System.out.println(actualtitle);
    String expectedtitle="Best Second Hand Books to read! Used Books Online Bookstore";
    if(actualtitle.equalsIgnoreCase(expectedtitle))
    {
    	System.out.println("Title  matched");
    }
    else
    {
    	System.out.println("Title not matched ");
    }

}

public void Textverification()

{
	By text=By.xpath("//*[@id=\"root\"]/div/footer/div/div[1]/h6[2]");
	WebElement word =driver.findElement(text);
	String letter=word.getText();
	if(letter.equalsIgnoreCase("languages")) 
	{
		System.out.println("Text verified");
	}
	else
	{
		System.out.println("Text not verified");
	}
}

public void Linkvalidation()throws Exception

{
	String baseurl="https://www.99bookscart.com/";
	URL ob=new URL(baseurl);
	HttpURLConnection con=(HttpURLConnection )ob.openConnection();
	con.connect();
	if(con.getResponseCode()==200) 
	{
		System.out.println("Link is valid");
	}
	else
	{
		System.out.println("Link is invalid");
	}
	
}


public void Logoverification()

{
	By logo=By.xpath("//*[@id=\"root\"]/header/div[2]/nav/div/div[1]/a/img");
	WebElement design=driver.findElement(logo);
	boolean display=design.isDisplayed();
	if(display)
	{
		System.out.println("Logo is present");
	}
	else
	{
		System.out.println("Logo is not present");
	}
}

public void Contentverification()

{
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://www.99bookscart.com");
	String src=driver.getPageSource();
	if(src.contains("explore"))
	{
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}

}

public void Responsecode()

{
	try
	{
		
	URL du=new URL("https://www.99bookscart.com");
	HttpURLConnection conn=(HttpURLConnection)du.openConnection();
	conn.connect();
	if(conn.getResponseCode()==200)
	{
		System.out.println("Valid Link");
	}
	else if(conn.getResponseCode()==404)
	{
		System.out.println("Broken link");
	}
}
	
catch(Exception d)	
{
	System.out.println(d.getMessage());
}
	
}

public void Pageverification() 

{
	String page=driver.getPageSource();
	if(page.contains("Genres"))
	{
		System.out.println("Content found");
	}
	else
	{
		System.out.println("Content is not found");
	}
}

public void Singlescreenshot()throws Exception

{
	By fileelement=By.xpath("//*[@id=\"root\"]/header/div[3]/div/a[3]");
	WebElement image=driver.findElement(fileelement);
	File src=image.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("./Image//singlescreenshot.png"));
}

public void Screenshot()throws Exception

{
	
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(src, new File("D:\\picture1.png"));
}

public void Scrolldown()throws Exception

{
	Thread.sleep(600);
	JavascriptExecutor ws=(JavascriptExecutor)driver;
	ws.executeScript("window.scrollBy(0,3200)");
}

public void Windowandtab()

{
	driver.switchTo().newWindow(WindowType.TAB);
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("https://www.99bookscart.com");
	
}

}

