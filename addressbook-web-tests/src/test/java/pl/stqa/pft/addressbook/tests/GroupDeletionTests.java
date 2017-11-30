package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    
    @Test
    public void testGroupDeletion() {

        app.getNavigationHelper().goToGroupPage();
      int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();

        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before-1);
    }


}

