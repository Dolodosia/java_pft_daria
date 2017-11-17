package pl.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;


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
