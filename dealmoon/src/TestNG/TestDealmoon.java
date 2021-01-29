package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
public class TestDealmoon {
	  public static WebDriver driver;
	  @Test public static void Open() {
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
    @Test(priority = 6,enabled = true)
				  public static void Search() {
        String getkeyword = getkeyword();
        System.out.println(getkeyword);
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

	  @Test(priority =5,enabled = true)
      public static  String Keyword() {
          //先将title以 空格分开  在按下标获取到所要进行搜索的关键词
          String[] title1 = getkeyword().split(" ");
          String keyword1 = title1[title1.length-1];
          //判断获取到的词是否包含逗号
          if (keyword1.contains("，")) {
              //用逗号将这个词分开 取最后一组关键词
              String[] keyword2 = keyword1.split("，");
              String keyword = keyword2[keyword2.length-1];
              //System.out.println(keyword);
              //判断时候包含折
              if (keyword.contains("折")) {
                  //将折字去掉
                  String keyword3 = keyword.replaceAll("折", "");
                  //System.out.println("keyword3" +keyword3);
                  return keyword3;
              }else {
                  //System.out.println("keyword" +keyword);
                  return keyword;
              }
          }else
          {	//判断时候包含折
              if (keyword1.contains("折")) {
                  //将折字去掉
                  String keyword4 = keyword1.replaceAll("折", "");
                  //System.out.println("keyword4" +keyword4);
                  return keyword4;

              }
              else{
                  //System.out.println("keyword1" +keyword1);
                  return keyword1;
              }
          }



      }

    @Test(priority = 4,enabled = true)
      public static String getkeyword() {
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          //先定位相关位置，然后获取其对应的title
          // Actions actions = new Actions(driver);
          //actions.click(driver.findElement(By.xpath(".//*[@id='t_keyword']")).getAttribute("placeholder"));
          String text = driver.findElement(By.xpath(".//*[@id='t_keyword']")).getAttribute("placeholder");

          System.out.println(text);
          //将获取到的title打印 用来debug
          //String conent = text.toString();
          //System.out.println(conent);
          return  text;

      }

	  @Test(priority = 1,enabled = true)
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
	  @Test(priority = 2,enabled = true)
					public static void signin() {		
						//清除所有cookie信息并刷新页面
						driver.manage().deleteAllCookies();
						driver.navigate().refresh();
						driver.findElement(By.id("sign_in_top")).click();
						WebElement middkle = driver.findElement(By.xpath("//iframe[contains(@src,'dealmoon')]"));
						driver.switchTo().defaultContent();
						driver.switchTo().frame(middkle);
						driver.findElement(By.id("logMail")).sendKeys("1064200847@qq.com");;
						driver.findElement(By.id("logPass")).sendKeys("sjx96282464");;
						driver.findElement(By.id("log_btn")).click();	
						}
	  @Test(priority = 3,dependsOnMethods = {"signin"},enabled = true)
	  					public static void MyFavorite() {
							driver.switchTo().defaultContent();
							try {
								Thread.sleep(1000);
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

        public static void now() {
	      System.out.println("开始测试");
      }
    @AfterClass
				  public static void AfterClass(){
					  System.out.println("该类测试完毕");
				  }
  @BeforeSuite
							public static void BeforeSuite(){System.out.println("准备工作完毕！");}
  @AfterSuite
						  public void Quit() {System.out.println("测试完毕！");driver.quit();}
}

