package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTest extends  TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getHeader().isLoginLinkPresent()) {
      app.getHeader().clickOnSignOutButton();
    }
    app.getHeader().clickOnLoginLink();
    app.getUser().fillLoginRegistrationForm(new User()
        .setEmail("lilu@gmail.com")
        .setPassword("$Lilu87$"));
    app.getUser().clickOnLoginButton();

  }


  @Test
  public void addContactPositiveTest() {
    //Clicl in 'ADD' for add contact
    app.getHeader().clickOnAddLink();

    //field in the add contact form
    app.getContact().filAddContactForm(new Contact()
            .setName("Olena")
            .setSecondName("Stuzuk")
            .setPhone("0508765432")
            .setEmail("olena@gmail.com")
            .setAddress("Stutgart")
            .setDescription("Gottestrasse 9"));
    //click on the save button
    app.getContact().clickOnSaveButton();
    Assert.assertTrue(app.getContact().isContactCreated("Olena"));
  }

  @AfterMethod
  public void removeContact() {
//    CreateContactTest.clickOnCotactName("Olena");
//    CreateContactTest.clickOnRemoveButton();
    app.getContact().removeContact();
  }

  //ALTERNATIVE
//  @AfterMethod
//  public void deleteContact(){
//    CreateAccountTest.clickOnCotactName("Olena");
//    CreateAccountTest.clickOnRemoveButton();
//  }
}
