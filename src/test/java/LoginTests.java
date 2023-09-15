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
        openLoginForm();
        fillLoginForm("bubu@mail.com", "Bb12345$");
        submitLogin();
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
        Assert.assertTrue(isLoggedSuccess());
    }

    @AfterMethod
    public void postcondition(){
        clickOkButton();
    }

}
