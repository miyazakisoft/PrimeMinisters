package primeministers;

import java.util.List;

/**
 * 属性群：人物の情報テーブルを入出力する際の属性情報を記憶。
 * 良好（2017年1月10日）
 * @version 1.0
 * @author 宮崎光
 */

public class Attributes extends Object {

	/**
	 * 属性リストのキー群を記憶するフィールド。
	 * 
	 */
	private List<String> attributesCollection;

	/**
	 * 属性リストを作成するコンストラクタ。
	 * 良好（2017年1月10日）
	 * @param anAttributesCollection 属性リスト
	 */
	public Attributes(List<String> anAttributesCollection) {
		super();
		this.attributesCollection = anAttributesCollection;
		return;
	}

	/**
	 * 指定されたキー文字列のインデックスを応答する。
	 * 良好（2017年1月10日）
	 * @param aString
	 *            キー文字列
	 * @return 要素番号
	 */
	private Integer indexOf(String aString) {
		return this.attributesCollection.indexOf(aString);
	}

	/**
	 * 画像のインデックスを応答する。
	 * 良好（2017年1月10日）
	 * @return 画像の要素番号
	 */
	public Integer indexOfImage() {
		return this.indexOf("画像");
	}

	/**
	 * 縮小画像のインデックスを応答する。
	 * 良好（2017年1月10日）
	 * @return 縮小画像の要素番号
	 */
	public Integer indexOfThumbnail() {
		return this.indexOf("縮小画像");
	}

	/**
	 * 番号を応答する。
	 * 良好（2017年1月10日）
	 * @return 番号
	 */
	public String getNumber() {
		return getAttributesCollection().get(0);
	}

	public List<String> getAttributesCollection() {
		return attributesCollection;
	}


}
