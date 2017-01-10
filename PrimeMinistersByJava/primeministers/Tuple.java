package primeministers;

import java.util.List;

/**
 * タプル：人物の情報テーブルの中の各々のレコード。
 * 
 * @version 1.0
 * @author 宮崎光
 */

public class Tuple extends Object {
	/**
	 * 属性リストを記憶するフィールド。
	 */
	private Attributes attributes;

	/**
	 * 値リストを記憶するフィールド。
	 */
	private List<String> values;

	/**
	 * 属性リスト値リストからタプルを作るコンストラクタ。 良好（2017年1月10日）
	 * 
	 * @param instanceOfAttributes
	 *            属性リスト
	 * @param valueCollection
	 *            値リスト
	 */
	public Tuple(Attributes instanceOfAttributes, List<String> valueCollection) {
		super();
		this.attributes = instanceOfAttributes;
		this.values = valueCollection;
		return;
	}

	/**
	 * 属性リストを応答する。 良好（2017年1月10日）
	 * 
	 * @return 属性リスト
	 */
	public Attributes attributes() {
		return this.attributes;
	}

	/**
	 * 自分自身を文字列にして、それを応答する。 良好（2017年1月10日）
	 * 
	 * @return 自分自身の文字列
	 */
	@Override
	public String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<? extends Tuple> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		return aBuffer.toString();
	}

	/**
	 * 値リストを応答する。 良好（2017年1月10日）
	 * 
	 * @return 値リスト
	 */
	public List<String> values() {
		return this.values;
	}

}
