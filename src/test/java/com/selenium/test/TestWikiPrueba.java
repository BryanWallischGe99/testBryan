package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;
import com.selenium.page.WikiHomePage;
import com.selenium.page.WikiResultadoPage;

public class TestWikiPrueba {

	WebDriver driver;
	
	@DataProvider(name = "datos")
	public Object[][] createData() {
	return new Object[][] {
		{ "Selenium","Selenium"},
		{ "TDD", "Desarrollo guiado por pruebas"},
		{ "JAVA", "Java (lenguaje de programación)"},
		{"DATA DRIVEN TESTING","Data-driven testing"}
	};
	}
	//TODO "Crear un metodo para obtener datos externos."
	@BeforeMethod
	public void abrirBrowser(ITestContext context) {
		
		//TODO "Enviar la informacion del browser y la url por archivo externo."
		driver = DriverFactory.LevantarBrowser(driver, context);
	}
	
	@Test(dataProvider = "datos",  description = "Validar y verificar que wikipedia Home Page contiene el campo de busqueda")
	public void ValidarCajaTex (String varBuscar, String resultado) throws Exception {
		 
		WikiHomePage wikihomepage = PageFactory.initElements(driver, WikiHomePage.class);
		wikihomepage.IngresarDatoCajaBusqueda(varBuscar);
		WikiResultadoPage wikiRdopage = PageFactory.initElements(driver, WikiResultadoPage.class);
		Thread.sleep(2000);
		//Assert.assertTrue((driver.getCurrentUrl().contains(resultado)), "No contiene " + resultado);
		Reporter.log("Validar que el titulo sea" + varBuscar);
		Assert.assertTrue((wikiRdopage.ObtenerTitulo().contains(resultado)),
				"el valor" + resultado + "no se encontro en el titulo" + wikiRdopage.ObtenerTitulo().toString());
	}
	
	@AfterMethod
	public void CerrarBrowser() {
		Reporter.log("cerrar Nrowser");
		DriverFactory.FinalizarBrowser(driver);
	}
	
}
