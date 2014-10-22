package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*******************************************************************************
 * 版权信息：博睿宏远科技发展有限公司 Copyright: Copyright (c) 2014 博睿宏远科技发展有限公司,Inc.All Rights
 * Reserved. BidPlanStructForm.java Created on 2014-8-21 Author: <a
 * href=mailto:wanghd@bonree.com>王厚达</a>
 * 
 * @Title: Test.java
 * @Package NettyDemo.util Description: Version: 1.0
 ******************************************************************************/
public class Test {
	public static void main(String[] args) {
		List<String> a=new ArrayList<String>();
		List<String> b=new ArrayList<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		b.add("D");
		b.add("E");
		b.add("C");
		
		Set<String> set = new HashSet<String>();

		set.addAll(a);
		set.retainAll(b);
		for(String str:set){
			System.out.println(str);
		}
	}

	public <T> List<T> union(List<T> list1, List<T> list2) {
		Set<T> set = new HashSet<T>();

		set.addAll(list1);
		set.addAll(list2);

		return new ArrayList<T>(set);
	}
}
