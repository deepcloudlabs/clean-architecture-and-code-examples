package com.example;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.utils.NumberUtils;

public class SearchableNames {
	
	public List<Integer> getNumbers(){
		return new Random().ints(1,100)
				           //.filter(even)
				           .filter(NumberUtils::isEven)
				           .distinct()
				           .limit(10)
				           .sorted()
				           .boxed()
				           .collect(Collectors.toList());
				
	}
}
