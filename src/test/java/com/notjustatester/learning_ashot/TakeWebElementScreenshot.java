package com.notjustatester.learning_ashot;

import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class TakeWebElementScreenshot {

	public static void main(String args[]) throws Exception {

		DesiredCapabilities desiredCapabilitiesObj;

		System.setProperty("webdriver.gecko.driver", "geckodriver-v0.24.0-win64/geckodriver.exe");

		desiredCapabilitiesObj = DesiredCapabilities.firefox();

		desiredCapabilitiesObj.setCapability("marionette", true);

		WebDriver webDriverObj = new FirefoxDriver(desiredCapabilitiesObj) ;

		webDriverObj.get("http://demo.automationtesting.in/Register.html");

		Thread.sleep(2000);

		WebElement webElement = webDriverObj.findElement(By.xpath("//h2[text()='Register']"));

		Screenshot screenshot = new AShot().takeScreenshot(webDriverObj, webElement);

		ImageIO.write(screenshot.getImage(), "PNG",
				new File(System.getProperty("user.dir") + "\\Images\\ElementScreenshot.png"));

		Thread.sleep(2000);

		webDriverObj.quit();
	}

}