package pl.stqa.pft.addressbook.model;

public class ContactData {

  //ok
  private int id;
  private String firstname;
  private String lastname;
  private String phone;
  private String email;
  private String group;
  private String address;

  //ok
  public ContactData(String firstname, String lastname, String phone, String email, String group, String address) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phone = phone;
    this.email = email;
    this.group = group;
    this.address= address;
  }

  //ok
  public ContactData(int id, String firstname, String lastname, String phone, String email, String group, String address) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phone = phone;
    this.email = email;
    this.group = group;
    this.address = address;
  }

  //ok
  public int getId() { return id; }

  //ok
  public void setId(int id) {
    this.id = id;
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

  public String getGroup() {
    return group;
  }

  public String getAddress() {
    return address;
  }


  @Override
   public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         ContactData that = (ContactData) o;

         if (id != that.id) return false;
         if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
         return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
       }


           @Override
   public int hashCode() {
         int result = id;
         result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
         result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
         return result;
       }


           @Override
   public String toString() {
         return "ContactData{" +
                         "id=" + id +
                         ", firstname='" + firstname + '\'' +
                         ", lastname='" + lastname + '\'' +
                         '}';
       }




}
