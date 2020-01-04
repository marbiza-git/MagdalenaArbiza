package Pages;

import PageBeans.LoanInfoBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class NonDMFunnelPage {

    @FindBy(name="desiredAmount")
    private WebElement desiredAmount;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/div/select")
    private WebElement dropLoanPurpose;

    @FindBy(xpath = "/html/body/div[1]/div/main/div/div/div/div/div[2]/div[2]/form/div/div/div[3]/button")
    private WebElement checkYourRate;

    public NonDMFunnelPage(WebDriver driver){
        driver.get("https://www.credify.tech/funnel/nonDMFunnel");
    }

    public void addDesiredAmount(WebDriver driver, String desAmount){
        driver.findElement(By.name("desiredAmount")).sendKeys(desAmount);
    }

    public void selectLoanPurpose(WebDriver driver, String loanPurpose){
        Select drop= new Select(driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/div/select")));
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
        checkYourRate = driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div/div/div/div[2]/div[2]/form/div/div/div[3]/button"));
        checkYourRate.click();
    }

    public void checkYourRate(WebDriver driver, LoanInfoBean loanInfoBean){
        addDesiredAmount(driver, loanInfoBean.getLoanAmount());
        selectLoanPurpose(driver, loanInfoBean.getLoanPurpose());
        submitPage(driver);
    }
}
