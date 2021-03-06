package com.num5268.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.num5268.food.model.FoodDTO;
import com.num5268.food.model.MyFoodDTO;
import com.num5268.food.persistence.DBContract;
import com.num5268.food.service.FoodService;

public class FoodServiceImplV1 implements FoodService {

	protected Connection dbConn;
	public FoodServiceImplV1() {
		dbConn = DBContract.getDbConn();
	}
	
	protected List<FoodDTO> select(PreparedStatement pStr) 
			throws SQLException{
		List<FoodDTO> fdList = new ArrayList<FoodDTO>();
		ResultSet rStr = pStr.executeQuery();
		while(rStr.next()) {
			
			FoodDTO fdVO = new FoodDTO();
			fdVO.setFd_fcode(rStr.getString("식품코드"));
			fdVO.setFd_fname(rStr.getString("식품명"));
			fdVO.setFd_num(rStr.getInt("출시년"));
			fdVO.setFd_mcode(rStr.getString("제조사코드"));
			fdVO.setFd_clcode(rStr.getString("분류코드"));
			fdVO.setFd_serv(rStr.getInt("제공량"));
			fdVO.setFd_capa(rStr.getInt("총내용량"));
			fdVO.setFd_ener(rStr.getInt("에너지"));
			fdVO.setFd_prot(rStr.getInt("단백질"));
			fdVO.setFd_fat(rStr.getInt("지방"));
			fdVO.setFd_carb(rStr.getInt("탄수화물"));
			fdVO.setFd_sug(rStr.getInt("총당류"));
			fdList.add(fdVO);
		}
		return fdList;
	}
	@Override
	public List<FoodDTO> findFoodName(String fname) {
		
		String sql = " SELECT * FROM VIEW_식품정보 ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> fdList = this.select(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<MyFoodDTO> MyFoodDate(String date) {
		String sql = " SELECT * FROM VIEW_식품정보 ";
		sql = " WHERE 식품코드 = 0 ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
