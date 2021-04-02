package com.callor.score.model;

public class OneDayVO {
	
	protected String strName;
	
	
	protected Integer intKor;
	protected Integer intEng;
	protected Integer intMath;
	protected Integer intScie;
	protected Integer intHist;
	
	protected Integer total;
	protected Float floatAvg;
	
	
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public Integer getIntKor() {
		return intKor;
	}
	public void setIntKor(Integer intKor) {
		this.intKor = intKor;
	}
	public Integer getIntEng() {
		return intEng;
	}
	public void setIntEng(Integer intEng) {
		this.intEng = intEng;
	}
	public Integer getIntMath() {
		return intMath;
	}
	public void setIntMath(Integer intMath) {
		this.intMath = intMath;
	}
	public Integer getIntScie() {
		return intScie;
	}
	public void setIntScie(Integer intScie) {
		this.intScie = intScie;
	}
	public Integer getIntHist() {
		return intHist;
	}
	public void setIntHist(Integer intHist) {
		this.intHist = intHist;
	}
	public Integer getTotal() {
		return total = intKor + intEng+intMath+intScie+intHist;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Float getFloatAvg() {
		Integer toTal = total;
		
		Float floatAvg = (float)toTal/3;
		return floatAvg;
	}
	public void setFloatAvg(Float floatAvg) {
		this.floatAvg = floatAvg;
	}
	
	
}
