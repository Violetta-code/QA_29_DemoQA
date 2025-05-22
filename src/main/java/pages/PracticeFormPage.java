package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver){
        //https://demoqa.com/forms
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id="firstName")
    WebElement fieldName;


    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement fieldLastName;


    @FindBy(id="userEmail")
    WebElement fieldEmail;

    @FindBy(xpath = "//input[@placeholder='Mobile Number']")
    WebElement fieldMobile;

    @FindBy(xpath = "//textarea[@placeholder='Current Address']")
    WebElement fieldAddress;

    @FindBy(id="dateOfBirthInput")
    WebElement fieldDataOfBirth;

    @FindBy(id="subjectsInput")
    WebElement fieldSubjects;

    @FindBy(id="react-select-3-input")
    WebElement inputState;

    @FindBy(id="react-select-4-input")
    WebElement inputCity;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalMessage;

    public void typePracticeForm(Student student){
        hideFooter();
        fieldName.sendKeys(student.getFirsName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());

        fieldMobile.sendKeys(student.getMobile());
        fieldAddress.sendKeys(student.getAddress());
       // fieldDataOfBirth.sendKeys(student.getDateOfBirth()); no wey
       typeDataOfBirth(student.getDateOfBirth());
       typeSubjects(student.getSubjects());
       typeHobbies(student.getHobbies());
      // inputState.sendKeys(student.getState());
        typeStateCity(student.getState(),student.getCity());
        btnSubmit.click();

    }

    private void typeGender(Gender gender){
        WebElement btnGender= driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

    private void typeDataOfBirth(String dataOfBirth){
        fieldDataOfBirth.click();

        String operationSystem=System.clearProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            fieldDataOfBirth.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        else if (operationSystem.startsWith("Mac"))
        fieldDataOfBirth.sendKeys(Keys.chord(Keys.COMMAND,"a"));

        fieldDataOfBirth.sendKeys(dataOfBirth);
        fieldDataOfBirth.sendKeys(Keys.ENTER);
    }
    private void typeSubjects(String subjects){
        fieldSubjects.click();
        String[] subArray=subjects.split(",");
        for(String sub:subArray){
            fieldSubjects.sendKeys(sub);
            fieldSubjects.sendKeys(Keys.ENTER);
        }
    }

    private void typeHobbies(List<Hobbies> hobbies){
        for(Hobbies hob:hobbies){
            switch (hob){
                case SPORTS:
                    driver.findElement(By.xpath(hob.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(hob.getLocator())).click();
                    break;
                case MUSIC:
                    driver.findElement(By.xpath(hob.getLocator())).click();
                    break;
            }
        }
    }

    private void typeStateCity(String state,String city){
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);

        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
    }
    public boolean validateModalMessage(){
        return validateTextInElement(modalMessage, "Thanks for submitting the form");
    }
    public boolean validateModalMessageNegative(){
        return validateTextInElement(modalMessage, "Negative");
    }
}
