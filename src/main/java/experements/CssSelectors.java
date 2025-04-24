package experements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {

    WebDriver driver=new ChromeDriver();


    @Test
    public void selectorsHomePage(){
        driver.get("https://demoqa.com");
        driver.manage().window().maximize();

        WebElement footer=driver.findElement(By.tagName("footer"));
        System.out.println(footer.getAttribute("class"));
    }
}
