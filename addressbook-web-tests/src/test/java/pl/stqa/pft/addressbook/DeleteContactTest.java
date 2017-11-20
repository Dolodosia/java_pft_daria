package pl.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class DeleteContactTest extends TestBase {
    
    @Test
    public void testDeleteContact() {

        app.clickSelectedContactToDelete();
        //exp
        //selectContact();

        app.deleteContact();

        //exp
        //deleteContact1();
    }


}

