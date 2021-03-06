package kadai;

import java.util.*;

/**
 * 学生証クラス
 * 身分証明の他にICカードとしての側面も持ち合わせる
 *
 */
class StudentCard {
	private String number;
	private String name;
	private int money;
	private static List<StudentCard> studentCardList_= new ArrayList<StudentCard>();
	
	/**
	 * コンストラクタ
	 * 学生の情報を受け取り、そのインスタンスをクラス変数であるstudentCardListに追加している
	 * @param num 学籍番号
	 * @param name 学生名
	 * @param money 初期チャージ金
	 */
	public StudentCard(String num,String name,int money){
		this.number = num;
		this.name = name;
		this.money = money;
		StudentCard.studentCardList_.add(this);
	}
	
	/**
	 * StudentCardList内に挿入されたカードがあるか確認
	 * あればそのカードを返し、なければnullを投げる
	 * @param stu 確認対象のカード
	 * @return 見つかったカード or null
	 */
	public static StudentCard getStudentCard(StudentCard stu){
        if(studentCardList_.contains(stu))return studentCardList_.get(studentCardList_.indexOf(stu));
        else return null;
    }
	
	// チャージ金額を返す
	public int getCash(){return money;}
	// 学生名を返す
	public String getName(){return name;}
	// 学籍番号を返す
	public String getNum(){return number;}
	// 新たにチャージ金額を設定する
	public void setCash(int money){this.money = money;}
}
