package pdc_HelperMethods;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class AppiumUtils {

	public AppiumDriverLocalService service;

	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port) {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/Users/prasa/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();

		service.start();
		return service;
	}

	public static void waitforSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
