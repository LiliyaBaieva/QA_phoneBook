package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

  @Test
  public void openHomePageTest(){
//    System.out.println("Home component is " + isHomeComponentPresent1());
    Assert.assertTrue(app.getHomepage().isHomeComponentPresent());
  }


}
