package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;

public interface HelperUser extends HelperBase{

    default void openLoginForm(){
        click(By.xpath("//*[.=' Log in ']"));
    }

    default void fillLoginForm(User user){
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
    }

    default void submitLogin(){
        click(By.xpath("//button[@type='submit']"));
    }

    default boolean isLoggedSuccess(){
        return isElementPresent(By.xpath("//h2[contains(text(), 'success')]"));
    }
    default boolean isLogged(){
        return isElementPresent(By.xpath("//*[.=' Logout ']"));
    }

    default void logOut(){
        click(By.xpath("//*[.=' Logout ']"));
    }
    default void openRegistrationForm(){
        click(By.xpath("//*[.=' Sign up ']"));
    }
    default void clickCheckBox(){
        //variant1
     //   click(By.cssSelector("label[for='terms-of-use']"));
        //variant2
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");

    }
    default void fillRegistrationForm(User user){
        type(By.xpath("//input[@id='name']"), user.getName());
        type(By.xpath("//input[@id='lastName']"), user.getLastName());
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.xpath("//input[@id='password']"), user.getPassword());
        clickCheckBox();
    }
    default void submitRegistration(){
        click(By.xpath("//button[@type='submit']"));
    }


}
