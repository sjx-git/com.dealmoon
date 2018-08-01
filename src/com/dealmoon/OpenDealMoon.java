/**
 * 打开北美主站  并做一些页面的正确性的判断
 */

package com.dealmoon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import java.util.Set;


public class OpenDealMoon {
	public static  WebDriver driver;

    public static void Open() {
		//firefox的启动方法
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        File file = new File("C:\\Users\\admin\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\phdw9qsn.default\\extensions\\firebug@software.joehewitt.com.xpi");
        FirefoxProfile profile = new FirefoxProfile();
        try {
            profile.addExtension(file);
        } catch (IOException e) {
            e.printStackTrace();
            }
         profile.setPreference("extensions.firebug.currentVersion", "2.0.19");
        //active firebug extensions
       profile.setPreference("extensions.firebug.allPagesActivation", "on");
        //ProfilesIni pi = new ProfilesIni();
		//FirefoxProfile profile = pi.getProfile("default");
       WebDriver driver = new FirefoxDriver(profile);
		WebDriver.Navigation navigation = driver.navigate();
		navigation.to("http://www.dealmoon.com/");


		//先配置本机的Chrome配置
        //System.setProperty("webdriver.chrome.marionette","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");//chromedriver服务地址
		//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
       // WebDriver driver = new ChromeDriver();
		//输入要访问的地址 北美主站
		//driver.get("http://www.dealmoon.com/");
		//窗口最大化
		driver.manage().window().maximize();
        try {
                     Thread.sleep(30000);
                 } catch (InterruptedException e) {
                      e.printStackTrace();
        }
		String a = driver.getWindowHandle();
       // System.out.print(driver.findElements(By.tagName("i")));
       Set <String> b = driver.getWindowHandles();
       System.out.print(b);
        System.out.println("sss ");
		//调用首页判断方法
       // HomeJudgement.homejudgement();
		


	}

	
}

