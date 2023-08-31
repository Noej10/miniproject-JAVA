package com.kh.word;
import java.util.*;
public class LoginMenu {
//
	public static final String RED = "\u001B[31m";
	public static final String EXIT = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	private Scanner sc;
	private MemberController mc;
	private ArrayList<Menu> m;
	
	public LoginMenu() {
		sc = new Scanner(System.in);
		mc = new MemberController();
		m = new ArrayList<Menu>();
	}
	
	

	
	public void loginMain() {
		boolean isLoop=true;
		
		while(isLoop) {	
			System.out.println("나만의 단어장입니다.");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 비밀번호 변경");
			System.out.println("4. 관리자모드");
			System.out.println("9. 프로그램 종료");
			System.out.println("번호를 선택하세요.");
			System.out.print("번호 : ");
			
			
				switch(sc.nextInt()) {
					case 1:{
						login();
					}break;
					case 2:{
						joinMembership();
					}break;
					case 3:{
						changePW();
					}break;
					case 4:{
						managerMod();
					}break;
					case 9:{
						isLoop=false;
						System.out.println(GREEN+"프로그램이 종료됩니다."+EXIT);
					}break;
					default:
						System.out.println(RED+"잘못 입력하셨습니다. 다시 입력하세요."+EXIT);
				}
			
			
		}
	}
	
	public void login() {
		String id,pw;
		int menuNum;
		System.out.print("사용자 ID를 입력하세요. : ");
		id = sc.next();
		System.out.print("사용자 비밀번호를 입력하세요. : ");
		pw = sc.next();
		
		menuNum=mc.login(id, pw);
		if(menuNum==-1)
			System.out.println(RED+"로그인 실패!"+EXIT);
		else {
			System.out.println(GREEN+"로그인 성공!"+EXIT);
			m.get(menuNum).wordMenu(); 
		}
	}
	
	
	//비밀번호 변경 기능 추가
	public void changePW() {
		String id,pw;
		
		System.out.print("비밀번호를 변경할 아이디를 입력하세요. : ");
		id = sc.next();
		System.out.print("변경할 비밀번호를 입력하세요. : ");
		pw = sc.next();
		
		mc.changePW(id,pw);
		
	}
	
	//id pw 뭐가 틀렸는지 // pw 3번 이상 틀릴경우 id 불린값사용해서 잠금 비밀번호 변경 시 해제
	
	public void joinMembership() {
		String id,pw,name;
		System.out.print("사용할 ID를 입력하세요. : ");
		id = sc.next();
		
		System.out.print("사용할 비밀번호를 입력하세요. : ");
		pw = sc.next();
		
		
		System.out.print("사용자의 이름을 입력하세요. : ");
		name = sc.next();
		
		mc.joinMembership(id, pw, name);
		m.add(new Menu());
		
		
		
	}
	
	public void managerMod() {
	boolean isLoop=true;
		
		while(isLoop) {	
			System.out.println("관리자 모드입니다.");
			System.out.println("1. 전체 회원 목록 확인");
			System.out.println("2. 아이디 잠금 해제");
			System.out.println("9. 관리자 모드 종료");
			System.out.println("번호를 선택하세요.");
			System.out.print("번호 : ");
			
				switch(sc.nextInt()) {
					case 1:{
						mc.showAllMember();
					}break;
					case 2:{
						int memberNum;
						mc.showAllMember();
						System.out.print("잠금을 해제할 아이디의 번호를 입력하세요. : ");
						memberNum = sc.nextInt();
						mc.managersReset(memberNum);
					}break;
					case 9:{
						isLoop=false;
						System.out.println(GREEN+"메인 메뉴로 돌아갑니다."+EXIT);
					}break;
					default:
						System.out.println(RED+"잘못 입력하셨습니다. 다시 입력하세요."+EXIT);
				}
			
		}
	}
}
