package com.callor.word;

import com.callor.word.service.WordService;
import com.callor.word.service.impl.OneDayWordImplV1;

public class WordEx_01 {
	
	public static void main(String[] args) {
		
		WordService wService = new OneDayWordImplV1();
		wService.selecMenu();
		
	}

}
