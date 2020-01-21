package pages;

import beans.LoanInfoBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NonDMFunnelPage {

    private static final String URL = "https://www.credify.tech/funnel/nonDMFunnel";
    private By desiredAmount = By.name("desiredAmount");
    private By dropLoanPurpose = By.cssSelector("[data-auto='dropLoanPurpose']");
    private By checkYourRate = By.cssSelector("[data-auto='CheckYourRate']");

    public NonDMFunnelPage(WebDriver driver){
        driver.get(URL);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(desiredAmount));
    }

    public void addDesiredAmount(WebDriver driver, String desAmount){
        driver.findElement(desiredAmount).sendKeys(desAmount);
    }

    public void selectLoanPurpose(WebDriver driver, String loanPurpose){
        Select drop= new Select(driver.findElement(dropLoanPurpose));
        switch (loanPurpose){
            case "CREDIT_CARD":
                drop.selectByValue("CREDIT_CARD");
                break;
            case "DEBT_CONSOLIDATION":
                drop.selectByValue("DEBT_CONSOLIDATION");
                break;
            case "SMALL_BUSINESS":
                drop.selectByValue("SMALL_BUSINESS");
                break;
            case "HOME_IMPROVEMENT":
                drop.selectByValue("HOME_IMPROVEMENT");
                break;
            case "LARGE_PURCHASE":
                drop.selectByValue("LARGE_PURCHASE");
                break;
            case "OTHER":
                drop.selectByValue("OTHER");
                break;
        }
    }

    public void submitPage(WebDriver driver){
        driver.findElement(checkYourRate).click();
    }

    public void checkYourRate(WebDriver driver, LoanInfoBean loanInfoBean){
        addDesiredAmount(driver, loanInfoBean.getLoanAmount());
        selectLoanPurpose(driver, loanInfoBean.getLoanPurpose());
        submitPage(driver);
    }
}
