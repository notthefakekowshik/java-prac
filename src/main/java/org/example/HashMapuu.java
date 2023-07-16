package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HashMapuu implements Runnable {

	public static void main(String[] args) {
		Thread t1 = new Thread();
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1,"kowshik");
		hm.put(2,"elon");
		System.out.println(hm.entrySet());
		for(Entry<Integer, String> currhm : hm.entrySet()) {
			System.out.println(currhm.getKey() + "->" + currhm.getValue());
		}
		List<Entry<Integer, String>> answer = hm.entrySet().stream().collect(Collectors.toList());
		System.out.println(answer);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
