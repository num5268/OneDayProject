package com.num5268.food.service;

import java.util.List;

import com.num5268.food.model.FoodDTO;
import com.num5268.food.model.MyFoodDTO;

public interface FoodService {
	
	
	public List<FoodDTO> findFoodName(String fname);
	
	public List<MyFoodDTO> MyFoodDate(String date);
	
	

}
