package primeministers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * 表：総理大臣の情報テーブル。
 * 
 * @version 1.0
 * @author 宮崎光
 */
public class Table extends Object {
	/**
	 * ここを作成してください。 まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */

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
	 * テーブルのコンストラクタ。
	 */
	public Table() {
		super();
		this.images = new ArrayList<BufferedImage>();
		this.thumbnails = new ArrayList<BufferedImage>();
		this.tuples = new ArrayList<Tuple>();
		return;
	}

	/**
	 * タプルを追加する。
	 * 
	 * @param aTuple
	 *            タプル
	 */
	public void add(Tuple aTuple) {
		this.tuples.add(aTuple);
		return;
	}

	/**
	 * 属性リストを応答する。
	 * 
	 * @return 属性リスト
	 */
	public Attributes attributes() {
		return this.attributes;
	}

	/**
	 * 属性リストを設定する。
	 * 
	 * @param instanceOfAttributes
	 *            属性リスト
	 */
	public void attributes(Attributes instanceOfAttributes) {
		this.attributes = instanceOfAttributes;
		return;
	}

	/**
	 * 画像群を応答する。
	 * 
	 * @return 画像群
	 */
	public List<BufferedImage> images() {
		return this.images;
	}

	/**
	 * 画像またはサムネイル画像の文字列を受け取って該当画像を応答する。
	 * 
	 * @param aString
	 *            画像またはサムネイル画像の文字列
	 */
	@SuppressWarnings("unused")
	private Image picture(String aString) {
		// 意味がわからないので、パス
		return null;
	}

	/**
	 * サムネイル画像群を応答する。
	 * 
	 * @return サムネイル画像群
	 */
	public List<BufferedImage> thumbnails() {
		return this.thumbnails;
	}

	/**
	 * 自分自身を文字列にして、それを応答する。
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
	 * タプル群を応答する。
	 * 
	 * @return タプル群
	 */
	public List<Tuple> tuples() {
		return this.tuples;
	}

}
