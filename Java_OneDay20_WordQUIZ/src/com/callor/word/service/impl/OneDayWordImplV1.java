package com.callor.word.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.WordVO;
import com.callor.word.service.WordService;

public class OneDayWordImplV1 implements WordService {

	protected List<WordVO> wordList;
	protected Scanner scan;
	protected Random rnd;

	private final int 영어 = 0;
	private final int 한글 = 1;
	private final int 점수 = 2;

	public OneDayWordImplV1() {

		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
		rnd = new Random();

		this.loadWord();
	}

	@Override
	public void selecMenu() {
		while (true) {
			System.out.println("1. 게임 시작");
			System.out.println("2. 게임 불러오기");
			System.out.println("3. 게임 저장");
			System.out.println("QUIT:그만하기");
			System.out.print(">> ");
			String strNum = scan.nextLine();

			if (strNum.equals("QUIT")) {
				System.out.println("종료");
			}
			Integer intNum = null;
			try {
				intNum = Integer.valueOf(strNum);
			} catch (NumberFormatException e) {
				System.out.println("숫자나 QUIT만");
				continue;
			}
			if (intNum == 1) {
				this.viewWord();
			} else if (intNum == 2){
				
			} else if (intNum == 3) {
				this.saveWord();
			}
		}
	}

	@Override
	public void loadWord() {

		String wordFile = "src/com/callor/word/word.txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(wordFile);
			buffer = new BufferedReader(fileReader);

			String reader;
			while (true) {
				reader = buffer.readLine();
				if (reader == null) {
					break;
				}

				String words[] = reader.split(":");

				WordVO wordVO = new WordVO();
				wordVO.setEnglish(words[영어]);
				wordVO.setKorea(words[한글]);
				wordList.add(wordVO);
			}
			buffer.close();

		} catch (FileNotFoundException e) {
			System.out.println("ㅁㄴㅇㅁㄴㅇ");
		} catch (IOException e) {
			System.out.println("asdasdasd");
		}

	}

	@Override
	public void viewWord() {

		int plusPoint = 0;
		int minusPoint = 0;
		while (true) {
			WordVO word = this.getWord();
			String strEng = word.getEnglish();

			String[] strWords = strEng.split("");

			for (int i = 0; i < 1000; i++) {
				int index1 = rnd.nextInt(strWords.length);
				int index2 = rnd.nextInt(strWords.length);

				String temp = strWords[index1];
				strWords[index1] = strWords[index2];
				strWords[index2] = temp;
			}

			System.out.println("=".repeat(50));
			System.out.println(word.toString());
			System.out.println("제시된 영단어를 바르게 배열하시오(Quit:게임 종료)");
			System.out.println("건너뛰기 : Pass");
			System.out.println(Arrays.toString(strWords));
			System.out.println("=".repeat(50));
			System.out.print(">> ");
			String strNum = scan.nextLine();

			if (strNum.equals("Quit")) {
				System.out.println("게임종료");
				break;
			}
			int nCount = 0;
			int scorePoint = 0;
			String pass = strNum;
			while(true) {
				if (pass.equals("Pass")) {
					minusPoint--;
					scorePoint += minusPoint;
					System.out.println("현재 점수 : " + scorePoint);
					continue;
				}

				if (strNum.equalsIgnoreCase(word.getEnglish())) {
					System.out.println("한글 뜻 :" + word.getKorea());
					scorePoint += plusPoint++;
					System.out.println("현재 점수 : " + scorePoint);

				} else if (strNum != word.getEnglish()) {

					System.out.println("틀렸습니다");
					System.out.println("힌트 : " + word.getKorea());
					continue;
				}

			}
			
		}
	}

	protected WordVO getWord() {
		rnd.nextInt(100);
		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);

		WordVO wordVO = wordList.get(num);

		return wordVO;
	}
	
	@Override
	public void saveWord() {
		String fileName = null;
		while(true) {
			System.out.println("저장할 파일이름을 입력");
			System.out.print(">> ");
			fileName = scan.nextLine();
			if(fileName.equals("")) {
				System.out.println("파일이름을 입력하시오");
				continue;
			}
			break;
		}
		String strFileName = "src/com/callor/word" + fileName;
		
		FileWriter fileWriter = null;
		PrintWriter out = null;
		
		try {
			fileWriter = new FileWriter(strFileName);
			out = new PrintWriter(fileWriter);
			
			out.flush();
			out.close();
		} catch (IOException e) {
		}
				
	}

	@Override
	public void scoreWord() {
		
	}

	@Override
	public void insertWord() {

	}

	@Override
	public void printWord() {
		// TODO Auto-generated method stub

	}

}
