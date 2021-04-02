package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.score.model.OneDayVO;

public class OneDayServiceV1 {
	
	protected Scanner scan;
	protected List<OneDayVO> onedayList;
	
	public OneDayServiceV1() {
		scan = new Scanner(System.in);
		onedayList = new ArrayList<OneDayVO>();
	}
	public void selecMenu () {
		
		while(true) {
			System.out.println("=".repeat(40));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(40));
			
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(40));
			System.out.print("업무선택 >> ");
			String strMenu = scan.nextLine();
			System.out.println();
			
			if (strMenu.equals("QUIT")) {
				break;
			}
		
			Integer intMenu = null;
			
			try {
				intMenu = Integer.valueOf(strMenu);
			} catch (Exception e) {
				continue;
			}
			
				if( intMenu == 1) {
					this.input();
				} else if(intMenu == 2) {
					this.printScore();
				}
		}
		System.out.println("업무 중지!");
		}
		public void input () {
			while (true) {
				System.out.println("=".repeat(50));
				System.out.println("학생이름을 입력하세요"
								+ "(입력을 중단하려면 QUIT)");
				System.out.println("=".repeat(50));
				System.out.print("이름 >> ");
				String strName = scan.nextLine();
				if(strName.equals("QUIT")) {
					return;
				}
				
				OneDayVO onedayVO = new OneDayVO();
				onedayVO.setStrName(strName);
				this.inputScore(onedayVO);
				return;
			}
			
			
		}
		
		public void inputScore (OneDayVO vo) {
			
				System.out.println("=".repeat(50));
				System.out.print(vo.getStrName());
				System.out.println(" 학생의 성적을 입력하세요"
								+ "성적 범위 : 0~100, 입력을 중단하여면 QUIT");
				System.out.println("=".repeat(50));
				
				
				System.out.print("국어 >> ");
				Integer intKor = scan.nextInt();
				System.out.print("영어 >> ");
				Integer intEng = scan.nextInt();
				System.out.print("수학 >> ");
				Integer intMath = scan.nextInt();
				System.out.print("과학 >> ");
				Integer intScie = scan.nextInt();
				System.out.print("국사 >> ");
				Integer intHist = scan.nextInt();
				
				OneDayVO onedayVO = new OneDayVO();
				
				onedayVO.setIntKor(intKor);
				onedayVO.setIntEng(intEng);
				onedayVO.setIntMath(intMath);
				onedayVO.setIntScie(intScie);
				onedayVO.setIntHist(intHist);
				
				onedayList.add(onedayVO);
				this.scoreList(onedayVO);
			
		}
		public void scoreList(OneDayVO vo) {
			
			System.out.println("=".repeat(50));
			System.out.print(vo.getStrName());
			System.out.println("학생의 성적이 추가 되었습니다");
			System.out.println("=".repeat(50));
			
			System.out.println("국어 : "+vo.getIntKor());
			System.out.println("영어 : "+vo.getIntEng());
			System.out.println("수학 : "+vo.getIntMath());
			System.out.println("과학 : "+vo.getIntScie());
			System.out.println("국사 : "+vo.getIntHist());
			
			this.selecMenu();
			
		}
		public void printScore () {
			System.out.println("=".repeat(60));
			System.out.print("이름\t국어\t영어\t수학\t"
							+ "과학\t국사\t총점\t평균\n");
			System.out.println("-".repeat(60));
			
			for(int i = 0 ;i <onedayList.size(); i++) {
				OneDayVO odVO = onedayList.get(i);
				
				System.out.print(odVO.getStrName()+"\t");
				System.out.print(odVO.getIntKor()+"\t");
				System.out.print(odVO.getIntEng()+"\t");
				System.out.print(odVO.getIntMath()+"\t");
				System.out.print(odVO.getIntScie()+"\t");
				System.out.print(odVO.getIntHist()+"\t");
				System.out.print(odVO.getTotal()+"\t");
				System.out.printf("%3.2f\n",odVO.getFloatAvg());
				
				
			}
			this.selecMenu();
		}
}
