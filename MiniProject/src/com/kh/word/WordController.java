package com.kh.word;
import java.util.*;
import java.math.*;
public class WordController {
	//
	private Scanner sc;
	private ArrayList<Word> arr; 
	static private ArrayList<Wordlist> WL;
	
	public WordController() {
		WL = new ArrayList<Wordlist>();
		sc = new Scanner(System.in);
		arr = new ArrayList<Word>();
		
	}
	// 단어장 추가
	public void addWL(String userId, String listName) {
		WL.add(new Wordlist(arr,userId,listName));
		System.out.println("정상적으로 등록되었습니다.");
	}
	
	// 전체 단어장 보여주기
	public void showAllWL() {
		System.out.println("번호\t단어장이름\t작성자");
		for(int i=0; i<WL.size(); i++) {
			System.out.println((i+1)+"\t"+WL.get(i).toString());
		}
	}
	
	// 선택 단어장의 전체 단어보기
	public void showChoiceWL(int menuNum) {
		System.out.println("번호\t영어\t한글"); 
		for(int i=0; i<WL.get(menuNum-1).getWr().size(); i++) {
			System.out.println((i+1)+"\t"+WL.get(menuNum-1).getWr().get(i).toString());
		}
	}
	
	// 선택된 단어장으로 퀴즈 진행하기
	public void wordQuizWL(int menuNum) {
		
		ArrayList<Word> quizResult = new ArrayList<Word>();
		int point = 0;
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size()!=10) {	
		set.add((int)(Math.random()*WL.get(menuNum-1).getWr().size()));
		}
		
		for(int s : set) {
			String quest = WL.get(menuNum-1).getWr().get(s).getKor();
			String answer;
			
			System.out.print(quest+"의 영어 단어를 입력하세요. : ");
			answer=sc.next();
			
			
			if(WL.get(menuNum-1).getWr().get(s).getEng().equals(answer)) {
				point += 10;
				quizResult.add(new Word(WL.get(menuNum-1).getWr().get(s).getEng(), WL.get(menuNum-1).getWr().get(s).getKor(), "O"));
			}
			else
				quizResult.add(new Word(WL.get(menuNum-1).getWr().get(s).getEng(), WL.get(menuNum-1).getWr().get(s).getKor(), "X"));
		}
		
		System.out.println("번호\t영어\t한글\t정답여부");
		for(int i=0; i<quizResult.size(); i++) {
			System.out.println((i+1)+"\t"+quizResult.get(i).quizResult());
		}
		System.out.println("당신의 점수는 "+point+"점 입니다.");
		
	}
	
	//단어장에 있는 단어 추가
	public void addWLword(int menuNum) {
		for(int i=0; i<WL.get(menuNum-1).getWr().size(); i++) {
		arr.add(new Word(WL.get(menuNum-1).getWr().get(i).getEng(),WL.get(menuNum-1).getWr().get(i).getKor()));
		}
		System.out.println("단어장의 단어를 정상적으로 추가했습니다.");
	}
	
	
	//단어 추가
	public void addWord(String eng, String kor){
		arr.add(new Word(eng,kor));
		System.out.println("단어가 정상적으로 저장되었습니다.");
	}
	
	//단어 삭제
	public void removeWord(int index) {
		arr.remove(index-1);
	}
	
	//단어 전체 보기
	public void showAllWord() {
		System.out.println("번호\t영어\t한글");
		for(int i=0; i<arr.size(); i++) {
			System.out.println((i+1)+"\t"+arr.get(i).toString());
		}
	}
	//영어로 단어 검색하기
		
	public void searchEngWord(String search) {
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i).getEng().equals(search)) {
				System.out.println("번호\t영어\t한글");
				System.out.println((i+1)+"\t"+arr.get(i).toString());
				break;
			}else if(i==arr.size()-1)
				System.out.println("검색하신 단어가 없습니다.");
				
		}
		
	}
	
	//한글로 단어 검색하기
	
	public void searchKorWord(String search) {
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i).getKor().equals(search)) {
				System.out.println("번호\t영어\t한글");
				System.out.println((i+1)+"\t"+arr.get(i).toString());
				break;
			}else if(i==arr.size()-1)
				System.out.println("검색하신 단어가 없습니다.");
				
		}
		
	}
	// 단어 수정
	public void changeWord(int index,String eng,String kor) {
		arr.get(index).setEng(eng);
		arr.get(index).setKor(kor);
		System.out.println("수정이 완료되었습니다.");
	}
		
	
	
	// 새로운 Word ArrayList 만들어서 저장(저장 시 O X 표시) 후 결과로 출력 
	public void wordQuiz() {
		
		ArrayList<Word> quizResult = new ArrayList<Word>();
		int point = 0;
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size()!=10) {
		set.add((int)(Math.random()*arr.size()));
		}
		
		for(int s : set) {
			String quest = arr.get(s).getKor();
			String answer;
			
			System.out.print(quest+"의 영어 단어를 입력하세요. : ");
			answer=sc.next();
			
			
			if(arr.get(s).getEng().equals(answer)) {
				point += 10;
				quizResult.add(new Word(arr.get(s).getEng(), arr.get(s).getKor(), "O"));
			}
			else
				quizResult.add(new Word(arr.get(s).getEng(), arr.get(s).getKor(), "X"));
		}
		
		System.out.println("번호\t영어\t한글\t정답여부");
		for(int i=0; i<quizResult.size(); i++) {
			System.out.println((i+1)+"\t"+quizResult.get(i).quizResult());
		}
		System.out.println("당신의 점수는 "+point+"점 입니다.");
	}
	
	
	
	
	
	//단어장 추가,삭제 단어장 전체 보기,단어 검색,단어 수정, 단어 문제 맞추기
	
	
}
