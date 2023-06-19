package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

//  @Test
//  public void isHeaderElementsPresent(){
//    Assert.assertTrue(isElementPresent1(By.xpath("//h1[contains(text(),'PHONEBOOK')]")));
//    Assert.assertTrue(isElementPresent1(By.xpath("//a[.='HOME']")));
//    Assert.assertTrue(isElementPresent1(By.xpath("//a[.='ABOUT']")));
//    Assert.assertTrue(isElementPresent1(By.xpath("//a[.='LOGIN']")));
//  }

  @Test
  public void isPhonebookElementPresent(){
    Assert.assertTrue(isElementPresent1(By.xpath("//h1[contains(text(),'PHONEBOOK')]")));
  }

  @Test
  public void isHomeButtonPresent(){
    Assert.assertTrue(isElementPresent1(By.xpath("//a[.='HOME']")));
  }

  @Test
  public void isAboutButtonPresent(){
    Assert.assertTrue(isElementPresent1(By.xpath("//a[.='ABOUT']")));
  }
  @Test
  public void isLoginButtonPresent(){
    Assert.assertTrue(isElementPresent1(By.xpath("//a[.='LOGIN']")));
  }



}
