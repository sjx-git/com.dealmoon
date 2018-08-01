/**
 * 搜索功能验证
 */

package com.dealmoon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.dealmoon.Keyword;
public class Search extends OpenDealMoon{

	public static void SearchKeyword() {
		//定位到搜素框
		WebElement SL = driver.findElement(By.id("t_keyword"));
		SL.clear();
		//输入要搜索的关键字
		SL.sendKeys(Keyword.Keyword());
		//点击搜索按钮
		WebElement SS = driver.findElement(By.className("icon-search-top"));
		SS.click();
		
		//获取所要验证的文本信息
		String  validate= driver.findElement(By.xpath(".//*[@class='mlist ']/div[2]/div[1]/div/h2")).getText();
		
		if (validate.equals(GetKeywordFromDeal.getkeyword())) {
			System.out.println("按关键字 ：" + Keyword.Keyword() + "  --搜索成功");
		}else {
			System.out.println("按关键字 ：" + Keyword.Keyword() + "  --搜索失败！" + validate);
		}
		
		
	}

}
