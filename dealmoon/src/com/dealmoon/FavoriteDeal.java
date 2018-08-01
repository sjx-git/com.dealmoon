package com.dealmoon;
import org.openqa.selenium.By;

public class FavoriteDeal extends OpenDealMoon{

	public static void favoritedeal(){
		//调用回首页
		BackHome.backhome();
		//获取当前选择的deal title 用来做最后的判断
		String favoritedeal = GetKeywordFromDeal.getkeyword();
	//调用登录方法
	Signin.signin();
	try {
		Thread.sleep(15000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	//刷新页面 以便于cookie中的 取消收藏 能显示出来
	driver.navigate().refresh();
	//点击该deal的收藏按钮
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	//判断 取消收藏 字段在页面是否可见  可见时 进入  已收藏情景
	if (JudgementPageElement.judgementpageelement()) {
		System.out.println("当前为：已经收藏的情景");
			//到我的收藏页面
			MyFavorite.myfavorite();
			//做判断：deal列表页获取的title与收藏页面获取的
				if (favoritedeal.equals(GetFavoriteDealId.getfavoritedealid())) {
					//调用取消收藏方法
					RemoveFavoriteDeal.removefavoritedeal();
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
								////做判断：deal列表页获取的title与收藏页面获取的  不一致时 说明取消功能
								if (favoritedeal.equals(GetFavoriteDealId.getfavoritedealid())== false){
									System.out.println("取消收藏成功");
								}else {								
									System.out.println("取消收藏失败："+"deal列表页获取到的--"+favoritedeal + "与收藏列表中获取到的--"+GetFavoriteDealId.getfavoritedealid()+ "仍然一致");
								}
				}else {
					System.out.println("收藏deal失败");
					System.out.println("deal列表页获取到的--    "   +favoritedeal + "      与收藏列表中获取到的--       "+   GetFavoriteDealId.getfavoritedealid()   +    "    不一致");
				}
	}else {
		System.out.println("当前为：未收藏的情景");
		driver.findElement(By.xpath(".//*[@class='mlist ']/div[2]/div[3]/s[2]/span/em[3]")).click();
			driver.navigate().refresh();
			//到我的收藏页面
			MyFavorite.myfavorite();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//做判断：deal列表页获取的title与收藏页面获取的
				if (favoritedeal.equals(GetFavoriteDealId.getfavoritedealid())) {
								System.out.println("收藏deal成功");
				}else {
					System.out.println("收藏deal失败");
					System.out.println("deal列表页获取到的--    "   +favoritedeal + "      与收藏列表中获取到的--       "+   GetFavoriteDealId.getfavoritedealid()   +    "    不一致");
				}
	}

	 
	}

}
