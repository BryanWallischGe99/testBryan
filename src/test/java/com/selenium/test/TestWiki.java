package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import com.selenium.MetodosUtiles.Utiles;

public class TestWiki {

		WebDriver driver;
		@BeforeMethod
		public void precondicion () { 
			
			System.setProperty("webdriver.chrome.driver", "C:/Chromedriver/chromedriver.exe");
			Utiles.escribir("Inicializando Browser");
			driver = new ChromeDriver();
			Utiles.escribir("Ir a la pagina http://wikipedia.org");
			driver.get("http://wikipedia.org");

		}
		
		@AfterMethod
		public void postcondicion () { 
			
			Utiles.escribir("Cerrar Browser");
			driver.close();
			
		}
		
		@DataProvider(name = "datos")
		public Object[][] createData() {
		return new Object[][] {
			{ "Selenium","Selenium"},
			{ "TDD", "Desarrollo guiado por pruebas"},
			{"DATA DRIVEN TESTING","Data-driven testing"}
		};
		}

		@Test(dataProvider = "datos", description = "Validar que las busquedas en Wikipedia cambian de idioma")
		public void ValidarBusquedaWikipedia2 (String varBuscar, String resultado) throws Exception {
		
			Utiles.escribir("Buscamos el elemento Web Caja de texto");
			WebElement searchInput = driver.findElement(By.id("searchInput"));
			Utiles.escribir("Verificar que este desplegada la Caja de busqueda");
			Assert.assertTrue(searchInput.getText().toString().isEmpty(),"La caja de Texto no estaba vacia");

			
			Thread.sleep(2000);
			Utiles.escribir("Desplegar lista de Wikipedia en tu Idioma");
			Reporter.log("Identificar el combo de idiomas");
			java.util.List<WebElement> Lista  =  driver.findElements(By.id("searchLanguage"));
			for(WebElement elements : Lista)  
			{
			System.out.println(elements.getText());
				if ( elements.getText().contains("Español") ) {
				elements.click();    
				break;
				}
			
			}
			
			Utiles.escribir("El contenido de la caja de texto es"+searchInput.getText().toString());
			Assert.assertTrue(searchInput.isDisplayed(),"La caja de Texto no estaba vacia");
			Utiles.escribir("Ingresar el texto Selenium");
			searchInput.sendKeys(varBuscar);
			Utiles.escribir("Presionar Enter");
			searchInput.submit();
			
			
			Thread.sleep(2000);
			Utiles.escribir("Buscar el titulo");
			WebElement validarTitulo = driver.findElement(By.id("firstHeading"));
			Utiles.escribir("El contenido del titulo es" + validarTitulo.getText().toString());
			Assert.assertTrue(validarTitulo.getText().contains(resultado));
			Utiles.escribir("Texto encontrado "+ validarTitulo.getText());
			Utiles.escribir("Verificar que el titulo es desplegado");
			Assert.assertTrue(validarTitulo.isDisplayed(),"El titulo no es visible");
		
		}
			
			@Test(description = "Verificar que los elementos se muestren")
			public void VerificarelementosWiki() throws Exception {
			
			Utiles.escribir("Buscamos el elemento Web Caja de texto");
			WebElement searchInput = driver.findElement(By.id("searchInput"));
			Utiles.escribir("Verificar que este desplegada la Caja de busqueda");
			Assert.assertTrue(searchInput.isDisplayed());
			Thread.sleep(2000);
			
			Utiles.escribir("Verificar link en Español");
			WebElement lkEspanol = driver.findElement(By.xpath("//strong[contains(text(),'Español')]"));
			Assert.assertTrue(lkEspanol.isDisplayed(),"No se mostro el link en Español");
			
			Utiles.escribir("Verificar link Ruso");
			WebElement lkru = driver.findElement(By.id("js-link-box-ru"));
			Assert.assertTrue(lkru.isDisplayed(),"No se mostro el link en Ruso");
			
			Thread.sleep(2000);
			
			Utiles.escribir("Verificar link en Aleman");
			WebElement lkDeutsch = driver.findElement(By.xpath("//strong[contains(text(),'Deutsch')]"));
			Assert.assertTrue(lkDeutsch.isDisplayed(),"No se mostro el link en Aleman");
			
			Utiles.escribir("Verificar link en Italiano");
			WebElement lkItaliano = driver.findElement(By.xpath("//strong[contains(text(),'Italiano')]")) ;
			Assert.assertTrue(lkItaliano.isDisplayed(),"No se mostro el link en Italiano");
			
			Utiles.escribir("Verificar link en Arabe");
			WebElement lkArabe= driver.findElement(By.xpath("//body/div[2]/div[9]/a[1]/strong[1]/bdi[1]"));
			Assert.assertTrue(lkArabe.isDisplayed(),"No se mostro el link en Arabe");
			
			Thread.sleep(2000);
			
			Utiles.escribir("Verificar link en Ingles");
			WebElement lken = driver.findElement(By.id("js-link-box-en"));
			Assert.assertTrue(lken.isDisplayed(),"No se mostro el link en Ingles");
			
			Utiles.escribir("Verificar link en Japon");
			WebElement lkja = driver.findElement(By.xpath("//a[@id='js-link-box-ja']"));
			Assert.assertTrue(lkja.isDisplayed(),"No se mostro el link en Japon");
			
			Utiles.escribir("Verificar link en Frances");
			WebElement lkfr = driver.findElement(By.id("js-link-box-fr"));
			Assert.assertTrue(lkfr.isDisplayed(),"No se mostro el link en Frances");
			
			Thread.sleep(2000);
			
			Utiles.escribir("Verificar link en Chino");
			WebElement lkzh = driver.findElement(By.id("js-link-box-zh"));
			Assert.assertTrue(lkzh.isDisplayed(),"No se mostro el link en Chino");
			
			Utiles.escribir("Verificar link en Portugues");
			WebElement lkpt = driver.findElement(By.id("js-link-box-pt"));
			Assert.assertTrue(lkpt.isDisplayed(),"No se mostro el link en Portugues");
			
			Utiles.escribir("Verificar Boton cambiar de idioma");
			WebElement cboCambioIdioma = driver.findElement(By.id("jsLangLabel"));
			Assert.assertTrue(cboCambioIdioma.isDisplayed(),"No se mostro el Boton cambiar de idioma");
			
			Thread.sleep(2000);
			
			Utiles.escribir("Verificar Boton de buscador");
			WebElement lkBotonBuscador = driver.findElement(By.xpath("//i[contains(text(),'Search')]"));
			Assert.assertTrue(lkBotonBuscador.isDisplayed(),"No se mostro el Boton de buscador");
			
			Utiles.escribir("Verificar Boton Wikipedia en tu idioma");
			WebElement btnWikipediaentuidioma = driver.findElement(By.id("js-lang-list-button"));
			Assert.assertTrue(btnWikipediaentuidioma.isDisplayed(),"No se mostro el Boton Wikipedia en tu idioma");
			
			Utiles.escribir("Mostrar Boton Wikipedia en tu idioma");
			Select selectBuscar = new Select(driver.findElement(By.id("searchLanguage")));
			
			for(WebElement elements : selectBuscar.getOptions())  {
				
			System.out.println(elements.getText());
				if ( elements.getText().contains("English") ) {
				elements.click();
				break;
				}
			}
			
			}
	}
	

