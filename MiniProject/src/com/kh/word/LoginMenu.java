package com.kh.word;
import java.util.*;
public class LoginMenu {

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
			System.out.println("3. 관리자모드");
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
						managerMod();
					}break;
					case 9:{
						isLoop=false;
						System.out.println("프로그램이 종료됩니다.");
					}break;
					default:
						System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
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
			System.out.println("로그인 실패!");
		else {
			System.out.println("로그인 성공!");
			m.get(menuNum).wordMenu();
		}
		
		
	}
	
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
			System.out.println("9. 관리자 모드 종료");
			System.out.println("번호를 선택하세요.");
			System.out.print("번호 : ");
			
				switch(sc.nextInt()) {
					case 1:{
						mc.showAllMember();
					}break;
					case 9:{
						isLoop=false;
						System.out.println("메인 메뉴로 돌아갑니다.");
					}break;
					default:
						System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				}
			
		}
	}
}
