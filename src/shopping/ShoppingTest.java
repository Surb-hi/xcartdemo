package shopping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.sql.Timestamp;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mousehover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
         //1.2 Mouse hover on the “Bestsellers”  link and click
        mousehover(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        Thread.sleep(200);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        //1.3 Verify the text “Bestsellers”
        String expectedresult1 = "Bestsellers";
        String actualresult1 = getTextFromElement(By.xpath("//h1[text()='Bestsellers']"));
        Assert.assertEquals(actualresult1, expectedresult1);
        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mousehover(By.xpath("//span[contains(text(),'Sort by:')]"));
        Thread.sleep(300);
        clickOnElement(By.xpath("//li[@class='list-type-grid ']//a[@data-sort-by='translations.name' and @data-sort-order='asc']"));
        Thread.sleep(200);
        //1.5 Click on “Add to cart” button of the product “Ollie - The App Controlled Robot”
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[2]/div[4]/div[1]/button[1]/span[1]"));
        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        String expectedresult2 = "Product has been added to your cart";
        String actualresult2 = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals(actualresult2, expectedresult2);
        // 1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));
        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        //1.9 Verify the text “Your shopping cart - 1 item”
        String expectedresult3 = "Your shopping cart - 1 item";
        String actualresult3 = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 1 item']"));
        Assert.assertEquals(actualresult3, expectedresult3);
        //1.10 Verify the Subtotal $299.00
        String actualMessage5_1 = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[1]"));
        String actualMessage5_3 = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[3]"));
        String actualMessage5_2 = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[2]"));
        String actualMessage5_4 = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[4]"));
        String actualMessage3 = actualMessage5_1 + actualMessage5_2 + actualMessage5_3 + actualMessage5_4; // Combining price to single string
        String expectedMessage3 = "$299.00";
        Assert.assertEquals(expectedMessage3, actualMessage3);
        //1.11 Verify the total $309.73
        String actualMessage6_1 = getTextFromElement(By.xpath("//li[@class='total']//span/span[@class='surcharge-cell']/span[@class ='part-prefix']"));
        String actualMessage6_2 = getTextFromElement(By.xpath("//li[@class='total']//span/span[@class='surcharge-cell']/span[@class ='part-integer']"));
        String actualMessage6_3 = getTextFromElement(By.xpath("//li[@class='total']//span/span[@class='surcharge-cell']/span[@class ='part-decimalDelimiter']"));
        String actualMessage6_4 = getTextFromElement(By.xpath("//li[@class='total']//span/span[@class='surcharge-cell']/span[@class ='part-decimal']"));
        String actualMessage4 = actualMessage6_1 + actualMessage6_2 + actualMessage6_3 + actualMessage6_4;// Combining price to single string
        String expectedMessage4 = "$309.73";
        Assert.assertEquals(expectedMessage4, actualMessage4);

        //1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//button[@class='btn  regular-button regular-main-button checkout']"));
        //1.13 Verify the text “No account yet?”
        String actualMessage5 = getTextFromElement(By.xpath("//h3[text()='Log in to your account']"));
        String expectedMessage5 = "Log in to your account";
        Assert.assertEquals( expectedMessage5, actualMessage5);

        // 1.14 Enter Email address
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String emailAddress = "ram"+timestamp.getTime()+"@domain.com";

        sendTextToElement(By.xpath("//input[@id='email']"), emailAddress);
        //1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));
        //1.16 Verify the text “Secure Checkout”
        String expectedresult7 = "Secure Checkout";
        String actualresult7 = getTextFromElement(By.xpath("//h1[contains(text(),'Secure Checkout')]"));
        Assert.assertEquals(actualresult7, expectedresult7);
        // 1.17 Fill all the mandatory fields
        //Shipping address
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"),"prime");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"),"patel");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"),"lee street");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-city']"),"leictsetr");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='shippingaddress-country-code']"),"United Kingdom");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"),"east-middlan");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"),"990099");
        sendTextToElement(By.xpath("//input[@id='email']"),"prime123@gmail.com");
        //1.18 Check the check box “Create an account for later use”
        clickOnElement(By.xpath("input[@id='create_profile']"));
        // 1.19 Enter the password
        sendTextToElement(By.xpath("//input[@name='password']"), "PassPassword0123");
        Thread.sleep(800);
        //1.20 Select the Delivery Method to “Local Shipping”
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='method128']"), "Local shipping");
        //1.21 Select Payment Method “COD”
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='pmethod6']"),"COD" );
        //1.22 Verify the total $311.00
        String expectedresult8 = "$311.03";
        String actualresult8 = getTextFromElement(By.linkText("311.03"));
        Assert.assertEquals(actualresult8, expectedresult8);
        //1.23 Click on “Place Order” Button
        clickOnElement(By.xpath("//span[contains(text(),'Place order: $311.03')]"));
        //1.24 Verify the text “Thank you for your order”
        String expectedresult9 = "Thank you for your order";
        String actualresult9 = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals(actualresult9, expectedresult9);
    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        // 1.1 Mouse hover on the “Hot deals”link
        mousehover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        // 1.2 Mouse hover on the “Bestseller”link and click
        mousehover(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        Thread.sleep(300);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        //1.3 Verify the text “Bestsellers”
        String expectedresult1 = "Bestsellers";
        String actualresult1 = getTextFromElement(By.xpath("//h1[text()='Bestsellers']"));
        Assert.assertEquals(actualresult1, expectedresult1);
        //1.4 Mouse hover on “Sort By”and select “Name A -Z”
        mousehover(By.xpath("//span[contains(text(),'Sort by:')]"));
        //1.5 Click on “Add to cart”button of the product “Vinyl Idolz:Ghostbusters”
        Thread.sleep(1000);
        mousehover(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]/div[1]/div[1]/a[1]/img[1]"));
        Thread.sleep(400);
        clickOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]/div[1]/div[2]/div[4]/div[1]/button[1]"));
        //1.6 Verify the message “Product has been added to your cart”display in green bar
        String expectedresult2 = "Product has been added to your cart";
        String actualresult2 = getTextFromElement(By.xpath("Product has been added to your cart"));
        Assert.assertEquals(actualresult2, expectedresult2);
        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));
        // 1.8 Click on “Your cart”icon and Click on “View cart”button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        // 1.9 Verify the text “Your shopping cart - 1 item”
        String expectedresult3 = "Your shopping cart - 1 item";
        String actualresult3 = getTextFromElement(By.linkText("Your shopping cart - 1 item"));
        Assert.assertEquals(actualresult3, expectedresult3);
        // 1.10 Click on “Empty your cart”link
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        //1.11 Verify the text “Are you sure you want to clear your cart ?”on alert
        String expectedresult4 = "Are you sure you want to clear your cart ?";
        String actualresult4 = alertText();
        Assert.assertEquals(actualresult4, expectedresult4);
        //1.12 Click “Ok”on alert
        alertHandle();
        Thread.sleep(1000);
        //1.13 Verify the message “Item(s) deleted from your cart”
        String expectedresult5 = "Item(s) deleted from your cart";
        String actualresult5 = getTextFromElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals(actualresult5, expectedresult5);
        //1.15 Verify the text “Your cart is empty”
        String expectedresult6 = "Your cart is empty";
        String actualresult6 = getTextFromElement(By.xpath("/h1[text()='Your cart is empty']"));
        Assert.assertEquals(actualresult6, expectedresult6);
    }
@Test
    @After
    //Here After method for close the browser
    public void teardown() {
        //closebrowser();
    }
}
