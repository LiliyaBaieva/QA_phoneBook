package com.phonebook;

import com.phonebook.fw.DataProviders;
import com.phonebook.model.Contact;
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
    app.getUser().login();

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
    app.getContact().clickOnSaveButton();
    Assert.assertTrue(app.getContact().isContactCreated("Olena"));
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "addContactFromCsvFile")
  public void addContactFromCsvPositiveTest(Contact contact) {
    app.getHeader().clickOnAddLink();
    app.getContact().filAddContactForm(contact);
    app.getContact().clickOnSaveButton();
  }

  @Test (dataProviderClass = DataProviders.class, dataProvider = "addContactFromCsvFileNegative")
  public void addContactFromCsvNegativeTest(Contact contact){
    app.getHeader().clickOnAddLink();
    app.getContact().filAddContactForm(contact);
    app.getContact().clickOnSaveButton();
  }

  @AfterMethod
  public void postCondition() {
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
