package com.dealmoon;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
public class MyFavorite extends OpenDealMoon{
	public static void myfavorite() {
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.className("login_user_name"));
		//模拟鼠标放上去之后的展示效果
		 Actions builder = new Actions(driver);
	        builder.moveToElement(driver.findElement(By.className("login_user_name"))).perform();
	        builder.moveToElement(driver.findElement(By.xpath("//a[contains(@href,'favorite')]"))).click().perform();
	       String t = driver.getTitle();
	    if (t.equals("我的收藏")) {
	  
			 System.out.println("成功进入到我的收藏页面");

		}else {
			System.out.println("未成功进入到我的收藏页面");
		}


	}

}
