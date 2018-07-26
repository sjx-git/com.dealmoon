package TestNG;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class TestDealmoon {
	  public static WebDriver driver;
	  @Test(priority = 6,enabled = false)
				  public static void SearchKeyword() {
						//定位到搜素框
						WebElement SL = driver.findElement(By.id("t_keyword"));
						SL.clear();
						//输入要搜索的关键字
						SL.sendKeys(Keyword());
						//点击搜索按钮
						WebElement SS = driver.findElement(By.className("icon-search-top"));
						SS.click();						
						//获取所要验证的文本信息
						String  validate= driver.findElement(By.xpath(".//*[@class='mlist ']/div[2]/div[1]/div/h2/a/span[2]")).getText();
						if (validate.equals(getkeyword())) {
							System.out.println("按关键字 ：" + Keyword() + "  --搜索成功");
							driver.quit();
						}else {
							System.out.println("按关键字 ：" + Keyword() + "  --搜索失败！");
						}					
					}
	  @Test(priority =5,enabled = false)
				  public static  String Keyword() {		
						//先将title以 空格分开  在按下标获取到所要进行搜索的关键词
						String[] title1 = getkeyword().split(" ");
						String keyword = title1[title1.length-1];
						//System.out.println(keyword);
						return keyword;		
	  				}
	  @Test(priority = 4,enabled = false)
				  public static String getkeyword() {
						//先定位相关位置，然后获取其对应的title
						String text = driver.findElement(By.xpath(".//*[@class='mlist ']/div[2]/div[1]/div/h2/a/span[2]")).getText();
						//将获取到的title打印 用来debug
						//String conent = text.toString();
						//system.out.println(conent);
						return  text; 		
					}
	  @Test(priority = 1,enabled = false)
					public static void SigninTestNullMailNullPass() {
						//清除所有cookie信息并刷新页面
						driver.manage().deleteAllCookies();
				        driver.navigate().refresh();
						driver.findElement(By.id("sign_in_top")).click();
						//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						//定位到所属iframe页面，切换过去，再进行定位
						WebElement middkle = driver.findElement(By.xpath("//iframe[contains(@src,'dealmoon')]"));
						driver.switchTo().defaultContent();
						driver.switchTo().frame(middkle);
						driver.findElement(By.id("logMail")).clear();
						driver.findElement(By.id("logPass")).clear();
						driver.findElement(By.id("log_btn")).click();
						String ts = driver.findElement(By.id("error")).getText();
						assertEquals(ts, "邮箱不能为空!", "提示信息不正确：");
						//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);\
						driver.switchTo().defaultContent();
						driver.findElement(By.xpath(".//*[@id='loginiframe']/span")).click();		
					}
	  @Test(priority = 2,enabled = false)
					public static void signin() {		
						//清除所有cookie信息并刷新页面
						driver.manage().deleteAllCookies();
						driver.navigate().refresh();
						driver.findElement(By.id("sign_in_top")).click();
						WebElement middkle = driver.findElement(By.xpath("//iframe[contains(@src,'dealmoon')]"));
						driver.switchTo().defaultContent();
						driver.switchTo().frame(middkle);
						driver.findElement(By.id("logMail")).sendKeys("1064200847@qq.com");;
						driver.findElement(By.id("logPass")).sendKeys("123456");;
						driver.findElement(By.id("log_btn")).click();	
						}
	  @Test(priority = 3,dependsOnMethods = {"signin"},enabled = false)
	  					public static void MyFavorite() {
							driver.switchTo().defaultContent();
							try {
								Thread.sleep(15000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							driver.findElement(By.className("login_user_name"));
							//模拟鼠标放上去之后的展示效果
							 Actions builder = new Actions(driver);
						        builder.moveToElement(driver.findElement(By.className("login_user_name"))).perform();
						        builder.moveToElement(driver.findElement(By.xpath("//a[contains(@href,'favorite')]"))).click().perform();;
						    String t = driver.getTitle();
						    if (t.equals("我的收藏")) {
								Reporter.log("成功进入到我的收藏页面");
							}else {
								Reporter.log("未成功进入到我的收藏页面");
							}
						}
	  @BeforeClass
	  					public static void Open() {
						//先配置本机的firefox配置
						ProfilesIni pi = new ProfilesIni();
						FirefoxProfile profile = pi.getProfile("default");
						// 打开firefox浏览器		
						driver = new FirefoxDriver(profile);
						//输入要访问的地址 北美主站
						driver.navigate().to("http://www.dealmoon.com/");
						//driver.get("http://www.dealmoon.com/");
						//窗口最大化
						driver.manage().window().maximize();
						//driver.findElement(By.xpath("html/body/header/div[1]/div[2]/div[1]/a"));
						//获取当前访问的url链接
						String url = driver.getCurrentUrl();
						//获取当前访问的url title 
						String title = driver.getTitle();
						//做判断 
						if (url.equals("http://cn.dealmoon.com/")) {
							assertEquals(title,"北美省钱快报 - 美国网购指南 - 24小时滚动更新美国商家折扣信息");
							Reporter.log("国内镜像站");
						}else if(url.equals("http://www.dealmoon.com/")) {
							assertEquals(title, "Online Shopping Promotions - The Latest Coupons & Promo Codes - Dealmoon.com");
							Reporter.log("国外镜像站");
						}
					}
	  @AfterClass
				  public static void AfterClass(){
					  System.out.println("该类测试完毕");
				  }
	  @BeforeSuite
							public static void BeforeSuite(){System.out.println("开始测试");}
	  @AfterSuite
						  public void Quit() {System.out.println("测试完毕");driver.quit();}
}

