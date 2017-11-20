package pl.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("new group1", "test 1", "test 2"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
