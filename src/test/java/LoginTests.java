import manager.NGListener;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)

public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(isLogged()) logout();
    }

    @Test
    public void loginPositiveTest(){
        String email = "bubu@mail.com";
        String password = "Bb12345$";
        openLoginForm();
        fillLoginForm(email, password);
        submitLogin();
        logger.info("loginPositiveTest starts with:" + email + " & " + password);
        Assert.assertTrue(isLoggedSuccess());
        clickOkButton();
    }
    @Test
    public void loginPositiveTestModel(){
        User user = new User()
                .withEmail("bubu@mail.com")
                .withPassword("Bb12345$");
        openLoginForm();
        fillLoginForm(user.getEmail(), user.getPassword());
        submitLogin();
        logger.info("loginPositiveTestModel starts with:" + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(isLoggedSuccess());
        clickOkButton();
    }
    @Test
    public void loginNegativeTestWrongEmail(){
        User user = new User()
                .withEmail("bubumail.com")
                .withPassword("Bb12345$");
        openLoginForm();
        fillLoginForm(user.getEmail(), user.getPassword());
        submitLogin();
        logger.info("loginNegativeTestWrongEmail starts with:" + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='error']")));
    }

    @Test
    public void loginNegativeTestWrongPassword(){
        User user = new User()
                .withEmail("bubu@mail.com")
                .withPassword("Bb12345");
        openLoginForm();
        fillLoginForm(user.getEmail(), user.getPassword());
        submitLogin();
        logger.info("loginNegativeTestWrongPassword starts with:" + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='dialog-container']")));
        clickOkButton();
    }

    @AfterMethod
    public void postcondition(){
        clickOnHeader();
    }

}
