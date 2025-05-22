package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {


    SoftAssert softAssert=new SoftAssert();

    @Test
    public void studentRegFormPositiveTest(){

        List<Hobbies> hobbies=new ArrayList<>();
        hobbies.add(Hobbies.SPORTS);
        hobbies.add(Hobbies.MUSIC);
        Student student=new Student("Miha","Volkov","dgtjfc@mail.ru", Gender.FEMALE,
                "0546424677","23 apr 2013","Maths,Physics,Chemistry",
                hobbies, "", "street 1", StateCity.NCR.getState(), StateCity.NCR.getCity()[1]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);

        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage());
       // System.out.println("Test faild");
       // Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative());

    }
    @Test
    public void studentRegFormPositiveTestValidateSoftAssert() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.SPORTS);
        Student student = new Student("Vasya", "Vasilev", "vasyavasilev@gmail.com",
                Gender.FEMALE, "0123456789", "22 Dec 2010",
                "Maths,Physics,Chemistry",
                hobbies, "", "street 1",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
//        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative());
        System.out.println("Test failed!!!");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr/td[last()]"))
                .getText().contains(student.getLastName()));
        System.out.println("===========================");
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage());
        System.out.println("============================");
        softAssert.assertAll();
    }
}
