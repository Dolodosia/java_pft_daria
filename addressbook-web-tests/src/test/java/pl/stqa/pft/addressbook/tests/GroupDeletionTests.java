package pl.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.GroupData;
import pl.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

//zad 17
public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().all().size()==0);{
      app.group().create(new GroupData().withName("test1"));
    }
  }


    @Test
    public void testGroupDeletion() {

      //Groups before = app.group().all();
      Groups before = app.db().groups();
      GroupData deletedGroup = before.iterator().next();
      app.group().delete(deletedGroup);

      assertThat(app.group().count(), equalTo(before.size() -1));
      //Groups after = app.group().all();
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.without(deletedGroup)));

        }



}




