package kadai;

class MainShopCharger{
	StudentCard insertedStudentCard;
	
	/*public MainShopCharger(){
		this.insertedStudentCard = null;
	}*/
	
	public void insertStudentCard(StudentCard card){
		insertedStudentCard = card;
	}
	
	public void chargeMoney(int money){
		if(this.insertedStudentCard == null){
			System.err.println("(Šw¶Ø‚ª“ü‚Á‚Ä)‚È‚¢‚Å‚·");
		}
		else {
			insertedStudentCard.set_cash(this.insertedStudentCard.get_cash()+money);
			this.printAccountBalance(this.insertedStudentCard);
		}
	}
	
	public void printAccountBalance(StudentCard card){
		System.out.println(card.get_name() + ": " + card.get_cash());
	}
	
	public static void main(String arg[]){
		MainShopCharger ICR = new MainShopCharger();
		StudentCard scard1 = new StudentCard("B163348","tanahashi",3000);
		StudentCard scard2 = new StudentCard("B999998","saotu",30000);
		ICR.chargeMoney(500);
		ICR.insertStudentCard(scard1);
		ICR.chargeMoney(5000);
		ICR.insertStudentCard(scard2);
		ICR.chargeMoney(500000);
	}
}
		
	
	
	