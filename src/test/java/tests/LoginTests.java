package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

//  public static void clickOnRemoveButton() {
//    app.click(By.xpath("//button[.='Remove']"));
//  }
//
//  public static void clickOnCotactName(String name) {
//    List<WebElement> contacts = app.driver.findElements(By.cssSelector("h2"));
//    for(WebElement element : contacts){
//      if(element.getText().contains(name)){
//        element.click();
//      }
//    }
//  }

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
    app.getUser().fillLoginRegistrationForm(new User()
        .setEmail("lilu@gmail.com")
        .setPassword("$Lilu87$"));
    //click on Registration
    app.getUser().clickOnLoginButton();
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

//  @AfterMethod
//  public void deleteContact(){
//    LoginTests.clickOnCotactName("Olena");
//    LoginTests.clickOnRemoveButton();
//  }
}
