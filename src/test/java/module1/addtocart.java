package module1;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basepackage.baseinit;
import utility.mylibrary;
public class addtocart extends baseinit{
	public static Logger logs;
	@BeforeTest
	public void setup() throws IOException
	{
		startup();
	}
@Test	
public void checkaddcart()
{
	logs=Logger.getLogger("devpinoyLogger");
	mylibrary.signin();
	logs.info("log in done");
	iselementpresent("btn_addtocart_cssselector").click();
	mylibrary.getscreenshot("1", driver);
	//mylibrary.signout();
	driver.close();
}
}
//select dropdown 
