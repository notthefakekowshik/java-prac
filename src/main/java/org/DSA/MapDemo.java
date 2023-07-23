package org.DSA;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MapDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);
		list.stream().map(val -> val +1).forEach(val -> System.out.println(val));
		List<Integer> updatedList = list.stream().map(val -> val +1).collect(Collectors.toList());
		int val = list.stream().reduce(0, Integer::sum);
		int anotherVal = list.stream().mapToInt(Integer::intValue).sum();
		OptionalDouble vall = list.stream().mapToInt(Integer::intValue).average();
		System.out.println(vall.getAsDouble());
		
	}

}
