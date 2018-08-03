package com.dealmoon;

import org.openqa.selenium.By;

public class GetFavoriteDealId  extends OpenDealMoon{

	public static String getfavoritedealid(){
		// 定位将要判断的deal，并返回相关title
		//String favoritetitile = driver.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[1]/a")).getText();
		
		String favoritetitile = driver.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/div[2]/div/div[1]")).getAttribute("dataid");
		System.out.println(favoritetitile);
		System.out.println("ddd");
		return favoritetitile;
	}

}
