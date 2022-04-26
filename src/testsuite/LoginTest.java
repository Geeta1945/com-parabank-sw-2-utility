package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;

public class LoginTest extends Utility {

@Before

    public void loadMyUrl(){
    loadUrl();

}
/*
1.userShouldLoginSuccessfullyWithValidCredentials
			* Enter valid username
			* Enter valid password
			* Click on ‘LOGIN’ button
			* Verify the ‘Accounts Overview’ text is display
 */
@Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

// there is some error message come for this website
    //entering valid credentials and checking for  ‘Accounts Overview’ text is displayed or not

    sendTextToElement(By.name("username"),"JinatAman1");
   sendTextToElement(By.name("password"),"Jinat1234");
   clickOnElement(By.xpath("//input[@value='Log In']"));
// over here website having internal error and thats why cant get text -"Accounts Overview"
    Assert.assertEquals("Accounts Overview",getTextFromElement(By.xpath("//h1[text()='Accounts Overview']")));

}

/*
2.verifyTheErrorMessage
			* Enter invalid username
			* Enter invalid password
			* Click on Login button
			* Verify the error message ‘The username and password could not be verified.’
 */

    @Test //problem
// Whichever wrong username and password entered for this login , it always ALLOWING TO LOGIN.
// I am not sure why and because of that reason this test fails as system allowing to login wil INVALID ID as well
    public void verifyTheErrorMessage(){

        sendTextToElement(By.name("username"),"JosephSmith90");
        sendTextToElement(By.name("password"),"Mypassword123");

        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        String actualMessage =driver.findElement(By.xpath("//h1[text()='The username and password could not be verified.']")).getText();
        Assert.assertEquals("The username and password could not be verified.",actualMessage);

    }
    /*3.userShouldLogOutSuccessfully
     * Enter valid username
     * Enter valid password
     * Click on ‘LOGIN’ button
     * Click on ‘Log Out’ link
     * Verify the text ‘Customer Login’
      */

    @Test //done
    public void userShouldLogOutSuccessfully(){

        sendTextToElement(By.name("username"),"JinatAman1");
       sendTextToElement(By.name("password"),"Jinat1234");
       clickOnElement(By.xpath("//input[@value='Log In']"));

       clickOnElement(By.xpath("//a[@href='/parabank/logout.htm']"));

       Assert.assertEquals("Customer Login",getTextFromElement(By.xpath("//h2[text()='Customer Login']")));

    }


@After

    public void closeUrl(){

   quitAllUrl();
}

}
