package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        setDriver(driver);
        driver.get("https://demoqa.com");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
//div[@class='category-cards']/div[2]
    @FindBy(xpath = "//div[@class='category-cards']/div[2]")
    WebElement btnForms;

    public void clickBtnForms(){
        hideBanner();
        hideFooter();
        btnForms.click();
    }
}
