package pages;

import beans.PersonalInfoBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PersonalInformationPage {

    private static final String PARSEURL = "https://www.credify.tech/funnel/personal-information-1/";
    private By borrowerFirstName = By.cssSelector("[name='borrowerFirstName']");
    private By borrowerLastName = By.cssSelector("[name='borrowerLastName']");
    private By borrowerStreet = By.cssSelector("[name='borrowerStreet']");
    private By optionStreet = By.cssSelector("[class='geosuggest__item__matched-text']");
    private By borrowerCity = By.cssSelector("[name='borrowerCity']");
    private By borrowerState = By.cssSelector("[name='borrowerState']");
    private By borrowerZip = By.cssSelector("[name='borrowerZipCode']");
    private By borrowerDOB = By.cssSelector("[name='borrowerDateOfBirth']");
    private By borrowerIncome = By.cssSelector("[name='borrowerIncome']");
    private By borrowerAdIncome = By.cssSelector("[name='borrowerAdditionalIncome']");
    private By borrowerEmail = By.cssSelector("[name='username']");
    private By borrowerPassword = By.cssSelector("[name='password']");
    private By continuePersonalInfo = By.cssSelector("[data-auto='continuePersonalInfo']");
    private By borrowerAgreements = By.xpath("//*[@id='root']/div/main/div/div[1]/div[2]/div[1]/div/div/form/div[2]/div/label/div[1]");
    private By submit = By.cssSelector("[data-auto='submitPersonalInfo']");
    private WebDriver driver;

    public PersonalInformationPage (WebDriver wb, String purpose, String amount){
        driver = wb;
        String url = PARSEURL + purpose + "/" + amount + "?step=contact";
        driver.get(url);
    }
    
    public void setFirstName(String fname){
        driver.findElement(borrowerFirstName).sendKeys(fname);
    }

    public void setLastName(String lname){
        driver.findElement(borrowerLastName).sendKeys(lname);
    }

    public void setBorrowerStreet(String street) throws InterruptedException {
        driver.findElement(borrowerStreet).sendKeys(street);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(optionStreet).click();
    }

    public void setBorrowerCity(String city){
        driver.findElement(borrowerCity).sendKeys(city);
    }

    public void setBorrowerState(String state){
        driver.findElement(borrowerState).sendKeys(state);
    }

    public void setBorrowerZipCode(String zipCode){
        driver.findElement(borrowerZip).sendKeys(zipCode);
    }

    public void setBorrowerIncome(String income){
        driver.findElement(borrowerIncome).sendKeys(income);
        clickContinuePI1();
    }

    public void setBorrowerAdditionalIncome(String adIncome){
        driver.findElement(borrowerAdIncome).sendKeys(adIncome);
        clickContinuePI1();
    }

    public void setEmail(String emailAccount){
        driver.findElement(borrowerEmail).sendKeys(emailAccount);
    }

    public void setPassword(String pass){
        driver.findElement(borrowerPassword).sendKeys(pass);
    }

    public void acceptAgreements(){
        driver.findElement(borrowerAgreements).click();
    }

    public void setBorrowerDOB(String dob){
        driver.findElement(borrowerDOB).sendKeys(dob); }

    public void clickContinuePI1(){
        driver.findElement(continuePersonalInfo).click();
    }

    public void submitPI1(){
        driver.findElement(submit).click();
    }

    public void completePI1(PersonalInfoBean personalInfoBean) throws InterruptedException {
        setFirstName(personalInfoBean.getFname());
        setLastName(personalInfoBean.getLname());
        setBorrowerStreet(personalInfoBean.getStreet());
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