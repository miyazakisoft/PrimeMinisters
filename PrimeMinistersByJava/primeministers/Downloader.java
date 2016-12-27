package primeministers;

import java.io.File;
import java.util.List;

/**
 * ダウンローダ：総理大臣のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 * 
 * @version 1.0
 * @author 宮崎光
 */
public class Downloader extends IO {
	/**
	 * ここを作成してください。 まず、次のページを参照しながら、スケルトン（スタブ）を作ることから始めましょう。
	 * http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/CSV2HTML/PrimeMinistersJavaDoc/index.html
	 */

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL文字列)を記憶するフィールド。
	 */
	private String url;

	public Downloader() {
		this.url = Downloader.urlStringOfCSV();
	}

	/**
	 * 総理大臣の情報を記しCSVファイルをダウンロードする。
	 */
	public void downloadCSV() {
		List<String> aCollection = IO.readTextFromURL(this.url);
		File aFile = new File(IO.directoryOfPages(), "PrimeMinisters.csv");
		IO.writeText(aCollection, aFile);
		
		return;
	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadImages() {
		File aFile = new File(IO.directoryOfPages(), "images");
		if (aFile.exists() == false) {
			aFile.mkdir();
		}
		Integer index = this.table.attributes().indexOfImage();
		this.downloadPictures(index);

		return;
	}

	/**
	 * 総理大臣の画像群またはサムネイル画像群をダウンロードする。
	 */
	private void downloadPictures(Integer indexOfPicture) {

	}

	/**
	 * 総理大臣の画像群をダウンロードする。
	 */
	public void downloadThumbnails() {
		File aFile = new File(IO.directoryOfPages(), "thumbnails");
		if (aFile.exists() == false) {
			aFile.mkdir();
		}
		Integer index = super.table.attributes().indexOfThumbnail();
		this.downloadPictures(index);

		return;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群を ダウンロードし、テーブルで応答する。
	 */
	@Override
	public Table table() {
		Reader aReader = new Reader();
		this.table = aReader.table();

		return this.table;
	}

	/**
	 * 総理大臣の情報を記したCSVファイルの在処(URL)を文字列で応答する。
	 */
	public String url() {
		return this.url;
	}

	/**
	 * 総理大臣の情報の在処(URL)を文字列で応答するクラスメソッド。
	 */
	public static String urlString() {
		return "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/VisualWorks/CSV2HTML/PrimeMinisters/";
	}

	/**
	 * 総理大臣の情報を記したCSVファイル在処(URL)を文字列で応答するクラスメソッド。
	 */
	public static String urlStringOfCSV() {
		return Downloader.urlString() + "PrimeMinisters.csv";
	}

}
