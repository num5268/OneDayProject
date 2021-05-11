package com.num5268.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
	
	private String fd_fcode;//	CHAR(7)		PRIMARY KEY,
	private String fd_fname;//	nVARCHAR2(50)	NOT NULL,	
    private Integer fd_num;//	NUMBER	NOT NULL	,
    private String fd_mcode;//	CHAR(6)	NOT NULL,	
    private String fd_clcode;//	CHAR(4)	NOT NULL,	
    private Integer fd_serv;//	NUMBER	NOT NULL	,
    private Integer fd_capa;//	NUMBER	NOT NULL	,
    private Integer fd_ener;//	NUMBER	NOT NULL	,
    private Integer fd_prot;//	NUMBER	NOT NULL	,
    private Integer fd_fat;//	NUMBER	NOT NULL	,
    private Integer fd_carb;//	NUMBER	NOT NULL	,
    private Integer fd_sug;//	NUMBER	NOT NULL	

}
