package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

  // ???
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
//  } ???

  //precondition: user should be logged out
  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.getHeader().isLoginLinkPresent()){
      app.getHeader().clickOnSignOutButton();
    }
    //click login link
    app.getHeader().clickOnLoginLink();
  }

  @Test(priority = 1)
  public void loginPositiveTest(){
    app.getUser().fillLoginRegistrationForm(new User()
        .setEmail("lilu@gmail.com")
        .setPassword("$Lilu87$"));
    app.getUser().clickOnLoginButton();
    Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
  }

  @Test(priority = 2)
  public void existedUserRegistrationNegativeTest(){
    //enter email field
    // [placeholder='Email']
    app.getUser().fillLoginRegistrationForm(new User()
        .setEmail("lilu@gmail.com")
        .setPassword("$Lilu87$"));

    //enter password field
    // [placeholder='Password']

    //click on Registration
  // by name - registration
//    driver.findElement(By.cssSelector("registration")).click();
    app.getUser().clickOnRegistrationButton();

    //assert user logged in(check Sign Out button displayed)
    Assert.assertTrue(app.getUser().isAlertPresent());


  }


}






