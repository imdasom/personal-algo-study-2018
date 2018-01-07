package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

	@org.junit.Test
	public void testIteratorSpeed() {
		List<String> list = new ArrayList<>();
		list.add("ONE");
		list.add("TWO");
		list.add("THREE");
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
		}
	}
	
	@org.junit.Test
	public void testForEachSpeed() {
		List<String> list = new ArrayList<>();
		list.add("ONE");
		list.add("TWO");
		list.add("THREE");
		
		for(String s : list) {
			String newS = s;
		}
	}

}
