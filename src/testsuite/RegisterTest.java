package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends Utility {

    @Before

    public void parasoftUrl() {
        loadUrl();
    }

    /*
    1.verifyThatSigningUpPageDisplay
		* click on the ‘Register’ link
		* Verify the text ‘Signing up is easy!’
     */
    @Test

    public void verifyThatSigningUpPageDisplay() {

        driver.findElement(By.linkText("Register")).click(); // finding register tab and clicking on it
        System.out.println(driver.findElement(By.xpath("//h1[text()='Signing up is easy!']")));
        Assert.assertEquals("Signing up is easy!", driver.findElement(By.xpath("//h1[text()='Signing up is easy!']")).getText());
        // Text() function is selenium webdriver's build in function which is used to locate elements based on text of a web element.

    }

    /*
    2.userSholdRegisterAccountSuccessfully
			* click on the ‘Register’ link
			* Enter First name
			* Enter Last name
			* Enter Address
			* Enter City
			* Enter State
			* Enter Zip Code
			* Enter Phone
			* Enter SSN
			* Enter Username
			* Enter Password
			* Enter Confirm
			* Click on REGISTER button
			* Verify the text 'Your account was created successfully. You are now logged in.’
     */
    @Test
// JosephSmith25 registered
    public void userShouldRegisterAccountSuccessfully() {
        clickOnElement(By.linkText("Register"));// finding register tab and clicking on it

        // Finding all the elements and entering details to register
        sendTextToElement(By.xpath("//input[@id='customer.firstName']"), "MyFirstname");
        sendTextToElement(By.xpath("//input[@name='customer.lastName']"), "lastname");
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "14,my street");
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"), "my city");
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "state");
        sendTextToElement(By.xpath("//input[@name='customer.address.zipCode']"), "ha2 0py");

        sendTextToElement(By.xpath("//input[@name='customer.phoneNumber']"), "1234567890");

        sendTextToElement(By.xpath("//input[@name='customer.ssn']"), "m734k00");
        sendTextToElement(By.xpath("//input[@name='customer.username']"), "JosephSmith26");
        sendTextToElement(By.xpath("//input[@id='customer.password']"), "MyPassword123");
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"), "MyPassword123");

        clickOnElement(By.xpath("//input[@value='Register']"));

        // verifying text "Verify the text 'Your account was created successfully. You are now logged in."

        Assert.assertEquals("Your account was created successfully. You are now logged in.", getTextFromElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")));
    }

    @After

    public void closeUrl() {

        quitAllUrl();
    }


}
