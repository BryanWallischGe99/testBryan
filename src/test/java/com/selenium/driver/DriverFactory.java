package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.Reporter;

import com.selenium.MetodosUtiles.Utiles;

public class DriverFactory {
 

		private enum browsers {
			EXPLORER, FIREFOX, CHROME
		};

		/***
		 * Metodo que abre un navegador y navega a la URL que le indiquemos
		 ***/
		public static WebDriver LevantarBrowser(WebDriver driver, ITestContext context) {
			String browserName = context.getCurrentXmlTest().getParameter("NombreNavegador");
			String URL = context.getCurrentXmlTest().getParameter("Url");
			switch (browsers.valueOf(browserName)) {
			case CHROME: // Using WebDriver
			{
				System.setProperty("webdriver.chrome.driver", "C:/Chromedriver/chromedriver.exe");
				Utiles.escribir("Abro browser");
				driver = new ChromeDriver();
				break;
			}
			case FIREFOX:// Using WebDriver
			{
				System.setProperty("webdriver.gecko.driver", "driverBrowsers\\firefox\\geckodriver.exe");
				Utiles.escribir("Abro browser");
				driver = new FirefoxDriver();
				break;
			}
			default:
				Utiles.escribir("No selecciono ningun browser correcto, se le asignara Chrome");
				System.setProperty("webdriver.chrome.driver", "C:/Chromedriver/chromedriver.exe");
				Utiles.escribir("Abro browser");
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.get(URL);
			return driver;
		}

		public static void FinalizarBrowser(WebDriver driver) {
			Utiles.escribir("Cerrando el browser");
			driver.quit();
			driver = null;
		}
	}


