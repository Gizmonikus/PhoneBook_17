package manager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitLogin(){
        click(By.xpath("//button[1]"));
    }
    public void submitRegistration(){
        click(By.xpath("//button[2]"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));

    }

    public void logOut(){
//        WebElement signOutButton = wd.findElement(By.xpath("//button"));
//        if (signOutButton.getText().equals("Sign Out")) {
        click(By.xpath("//button"));
        //}
    }

    public void openLoginRegistrationForm(){
        click(By.xpath("//a[text()='LOGIN']"));
    }

    public void fillLoginRegistrationForm(String email, String password){
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }
    public void login(String email, String password){
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();
        pause(10);

    }

    public void FillAddForm(String name, String lastName, String phone, String email, String addres, String description){
        type(By.xpath("//input[@placeholder='Name']"), name);
        type(By.xpath("//input[@placeholder='Last Name']"), lastName);
        type(By.xpath("//input[@placeholder='Phone']"), phone);
        type(By.xpath("//input[@placeholder='email']"), email);
        type(By.xpath("//input[@placeholder='Address']"), addres);
        type(By.xpath("//input[@placeholder='description']"), description);
    }


    public boolean isAlertPressent() {

        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if(alert == null){
            return false;
        }else{
            wd.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept(); //for ok button
            //alert.dismiss() for Cancel button
            //alert.sendKeys() for input data
            return true;
        }

    }

    public boolean isErrorMessageInFormat(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        String errorMessage = "Wrong email or password";
        return alert.getText().contains(errorMessage);
    }

}


