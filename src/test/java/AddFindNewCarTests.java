import models.Car;
import models.Find;
import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddFindNewCarTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void precondition() {
        if (isLogged() == false) {
            login(new User()
               //     .withEmail("bubu@mail.com")
                    .withEmail(getEmail())
              //      .withPassword("Bb12345$")
                    .withPassword(getPassword())
            );
        }
    }

    @Test(groups = {"positive", "smoke"})
    public void addNewCarPositive() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Car car = Car.builder()
                .location("Tel Aviv")
                .manufacture("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .carRegNumber("100-200-" + i)
                .price("150")
                .about("New car")
                .build();

        openCarForm();
        fillCarForm(car);
        pause(5000);
        logger.info("addNewCarPositive added successfully a new car: " + car.getManufacture() + " with reg.number: " + car.getCarRegNumber());
        submitCar();
        click(By.xpath("//button[normalize-space()='Add another car']"));
    }

    @Test(groups = {"positive"})
    public void findCarPositive() {

        Find find = Find.builder()
                .location("Tel Aviv")
                .dates("11/10/23-11/20/23")
                .build();

        openFindForm();
        fillFindForm(find);
        submitFind();
    }
    @Test(groups = {"positive"})
    public void findCarPositiveThisMonth() {

        Find find = Find.builder()
                .location("Tel Aviv")
                .build();

        openFindForm();
        fillCalendarForm(find);
        submitFind();
    }
    @Test(groups = {"positive"})
    public void findCarPositiveAnyMonth() {

        Find find = Find.builder()
                .location("Tel Aviv")
                .build();

        openFindForm();
        fillCalendarFormNextMonth(find);
        submitFind();
    }
@AfterMethod(alwaysRun = true)
    public void postcondition(){
    openFindForm();
    deleteCity(By.id("city"));
}
}
