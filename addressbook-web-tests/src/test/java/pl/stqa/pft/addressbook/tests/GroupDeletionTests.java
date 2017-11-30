package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    
    @Test
    public void testGroupDeletion() {

        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isThereAGroup()){
          app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }

      //int before = app.getGroupHelper().getGroupCount();
      List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().deleteSelectedGroup();
        app.getGroupHelper().returnToGroupPage();

        //int after = app.getGroupHelper().getGroupCount();
      List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size()-1);
    }


}

