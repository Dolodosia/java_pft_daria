package pl.stqa.pft.addressbook.tests;

        import org.testng.Assert;
        import org.testng.annotations.Test;
        import pl.stqa.pft.addressbook.model.ContactData;
        import java.util.List;

public class DeleteContactTest extends TestBase {

  @Test (enabled = false)
  public void testDeleteContact() {


    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("ddd", "ttttt", "666999111", "ooo@ccc.pl", "test1", "ulica"), true);
    }

    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectContact((before.size()- 1));
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAccept();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size() , before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }

}

