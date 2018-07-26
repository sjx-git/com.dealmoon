package com.dealmoon;
public class Keyword extends OpenDealMoon {
	public static  String Keyword() {		
				//先将title以 空格分开  在按下标获取到所要进行搜索的关键词
				String[] title1 = GetKeywordFromDeal.getkeyword().split(" ");
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

}
