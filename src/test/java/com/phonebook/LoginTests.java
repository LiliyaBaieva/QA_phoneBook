package com.phonebook;

import com.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLoginLinkPresent()){
      app.getHeader().clickOnSignOutButton();
    }
    //click login link
    app.getHeader().clickOnLoginLink();
  }

  @Test
  public void loginPositiveTest(){
    //enter email field
    app.getUser().login();
    //assert user logged in(check Sign Out button displayed)
    Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
  }
  @Test
  public void loginNegativeWithoutPasswordTest(){
    //enter email field
    app.getUser().fillLoginRegistrationForm(new User()
        .setEmail("lilu@gmail.com"));
    //click on Registration
    app.getUser().clickOnLoginButton();
    //assert user logged in(check Sign Out button displayed)
    Assert.assertTrue(app.getUser().isAlertPresent());
  }

}
