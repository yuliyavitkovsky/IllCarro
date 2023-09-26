import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    }

    @AfterMethod
    public void postcondition(){
        clickOkButton();
    }

}
