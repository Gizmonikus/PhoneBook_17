package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    WebDriver wd;
    HelperUser user;

    public HelperUser getUser() {
        return user;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");//новый сайт
        user = new HelperUser(wd);
    }

    public void stop() {
//        wd.quit();
    }

}
