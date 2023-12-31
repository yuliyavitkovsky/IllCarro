import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(isLogged()) logout();
    }
    @Test(groups = {"positive"})
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
        logger.info("registrationPositiveTest starts with:" + user.getEmail() + " & " + user.getPassword());
    }
    @Test(groups = {"negative"})
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
        logger.info("registrationNegativeTestWrongEmail starts with:" + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='input-container']//div[2]")));
    }
    @Test(groups = {"negative"})
    public void registrationNegativeTestWrongPassword() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "John",
                "Snow",
                "bebe" + i + "@mail.com",
                "b12345"
        );

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("registrationNegativeTestWrongPassword starts with:" + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='error']")));
    }

    @Test(groups = {"negative"})
    public void registrationNegativeTestEmptyName() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                " ",
                "Snow",
                "bebe" + i + "@mail.com",
                "Bb12345$"
        );
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("registrationNegativeTestEmptyName starts with:" + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='dialog-container']")));
        clickOkButton();
    }
    @Test(groups = {"negative"})
    public void registrationNegativeTestEmptyLastName() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "John",
                " ",
                "bebe" + i + "@mail.com",
                "Bb12345$"
        );
        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();
        logger.info("registrationNegativeTestEmptyLastName starts with:" + user.getEmail() + " & " + user.getPassword());
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='dialog-container']")));
        clickOkButton();
    }

    @AfterMethod(alwaysRun = true)
    public void postcondition(){
        clickOnHeader();
    }
}
