package com.dealmoon;

import static org.testng.Assert.assertEquals; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SigninTestNull extends Search{
	public static void SigninTestNullMailNullPass() {
		//清除所有cookie信息并刷新页面
		driver.manage().deleteAllCookies();
       driver.navigate().refresh();
		driver.findElement(By.id("sign_in_top")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//定位到所属iframe页面，切换过去，再进行定位
		WebElement middkle = driver.findElement(By.xpath("//iframe[contains(@src,'dealmoon')]"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(middkle);
		driver.findElement(By.id("logMail")).clear();
		driver.findElement(By.id("logPass")).clear();
		driver.findElement(By.id("log_btn")).click();
		String ts = driver.findElement(By.id("error")).getText();
		assertEquals(ts, "邮箱不能为空!", "提示信息不正确：");
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);\
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath(".//*[@id='loginiframe']/span")).click();		
	}
	

}
