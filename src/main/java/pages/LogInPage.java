package pages;

import beans.PersonalInfoBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    private static final String URL = "https://www.credify.tech/portal/login";
    private By emailField = By.cssSelector("[data-auto='username']");
    private By password = By.cssSelector("[data-auto='password']");
    private By signInButton = By.cssSelector("[data-auto='login']");
    private WebDriver driver;

    public LogInPage(WebDriver wb){
        driver = wb;
        driver.get(URL);
    }

    private void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    private void setPass(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    private void clickSigIn(){
        driver.findElement(signInButton).click();
    }

    public void signIn(PersonalInfoBean personalInfoBean){
        setEmail(personalInfoBean.getEmail());
        setPass(personalInfoBean.getPassword());
        clickSigIn();
    }
}





