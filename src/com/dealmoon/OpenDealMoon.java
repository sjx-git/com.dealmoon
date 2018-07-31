/**
 * 打开北美主站  并做一些页面的正确性的判断
 */

package com.dealmoon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class OpenDealMoon {
	public static  WebDriver driver;

    public static void Open() {
		//firefox的启动方法

		System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		ProfilesIni pi = new ProfilesIni();
		FirefoxProfile profile = pi.getProfile("default");
		WebDriver.Navigation navigation = driver.navigate();
		driver.navigate().to("http://www.dealmoon.com/");


		//先配置本机的Chrome配置
        //System.setProperty("webdriver.chrome.marionette","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");//chromedriver服务地址
		//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
       // WebDriver driver = new ChromeDriver();
		//输入要访问的地址 北美主站
		//driver.get("http://www.dealmoon.com/");
		//窗口最大化
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("html/body/header/div[1]/div[2]/div[1]/a"));
		//调用首页判断方法
		HomeJudgement.homejudgement();
		


	}

	
}

