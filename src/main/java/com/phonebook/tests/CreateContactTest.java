package com.phonebook.tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTest extends  TestBase{
  @BeforeMethod
  public void ensurePrecondition(){
    if(!app.isLoginLinkPresent()){
      app.clickOnSignOutButton();
    }
    app.clickOnLoginLink();
    app.fillLoginRegistrationForm(new User()
        .setEmail("lilu@gmail.com")
        .setPassword("$Lilu87$"));
    app.clickOnLoginButton();

  }


  @Test
  public void addContactPositiveTest(){
    //Clicl in 'ADD' for add contact
    app.clickOnAddLink();

    //field in the add contact form
    app.filAddContactForm("Olena", "Stuzuk", "0508765432", "olena@gmail.com", "Stutgart",
        "Gottestrasse 9");
    //click on the save button
    app.clickOnSaveButton();
    Assert.assertTrue(app.isContactCreated("Olena"));
  }

  @AfterMethod
  public void deleteContact(){
    List<WebElement> contacts = app.driver.findElements(By.cssSelector("h2"));
    for(WebElement element : contacts){
      if(element.getText().contains("Olena")){
        element.click();  //кликает открываеться карточка
        app.click(By.xpath("//button[.='Remove']")); // не удаляет а должно
      }
    }
  }

}
