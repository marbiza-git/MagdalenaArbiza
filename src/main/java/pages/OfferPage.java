package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPage {

    private static final String URL = "https://www.credify.tech/funnel/offer-page";
    private By loanAmount = By.cssSelector("[data-auto='userLoanAmount']");
    private By monthlyPay = By.cssSelector("[data-auto='defaultMonthlyPayment']");
    private By loanTerm = By.cssSelector("[data-auto='defaultLoanTerm']");
    private By interestRate = By.cssSelector("[data-auto='defaultLoanInterestRate']");
    private By apr = By.cssSelector("[data-auto='defaultMoreInfoAPR']");
    private By menu = By.xpath("/html/body/div[1]/div/main/div/header/div");
    private By navMenu = By.cssSelector("[class='header-nav-menu']");
    private By signOut = By.xpath("/html/body/div[1]/div/main/div/header/div/nav/ul/li[2]/a");
    private WebDriver driver;

    public OfferPage(WebDriver wb){
        driver = wb;
        driver.get(URL);
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("offer-page"));
    }

    public String getLoanAmount(){
        return driver.findElement(loanAmount).getText();
    }

    public String getMonthlyPayment(){
        return driver.findElement(monthlyPay).getText();
    }

    public String getLoanTerm(){
        return driver.findElement(loanTerm).getText();
    }

    public String getInterestRate(){ return driver.findElement(interestRate).getText(); }

    public String getAPR(){ return driver.findElement(apr).getText(); }

    public void signOut() throws InterruptedException {
        WebDriverWait wbd = new WebDriverWait(driver, 10);

        if (wbd.until(ExpectedConditions.elementToBeClickable(menu)).isDisplayed()) {
            driver.findElement(menu).click();
            driver.switchTo().activeElement().findElement(navMenu);
            driver.findElement(signOut).click();
        }
        wbd.until(ExpectedConditions.urlContains("logout"));
    }
}