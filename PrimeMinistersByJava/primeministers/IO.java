package primeministers;

import java.io.Reader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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
	 * テーブル（表：スプレッドシート）を記憶するフィールド。
	 */
	protected Table table;

	/**
	 * 入出力のコンストラクタ 良好（2017年1月10日）
	 */
	public IO() {
		super();
		return;
	}

	/**
	 * ファイルやディレクトリを削除するクラスメソッド。 良好（2017年1月10日）
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
	 * 人物ページのためのディレクトリ（存在しなければ作成して）を応答するメソッド。 良好（2017年1月10日）
	 * 
	 * @param TittleName
	 *            タイトル名
	 * @return aFile ファイル
	 */
	public static File directoryOfPages(String TittleName) {
		File aFile = new File(System.getProperty("user.home") + "/Desktop", TittleName);
		if (!aFile.exists()) {
			aFile.mkdir();
		}
		return aFile;
	}

	/**
	 * 入出力する際の文字コードを応答するクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @return 文字コード
	 */
	public static String encodingSymbol() {
		return "UTF-8";
	}

	/**
	 * 指定されたファイルからテキストを読み込んで、それを行リストにして応答するクラスメソッド。 良好（2017年1月10日）
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
	 * 指定されたファイル文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。 良好（2017年1月10日）
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
	 * 指定されたURL文字列からテキストを読み込んで、それを行リストにして応答するクラスメソッド。 良好（2017年1月10日）
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
	 * 指定されたURLからテキストを読み込んで、それを行リストにして応答するクラスメソッド。 良好（2017年1月10日）
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
	 * 連続フラグをtrueにすると、separatorsで指定した文字列(aString)が連続していた場合、 空白を追加するようになる。
	 * 良好（2017年1月10日）
	 * 
	 * @param aString
	 *            文字列
	 * @param separators
	 *            セパレータ
	 * @param ConsecutiveFlag
	 *            連続フラグ
	 * @return result 文字列をセパレータで分割したトークン列
	 */
	public static ArrayList<String> splitString(String aString, String separators, Boolean ConsecutiveFlag) {
		ArrayList<Integer> indexes;
		Integer stop;
		Integer index;
		ArrayList<String> result;

		indexes = new ArrayList<Integer>();
		indexes.add(-1);

		stop = aString.length();
		for (index = 0; index < stop; index++) {
			if ((separators.indexOf(aString.charAt(index))) >= 0) {
				indexes.add(index);
			}
		}
		indexes.add(stop);
		stop = indexes.size() - 1;
		result = new ArrayList<String>();
		for (index = 0; index < stop; index++) {
			int start;
			int end;

			start = indexes.get(index) + 1;
			end = indexes.get(index + 1) - 1;
			if (end >= start) {
				result.add(aString.substring(start, end + 1));
			} else {
				if (ConsecutiveFlag) {
					result.add("");
				}
			}
		}

		return result;
	}

	/**
	 * テーブルを応答する。 良好（2017年1月10日）
	 * 
	 * @return talbe テーブル（表：スプレッドシート）
	 */
	public Table table() {
		return this.table;
	}

	/**
	 * 指定された行リストを、指定されたファイルに書き出すクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @param aCollection
	 *            リスト
	 * @param aFile
	 *            ファイル
	 */
	public static void writeText(List<String> aCollection, File aFile) {

		try {
			// FileNotFoundExceptionが出るかもしれない
			OutputStream outputStream = new FileOutputStream(aFile);
			// UnsupportedEncodingExceptionが出るかもしれない
			Writer outputStreamWriter = new OutputStreamWriter(outputStream, IO.encodingSymbol());

			Writer outputWriter = new BufferedWriter(outputStreamWriter);

			String crlf = System.getProperty("line.separator");
			for (String aString : aCollection) {
				// IOExceptionが出るかもしれない
				outputWriter.write(aString);
				outputWriter.write(crlf);
			}
			// IOExceptionが出るかもしれない
			outputWriter.close();
		} catch (IOException anException) {
			anException.printStackTrace();
		}
		return;

	}

	/**
	 * 指定された行リストを、指定されたファイル名のファイルに書き出すクラスメソッド。 良好（2017年1月10日）
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
	 * テキストをリストに追加し、そのリストを返すクラスメソッド。 良好（2017年1月10日）
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
