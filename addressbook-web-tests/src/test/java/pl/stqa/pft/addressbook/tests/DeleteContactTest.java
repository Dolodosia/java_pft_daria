package pl.stqa.pft.addressbook.tests;

        import org.testng.Assert;
        import org.testng.annotations.Test;
        import pl.stqa.pft.addressbook.model.ContactData;

        import java.util.List;

public class DeleteContactTest extends TestBase {

  @Test
  public void testDeleteContact() {

    //int before = app.getContactHelper().getContactCount();

    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("ddd", "ttttt", "666999111", "ooo@ccc.pl", "test1"), true);
    }


    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAccept();




  }

}

