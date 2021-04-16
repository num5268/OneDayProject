package com.callor.word.model;

public class WordVO {
	
	private String english;
	private String Korea;
	private String count;
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKorea() {
		return Korea;
	}
	public void setKorea(String korea) {
		Korea = korea;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "WordVO [영어=" + english + 
				", 국어=" + Korea + 
				", 점수=" + count + "]";
	}
	
	
	

}
