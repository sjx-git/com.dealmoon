package com.dealmoon;

import org.openqa.selenium.By;

public class GetKeywordFromDeal extends OpenDealMoon{

	public static String getkeyword() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//先定位相关位置，然后获取其对应的title
		String text = driver.findElement(By.xpath(".//*[@class='mlist ']/div[2]/div[1]/div/h2/a/span[1]/span")).getText();
		//将获取到的title打印 用来debug
		//String conent = text.toString();
		//system.out.println(conent);
		return  text; 

	}

}