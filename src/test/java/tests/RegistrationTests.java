package tests;

import models.User;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @Test
    public void registrationPositive(){
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        User user = new User(
                "John",
                "Snow",
                "bebe_" + i + "@mail.com",
                "Bb12345$"
        );

        openRegistrationForm();
        fillRegistrationForm(user);
        submitRegistration();

    }

}
