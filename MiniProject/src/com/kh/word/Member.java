package com.kh.word;

public class Member {

	private String id;
	private String pw;
	private String name;
	private int memberNum;
	public static int NUM=0;
	
	public Member(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.memberNum = NUM++;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMemberNum() {
		return this.memberNum;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.id+"\t"+this.pw+"\t"+this.name;
	}

}
