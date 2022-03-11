package com.manish.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

	public static void main(String[] args) {
		
		WebDriver d = new ChromeDriver();
    	d.manage().window().maximize();
    	d.get("http://localhost/Login%20Page/login.php");
    	d.findElement(By.id("regname")).sendKeys("man");
    	d.findElement(By.id("password")).sendKeys("man123");
    	d.findElement(By.id("email")).sendKeys("man123@gmail.com");
    	d.findElement(By.id("phno")).sendKeys("7529638412");
    	d.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/h2[2]/form/button")).click();

	}

}
