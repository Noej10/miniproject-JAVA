package com.kh.word;

import java.util.*;
//
public class MemberController {
	
	private ArrayList<Member> arr;
	
	public MemberController() {
		arr = new ArrayList<Member>();
	}
	
	public void joinMembership(String id, String pw, String name) {
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i).getId().equals(id)) {
				System.out.println("중복된 아이디는 사용할 수 없습니다.");
				return;
			}
		}
		
		arr.add(new Member(id, pw, name));
		System.out.println("회원 가입이 정상적으로 완료되었습니다.");
	}
	
	public int login(String id, String pw) {
		int memberNum=-1;
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i).getId().equals(id)) {
				if(arr.get(i).getFailKey()>=3) {
					System.out.println("비밀번호를 3회 이상 잘못 기입하여 아이디가 잠금처리되었습니다.");
					System.out.println("잠금해제를 위해 해당 아이디의 비밀번호를 초기화해주세요.");
				
				}else if(arr.get(i).getPw().equals(pw)) {
					memberNum = arr.get(i).getMemberNum();
					arr.get(i).resetFailKey();
					break;
				}else{
					System.out.println("비밀번호가 틀렸습니다.");
					arr.get(i).addFailKey();
					break;
				}
			}else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
		}
		
		return memberNum;
		
	}
	
	public void showAllMember() {
		System.out.println("아이디\t비밀번호\t이름");
			for(int i=0; i<arr.size(); i++) {
				System.out.println(arr.get(i).toString());
			}
		
	}
	public void changePW(String id, String pw) {
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i).getId().equals(id)) {
				arr.get(i).setPw(pw);
				System.out.println("비밀번호가 정상적으로 변경되었습니다.");
				arr.get(i).resetFailKey();
			}else {
				System.out.println("아이디가 존재하지 않습니다.");
			}
		}
		
	}
	
}
