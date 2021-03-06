package kadai;

import java.util.*;
import java.security.*;
import java.time.*;

/**
 * カードへ金銭をチャージするクラス
 * あるStudentCardへ任意の数値だけチャージする機能と、最新ログと過去5件までのログ表示機能を搭載
 * 
 */
class MainShopCharger extends CardScanner{

    private String LastCharge;
    private Queue<String> qe = new LinkedList<String>();
    private Calendar cal;
    private MessageDigest md;
    private HashMap<String,String> hl = new HashMap<String,String>();
    
    /**
     * コンストラクタ
     * ハッシュ値生成用のMessageDigestのインスタンス生成とその例外処理を行う
     */
    public MainShopCharger(){
    	try {
			md  = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("algorithm not found\n");
		}
    }
    
    /**
     * 抽象クラスからの継承
     * このクラスではカードを読み込んだのち様々な動作を行うことを想定するため,
     * 内部変数に格納することのみを行う
     * @param stu 読み込むカード
     */
    public void scanCard(StudentCard card){
    	insertedStudentCard = StudentCard.getStudentCard(card);
    }
    
    /**
     * 金銭のチャージ
     * 内部に格納したカードに任意の数値だけ金銭をチャージする
     * @param money チャージする金額
     */
	public void chargeMoney(int money){
		//カードがなければerr表示
		if(this.insertedStudentCard == null){
			System.err.println("not inserted");
		}
		else {
			// 金額を追加し, チャージ後の残金を表示
			insertedStudentCard.setCash(this.insertedStudentCard.getCash()+money);
			this.printAccountBalance(this.insertedStudentCard);
            
			// 現在日時を取得し, ログに残すための文字列を生成
            cal = Calendar.getInstance();
            LastCharge = cal.getTime() + " - " + insertedStudentCard.getName() + " : " + insertedStudentCard.getCash();
            //System.out.println(LastCharge);
            
            // ハッシュ値を生成
            md.update(LastCharge.getBytes());
            byte[] digest = md.digest();
     
            // 16進数文字列に変換
            StringBuffer buffer = new StringBuffer();
            String hash;
            for(int i = 0; i < digest.length; i++) {
                String tmp = Integer.toHexString(digest[i] & 0xff);
                if(tmp.length() == 1) {
                    buffer.append('0').append(tmp);
                } else {
                    buffer.append(tmp);
                }
            }
            hash = buffer.toString();
            
            // ハッシュ値をキーにログをリストへ追加
            hl.put(hash, LastCharge);
            
            // ハッシュ値＋チャージ内容の形でログに格納
            String Logs = hash.substring(0, 10) + LastCharge;
            if(qe.size() < 5)qe.add(Logs);
            else{
                qe.add(Logs);
                qe.poll();
            }
            
        }
	}
	
	/**
	 * チャージ後金額表示用関数
	 * @param card 表示対象のカード
	 */
	public void printAccountBalance(StudentCard card){
		System.out.println(card.getName() + " charged: " + card.getCash());
	}
    
	/**
	 * 最新ログを表示
	 */
	public void printLatestLog(){
		System.out.println("-Latest Charge-\n"+LastCharge);
	}
	
	/** 
	 * 最新5件のログ表示
	 */
    public void printChargeLog(){
    	System.out.println("-Show Logs-");
        int s = qe.size();
        for(int i=0;i<s;i++){
            String str = qe.poll();
            System.out.println(str);
            qe.add(str);
        }
    }
    
	public static void main(String arg[]){
		MainShopCharger ICR = new MainShopCharger();
		StudentCard scard1 = new StudentCard("B163348","Michel",3000);
		StudentCard scard2 = new StudentCard("B999998","Jenny",30000);
		ICR.chargeMoney(500);
		ICR.scanCard(scard1);
		ICR.chargeMoney(5000);
		ICR.scanCard(scard2);
		ICR.chargeMoney(500000);
		
		ICR.printLatestLog();
		ICR.printChargeLog();
	}
}
		
	
	