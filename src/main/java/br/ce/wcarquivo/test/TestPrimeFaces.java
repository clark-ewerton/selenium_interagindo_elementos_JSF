package br.ce.wcarquivo.test;

import static br.ce.wcarquivo.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcarquivo.page.PrimeFacesPage;

public class TestPrimeFaces {

	private PrimeFacesPage page = new PrimeFacesPage();

	@Test
	public void deveInteragirComRadioPrime() {
		
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");

		page.setRadioXboxOne();
		Assert.assertTrue(page.setValidarRadioXboxSelecionado());

		page.setRadioPS4();
		Assert.assertTrue(page.setValidarRadioPS4Selecionado());

	}

	@Test
	public void deveInteragirComComboboxPrime() {

		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");

		page.setComboboxBasic("j_idt692:console", "PS4");

		Assert.assertEquals("PS4", page.setValidarComboboxBasic());

	}
	
	@Test
	public void deveInteragirComCheckboxMenuPrime() {

		getDriver().get("https://www.primefaces.org/showcase/ui/input/checkboxMenu.xhtml");

		//seleciono o valor do checkBoxMenu do JSF
		page.setCheckboxMenu("j_idt691:multiple", "Miami");
		//fecho a seleção
		page.setFecharCheckboxMenu();

		Assert.assertEquals("Miami", page.setValidarCheckboxMenu());

	}
}
