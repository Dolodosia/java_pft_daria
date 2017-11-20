package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    

    
    @Test
    public void testGroupDeletion() {

        app.goToGroupPage();
        //selectdeletedgroup();

        //tak powinno byc...?
        app.selectGroup();
        app.deleteSelectedGroup();
        app.returnToGroupPage();

    }


}

