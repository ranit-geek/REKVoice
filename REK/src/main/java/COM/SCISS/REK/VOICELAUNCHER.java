package COM.SCISS.REK;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

//import selenium 
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;




public class VOICELAUNCHER {
	

	
	    public static void main(String[] args) throws IOException {
	    
	    	 
	    	
//selenium migration starts......................................................................
	    	
	    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
	    	WebDriver driver=new ChromeDriver();
	    	
		   
//selenium mig ends---------------------------------------------------------------------------------
	    	
		        
		        
		        
//sphinx config starts...............................................................................
	    	
	     Configuration configuration = new Configuration();
	        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
	        configuration.setDictionaryPath("\\Users\\ranit.dey\\eclipse-workspace-rek1\\MyREK\\0305.dic");
	        configuration.setLanguageModelPath("\\Users\\ranit.dey\\eclipse-workspace-rek1\\MyREK\\0305.lm");
	        LiveSpeechRecognizer recognize = new LiveSpeechRecognizer(configuration);
	        recognize.startRecognition(true);  
	        SpeechResult result;
	       
//sphinx config ends--------------------------------------------------------------------------------------
	       

	        while ((result = recognize.getResult()) != null)
	        {	
	            String command = result.getHypothesis();
	            String work = null;
	            Process p;
	            
	             if(command.equalsIgnoreCase("rek open google")) {
	            	
	 	   			 
	            	 driver.get("www.google.com");
	            	 System.out.println(command);
	            } 
	           else  if(command.equalsIgnoreCase("rek open youtube")) {
	        	 
	   			
	        	   driver.get("www.youtube.com");

//....................................................................................
	        	   
	            } else  if(command.equalsIgnoreCase("rek open gmail")) {
	            	 System.out.println(command);
	            	 driver.get("www.gmail.com");
	            } else  if(command.equalsIgnoreCase("rek new tab")) {
	            	 System.out.println(command);
	            	
	 	   		
	            	 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	            } else  if(command.equalsIgnoreCase("rek close tab")) {
	            	 System.out.println(command);
	            	
	            	 driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"w");
	            } else  if(command.equalsIgnoreCase("rek switch back tab")) {
	            	 System.out.println(command);
	            	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t"); 
	           
	            } else if(command.equalsIgnoreCase("rek open file manager")) {
	                work = "explorer";
	            } else if (command.equalsIgnoreCase("rek close file manager")) {
	            	//work ="Taskkill /IM explorer.exe";
	            	System.out.println("please dont try it");
	            } else if (command.equalsIgnoreCase("rek open browser")) {
	                work = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	            } else if (command.equalsIgnoreCase("rek close browser")) {
	                work = "Taskkill /IM chrome.exe /F";
	            }
	            if(work != null) {
	               p = Runtime.getRuntime().exec(work);
	            }
	       
	        }
	        
	       
	    	
	    	
	    
	    }
	 
	
	
	
}
