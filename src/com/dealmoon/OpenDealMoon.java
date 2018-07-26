/**
 * 打开北美主站  并做一些页面的正确性的判断
 */

package com.dealmoon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class OpenDealMoon {
	public static  WebDriver driver;

    public static void Open() {

		//先配置本机的Chrome配置
        //System.setProperty("webdriver.chrome.marionette","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");//chromedriver服务地址
		//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		// 打开firefox浏览器
		//输入要访问的地址 北美主站
		//driver.navigate().to("http://www.dealmoon.com/");
		driver.get("http://www.dealmoon.com/");
		//窗口最大化
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("html/body/header/div[1]/div[2]/div[1]/a"));
		//调用首页判断方法
		HomeJudgement.homejudgement();
		


	}

	
}

