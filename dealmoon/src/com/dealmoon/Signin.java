package com.dealmoon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Signin extends OpenDealMoon{

	public static void signin() {		
		//清除所有cookie信息并刷新页面
		driver.manage().deleteAllCookies();
        driver.navigate().refresh();
		driver.findElement(By.id("sign_in_top")).click();
		WebElement middkle = driver.findElement(By.xpath("//iframe[contains(@src,'dealmoon')]"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(middkle);
		driver.findElement(By.id("logMail")).sendKeys("1064200847@qq.com");;
		driver.findElement(By.id("logPass")).sendKeys("123456");;
		driver.findElement(By.id("log_btn")).click();
		
		
	}

}
