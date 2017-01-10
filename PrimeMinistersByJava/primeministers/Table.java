package primeministers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * 表：人物の情報テーブル。
 * 
 * @version 1.0
 * @author 宮崎光
 */
public class Table extends Object {

	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;

	/**
	 * 画像群を記憶するフィールド。
	 */
	private List<BufferedImage> images;

	/**
	 * サムネイル画像群を記憶するフィールド。
	 */
	private List<BufferedImage> thumbnails;

	/**
	 * タプル群を記憶するフィールド。
	 */
	private List<Tuple> tuples;

	/**
	 * テーブルのコンストラクタ。 良好（2017年1月10日）
	 */
	public Table() {
		super();
		this.images = new ArrayList<BufferedImage>();
		this.thumbnails = new ArrayList<BufferedImage>();
		this.tuples = new ArrayList<Tuple>();
		return;
	}

	/**
	 * タプルを追加する。 良好（2017年1月10日）
	 * 
	 * @param aTuple
	 *            タプル
	 */
	public void add(Tuple aTuple) {
		this.tuples.add(aTuple);
		return;
	}

	/**
	 * 属性リストを応答する。 良好（2017年1月10日）
	 * 
	 * @return 属性リスト
	 */
	public Attributes getAttributes() {
		return this.attributes;
	}

	/**
	 * 属性リストを設定する。 良好（2017年1月10日）
	 * 
	 * @param instanceOfAttributes
	 *            属性リスト
	 */
	public void setAttributes(Attributes instanceOfAttributes) {
		this.attributes = instanceOfAttributes;
		return;
	}

	/**
	 * 画像群を応答する。 良好（2017年1月10日）
	 * 
	 * @return 画像群
	 */
	public List<BufferedImage> images() {
		return this.images;
	}

	/**
	 * サムネイル画像群を応答する。 良好（2017年1月10日）
	 * 
	 * @return サムネイル画像群
	 */
	public List<BufferedImage> thumbnails() {
		return this.thumbnails;
	}

	/**
	 * 自分自身を文字列にして、それを応答する。 良好（2017年1月10日）
	 * 
	 * @return 自分自身の文字列
	 */
	@Override
	public String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<? extends Table> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		return aBuffer.toString();
	}

	/**
	 * タプル群を応答する。 良好（2017年1月10日）
	 * 
	 * @return タプル群
	 */
	public List<Tuple> tuples() {
		return this.tuples;
	}

}
