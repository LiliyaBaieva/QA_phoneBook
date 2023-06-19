package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
  //precondition: user should be logged out
  @BeforeMethod
  public void ensurePrecondition(){
    if(!isElementPresent(By.xpath("//a[.='LOGIN']"))){
      click(By.xpath("//button[.='Sign Out']"));
    }
    //click login link
    click(By.xpath("//a[.='LOGIN']"));
  }

  @Test
  public void existedUserRegistrationNegativeTest(){
    //enter email field
    // [placeholder='Email']
    type(By.cssSelector("[placeholder='Email']"), "pushok88@gmail.com");

    //enter password field
    // [placeholder='Password']
    type(By.cssSelector("[placeholder='Password']"), "~Puh-1okkkkk~");

    //click on Registration
  // by name - registration
//    driver.findElement(By.cssSelector("registration")).click();
    click(By.cssSelector("registration"));

    //assert user logged in(check Sign Out button displayed)
    Assert.assertTrue(isAlertPresent());


  }


}






