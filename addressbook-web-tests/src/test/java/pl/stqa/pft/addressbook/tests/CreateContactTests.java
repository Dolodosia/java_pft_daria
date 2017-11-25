package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class CreateContactTests extends TestBase {
    
    @Test
    public void testCreateContact() {

        app.getContactHelper().goToContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Firefox", "zadanie7", "666555666", "zadanie5@test.pl"));
        app.getContactHelper().goToHomePage();

    }


}

