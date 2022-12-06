import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {
    //WebDriver wd;
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogged()) {
            app.getUser().pause(3);


        } else {
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm("bobinsan20@yandex.com", "Bob12345@");
            app.getUser().submitLogin();
            app.getUser().pause(10);
        }
    }

    @Test
    public void addNewContactPositiveTest() {
        app.getUser().click(By.xpath("//a[@href='/add']"));
        app.getUser().pause(3);
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "John" + i;
        String lastName = "Snow" + i;
        String phone = "0555600876" + i;
        String email = "JohnSnow@gmail.com" + i;
        String address = "Tel-Aviv, Vardia 17" + i;
        String description = "Friend" + i;

        app.getUser().type(By.xpath("//input[1]"), name);
        app.getUser().type(By.xpath("//input[2]"), lastName);
        app.getUser().type(By.xpath("//input[3]"), phone);
        app.getUser().type(By.xpath("//input[4]"), email);
        app.getUser().type(By.xpath("//input[5]"), address);
        app.getUser().type(By.xpath("//input[6]"), description);
        app.getUser().click(By.xpath("//div[@class='add_form__2rsm2']//button"));

        Assert.assertTrue(
app.getUser().getText(By.xpath(""+"//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(phone));
    }
    //=======Hw_7=======
//        String email = "bobinsan20@yandex.ru";
//        String password = "Bob12345@";
//        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(email, password);
//        app.getUser().submitLogin();
//        app.getUser().pause(10);
//        app.getUser().click(By.xpath("//a[@href='/add']"));
//        app.getUser().type(By.xpath("//input[1]"), "John");
//        app.getUser().type(By.xpath("//input[2]"), "Dousan");
//        app.getUser().type(By.xpath("//input[3]"), "0521237654");
//        app.getUser().type(By.xpath("//input[4]"), "JohnDousan@gmail.com");
//        app.getUser().type(By.xpath("//input[5]"), "Tel-Aviv,st.Tel-hai 17");
//        app.getUser().type(By.xpath("//input[6]"), "Friend");
//        app.getUser().click(By.xpath("//button[.='Save']"));
//
//    }

    //@AfterMethod

}

