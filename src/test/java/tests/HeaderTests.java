package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

  @Test
  public void isPhonebookLogoPresent(){
    Assert.assertTrue(app.getHeader().isPhonebookElLogoPresent());
  }

  @Test
  public void verifyIsHomeLinkPresent(){
    Assert.assertTrue(app.getHeader().isHomeLinkPresent());
  }

  @Test
  public void verifyIsAboutButtonPresent(){
    Assert.assertTrue(app.getHeader().isAboutButtonPresent());
  }

  @Test
  public void verifyIsLoginButtonPresent(){
    Assert.assertTrue(app.getUser().isLoginButtonPresent());
  }

}
