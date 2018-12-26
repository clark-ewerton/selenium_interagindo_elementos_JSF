package br.ce.wcarquivo.core;

public class Propriedades {
	
	//defino a velocidade dos testes, se a janela do browser sera fechada a cada teste ou nao
	public static Boolean FECHAR_BROWSER = false;
	
	//define o chaveamento de browsers
	public static Browsers browser = Browsers.CHROME;
	
	public enum Browsers{
		CHROME
	}

}
