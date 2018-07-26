package com.dealmoon;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class JudgementPageElement  extends OpenDealMoon{
	//检查页面是否有 取消收藏 字段
	public static boolean judgementpageelement() { 
        try { 
              driver.findElement(By.id(GetDealId.getdealid())).findElement(By.xpath("//span[contains(@title,'取消收藏')]")); 
             // System.out.println("true" +GetDealId.getdealid());
              return true; 
        } catch (NoSuchElementException e) { 
        	//System.out.println("false"+GetDealId.getdealid());
              return false; 
        } 
    }

}
