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
				System.out.println("메뉴 선택오류");
				System.out.println("메뉴는 1,2 또는 QUIT만 입력 가능");
				continue;
			}
				if( intMenu == 1) {
					this.inputScore();
				} else if(intMenu == 2) {
					this.printScore();
				}
				return;
		}
		System.out.println("업무 중지!");
		}
		
		public void inputScore () {
			
				System.out.println("=".repeat(50));
				System.out.println("학생이름을 입력하세요"
								+ "(입력을 중단하려면 QUIT)");
				System.out.println("=".repeat(50));
				System.out.print("이름 >> ");
				String strName = scan.nextLine();
				
				System.out.println("=".repeat(50));
				System.out.print(strName);
				System.out.println(" 학생의 성적을 입력하세요"
								+ "성적 범위 : 0~100, 입력을 중단하여면 QUIT");
				System.out.println("=".repeat(50));
				
				System.out.println("과목별 성적 입력하세요");
				Integer intkor = this.inputScore("국어");
				if(intkor == null) {
					return;
				}
				Integer inteng = this.inputScore("영어");
				if(inteng == null) {
					return;
				}
				Integer intmath = this.inputScore("수학");
				if(intmath == null) {
					return;
				}
				Integer intscie = this.inputScore("과학");
				if(intscie == null) {
					return;
				}
				Integer inthist = this.inputScore("국사");
				if(inthist == null) {
					return;
				}
				
				OneDayVO onedayVO = new OneDayVO();
				onedayVO.setStrName(strName);
				
				onedayVO.setIntKor(intkor);
				onedayVO.setIntEng(inteng);
				onedayVO.setIntMath(intmath);
				onedayVO.setIntScie(intscie);
				onedayVO.setIntHist(inthist);
				
				onedayList.add(onedayVO);
				this.scoreList(onedayVO);
				
		}
		public Integer inputScore(String subject) {
			while(true) {
				System.out.print(subject + ">> ");
				String strScore = scan.nextLine();
				if(strScore.equals("QUIT")) {
					return null;
				}
				Integer intScore = 0;
				try {
					intScore = Integer.valueOf(strScore);
				} catch (Exception e) {
					System.out.println("성적은 숫자로만 입력");
					continue;
				}
				if(intScore < 0 || intScore > 100) {
					System.out.println("0 ~ 100까지");
					continue;
				}
				return intScore;
			}
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
			

				int totalKor = 0;
				int totalEng = 0;
				int totalMath = 0;
				int totalScie = 0;
				int totalHist = 0;
				
				int allTotal = 0;
				float allAvg = 0;
				
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
				
				totalKor += odVO.getIntKor();
				totalEng += odVO.getIntEng();
				totalMath += odVO.getIntMath();
				totalScie += odVO.getIntScie();
				totalHist += odVO.getIntHist();
				
				allTotal += odVO.getTotal();
				allAvg += odVO.getFloatAvg();
			}
			System.out.println("=".repeat(50));
			System.out.print("총점\t");
			System.out.print(totalKor + "\t");
			System.out.print(totalEng + "\t");
			System.out.print(totalMath + "\t");
			System.out.print(totalScie + "\t");
			System.out.print(totalHist + "\t");
			System.out.print(allTotal + "\t");
			
			System.out.print( allAvg/onedayList.size() + "\n" );
			
			this.selecMenu();
			
		} // end
}
