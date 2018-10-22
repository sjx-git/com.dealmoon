/**
 * 搜索功能验证
 */

package com.dealmoon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class Search extends OpenDealMoon{

	public static void SearchKeyword() {
		//定位到搜素框
		WebElement SL = driver.findElement(By.id("t_keyword"));
		SL.clear();
		//输入要搜索的关键字
        String key = Keyword.Keyword();
        System.out.println("key 的值是： "+ key);
		SL.sendKeys(key);
		//点击搜索按钮
		WebElement SS = driver.findElement(By.xpath(".//*[@id='frmSearch']/div/div"));
		SS.click();
		try {
		    Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取所要验证的文本信息
		String  validate= driver.findElement(By.xpath(".//*[@id='US']/div[2]/div/h1/a")).getText();
		System.out.println(validate);
		System.out.println("GetKeywordFromDeal.getkeyword() 的值是 "+ GetKeywordFromDeal.getkeyword());
		if (validate.equals(GetKeywordFromDeal.getkeyword())) {
			System.out.println("按关键字 ：" + key + "  --搜索成功");
		}else {
			System.out.println("按关键字 ：" + key + "  --搜索失败！" + validate);
		}
		
		
	}

}
