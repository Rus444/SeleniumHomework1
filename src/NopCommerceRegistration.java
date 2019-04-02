import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NopCommerceRegistration {
    //initializing WebDriver
    protected static WebDriver driver;

    static String currentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHMMSS");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        System.out.println("Current date and time is " + date1);
        return date1;
    }

    //Main method
    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "src\\BrowserDrivers\\chromedriver.exe");
    driver = new ChromeDriver();
    //applying implicit wait to driver instance - 6 seconds
    driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    //asking driver to get the homepage url
    driver.get("https://demo.nopcommerce.com/");
    //click on Register button
    driver.findElement(By.xpath("//div[2]/div[1]/ul/li[1]/a")).click();
    //find First Name field and enter a value
    driver.findElement(By.xpath
    ("//*[@id=\"FirstName\"]")).sendKeys("rus"+currentDateTime());
    //find Last Name field and enter a value
    driver.findElement(By.xpath
    ("//*[@id=\"LastName\"]")).sendKeys("crow"+currentDateTime());
    //find E-Mail field and enter a value
    driver.findElement(By.xpath
    ("//*[@id=\"Email\"]")).sendKeys("rus.charuh"+currentDateTime()+"@gmail.com");
    //find Password field and enter a value
    driver.findElement(By.xpath
    ("//*[@id=\"Password\"]")).sendKeys("ruscrowtest");
    //find Confirm Password field and enter the same value as above
    driver.findElement(By.xpath
    ("//*[@id=\"ConfirmPassword\"]")).sendKeys("ruscrowtest");
    //find Registration button and click
    driver.findElement(By.xpath
    ("//*[@id=\"register-button\"]")).click();
    //initialize String to hold Actual Registration Success Message
    String actualRegSuccMsg=driver.findElement(By.xpath("//form/div/div[2]/div[1]")).getText();
    //Compare Expected and Actual results
    Assert.assertEquals("Your registration completed",actualRegSuccMsg);
    driver.close();
    }
}
