package COM.SCISS.REK;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumConfig extends Base{
	
	
public static void getseleniumMigration()
{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
	driver=new ChromeDriver();
	
}
	
}
