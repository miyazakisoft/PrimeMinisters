package primeministers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

/**
 * ダウンローダ：人物のCSVファイル・画像ファイル・サムネイル画像ファイルをダウンロードする。
 * 
 * @version 1.0
 * @author 宮崎光
 */
public class Downloader extends IO {

	/**
	 * 人物の情報を記したCSVファイルの在処(URL文字列)を記憶するフィールド。
	 */
	private String url;

	/**
	 * CSVFileの名前を記憶するフィールド。
	 */
	private String csvFileName;

	/**
	 * 人物の情報の在処(URL)を記憶するフィールド。
	 */
	private String urlString;

	/**
	 * タイトルの名前を記憶するフィールド。
	 */
	private String tittleName;

	/**
	 * Downloaderのコンストラクタである。 良好（2017年1月10日）
	 * 
	 * @param anURL
	 *            URL
	 * @param anTittleName
	 *            タイトル名
	 */
	public Downloader(String anURL, String anTittleName) {
		super();
		this.setURL(anURL);
		String csvFileName = this.convertURLToCSVFileName(anURL);
		this.setCSVFileName(csvFileName);

		String urlString = this.convertURLToURLString(anURL);
		this.setUrlString(urlString);

		this.setTittleName(anTittleName);

	}

	/**
	 * 人物の情報を記したCSVファイルの在処(URL)を文字列でフィールドにセットする。 良好（2017年1月10日）
	 * 
	 * @param anURL
	 *            人物の情報を記したCSVファイルの在処(URL)
	 */
	private void setURL(String anURL) {
		this.url = anURL;
	}

	/**
	 * 人物の情報を記したCSVファイルの在処(URL)を文字列で応答する。 良好（2017年1月10日）
	 * 
	 * @return url URL
	 */
	public String getURL() {
		return this.url;
	}

	/**
	 * CSVFileの名前をフィールドにセットする。 良好（2017年1月10日）
	 * 
	 * @param aCSVFileName
	 *            CSVファイルの名前
	 */
	private void setCSVFileName(String aCSVFileName) {
		this.csvFileName = aCSVFileName;
	}

	/**
	 * CSVFileの名前を応答する。 良好（2017年1月10日）
	 * 
	 * @return CSVFileの名前
	 */
	public String getCSVFileName() {
		return this.csvFileName;
	}

	/**
	 * URL文字列からCSVFile名の文字列を抽出する。 良好（2017年1月10日）
	 * 
	 * @param anURL
	 *            URL
	 * @return CSVFileName CSVFile名
	 */
	private String convertURLToCSVFileName(String anURL) {

		String[] URLDelimited = anURL.split("/");

		String CSVFileName = URLDelimited[URLDelimited.length - 1];

		return CSVFileName;
	}

	/**
	 * URL文字列をフィールドにセットする。 良好（2017年1月10日）
	 * 
	 * @param anURLString
	 *            URL文字列
	 */
	public void setUrlString(String anURLString) {
		this.urlString = anURLString;
	}

	/**
	 * URL文字列を応答する。 良好（2017年1月10日）
	 * 
	 * @return urlString URL文字列
	 */
	public String getUrlString() {
		return urlString;
	}

	/**
	 * URL文字列からURLStringの文字列を抽出する。 良好（2017年1月10日）
	 * 
	 * @param anURL
	 *            URL
	 * @return UrlString URL文字列
	 */
	public String convertURLToURLString(String anURL) {
		Pattern pattern = Pattern.compile("(.*)/.*.csv");

		Matcher match = pattern.matcher(anURL);
		if (match.find()) {
			return match.group(1);
		} else {
			System.err.println("URLの指定に誤りがあります");
			return null;
		}
	}

	/**
	 * タイトルの名前をフィールドにセットする。 良好（2017年1月10日）
	 * 
	 * @param aTittleName
	 *            タイトルの名前
	 */
	public void setTittleName(String aTittleName) {
		this.tittleName = aTittleName;
	}

	/**
	 * タイトルの名前を文字列で応答する。 良好（2017年1月10日）
	 * 
	 * @return tittleName タイトル名
	 */
	public String getTittleName() {
		return this.tittleName;
	}

	/**
	 * 人物の情報を記したCSVファイル在処(URL)を文字列で応答するクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @return URLStringとCSVFile名を連結して応答する。
	 */
	public String urlStringOfCSV() {
		return this.getUrlString() + this.getCSVFileName();
	}

	/**
	 * 人物の情報を記しCSVファイルをダウンロードする。 良好（2017年1月10日）
	 */
	public void downloadCSV() {
		List<String> aCollection = IO.readTextFromURL(this.url);
		File aFile = new File(IO.directoryOfPages(this.getTittleName()), this.getCSVFileName());
		IO.writeText(aCollection, aFile);

		return;
	}

	/**
	 * 人物の画像群をダウンロードする。 良好（2017年1月10日）
	 */
	public void downloadImages() {
		File aFile = new File(IO.directoryOfPages(this.getTittleName()), "images");
		if (aFile.exists() == false) {
			aFile.mkdir();
		}
		Integer index = this.table().getAttributes().indexOfImage();
		this.downloadPictures(index);

		return;
	}

	/**
	 * 人物の画像群をダウンロードする。 良好（2017年1月10日）
	 */
	public void downloadThumbnails() {
		File aFile = new File(IO.directoryOfPages(this.getTittleName()), "thumbnails");
		if (aFile.exists() == false) {
			aFile.mkdir();
		}
		Integer index = this.table.getAttributes().indexOfThumbnail();
		this.downloadPictures(index);

		return;
	}

	/**
	 * 人物の画像群またはサムネイル画像群をダウンロードする。 良好（2017年1月10日）
	 */
	private void downloadPictures(Integer indexOfPicture) {

		try {
			for (Tuple aTuple : this.table().tuples()) {
				URL aURL = null;
				BufferedImage anImage = null;
				String aString = aTuple.values().get(indexOfPicture);

				StringBuffer aBuffer = new StringBuffer();
				aBuffer.append(this.getUrlString());
				aBuffer.append("/");
				aBuffer.append(aString);

				// MalformedURLExceptionが出るかもしれない
				aURL = new URL(aBuffer.toString());

				// IOExceptionが出るかもしれない
				anImage = ImageIO.read(aURL);
				System.out.println(aBuffer.toString());

				// IOExceptionが出るかもしれない
				ImageIO.write(anImage, "jpeg", new File(IO.directoryOfPages(this.getTittleName()), aString));

				if (indexOfPicture == aTuple.attributes().indexOfThumbnail()) {
					this.table.thumbnails().add(anImage);
				} else {
					this.table.images().add(anImage);
				}
			}
		} catch (MalformedURLException anException) {
			anException.printStackTrace();
		} catch (IOException anException) {
			anException.printStackTrace();
		}
		return;
	}

	/**
	 * 人物の情報を記したCSVファイルをダウンロードして、画像群やサムネイル画像群を ダウンロードし、テーブルで応答する。 良好（2017年1月10日）
	 */
	@Override
	public Table table() {
		Reader aReader = new Reader(this.getTittleName(), this.csvFileName);
		this.table = aReader.table();

		return this.table;
	}

}
