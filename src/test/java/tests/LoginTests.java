package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        if(isLogged())
            logOut();
    }

//    @Test
//    public  void loginPositiveTest(){
//
//        openLoginForm();
//        fillLoginForm("bubu@mail.com", "Bb12345$");
//        submitLogin();
//        Assert.assertTrue(isLoggedSuccess());
//    }
    @Test
    public  void loginPositiveTest1(){
        User user = (User) new User()
                .withEmail("bubu@mail.com")
                .withPassword("Bb12345$");

        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition(){
        clickOnButton();
}
}