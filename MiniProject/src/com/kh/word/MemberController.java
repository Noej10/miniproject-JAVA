package com.kh.word;

import java.util.*;

public class MemberController {
	
	private ArrayList<Member> arr;
	
	public MemberController() {
		arr = new ArrayList<Member>();
	}
	
	public void joinMembership(String id, String pw, String name) {
		arr.add(new Member(id, pw, name));
		System.out.println("회원 가입이 정상적으로 완료되었습니다.");
	}
	
	public int login(String id, String pw) {
		int memberNum=-1;
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i).getId().equals(id)) {
				if(arr.get(i).getPw().equals(pw)) {
					memberNum = arr.get(i).getMemberNum();
					break;
				}
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
	
}
