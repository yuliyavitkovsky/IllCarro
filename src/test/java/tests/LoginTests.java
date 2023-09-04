package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public  void loginPositiveTest(){

        openLoginRegistrationForm();
        fillLoginRegistrationForm("bubu@mail.com", "Bb12345$");
        submitLogin();
        pause(3000);
        Assert.assertTrue(isElementPresent(By.xpath("//button[normalize-space()='Ok']")));
        click(By.xpath("//button[normalize-space()='Ok']"));

        isLogged();
    }

}