package experements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {

    WebDriver driver=new ChromeDriver();

    @Test
    public void selectorsTextBox(){

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        hideBanner();
        hideFooter();

        WebElement fullName=driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        fullName.sendKeys("Vi Svd");

        WebElement email=driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        email.sendKeys("viasvd@gmail.com");

        WebElement currentAddress=driver.findElement(By.xpath("//*[@placeholder='Current Address']"));
        currentAddress.sendKeys("13 home avin");

        WebElement permAddress=driver.findElement(By.id("permanentAddress"));
        permAddress.sendKeys("fdyt uiftdr rzsetsj");

        WebElement buttonSubmit=driver.findElement(By.xpath("//button[text()='Submit']"));
        buttonSubmit.click();

        WebElement output=driver.findElement(By.xpath("//div[@id='output']"));
        System.out.println(output.getText());

        driver.quit();

    }

    public void hideBanner(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");
    }

    public void hideFooter(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
