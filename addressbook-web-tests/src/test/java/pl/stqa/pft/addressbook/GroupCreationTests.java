package pl.stqa.pft.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("testXXX", "test2", "test3"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
