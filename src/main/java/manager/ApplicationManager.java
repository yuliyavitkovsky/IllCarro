package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public interface ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

 //   WebDriver wd = new ChromeDriver();
    EventFiringWebDriver wd = new EventFiringWebDriver(new ChromeDriver());
Properties properties = new Properties();
    default void init() throws IOException {

        String target = System.getProperty("target", "pre_prod");
        properties.load(new FileReader
                (new File(String.format("src/test/resources/%s.properties", target))));
        String link = properties.getProperty("web.baseURL");
//        wd = new ChromeDriver();
//         wd.manage().window().maximize();
        wd.register(new WDListener());
//        String link = "https://ilcarro.web.app/search";
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


