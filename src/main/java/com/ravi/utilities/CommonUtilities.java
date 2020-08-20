package com.ravi.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CommonUtilities extends TestBase{
	
	FileInputStream fis;
	Properties prop=new Properties();
	Logger log=Logger.getLogger(getClass().getSimpleName());
	
	public void LoadConfigPropertyFile(String configFilePath) throws Exception {
		log.info("Current dir using System:" + configFilePath);
		fis=new FileInputStream(configFilePath);
		prop.load(fis);
		System.getProperties().putAll(prop);
	}
	
	public void LoadTestDataPropertyFile(String testdataFilePath) throws Exception {
		log.info("Current dir using System:" + testdataFilePath);
		fis=new FileInputStream(testdataFilePath);
		prop.load(fis);
		System.getProperties().putAll(prop);
		PropertyConfigurator.configure(prop);
	}
	public void loadLog4jPropertyFile(String load4jFilePath) throws Exception {
		log.info("Log4j Property file Path :" + load4jFilePath);
		fis = new FileInputStream(load4jFilePath);
		prop.load(fis);
		PropertyConfigurator.configure(prop);

		// This line must be added to print the logs in console
	  //  BasicConfigurator.configure();

	}
	
	public static String takeScreenShotWebReturnPath(WebDriver driver, String ClassName) throws IOException {
		String sDestDir = "/screenshots/";
		String sImageName = System.getProperty("user.dir") + sDestDir+ClassName+".jpg";
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File(sImageName));
		System.out.println(sImageName);
		return sImageName;
	}
	
}
