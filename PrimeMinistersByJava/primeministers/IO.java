package primeministers;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 入出力：リーダ・ダウンローダ・ライタを抽象する。
 * 
 * @version 1.0
 * @author 宮崎光
 */
public abstract class IO extends Object {
	/**
	 * ここを作成してください。 まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */

	/**
	 * テーブル（表：スプレッドシート）を記憶するフィールド。
	 */
	protected Table table;

	/**
	 * 入出力のコンストラクタ
	 */
	public IO() {
		super();
		return;
	}

	/**
	 * ファイルやディレクトリを削除するクラスメソッド。
	 * 
	 * @param aFile
	 *            ファイル名
	 */
	public static void deleteFileOrDirectory(File aFile) {
		if (aFile.exists()) {
			aFile.delete();
		}
	}

	/**
	 * 総理大臣ページのためのディレクトリ（存在しなければ作成して）を応答するメソッド。
	 * 
	 * @return aFile ファイル
	 */
	public static File directoryOfPages() {
		File aFile = new File(System.getProperty("user.home") + "/Desktop", "SouriDaijin");
		if (!aFile.exists()) {
			aFile.mkdir();
		}
		return aFile;
	}

	/**
	 * 入出力する際の文字コードを応答するクラスメソッド。
	 * 
	 * @return 文字コード
	 */
	public static String encodingSymbol() {
		return "UTF-8";
	}

	/**
	 * 指定されたファイルからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * 
	 * @param aFile
	 *            ファイル
	 * @return aCollection リスト
	 */
	public static List<String> readTextFromFile(File aFile) {
		Reader inputStreamReader = null;

		try {
			// IOExceptionがでるかもしれない
			InputStream inputStream = new FileInputStream(aFile);

			// UnsupportedEncodingExceptionがでるかもしれない
			inputStreamReader = new InputStreamReader(inputStream, IO.encodingSymbol());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> aCollection = IO.readText(inputStreamReader);

		return aCollection;
	}

	/**
	 * 指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * 
	 * @param aFileString
	 *            ファイル文字列
	 * @return aCollection リスト
	 */
	public static List<String> readTextFromFile(String aFileString) {
		File aFile = new File(aFileString);
		List<String> aCollection = IO.readTextFromFile(aFile);
		return aCollection;
	}

	/**
	 * 指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * 
	 * @param urlString
	 *            URL文字列
	 * @return aCollection リスト
	 */
	public static List<String> readTextFromURL(String urlString) {
		URL aURL = null;
		try {
			// MalformedURLException anExceptionがでるかもしれない
			aURL = new URL(urlString);
		} catch (MalformedURLException anException) {
			anException.printStackTrace();
		}
		List<String> aCollection = IO.readTextFromURL(aURL);
		return aCollection;
	}

	/**
	 * 指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド。
	 * 
	 * @param aURL
	 *            URL
	 * @return aCollection リスト
	 */
	public static List<String> readTextFromURL(URL aURL) {
		Reader inputStreamReader = null;
		try {
			// IOExceptionがでるかもしれない
			InputStream inputStream = aURL.openStream();

			// UnsupportedEncodingExceptionがでるかもしれない
			inputStreamReader = new InputStreamReader(inputStream, IO.encodingSymbol());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<String> aCollection = IO.readText(inputStreamReader);

		return aCollection;
	}

	/**
	 * 文字列をセパレータで分割したトークン列を応答するクラスメソッド。
	 * 
	 * @param aString
	 *            文字列
	 * @param separators
	 *            セパレータ
	 */
	public static ArrayList<String> splitString(String aString, String separators) {
		return null;
	}

	/**
	 * テーブルを応答する。
	 * 
	 * @return talbe テーブル（表：スプレッドシート）
	 */
	public Table table() {
		return this.table;
	}

	/**
	 * 指定された行リストを、指定されたファイルに書き出すクラスメソッド。
	 * 
	 * @param aCollection
	 *            リスト
	 * @param aFile
	 *            ファイル
	 */
	public static void writeText(List<String> aCollection, File aFile) {

		return;
	}

	/**
	 * 指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド。
	 * 
	 * @param aCollection
	 *            リスト
	 * @param pathName
	 *            パス名
	 */
	public static void writeText(List<String> aCollection, String pathName) {
		File aFile = new File(pathName);
		IO.writeText(aCollection, aFile);
		return;
	}

	/**
	 * テキストをリストに追加し、そのリストを返すクラスメソッド。
	 * 
	 * @param inputStreamReader
	 *            インプットストリームリーダー
	 * @return aCollection リスト
	 */
	private static List<String> readText(Reader inputStreamReader) {
		List<String> aCollection = new ArrayList<String>();
		BufferedReader inputReader = new BufferedReader(inputStreamReader);
		String aString = null;
		try {
			// IOExceptionがでるかもしれない
			while ((aString = inputReader.readLine()) != null) {
				aCollection.add(aString);
			}
			inputReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aCollection;
	}

}
