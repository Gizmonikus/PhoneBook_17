import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {
//WebDriver wd;

    @Test
    public void addNewContactTest() {
        String email = "bobinsan20@yandex.ru";
        String password = "Bob12345@";
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(email, password);
        app.getUser().submitLogin();
        app.getUser().pause(10);
        app.getUser().click(By.xpath("//a[@href='/add']"));
        app.getUser().type(By.xpath("//input[1]"), "John");
        app.getUser().type(By.xpath("//input[2]"), "Dousan");
        app.getUser().type(By.xpath("//input[3]"), "0521237654");
        app.getUser().type(By.xpath("//input[4]"), "JohnDousan@gmail.com");
        app.getUser().type(By.xpath("//input[5]"), "Tel-Aviv,st.Tel-hai 17");
        app.getUser().type(By.xpath("//input[6]"), "Friend");
        app.getUser().click(By.xpath("//button[.='Save']"));

    }
}

