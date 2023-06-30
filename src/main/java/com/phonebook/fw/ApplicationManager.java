package com.phonebook.fw;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {

  String browser;
  WebDriver driver;

  UserHelper user;
  ContactHelper contact;
  HeaderHelper header;
  HomePageHelper homepage;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public UserHelper getUser() {
    return user;
  }

  public ContactHelper getContact() {
    return contact;
  }

  public HeaderHelper getHeader() {
    return header;
  }

  public HomePageHelper getHomepage() {
    return homepage;
  }

  public void init() {

    if(browser.equalsIgnoreCase("chrome")){
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equalsIgnoreCase("edge")){
      EdgeOptions options = new EdgeOptions();
      options.addArguments("remote-allow-origins=*");
      driver = new EdgeDriver(options);
    }

    driver.get("https://telranedu.web.app/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    user = new UserHelper(driver);
    contact = new ContactHelper(driver);
    header = new HeaderHelper(driver);
    homepage = new HomePageHelper(driver);
  }

  public void stop() {
    driver.quit();
  }

}
