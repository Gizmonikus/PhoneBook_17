import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getUser().isLogged()){
            app.getUser().login(User.builder()
                    .email("bobinsan20@yandex.ru")
                    .password("Bob12345@")
                    .build());
        }
    }

    @Test
    public void removeOneContactPositive(){

        int result = app.getContact().removeOneContact();
        Assert.assertEquals(result, -1);

    }

    @Test
    public void removeAllContactsPositive(){
//        app.getContact().removeAllContacts();
    }

}
