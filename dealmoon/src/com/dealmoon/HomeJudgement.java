package com.dealmoon;
/**进行首页的判定
 * 
 */
import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;

public class HomeJudgement extends OpenDealMoon {

	public static void homejudgement() {
        /**
         * //定位有问题
         *         try {
         *             Thread.sleep(30000);
         *         } catch (InterruptedException e) {
         *             e.printStackTrace();
         *         }
         */


		//获取当前访问的url链接
        System.out.print(driver.getCurrentUrl());
		String url = driver.getCurrentUrl();
		//获取当前访问的url title 
		String title = driver.getTitle();
		//做判断 
		if (url.equals("http://cn.dealmoon.com/")) {
			assertEquals(title,"北美省钱快报 - 美国网购指南 - 24小时滚动更新美国商家折扣信息");
			System.out.println("国内镜像站");
		}else if(url.equals("http://www.dealmoon.com/")) {
			assertEquals(title, "Online Shopping Promotions - The Latest Coupons & Promo Codes - Dealmoon.com");
			System.out.println("国外镜像站");
		}

	}

}
