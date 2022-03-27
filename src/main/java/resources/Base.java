package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public  WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException{
	prop=new Properties();
	FileInputStream fis=new FileInputStream("D:\\Workspace1\\FinalFramework\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	if(browserName.contains("chrome")){
		ChromeOptions options=new ChromeOptions();
		if(browserName.contains("headless"))
			options.addArguments("headless");
		//System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
	}
	else if(browserName.contains("firefox")){
		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else if(browserName.contains("edge")){
//		System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Drivers\\msedgedriver.exe"); 
		driver = new EdgeDriver();
		
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
		
	
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException{
	       
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        //String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+"_"+getDate()+".png";
        String destinationFile = System.getProperty("user.dir")+"\\screenShots\\"+testCaseName+"_"+getDate()+".png";
        try {
            FileHandler.copy(source, new File(destinationFile));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Location not found>>>"+e.getMessage());
        }
        return destinationFile;
   
    }
	
	public static String getDate()
    {
        DateFormat dformat = new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
        Date date= new Date();
        return dformat.format(date);   
    }
	

}
