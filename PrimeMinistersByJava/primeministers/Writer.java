package primeministers;

import java.io.BufferedWriter;
import java.io.File;
import java.util.List;

/**
 * ライタ：総理大臣の情報のテーブルをHTMLページとして書き出す。
 * 
 * @version 1.0
 * @author 宮崎光
 */

public class Writer extends IO {
	/**
	 * ここを作成してください。 まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */

	/**
	 * ライタのコンストラクタ。
	 */
	public Writer() {
		super();
		return;
	}

	/**
	 * 属性リストを応答する。
	 */
	public Attributes attributes() {
		return this.table.attributes();
	}

	/**
	 * ローカルなHTMLのインデックスファイル(index.html)を応答するクラスメソッド。
	 */
	public File filenameOfHTML() {
		File aFile = IO.directoryOfPages();
		aFile = new File(aFile.getPath() + File.separator + "index.html");
		return aFile;
	}

	/**
	 * HTMLページを基にするテーブルを受け取って、インデックスファイル(index.html)に書き出す。
	 */
	public Table table(Table aTable) {
		return super.table();
	}

	/**
	 * タプル群を応答する。
	 */
	public List<Tuple> tuples() {
		return this.table.tuples();
	}

	/**
	 * 属性リストを書き出す。
	 */
	public void writeAttributesOn(BufferedWriter outputWriter) {
		return;
	}

	/**
	 * フッタを書き出す。
	 */
	public void writeFooterOn(BufferedWriter outputWriter) {
		return;
	}

	/**
	 * ヘッダを書き出す。
	 */
	public void writeHeaderOn(BufferedWriter outputWriter) {
		return;
	}

	/**
	 * ボディを書き出す。
	 */
	public void writeTableBodyOn(BufferedWriter outputWriter) {
		return;
	}

	/**
	 * タプルを書き出す。
	 */
	public void writeTuplesOn(BufferedWriter outputWriter) {

	}
}
