package Pages;

import PageBeans.PersonalInfoBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PersonalInformationPage {

    private WebDriver driver;

    public PersonalInformationPage (WebDriver wb, String purpose, String amount){
        driver = wb;
        String url = "https://www.credify.tech/funnel/personal-information-1/"
                + purpose + "/" + amount + "?step=contact";
        driver.get(url);
    }
    
    public void setFirstName(String fname){
        driver.findElement(By.name("borrowerFirstName")).sendKeys(fname);
    }

    public void setLastName(String lname){
        driver.findElement(By.name("borrowerLastName")).sendKeys(lname);
    }

    public void setBorrowerStreet(String street) throws InterruptedException {
        driver.findElement(By.name("borrowerStreet")).sendKeys(street);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[1]/div[2]/div/div/div/div/div/div/div[2]/ul/li[2]/span/b")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setBorrowerCity(String city){
        driver.findElement(By.name("borrowerCity")).sendKeys(city);
    }

    public void setBorrowerState(String state){
        driver.findElement(By.name("borrowerState")).sendKeys(state);
    }

    public void setBorrowerZipCode(String zipCode){
        driver.findElement(By.name("borrowerZipCode")).sendKeys(zipCode);
    }

    public void setBorrowerIncome(String income){
        driver.findElement(By.name("borrowerIncome")).sendKeys(income);
        driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/button"));
    }

    public void setBorrowerAdditionalIncome(String adIncome){
        driver.findElement(By.name("borrowerAdditionalIncome")).sendKeys(adIncome);
        driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/button")).click();
    }

    public void setEmail(String emailAccount){
        driver.findElement(By.name("username")).sendKeys(emailAccount);
    }

    public void setPassword(String pass){
        driver.findElement(By.name("password")).sendKeys(pass);
    }

    public void acceptAgreements(){
        driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div/label/div[1]")).click();
    }

    public void setBorrowerDOB(String dob){
        driver.findElement(By.name("borrowerDateOfBirth")).sendKeys(dob); }

    public void clickContinuePI1(){
        driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/button")).click();
    }

    public void submitPI1(){
        driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[3]/button")).click();
    }

    public void completePI1(PersonalInfoBean personalInfoBean) throws InterruptedException {
        //selectIsJointApp(isJoint);
        setFirstName(personalInfoBean.getFname());
        setLastName(personalInfoBean.getLname());
        setBorrowerStreet(personalInfoBean.getStreet());
        setBorrowerZipCode(personalInfoBean.getZip());
        setBorrowerDOB(personalInfoBean.getDobMonth() + personalInfoBean.getDobDay() + personalInfoBean.getDobYear());
        clickContinuePI1();
        setBorrowerIncome(personalInfoBean.getIncome());
        if(!personalInfoBean.getAddIncome().equals("0"))
            setBorrowerAdditionalIncome(personalInfoBean.getAddIncome());
        clickContinuePI1();
        setEmail(personalInfoBean.getEmail());
        setPassword(personalInfoBean.getPassword());
        acceptAgreements();
        submitPI1();
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("offer-page"));    }
}
