package com.selenium.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class WikiResultadoPage {

	WebDriver driver;
	
		public WikiResultadoPage(WebDriver ldriver)
		{
			this.driver=ldriver;
		}
		
		@FindBy (id = "firstHeading")
		private WebElement lblTitulo;
		
		public String ObtenerTitulo ()
		{
			Reporter.log("Localizar y comprobar que el titulo este disponible");
			return lblTitulo.getText();
		}
}
