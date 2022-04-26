package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/sale_products/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }
    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        Thread.sleep(1000);
        mousehover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        //1.2 Mouse hover on the “Sale”  link and click
        Thread.sleep(1000);
        mousehover(By.xpath("//li[@class='leaf has-sub']//span[text()='Sale']"));
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Sale']"));
        //1.3 Verify the text “Sale”
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Sale']"));
        String expectedMessage = "Sale";
        Assert.assertEquals(expectedMessage, actualMessage);
        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mousehover(By.xpath("//span[text()='Sort by:']"));
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]"));
        Thread.sleep(300);
        //1.5 Verify that the product arrange alphabetically
        String actualMessage1 = getTextFromElement(By.xpath("//span[text()='Name A - Z']"));
        String expectedMessage1 = "Name A - Z";
        Assert.assertEquals("not navigate to page", expectedMessage1, actualMessage1);

    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {
        //2.1 Mouse hover on the “Hot deals” link
        Thread.sleep(1000);
        mousehover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        //2.2 Mouse hover on the “Sale”  link and click
        Thread.sleep(1000);
        mousehover(By.xpath("//li[@class='leaf has-sub']//span[text()='Sale']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Sale']"));
        //2.3 Verify the text “Sale”
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Sale']"));
        String expectedMessage = "Sale";
        Assert.assertEquals("not navigate to page", expectedMessage, actualMessage);
        //2.4 Mouse hover on “Sort By” and select “Price Low-High”
        mousehover(By.xpath("//span[text()='Sort by:']"));
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]"));
        Thread.sleep(300);
        //2.5 Verify that the product’s price arrange Low to High
        String actualMessage1 = getTextFromElement(By.xpath("//span[text()='Price Low - High']"));
        String expectedMessage1 = "Price Low - High";
        Assert.assertEquals("not navigate to page", expectedMessage1, actualMessage1);
    }
    @Test
    public void verifySaleProductsArrangeByRates() throws InterruptedException {
        //3.1 Mouse hover on the “Hot deals” link
        Thread.sleep(1000);
        mousehover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        //3.2 Mouse hover on the “Sale”  link and click
        Thread.sleep(1000);
        mousehover(By.xpath("//li[@class='leaf has-sub']//span[text()='Sale']"));
        Thread.sleep(300);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Sale']"));
        //3.3 Verify the text “Sale”
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Sale']"));
        String expectedMessage = "Sale";
        Assert.assertEquals("not navigate to page", expectedMessage, actualMessage);
        //3.4 Mouse hover on “Sort By” and select “Rates”
        mousehover(By.xpath("//span[text()='Sort by:']"));
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[7]/a[1]"));
        //3.5 Verify that the product’s arrange Rates
        String actualMessage1 = getTextFromElement(By.xpath("//span[text()='Rates ']"));
        String expectedMessage1 = "Rates";
        Assert.assertEquals("not navigate to page", expectedMessage1, actualMessage1);
        }
    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        Thread.sleep(1000);
        mousehover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        //1.2 Mouse hover on the “Bestsellers”  link and click
        Thread.sleep(1000);
        mousehover(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        //1.3 Verify the text “Bestsellers”
        Thread.sleep(400);
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Bestsellers']"));
        String expectedMessage = "Bestsellers";
        Assert.assertEquals("not navigate to page", expectedMessage, actualMessage);
        //1.4 Mouse hover on “Sort By” and select “Name Z-A”
        mousehover(By.xpath("//span[text()='Sort by:']"));
        Thread.sleep(600);
        clickOnElement(By.xpath("//li[@class='list-type-grid ']//a[@data-sort-by='translations.name' and @data-sort-order='desc']"));
        //1.5 Verify that the product arrange by Z to A
        String actualMessage1 = getTextFromElement(By.xpath("//span[text()='Name Z - A']"));
        String expectedMessage1 = "Name Z - A";
        Assert.assertEquals("not navigate to page", expectedMessage1, actualMessage1);

    }
    @Test
    	public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //2.1 Mouse hover on the “Hot deals” link
        Thread.sleep(1000);
        mousehover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        //2.2 Mouse hover on the “Bestsellers” link and click
        Thread.sleep(1000);
        mousehover(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        //2.3 Verify the text “Bestsellers”
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Bestsellers']"));
        String expectedMessage = "Bestsellers";
        Assert.assertEquals("not navigate to page", expectedMessage, actualMessage);
        //2.4 Mouse hover on “Sort By” and select “Price High-Low”
        mousehover(By.xpath("//span[text()='Sort by:']"));
        clickOnElement(By.xpath("//li[@class='list-type-grid ']//a[@data-sort-by='p.price' and @data-sort-order='desc']"));
        //2.5 Verify that the product’s price arrange High to Low
        String actualMessage1 = getTextFromElement(By.xpath("//span[text()='Price High - Low']"));
        String expectedMessage1 = "Price High - Low";
        Assert.assertEquals("not navigate to page", expectedMessage1, actualMessage1);

    }
    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        //3.1 Mouse hover on the “Hot deals” link
        Thread.sleep(1000);
        mousehover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        //3.2 Mouse hover on the “Bestsellers”  link and click
        Thread.sleep(1000);
        mousehover(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        Thread.sleep(400);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        //3.3 Verify the text “Bestsellers”
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Bestsellers']"));
        String expectedMessage = "Bestsellers";
        Assert.assertEquals("not navigate to page", expectedMessage, actualMessage);
        //3.4 Mouse hover on “Sort By” and select “Rates”
        mousehover(By.xpath("//span[text()='Sort by:']"));
        clickOnElement(By.xpath("//li[@class='list-type-grid ']//a[@data-sort-by='r.rating' and @data-sort-order='asc']"));
        //3.5 Verify that the product’s arrange Rates
        String actualMessage1 = getTextFromElement(By.xpath("//span[text()='Rates ']"));
        String expectedMessage1 = "Rates";
        Assert.assertEquals("not navigate to page", expectedMessage1, actualMessage1);
    }
    @After
    //Here After method for close the browser
    public void teardown() {
        closebrowser();
    }
}
