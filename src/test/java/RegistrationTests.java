import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User(
                "John",
                "Snow",
                "bebe" + i + "@mail.com",
                "Bb12345$"
        );

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
    }
    @Test
    public void registrationNegativeTestWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User(
                "John",
                "Snow",
                "bebe" + i + "mail.com",
                "Bb12345$"
        );

        openRegistrationForm();
        fillRegistrationForm(user);
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='input-container']//div[2]")));
    }
    @Test
    public void registrationNegativeTestWrongPassword(){

        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = new User(
                "John",
                "Snow",
                "bebe" + i + "@mail.com",
                "b12345"
        );

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='error']")));

    }

}
