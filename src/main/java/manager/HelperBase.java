package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface HelperBase extends ApplicationManager{
    default void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    default void click(By locator){
        wd.findElement(locator).click();
    }

    default void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    default boolean isElementPresent(By locator){
        return wd.findElements(locator).size() > 0;
    }


    default void clickOnButton(){
        click(By.xpath("//button[@type='button']"));
    }


}
