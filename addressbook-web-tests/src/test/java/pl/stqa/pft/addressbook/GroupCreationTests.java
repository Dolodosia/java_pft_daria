package pl.stqa.pft.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class GroupCreationTests {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        //wd = new FirefoxDriver();
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));

        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.get("http://localhost/addressbook/addressbook/");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test
    public void testGroupCreation() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("new group1", "test 1", "test 2"));
        submitGroupCreation();
        returnToGroupPage();
    }

    private void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    private void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    private void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    private void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    private void goToGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}