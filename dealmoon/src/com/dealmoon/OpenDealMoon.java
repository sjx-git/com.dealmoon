/**
 * 打开北美主站  并做一些页面的正确性的判断
 */

package com.dealmoon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenDealMoon {
	public static  WebDriver driver ;
    public static void Open() {
		/**firefox的启动方法
       // System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //公司的firebug配置地址
       // File file = new File("C:\\Users\\admin\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\phdw9qsn.default\\extensions\\firebug@software.joehewitt.com.xpi");
       //家里的firefox配置地址
        //File file = new File("C:\\Users\\sjx\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\a1wpiqpa.default\\extensions\\firebug@software.joehewitt.com.xpi");
       // FirefoxProfile profile = new FirefoxProfile();
        try {
            profile.addExtension(file);
        } catch (IOException e) {
            e.printStackTrace();
            }
         profile.setPreference("extensions.firebug.currentVersion", "2..19");
        //active firebug extensions
       profile.setPreference("extensions.firebug.allPagesActivation", "on");
        //ProfilesIni pi = new ProfilesIni();
		//FirefoxProfile profile = pi.getProfile("default");
       WebDriver driver = new FirefoxDriver(profile);
		WebDriver.Navigation navigation = driver.navigate();
		navigation.to("http://www.dealmoon.com/");
        **/

		//先配置本机的Chrome配置
        System.setProperty("webdriver.chrome.marionette","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");//chromedriver服务地址
		System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
		//输入要访问的地址 北美主站
		driver.get("http://www.dealmoon.com/");
		//窗口最大化
		driver.manage().window().maximize();
        try {
                     Thread.sleep(1);
                 } catch (InterruptedException e) {
                      e.printStackTrace();
        }
        //获取当前窗口的句柄
		String a = driver.getWindowHandle();
        //System.out.println("当前的窗口句柄为： "+ a);
       // System.out.print(driver.findElements(By.tagName("i")));
        //获取所有窗口的句柄
       //Set <String> b = driver.getWindowHandles();
       //System.out.println("所有的的窗口句柄为："+ b);
        driver.switchTo().window(a);
		//调用首页判断方法
      //HomeJudgement.homejudgement();
		


	}

	
}

