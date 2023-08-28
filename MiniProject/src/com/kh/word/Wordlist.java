package com.kh.word;
import java.util.*;
public class Wordlist{

	private String userId;
	private String listName;
	private ArrayList<Word> wr;
	
	
	public Wordlist(ArrayList<Word> wr, String userId, String listName) {
		this.wr = wr;
		this.userId = userId;
		this.listName = listName;
		
	}
	
	public ArrayList<Word> getWr(){
		return this.wr;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public String getListName() {
		return this.listName;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setListName(String listName) {
		this.listName = listName;
	}
	
	
	public String toString() {
		return this.listName+"\t"+this.userId;
	}
	
	

}
