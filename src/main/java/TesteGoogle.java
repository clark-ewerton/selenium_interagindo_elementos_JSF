import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class TesteGoogle {

	@Test
	public void teste() {
		//driver para Firefox
		System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\clark.silva\\Documents\\selenium\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		//driver para Chrome
		System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\clark.silva\\Documents\\selenium\\geckodriver-v0.23.0-win64\\chromedriver.exe");
		//driver para InternetExplorer
				System.setProperty("webdriver.ie.driver",
		                "C:\\Users\\clark.silva\\Documents\\selenium\\geckodriver-v0.23.0-win64\\IEDriverServer.exe");
		
		//instancia o Firefox
		//WebDriver driver = new FirefoxDriver();
		
		//instancia o Chrome
		WebDriver driver = new ChromeDriver();
		
		//instancia o Internet Explorer
		//WebDriver driver = new InternetExplorerDriver();
		
		//ajuste tamanho e posição janela do browser
		//setPosition(new Point)
		//driver.manage().window().setSize(new Dimension(700, 765));
		//Executar o browser maximizado
		//driver.manage().window().maximize();
		//Acessa o endereço abaixo
		driver.get("https://www.google.com.br");
		//imprime o título da página web
		System.out.println(driver.getTitle());
		//Valida o elemento da página
		Assert.assertEquals("Google", driver.getTitle());
		//fecha todas as abas do browser e encerra a instancia
		driver.quit();
		
		
	}
}
