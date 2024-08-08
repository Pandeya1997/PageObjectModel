package com.thetestingacadmey.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestVWOLogin {
   @Test
    public void testVWOLogin(){
      WebDriver driver = new EdgeDriver();
      driver.get("https://app.vwo.com");
       System.out.println(driver.getTitle());
       Assert.assertEquals(driver.getTitle(),"Login - VWO");
       Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
       WebElement freeTrialLink = driver.findElement(By.partialLinkText("Start a free"));
       freeTrialLink.click();

       WebElement enterEmail = driver.findElement(By.id("page-v1-step1-email"));
       enterEmail.sendKeys("admin@admin.com");


       WebElement gdprConsentCheckbox = driver.findElement(By.name("gdpr_consent_checkbox"));
       gdprConsentCheckbox.click();

       List<WebElement> buttonList = driver.findElements(By.tagName("button"));
       buttonList.get(0).click();
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }

       WebElement error_msg_email_exist = driver.findElement(By.className("invalid-reason"));
       System.out.println(error_msg_email_exist.getText());

       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }
       driver.quit();
    }

}
