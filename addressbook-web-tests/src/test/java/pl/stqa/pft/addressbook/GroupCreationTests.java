package pl.stqa.pft.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        app.goToGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("testXXX", "test2", "test3"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
