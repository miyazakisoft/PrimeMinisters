package primeministers;

import java.io.File;
import java.util.List;

/**
 * リーダ：総理大臣の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 * 
 * @version 1.0
 * @author 宮崎光
 */

public class Reader extends IO {
	/**
	 * ここを作成してください。 まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */

	/**
	 * 総理大臣の情報を記したCSVファイルを記憶するフィールド。
	 */
	private File filename;

	/**
	 * リーダのコンストラクタ。
	 */
	public Reader() {
		super();
		this.filename = new File(IO.directoryOfPages(), "PrimeMinisters.csv");
		return;
	}

	/**
	 * ダウンロードしたCSVファイルを応答する。
	 */
	public File filename() {
		return this.filename;
	}

	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答するクラスメソッド。
	 */
	public File filenameOfCSV() {
		return this.filename.getAbsoluteFile();
	}

	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。
	 */
	public Table table() {
		//途中
		return null;
	}

}
