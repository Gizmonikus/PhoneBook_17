import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

//    WebDriver wd;
//
    @BeforeMethod
    public void preCondition(){
        if(isLogged()){
            logOut();
        }
    }


    @Test
    public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "@mail.com";
        String password = "$Abcdef12345";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitRegistration();
        pause(15);
        Assert.assertTrue(isElementPresent(By.xpath("//button")));
    }

    @Test
    public void registrationWrongEmail() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "name" + i + "mail.com";
        String password = "$Abcdef12345";

        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitRegistration();
        pause(3);
        Assert.assertFalse(isElementPresent(By.xpath("//button")));

    }


//    @AfterMethod
//    public void tearDown(){
////        wd.quit();
//    }

}
