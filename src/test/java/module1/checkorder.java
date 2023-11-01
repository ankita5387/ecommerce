package module1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basepackage.baseinit;
import utility.mylibrary;

public class checkorder extends baseinit {
	public static Logger logs;
	@BeforeTest
	public void setup() throws IOException
	{
		startup();
	}
@Test	
public void checkdropdown() throws InterruptedException
{
	logs=Logger.getLogger("devpinoyLogger");
	mylibrary.signin();																
	logs.info("log in done");
	Thread.sleep(5000);
	Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='root']/div/div[3]/div/div/select")));
    dropdown.selectByValue("2");
    List<WebElement> bookElements = driver.findElements(By.xpath("//div[@class='Products_title__7ggYL']"));
    List<String> bookNames = new ArrayList<>();
    for (WebElement book : bookElements) {
        bookNames.add(book.getText().trim());
       // System.out.println(bookNames);
    }
    boolean isSorted = true;
    for (int i = 1; i < bookNames.size(); i++) {
        if (bookNames.get(i - 1).compareToIgnoreCase(bookNames.get(i)) < 0) {
        	System.out.println("1="+bookNames.get(i - 1));
        	System.out.println("2="+bookNames.get(i));
        	System.out.println("3="+bookNames.get(i - 1).compareToIgnoreCase(bookNames.get(i)));
            isSorted = false;
            break;
        }
    }
    if (isSorted) {
        System.out.println("The book names are sorted in descending order.");
    } else {
        System.out.println("The book names are not sorted in descending order.");
    }

	System.out.println("selected");
	mylibrary.getscreenshot("1", driver);
	//mylibrary.signout();
	driver.close();
}

}
