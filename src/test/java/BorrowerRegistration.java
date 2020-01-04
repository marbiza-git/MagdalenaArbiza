import PageBeans.LoanInfoBean;
import PageBeans.PersonalInfoBean;
import Pages.LogInPage;
import Pages.NonDMFunnelPage;
import Pages.OfferPage;
import Pages.PersonalInformationPage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class BorrowerRegistration {

    private LoanInfoBean loanInfoBean;
    private PersonalInfoBean personalInfoBean;
    private String email = "candidate" + RandomStringUtils.randomNumeric(5) + "@upgrade-challenge.com";
    WebDriver driver;
    private OfferPage offerPage;

    @BeforeTest
    public void setupClass() {

        loanInfoBean = new LoanInfoBean();
        personalInfoBean = new PersonalInfoBean(email);
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Magdalena\\selenium-java-3.141.59\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void closeChromeDriver(){
        driver.quit();
    }

    @Test(description = "Upgrade_exercise")
    public void startRegistration() throws InterruptedException {

        NonDMFunnelPage nonDMFunnelPage = new NonDMFunnelPage(driver);
        nonDMFunnelPage.checkYourRate(driver, loanInfoBean);

        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver, loanInfoBean.getLoanPurpose(), loanInfoBean.getLoanAmount());
        personalInformationPage.completePI1(personalInfoBean);

        offerPage = new OfferPage(driver);

        String amount = offerPage.getLoanAmount();
        String monthlyPayment = offerPage.getMonthlyPayment();
        String loanTerm = offerPage.getLoanTerm();
        String interestRate = offerPage.getInterestRate();
        String apr = offerPage.getAPR();

        offerPage.signOut();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.SignIn(personalInfoBean);

        offerPage = new OfferPage(driver);

        Assert.assertEquals(amount, offerPage.getLoanAmount());
        Assert.assertEquals(monthlyPayment, offerPage.getMonthlyPayment());
        Assert.assertEquals(loanTerm, offerPage.getLoanTerm());
        Assert.assertEquals(interestRate, offerPage.getInterestRate());
        Assert.assertEquals(apr, offerPage.getAPR());

        LOGGER.info("All the values are the same. Working as expected.");
    }

}
