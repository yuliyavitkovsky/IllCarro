package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public interface ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

 //   WebDriver wd = new ChromeDriver();
    EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());

    default void init(){
//        wd = new ChromeDriver();
//         wd.manage().window().maximize();
        wd.register(new WDListener());
        String link = "https://ilcarro.web.app/search";
                wd.navigate().to(link);
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        logger.info("Navigated to the link ---> " + link);
//        helperUser = new HelperUser(wd);
    }

    default void tearDown(){

        wd.quit();
        logger.info("Tests completed");
    }



}


