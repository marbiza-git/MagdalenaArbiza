package Pages;

import PageBeans.PersonalInfoBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    private WebDriver driver;

    public LogInPage(WebDriver wb){
        driver = wb;
        driver.get("https://www.credify.tech/portal/login");
    }

    private void setEmail(String email){
        driver.findElement(By.xpath("/html/body/div/div/main/div/div/div/div/form/div/div[2]/div/div/div/input")).sendKeys(email);
    }

    private void setPass(String pass){
        driver.findElement(By.xpath("/html/body/div/div/main/div/div/div/div/form/div/div[3]/div/div/div[1]/input")).sendKeys(pass);
    }

    private void clickSigIn(){
        driver.findElement(By.xpath("/html/body/div/div/main/div/div/div/div/form/button")).click();
    }

    public void SignIn(PersonalInfoBean personalInfoBean){
        setEmail(personalInfoBean.getEmail());
        setPass(personalInfoBean.getPassword());
        clickSigIn();
    }
}





