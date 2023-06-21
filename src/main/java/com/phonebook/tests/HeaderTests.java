package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

  @Test
  public void isPhonebookLogoPresent(){
    Assert.assertTrue(app.isPhonebookElLogoPresent());
  }

  @Test
  public void verifyIsHomeLinkPresent(){
    Assert.assertTrue(app.isHomeLinkPresent());
  }

  @Test
  public void verifyIsAboutButtonPresent(){
    Assert.assertTrue(app.isAboutButtonPresent());
  }

  @Test
  public void verifyIsLoginButtonPresent(){
    Assert.assertTrue(app.isLoginButtonPresent());
  }
}
