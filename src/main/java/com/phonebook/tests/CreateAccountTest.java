package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
  //precondition: user should be logged out
  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.isLoginLinkPresent()){
      app.clickOnSignOutButton();
    }
    //click login link
    app.clickOnLoginLink();
  }

  @Test
  public void existedUserRegistrationNegativeTest(){
    //enter email field
    // [placeholder='Email']
    app.fillLoginRegistrationForm(new User()
        .setEmail("lilu@gmail.com")
        .setPassword("$Lilu87$"));

    //enter password field
    // [placeholder='Password']

    //click on Registration
  // by name - registration
//    driver.findElement(By.cssSelector("registration")).click();
    app.clickOnRegistrationButton();

    //assert user logged in(check Sign Out button displayed)
    Assert.assertTrue(app.isAlertPresent());


  }

}






