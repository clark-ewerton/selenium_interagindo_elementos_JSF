package br.ce.wcarquivo.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	
	private DriverFactory() {};
	
	public static WebDriver getDriver() {		
		//driver para Chrome
		System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\clark.silva\\Documents\\selenium\\geckodriver-v0.23.0-win64\\chromedriver.exe");
		
		//driver para Chrome
		/*System.setProperty("webdriver.chrome.driver",
        "C:\\Users\\CLARK\\Documents\\selenium\\chromedriver.exe");*/

		if(driver == null) {
			switch(Propriedades.browser) {
			case CHROME: driver = new ChromeDriver(); break;
			}
			
			driver.manage().window().setSize(new Dimension(1200, 765));
		}

		return driver;
		}
	
	public static void KillDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
