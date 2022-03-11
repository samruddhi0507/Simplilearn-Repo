package com.manish.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login 
{
    public static void main( String[] args )
    {
      
    	WebDriver d = new ChromeDriver();
    	d.manage().window().maximize();
    	d.get("http://localhost/Login%20Page/login.php");
    	d.findElement(By.id("username")).sendKeys("man");
    	d.findElement(By.id("pass")).sendKeys("man123");
    	d.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/h2[2]/form/button")).click();
 	
	
    }
}
