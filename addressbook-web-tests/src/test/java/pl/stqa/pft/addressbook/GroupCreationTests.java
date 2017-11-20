package pl.stqa.pft.addressbook;

import org.testng.annotations.Test;

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
