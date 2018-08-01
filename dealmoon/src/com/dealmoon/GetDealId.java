package com.dealmoon;
import org.openqa.selenium.By;

public class GetDealId extends OpenDealMoon{

	public static String getdealid() {
		// 先定位到第一个deal上  然后返回id value
		String a = driver.findElement(By.xpath("//div[contains(@data-ad-type,'deal')]")).getAttribute("id");
		/**
		if (driver.findElement(By.id(a)).findElement(By.xpath("//span[contains(@title,'取消收藏')]")) != null) {
			System.out.println(a);
		}
		*/
		return  a;
		
	};

}
