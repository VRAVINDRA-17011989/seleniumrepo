package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public Properties prop;
	WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		
		String browserName = "chrome";
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			 driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			 driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			 driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}

}
