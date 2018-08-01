package com.dealmoon;

import org.openqa.selenium.By;

public class RemoveFavoriteDeal  extends OpenDealMoon{

	public static void removefavoritedeal() {
		// 定位到要取消收藏的deal 并取消收藏
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[2]/div[2]/a")).click();
		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//点击 弹出框的   确定按钮
		driver.findElement(By.xpath(".//*[@id='J_WinpopBox']/div[3]/div[2]/input[2]")).click();;
		

	}

}
