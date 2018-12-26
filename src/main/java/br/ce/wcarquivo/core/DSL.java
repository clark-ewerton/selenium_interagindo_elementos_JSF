package br.ce.wcarquivo.core;
import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	

	/************* TExtField **************/
	public void escreveNoCampo(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).clear();
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorcampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	public boolean procuraInicioTexto(String id, String valor) {
		return getDriver().findElement(By.id(id)).getText().startsWith(valor);
	}
	
	/************* Botao ***************/
	public void clicarBotao(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();
	}
	
	/************* Radio ***************/
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	//sobrecarga
	public void clicarRadio(String id_campo) {
		clicarRadio(By.id(id_campo));
	}
	
	
	/************* Checkbox ***************/
	public void clicarCheckbox(String id_campo) {
		getDriver().findElement(By.id(id_campo)).click();
	}
	
	public boolean clicarOpcaoSelecionada(String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
	
	/************* Combobox ***************/
	public Select clicarValorCombobox(By by) {
		 Select combo = new Select(getDriver().findElement(by));
		 return combo;
	}
	
	public void clicarValorCombobox(String id, String valor_escolhido) {
		 Select combo = clicarValorCombobox(By.id(id));
		    List<WebElement> options = combo.getOptions();
		    combo.selectByVisibleText(valor_escolhido);
	}
	
	public String retornarValorComboBox(String id) {
		Select combo = new Select(getDriver().findElement(By.id(id)));
	    List<WebElement> options = combo.getOptions();
	    return combo.getFirstSelectedOption().getText();
	    
	}
	
	public int retornarTamanhoCombobox(String id) {
		Select combo = new Select(getDriver().findElement(By.id(id)));
	    List<WebElement> options = combo.getOptions();
	    return options.size();
	    
	}
	
	/************* Combo Multipla ***************/
	public void clicarValorcomboMultipla(String id, String valor_escolhido) {
		 Select combo = new Select(getDriver().findElement(By.id(id)));
		    combo.selectByVisibleText(valor_escolhido);
	}
	
	public int retornarTamanhocomboMultipla(String id) {
		 Select combo = new Select(getDriver().findElement(By.id(id)));
		 List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		    return allSelectedOptions.size();
	}
	
	/************* Alert ***************/
	public Alert alternarparaAlert() {
		Alert alert = getDriver().switchTo().alert();
		return alert;
	}
	
	public String entrarAlert() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}
	
	public String fecharAlert() {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	/************* Frame ***************/
	public void alternarparaIframe(String id_campo) {
		getDriver().switchTo().frame(id_campo);
		
	}
	
	/*************** retornar para a pagina principal *************/
	public void alternarParaPaginaPrincipal() {
		getDriver().switchTo().defaultContent();
	}
	
	/************* Tabela ***************/
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
		//captura a tabela desejada
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
		//procurar coluna do registro
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		//procura linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celular encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]//td["+idColunaBotao+"]"));
		celula.findElement(By.xpath(".//input")).click();
	}

	
	protected int obterIndiceColuna(String colunaBusca, WebElement tabela) {
		//pega o título de cada coluna
				List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
				//se for -1, quer dizer que eu nao encontrei
				int idColuna = -1;
				//se o valor do int for de 0 para cima, quer dizer que eu encontrei o que estava procurando
				for(int i = 0; i < colunas.size(); i++) {
					if(colunas.get(i).getText().equals(colunaBusca)) {
						//i+1 porque o indice no xpath nao começa em 0
						idColuna = i+1;
						break;
					}
				}
				return idColuna;
	}

	private int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		//encontrar linha do registro
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		//se o valor do int for de 0 para cima, quer dizer que eu encontrei o que estava procurando
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				//i+1 porque o indice no xpath nao começa em 0
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}
	
	
	
	/********************* interacao com javascript *****************/
	public Object executarJS(String comando, Object... parametro) {
		//como o driver é uma instancia de um webdriver e nao de Javascriptexecutor, faço um cast
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				//js.executeScript("alert ('Testando js via selenium')");
				//js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
				//js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
				
				//WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
				return js.executeScript(comando, parametro);
	}

}
