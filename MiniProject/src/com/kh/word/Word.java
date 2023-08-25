package com.kh.word;

public class Word {
	//
	private String answer;
	private String eng;
	private String kor;

	

	
	public Word(String eng, String kor) {
	
		this.eng = eng;
		this.kor = kor;
	}
	
	public Word(String eng, String kor, String answer) {
		this.eng = eng;
		this.kor = kor;
		this.answer = answer;
	}
	
	public String getEng() {
		return this.eng;
	}
	
	public String getKor() {
		return this.kor;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	
	public void setEng(String eng) {
		this.eng=eng;
	}
	
	public void setKor(String kor) {
		this.kor=kor;
	}
	
	public String toString() {
		return this.eng+"\t"+this.kor;
	}
	
	public String quizResult() {
		return this.eng+"\t"+this.kor+"\t"+this.answer;
	}
	
}
