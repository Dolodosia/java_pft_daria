package pl.stqa.pft.addressbook.tests;

        import org.testng.annotations.Test;
        import pl.stqa.pft.addressbook.model.ContactData;

public class DeleteContactTest extends TestBase {

  @Test
  public void testDeleteContact() {


app.getNavigationHelper().goToHomePage();
    if(! app.getContactHelper().isThereAContact()){
           app.getContactHelper().createContact(new ContactData("xxx", "yyy", "666555666", "zadanie5@test.pl", "test1"), true);
        }

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertAccept();

  }

}

