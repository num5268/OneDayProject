package com.num5268.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.num5268.food.model.FoodDTO;
import com.num5268.food.model.MyFoodDTO;
import com.num5268.food.persistence.DBContract;
import com.num5268.food.service.FoodService;
import com.num5268.food.service.impl.FoodServiceImplV1;

import oracle.net.ano.Service;

@WebServlet("/food/*")
public class FoodController extends HttpServlet{
	
	protected Connection dbConn;
	protected FoodService fdService;

	public FoodController() {
		fdService = new FoodServiceImplV1();
		dbConn = DBContract.getDbConn();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/WEB-INF/views/food.jsp")
		.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;localhost=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String fd_fcode = req.getParameter("fd_fcode");
		List<FoodDTO> fdList = fdService.findFoodName(fd_fcode);
		req.setAttribute("FOODS", fdList);
		req.getRequestDispatcher("/WEB-INF/views/views.jsp")
		.forward(req, resp);
		PrintWriter out = resp.getWriter();
		
	}
	
	
}
