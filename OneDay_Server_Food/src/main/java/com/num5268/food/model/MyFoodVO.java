package com.num5268.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodVO {
	 
		private String mf_isbn;// CHAR(6) PRIMARY KEY,
		private String mf_date;// VARCHAR2(15) NOT NULL,
		private String mf_code;// CHAR(7) NOT NULL,
		private Integer mf_intk;// NUMBER NOT NULL

}
