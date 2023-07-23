package org.DSA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.remove(list.indexOf(20));
		Iterator<Integer> listIt = list.iterator();
		while(listIt.hasNext()){
			System.out.println(listIt.hasNext());
		}
		//System.out.println(list);
	}

}