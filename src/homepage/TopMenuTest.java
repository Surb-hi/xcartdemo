package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/contact_us/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {
        //Click on the “Shipping” link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Shipping']"));
        //Verify the text “Shipping
        Thread.sleep(1000);
        String expectedresult = "Home";
        String actualresult = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[1]"));
        Assert.assertEquals(actualresult, expectedresult);
    }

    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        //2.1 Click on the “New!” link
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]/a[1]"));
        //2.2 Verify the text “New arrivals”
        Thread.sleep(1000);
        String expectedresult = "New arrivals";
        String actualresult = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(actualresult, expectedresult);
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException {
        //3.1 Click on the “Coming soon” link
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[5]/a[1]/span[1]"));
        //3.2 Verify the text “Coming soon
        Thread.sleep(1000);
        String expectedresult = "Coming soon";
        String actualresult = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(actualresult, expectedresult);
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException {
        //4.1 Click on the “Contact us” link
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[1]/div[1]/div[4]/div[1]/ul[1]/li[6]/a[1]"));
        //4.2 Verify the text “Contact us”
        Thread.sleep(1000);
        String expectedresult = "Contact us";
        String actualresult = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(actualresult, expectedresult);
    }

    @After
    //Here After method for close the browser
    public void teardown() {
        closebrowser();
    }

}