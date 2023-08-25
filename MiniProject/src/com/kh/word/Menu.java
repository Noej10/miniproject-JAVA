package com.kh.word;

import java.util.Scanner;
//
public class Menu {
	private WordController wc;
	private Scanner sc;
	
	public Menu() {
		wc = new WordController();
		sc = new Scanner(System.in);
	}
	
	public void wordMenu() {
		boolean isLoop=true;
		
		while(isLoop) {
		
			System.out.println("======= 단 어 장 =======");
			System.out.println("1. 단어 추가");
			System.out.println("2. 단어 삭제");
			System.out.println("3. 단어 수정");
			System.out.println("4. 단어 검색");
			System.out.println("5. 단어 전체 보기");
			System.out.println("6. 단어 퀴즈");
			System.out.println("9. 로그아웃");
			System.out.print("메뉴 번호 : ");
			
			switch(sc.nextInt()) {
				case 1:{
					addMenu();
				}break;
				case 2:{
					removeMenu();
				}break;
				case 3:{
					changeMenu();
				}break;
				case 4:{
					searchMenu();
				}break;
				case 5:{
					wc.showAllWord();
				}break;
				case 6:{
					quizMenu();
				}break;
				case 9:{
					isLoop=false;
					System.out.println("로그아웃 되었습니다.");
				}break;
				default:
					System.out.print("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void addMenu() {
		String eng,kor;
		System.out.print("영단어를 입력하세요. : ");
		eng = sc.next();
		System.out.print("한글을 입력하세요. : ");
		kor = sc.next();
		
		wc.addWord(eng, kor);
	}
	
	public void removeMenu() {
		int num;
		wc.showAllWord();
		System.out.println("삭제할 단어의 번호를 입력하세요.");
		System.out.print("번호 : ");
		num = sc.nextInt();
		wc.removeWord(num);
	}
	
	
	public void changeMenu() {
		int index;
		String eng,kor;
		wc.showAllWord();
		
		System.out.println("수정할 단어의 번호를 입력하세요.");
		System.out.print("번호 : ");
		index = sc.nextInt();
		System.out.print("영단어를 입력하세요. : ");
		eng = sc.next();
		System.out.print("한글을 입력하세요. : ");
		kor= sc.next();
		wc.changeWord(index, eng, kor);
	}
	
	
	
	
	
	
	
	
	public void searchMenu() {
		
		boolean isLoop=true;
		
		
		while(isLoop) {
			System.out.println("1. 영어로 단어 검색하기");
			System.out.println("2. 한글로 단어 검색하기");
			System.out.println("9. 메인 메뉴로 돌아가기");
			System.out.print("메뉴 번호 : ");
			
			switch(sc.nextInt()) {
				case 1:{
					System.out.print("검색어를 입력해주세요(영어) : ");
					wc.searchEngWord(sc.next());
				}break;
				case 2:{
					System.out.print("검색어를 입력해주세요(한글) : ");
					wc.searchKorWord(sc.next());
				}break;
				case 9:{
					isLoop = false;
					System.out.println("메인 메뉴로 돌아갑니다.");
				}break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
		
	}
	
	public void quizMenu() {
		boolean isLoop = true;
		System.out.println("등록한 단어들 중 10개가 무작위로 표시(한글)됩니다.");
		System.out.println("해당 단어의 영어를 입력하여 정답을 맞춰보세요!");
		
		while(isLoop) {
			System.out.print("퀴즈 시작(Y/N) : ");
			
			switch(sc.next()) {
				case "y":
				case "Y":{
					wc.wordQuiz();
				}break;
				case "N":
				case "n":{
					isLoop = false;
					System.out.print("메인 메뉴로 돌아갑니다.");
				}break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
}
