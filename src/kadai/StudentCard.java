package kadai;

import java.util.*;

class StudentCard {
	private String number;
	private String name;
	private int money;
	
	public StudentCard(String num,String name,int money){
		this.number = num;
		this.name = name;
		this.money = money;
		StudentCard.studentCardList_.add(this);
	}
	
	private static List<StudentCard> studentCardList_= new ArrayList<StudentCard>();
	
	public int get_cash(){return money;}
	public String get_name(){return name;}
	public String get_num(){return number;}
	public void set_cash(int money){this.money = money;} 
	
}
