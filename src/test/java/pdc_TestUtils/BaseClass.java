package pdc_TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pdc_HelperMethods.AppiumUtils;

public class BaseClass extends AppiumUtils{

	 public AppiumDriverLocalService service;
	    public AndroidDriver driver;

	    @BeforeClass(alwaysRun=true)
	    public void appiumConfigure() throws IOException {
	        Properties prop = new Properties();  
	        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//pdc_HelperMethods//GlobalData.properties");

	        prop.load(fis);

	        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
	        String port = prop.getProperty("port");

	        service = startAppiumServer(ipAddress, Integer.parseInt(port));    

	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setDeviceName("PDC_Module");
	        options.setApp(System.getProperty("user.dir") + "//src//test//java//pdc_Resources//app-dev-release 23.apk");

	        driver = new AndroidDriver(service.getUrl(), options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @AfterClass(alwaysRun=true)
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	        if (service != null) {
	            service.stop();
	        }
	    }
}
