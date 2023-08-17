package org.DSA;



class Person{
	private final int age;
	private final String name;
	Person(int age ,String name){
		this.age = age;
		this.name = name;
	}

	public int getAge(){
		return this.age;
	}

	public String getName(){
		return this.name;
	}
	
}

public class RecordDemo {

	public static void main(String[] args) {
		Person kowshik = new Person(22,"kwoshik");
		PersonRecord kowshikRecord = new PersonRecord(22,"kowshikRecord");
		System.out.println(kowshik.getAge());
		System.out.println(kowshikRecord.age());
	}

}
