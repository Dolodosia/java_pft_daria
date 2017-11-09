package pl.stqa.pft.addressbook;

public class ContactGroupData {
  private final String firstname;
  private final String lastname;
  private final String phone;
  private final String email;

  public ContactGroupData(String firstname, String lastname, String phone, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.phone = phone;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }
}
