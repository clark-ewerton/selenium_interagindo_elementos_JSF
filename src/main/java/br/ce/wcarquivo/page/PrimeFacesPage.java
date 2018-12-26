package br.ce.wcarquivo.page;
import org.openqa.selenium.By;

import br.ce.wcarquivo.core.BasePage;
import br.ce.wcarquivo.core.DSL;

public class PrimeFacesPage extends BasePage {

	
	/***************** métodos ********************/
	
	/***************** Radio *********************/
	public void setRadioXboxOne() {
		dsl.clicarRadio(By.xpath("//input[@id='j_idt692:console:0']/../..//span"));
	}
	
	public void setRadioPS4() {
		dsl.clicarRadio(By.xpath("//input[@id='j_idt692:console:1']/../..//span"));
	}
	
	/***************** ComboBox *********************/
	
	public void setComboboxBasic(String radical, String valor) {
		dsl.clicarRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		try {
			   new Thread().sleep(1000); //Esse valor é um milisegundos
			} catch (InterruptedException e) { e.printStackTrace(); }
		dsl.clicarRadio(By.xpath(".//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
	}
	
	
/***************** CheckboxMenu *********************/
	
	public void setCheckboxMenu(String radical, String cidade) {
		dsl.clicarRadio(By.xpath("//div[@id='" + radical + "']//span"));
		try {
			new Thread().sleep(500);
		} catch(InterruptedException e) {e.printStackTrace();}
		dsl.clicarRadio(By.xpath(".//li[@data-item-value='" + cidade + "']//span"));
	}
	
	public void setFecharCheckboxMenu() {
		dsl.clicarRadio(By.xpath("//div[@id='j_idt691:multiple_panel']//a[@aria-label='Close']"));
	}
	
	
	/********************** validacões *********************/
	public Boolean setValidarRadioXboxSelecionado() {
		return dsl.clicarOpcaoSelecionada("j_idt692:console:0");
	}
	
	public Boolean setValidarRadioPS4Selecionado() {
		return dsl.clicarOpcaoSelecionada("j_idt692:console:1");
	}
	
	public String setValidarComboboxBasic() {
		return dsl.obterTexto(By.xpath(".//*[@id='j_idt692:console_label']"));
	}
	
	public String setValidarCheckboxMenu() {
		return dsl.obterTexto(By.xpath(".//div[@id='j_idt691:multiple']//li"));
	}
}
