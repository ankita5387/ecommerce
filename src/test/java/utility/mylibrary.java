package utility;



import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import basepackage.baseinit;

public class mylibrary extends baseinit {
	public static void signin()
	{
		iselementpresent("btn_login_xpath").click();
		
		
		
		

	}
	public static void signout()
	{
		iselementpresent("btn_logout_xpath").click();
	}
	public static String getscreenshot(String imagename,WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scrFile=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\"+imagename+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileHandler.copy(scrFile, destination);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		System.out.println(e.getMessage());
				
		}
		return path;
	}
}


