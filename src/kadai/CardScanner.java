package kadai;

/**
 * カードスキャナのみの機能を持つ抽象クラス
 * ICチャージ機や学生証スキャナの根幹となる
 *
 */
public abstract class CardScanner {
	//挿入されているカード
	protected StudentCard insertedStudentCard;
	
	/**
	 * カードスキャンを行う
	 * @param card 挿入するカード
	 */
	abstract void scanCard(StudentCard card);
}
