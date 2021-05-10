package com.num5268.food.service;

import java.util.List;

import com.num5268.food.model.FoodVO;
import com.num5268.food.model.MyFoodVO;

public interface FoodService {
	
	
	public List<FoodVO> findFoodName(String fname);
	
	public List<MyFoodVO> MyFoodDate(String date);
	
	

}
