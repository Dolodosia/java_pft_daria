package pl.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class CreateContactTests extends TestBase {
    
    @Test
    public void testCreateContact() {

        addNewContact();
        fillNewContactForm(new ContactData("Jan", "Tester", "666000444", "testemnail@mail.com"));
        newContactEnd();
    }


}

