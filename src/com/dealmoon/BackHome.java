package com.dealmoon;

import org.openqa.selenium.By;

public class BackHome  extends OpenDealMoon{

	public static void backhome() {
		try {
			Thread.sleep(17000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//返回首页
		driver.findElement(By.xpath("html/body/header/nav/ul/li[1]/a")).click();
		//检查是否为首页
		HomeJudgement.homejudgement();
	}

}
