package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SelenoidTest {
    public WebDriver driver;

    @Test
    public void test1(){
        try {
            driver.get("http://www.google.com");
            Thread.sleep(10000);
            System.out.println("Title: " + driver.getTitle());
            driver.quit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeClass
            public void setup() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        options.setCapability("selenoid:options", selenoidOptions);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }
}


