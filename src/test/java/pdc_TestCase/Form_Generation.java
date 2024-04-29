package pdc_TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.openqa.selenium.support.ui.Select;

import pdc_TestUtils.BaseClass;

public class Form_Generation extends BaseClass {

	@Test(priority = 1)

	public void FillForm() throws InterruptedException {
		//allow while using the app
	  driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
				.click();
		
		// climate option clicked
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Climate')]")).click();
		System.out.println("selection of climate -passed");
	
		//dome parameter clicked
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Dome Parameters')]")).click();
		System.out.println("Selection of dome - passed");

		// Wait for the dropdown to open (adjust the wait time as needed)
        waitforSeconds(2);
		// Click on the dropdown element to open it
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Please select a farm')]")).click();

		// Wait for the dropdown options to appear (adjust the wait time as needed)
		 waitforSeconds(2);

		// Click on the desired option
		WebElement option = driver
				.findElement(By.xpath("//android.widget.TextView[contains(@text, 'NANTA-A | Zone : 1')]"));
		option.click();

		 waitforSeconds(2);
		
		//+ icon for new form
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView"))
				.click();

		 waitforSeconds(2);

		// 1st dropdown -> click -> select
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Select Polyhouse')]")).click();
		 waitforSeconds(2);
		WebElement polyhouse = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Dome')]"));
		polyhouse.click();
		
		System.out.println("dropdown 1 - completed");
	
		// Locate the dropdown element
		WebElement dropdown = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Select Dome')]"));

		// Check if the dropdown is enabled
		if (dropdown.isEnabled()) {
		    // Use Actions class to click on the dropdown
		    Actions actions = new Actions(driver);
		    actions.moveToElement(dropdown).click().perform();
		    waitforSeconds(2); // Wait for the options to appear (optional)
		    
		    // Now locate and click on the desired option
		    WebElement option2 = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Mandatory field')]"));
		    option2.click();
		    System.out.println("Dropdown clicked successfully.");    
		}
		
		// 3rd dropdown -> click -> select
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Select Section')]")).click();
		 waitforSeconds(2);
		WebElement Section = driver
				.findElement(By.xpath("//android.widget.TextView[contains(@text,'A')]"));
		Section.click();
		
		System.out.println("dropdown 3 - completed");
		
		// temperature text box
         WebElement temperature = driver.findElement(By.xpath("//android.widget.EditText[2]"));
        temperature.click();
        waitforSeconds(2);
        
        //remaining fields
        //submit button
        
        
       
        
	}
}
