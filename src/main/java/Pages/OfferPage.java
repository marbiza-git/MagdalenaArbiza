package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OfferPage {

    private WebDriver driver;

    public OfferPage(WebDriver wb){
        driver = wb;
        driver.get("https://www.credify.tech/funnel/offer-page");
        new WebDriverWait(driver, 20).until(ExpectedConditions.urlContains("offer-page"));
    }

    public String getLoanAmount(){
        return driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/span[2]")).getText();
    }

    public String getMonthlyPayment(){
        return driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[1]/div/div/span")).getText();
    }

    public String getLoanTerm(){
        return driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[1]")).getText();
    }

    public String getInterestRate(){
        return driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[2]")).getText();
    }

    public String getAPR(){
        return driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[3]/div")).getText();
    }

    public void signOut() throws InterruptedException {
        WebDriverWait wbd = new WebDriverWait(driver, 10);

        if (wbd.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/main/div/header/div"))).isDisplayed()) {
            driver.findElement(By.xpath("/html/body/div[1]/div/main/div/header/div")).click();
            driver.switchTo().activeElement().findElement(By.xpath("/html/body/div[1]/div/main/div/header/div/nav"));
            driver.findElement(By.xpath("/html/body/div[1]/div/main/div/header/div/nav/ul/li[2]/a")).click();
        }
        wbd.until(ExpectedConditions.urlContains("logout"));
    }


}
