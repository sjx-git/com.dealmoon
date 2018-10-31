/**
 * 搜索功能验证
 */

package com.dealmoon;

import org.openqa.selenium.By;
public class Search extends OpenDealMoon{

	public static void SearchKeyword() {
		//定位到搜素框
		//WebElement SL = driver.findElement(By.id("t_keyword"));
		//SL.clear();
		//输入要搜索的关键字
        //String key = Keyword.Keyword();
        //System.out.println("key 的值是： "+ key);
		//SL.sendKeys(key);
		//点击搜索按钮
        String getkeyword = GetKeywordFromDeal.getkeyword();
		driver.findElement(By.xpath(".//*[@id='frmSearch']/div/div")).click();
		try {
		    Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取所要验证的文本信息
		String  validate= driver.findElement(By.xpath(".//*[@id='dealsList']/div[1]/div/div[2]/div/div[3]/div/span/em")).getText();
		//System.out.println(validate);
		//System.out.println("GetKeywordFromDeal.getkeyword() 的值是 "+ getkeyword);
		if (getkeyword.contains(validate)) {
			System.out.println("按关键字 ：" + getkeyword + "  --搜索成功");
		}else {
			System.out.println("按关键字 ：" + getkeyword + "  --搜索失败！" + "获取到的搜索关键字是" +validate);
		}
		
		
	}

}
