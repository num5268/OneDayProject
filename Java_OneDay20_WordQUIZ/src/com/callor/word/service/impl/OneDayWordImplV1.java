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
	protected Integer point;
	protected int nCount;

	private final int 영어 = 0;
	private final int 한글 = 1;

	public OneDayWordImplV1() {

		wordList = new ArrayList<WordVO>();
		scan = new Scanner(System.in);
		rnd = new Random();
		point = 0;
		nCount = 0;

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
				System.out.println("게임 종료");
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
			} else if (intNum == 2) {
				this.loadScore();
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
			System.out.println(wordFile + "이 존재하지 않습니다");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중 문제 발생");
		}

	}

	@Override
	public void viewWord() {
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
			System.out.println(Arrays.toString(strWords));
			System.out.println("=".repeat(50));
			System.out.print(">> ");
			String strNum = scan.nextLine();

			if (strNum.equals("Quit")) {
				System.out.println("게임종료");
				break;
			}
			while (true) {

				if (strNum.equalsIgnoreCase(word.getEnglish())) {
					System.out.println("한글 뜻 :" + word.getKorea());
					this.answer();
					break;

				} else {
					int wAnswer = this.wrongAnswer();
					if (wAnswer == 1) {
						System.out.println(nCount + "번째 재도전");
						System.out.println("=".repeat(50));
						System.out.println("힌트:" + word.getKorea());
					} else if (wAnswer == 2) {
						point -= 1;
						System.out.println("=".repeat(50));
						System.out.println("현재 보유 포인트 : " + point);
						break;
					} else if (wAnswer == 3) {
						System.out.println(nCount + "번째 재도전");
						System.out.println("점수가 부족하여 힌트없이 진행");
					}
				}
			}
		}
	}

	protected void answer() {
		System.out.println("정답");
		point += 3;
		System.out.println("현재 보유 포인트 : " + point);
	}

	protected WordVO getWord() {

		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);

		WordVO wordVO = wordList.get(num);

		return wordVO;
	}

	protected Integer wrongAnswer() {
		WordVO vo = this.getWord();
		while (true) {
			nCount++;

			if (nCount > 3) {
				System.out.println("=".repeat(50));
				System.out.println("재도전 불가");
				System.out.println("=".repeat(50));
				return 2;
			}

			System.out.println("=".repeat(50));
			System.out.println("오답입니다");
			System.out.println("-".repeat(50));
			System.out.println("1. 재도전 : -1");
			System.out.println("2. 건너뛰기 : -1");
			System.out.println("-".repeat(50));
			System.out.print(">> ");
			String strNum = scan.nextLine();
			Integer intNum = Integer.valueOf(strNum);
			
			if (intNum == 1) {
				point--;
				System.out.println("현재 보유 포인트 : " + point);
				System.out.println("-".repeat(50));
				System.out.println("힌트확인시 -1포인트 차감 YES/NO");
				System.out.println("-".repeat(50));
				System.out.print(">> ");
				String hint = scan.nextLine();

				if (hint.equals("YES")) {
					if (point > 0) {
						point -= 1;
						System.out.println("현재 보유 포인트 : " + point);
						return 1;
					}
					System.out.println("포인트가 부족합니다");
				}
			} else if (intNum == 2) {
				return 2;
			}
			return 3;
		}
	}

	@Override
	public void saveWord() {
		
		while (true) {
			System.out.println("저장할 파일이름을 입력");
			System.out.print(">> ");
			String fileName = scan.nextLine();

			FileWriter fileWriter = null;
			PrintWriter out = null;

			fileName = "src/com/callor/word" + fileName;

			try {
				fileWriter = new FileWriter(fileName);
				out = new PrintWriter(fileWriter);

				out.flush();
				out.close();
			} catch (IOException e) {
				System.out.println("파일을 생성할 수 없습니다");
				System.out.println("파일 이름을 다시 입력해주세요");
				continue;
			}
			System.out.println("파일에 저장되었습니다");
			break;
		}
	}

	public Integer loadScore() {
		while (true) {
			System.out.println("저장했던 파일의 이름을 입력해주세요");
			System.out.print(">> ");
			String scanFile = scan.nextLine();
			String fileName = "src/com/callor/word/" + scanFile;

			FileReader fileReader = null;
			BufferedReader buffer = null;
			Integer intScore = null;

			try {
				fileReader = new FileReader(fileName);
				buffer = new BufferedReader(fileReader);

				String reader = new String();
				while ((reader = buffer.readLine()) == null) {
					intScore = Integer.valueOf(reader);
				}
				buffer.close();
			} catch (FileNotFoundException e) {
				System.out.println(fileName + "이 존재하지 않습니다");
				continue;
			} catch (IOException e) {
				System.out.println("파일을 불러오는 중 문제가 발생하였습니다");
				continue;
			}
			return intScore;
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
