package COM.SCISS.REK;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ExecuteCommands extends Base {

	public static void executeCommands() throws IOException {
		while ((result = recognize.getResult()) != null) {
			String command = result.getHypothesis();
			work = null;
			Process p;

			if (command.equalsIgnoreCase("rek open google")) {

				driver.get("www.google.com");
				System.out.println(command);
			} else if (command.equalsIgnoreCase("rek open youtube")) {

				driver.get("www.youtube.com");

			} else if (command.equalsIgnoreCase("rek open gmail")) {
				System.out.println(command);
				driver.get("www.gmail.com");
			} else if (command.equalsIgnoreCase("rek new tab")) {
				System.out.println(command);

				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
			} else if (command.equalsIgnoreCase("rek close tab")) {
				System.out.println(command);

				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
			} else if (command.equalsIgnoreCase("rek switch back tab")) {
				System.out.println(command);
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");

			} else if (command.equalsIgnoreCase("rek open file manager")) {
				work = "explorer";
			} else if (command.equalsIgnoreCase("rek close file manager")) {
				// work ="Taskkill /IM explorer.exe";
				System.out.println("please dont try it");
			} else if (command.equalsIgnoreCase("rek open browser")) {
				work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
			} else if (command.equalsIgnoreCase("rek close browser")) {
				work = "Taskkill /IM chrome.exe /F";
			}
			if (work != null) {
				p = Runtime.getRuntime().exec(work);
			}

		}
	}

}
