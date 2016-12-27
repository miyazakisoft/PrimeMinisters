package primeministers;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性群：総理大臣の情報テーブルを入出力する際の属性情報を記憶。
 * 
 * @version 1.0
 * @author 宮崎光
 */

public class Attributes extends Object {

	/**
	 * ここを作成してください。 まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */

	/**
	 * 属性リストのキー群を記憶するフィールド。
	 */
	private List<String> keys;

	/**
	 * 属性リストの名前群を記憶するフィールド。
	 */
	private List<String> names;

	/**
	 * 入力用("input")または出力用("output")で属性リストを作成するコンストラクタ。
	 * 
	 * @param aString
	 */
	public Attributes(String aString) {
		super();
		this.keys = new ArrayList<String>();
		this.names = new ArrayList<String>();
		String[] keyStrings = null;
		String[] nameStrings = null;

		if (aString.equals("input")) {
			keyStrings = new String[] { "no", "order", "names", "kana", "period", "school", "party", "birth", "image",
					"thumbnail" };

			nameStrings = new String[] { "人目", "代", "氏名", "ふりがな", "在位期間", "在位日数", "出身校", "政党", "出身地", "画像", "サムネイル" };

		} else if (aString == "output") {
			keyStrings = new String[] { "no", "order", "names", "kana", "period", "day", "school", "party", "birth",
					"image" };

			nameStrings = new String[] { "人目", "代", "氏名", "ふりがな", "在位期間", "在位日数", "出身校", "政党", "出身地", "画像" };

		} else {
			throw new Error("inputまたはoutputで指定されていません");
		}

		for (String key : keyStrings) {
			this.keys.add(key);
		}

		for (String name : nameStrings) {
			this.names.add(name);
		}

		return;
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。
	 * 
	 * @param index
	 *            要素番号
	 * @return インデックスに対応する名前
	 */
	protected String at(Integer index) {
		return this.names.get(index);
	}

	/**
	 * 指定されたキー文字列のインデックスを応答する。
	 * 
	 * @param aString
	 *            キー文字列
	 * @return 要素番号
	 */
	private Integer indexOf(String aString) {
		return this.keys.indexOf(aString);
	}

	/**
	 * 在位日数のインデックスを応答する。
	 * 
	 * @return 在位日数の要素番号
	 */
	public Integer indexOfDays() {
		return this.indexOf("day");
	}

	/**
	 * 画像のインデックスを応答する。
	 * 
	 * @return 画像の要素番号
	 */
	public Integer indexOfImage() {
		return this.indexOf("image");
	}

	/**
	 * ふりがなのインデックスを応答する。
	 * 
	 * @return ふりがなの要素番号
	 */
	public Integer indexOfKana() {
		return this.indexOf("kana");
	}

	/**
	 * 氏名のインデックスを応答する。
	 * 
	 * @return 氏名の要素番号
	 */
	public Integer indexOfName() {
		return this.indexOf("names");
	}

	/**
	 * 番号のインデックスを応答する。
	 * 
	 * @return 番号の要素番号
	 */
	public Integer indexOfNo() {
		return this.indexOf("no");
	}

	/**
	 * 代のインデックスを応答する。
	 * 
	 * @return 代の要素番号
	 */
	public Integer indexOfOrder() {
		return this.indexOf("order");
	}

	/**
	 * 政党のインデックスを応答する。
	 * 
	 * @return 政党の要素番号
	 */
	public Integer indexOfParty() {
		return this.indexOf("party");
	}

	/**
	 * 在位期間のインデックスを応答する。
	 * 
	 * @return 在位期間の要素番号
	 */
	public Integer indexOfPeriod() {
		return this.indexOf("period");
	}

	/**
	 * 出身地のインデックスを応答する。
	 * 
	 * @return 出身地の要素番号
	 */
	public Integer indexOfPlace() {
		return this.indexOf("birth");
	}

	/**
	 * 出身校のインデックスを応答する。
	 * 
	 * @return 出身校の要素番号
	 */
	public Integer indexOfSchool() {
		return this.indexOf("school");
	}

	/**
	 * サムネイル画像のインデックスを応答する。
	 * 
	 * @return サムネイル画像の要素番号
	 */
	public Integer indexOfThumbnail() {
		return this.indexOf("thumbnail");
	}

	/**
	 * 指定されたインデックスに対応するキーを応答する。
	 * 
	 * @param index
	 *            要素番号
	 * @return インデックスに対応するキー
	 */
	protected String keyAt(Integer index) {
		return this.keys.get(index);
	}

	/**
	 * キー群を応答する。
	 * 
	 * @return キー群
	 */
	public List<String> keys() {
		return this.keys;
	}

	/**
	 * 指定されたインデックスに対応する名前を応答する。
	 * 
	 * @param index
	 *            要素番号
	 * @return インデックスに対応する名前
	 */
	protected String nameAt(Integer index) {
		return this.names.get(index);
	}

	/**
	 * 名前群を応答する。
	 * 
	 * @return 名前群
	 */
	public List<String> names() {
		return this.names;
	}

	/**
	 * 名前群を設定する。
	 * 
	 * @param aCollection
	 *            名前群
	 */
	public void names(List<String> aCollection) {
		this.names = aCollection;
		return;
	}

	/**
	 * 属性リストの長さを応答する。
	 * 
	 * @return 属性リストの長さ
	 */
	public Integer size() {
		return this.keys.size();
	}

	/**
	 * 自分自身を文字列にして、それを応答する。
	 * 
	 * @return 自分自身の文字列
	 */
	@Override
	public String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<? extends Attributes> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[keys=");
		aBuffer.append(keys);
		aBuffer.append(",names=");
		aBuffer.append(names);
		aBuffer.append("]");
		return aBuffer.toString();
	}

}
