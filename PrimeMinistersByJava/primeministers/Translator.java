package primeministers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * トランスレータ：人物のCSVファイルをHTMLページへと変換するプログラム。
 *
 * @version 1.0
 * @author 宮崎光
 */
public class Translator extends Object {

	/**
	 * CSVに由来するテーブルを記憶するフィールド
	 */
	private Table inputTable;

	/**
	 * HTMLに由来するテーブルを記憶するフィールド
	 */
	private Table htmlTable;

	/**
	 * urlを記憶するフィールド
	 */
	private String url;

	/**
	 * タイトル名を記憶するフィールド
	 */
	private String tittleName;

	/**
	 * トランスレータのコンストラクタ。 良好（2017年1月10日）
	 *
	 * @param aUrl
	 *            URL
	 * @param aTittleName
	 *            タイトル名
	 *
	 */
	public Translator(String aUrl, String aTittleName) {
		super();
		this.url = aUrl;
		this.tittleName = aTittleName;
		return;
	}

	/**
	 * 在位日数を計算して、それを文字列にして応答する。 バグ（2017年1月10日）
	 *
	 * @param periodString
	 *            在位期間の文字列
	 * @return days 在位日数
	 *
	 */
	public String computeNumberOfDays(String periodString) {
		ArrayList<String> aStringArray = IO.splitString(periodString, "〜年月日", false);

		Integer yearFrom, monthFrom, dayFrom;
		Integer yearTo, monthTo, dayTo;

		yearFrom = Integer.parseInt(aStringArray.get(0));
		monthFrom = Integer.parseInt(aStringArray.get(1));
		dayFrom = Integer.parseInt(aStringArray.get(2));

		if (aStringArray.size() < 4) {
			Calendar aCalendar = Calendar.getInstance();
			yearTo = aCalendar.get(Calendar.YEAR); // 現在の年を取得
			monthTo = aCalendar.get(Calendar.MONTH) + 1; // 現在の月を取得
			dayTo = aCalendar.get(Calendar.DATE) + 1; // 現在の日を取得
		} else {
			yearTo = Integer.parseInt(aStringArray.get(3));
			monthTo = Integer.parseInt(aStringArray.get(4));
			dayTo = Integer.parseInt(aStringArray.get(5));
		}

		LocalDate from = LocalDate.of(yearFrom, monthFrom, dayFrom);
		LocalDate to = LocalDate.of(yearTo, monthTo, dayTo);
		long diffDays = ChronoUnit.DAYS.between(from, to) + 1;

		String days = String.format("%,d", diffDays);

		return days;

	}

	/**
	 * サムネイル画像から画像へ飛ぶためのHTML文字列を生成して、それを応答する。 良好（2017年1月10日）
	 *
	 * @param aTuple
	 *            タプル
	 * @return サムネイル画像から画像へ飛ぶためのHTML文字列
	 */
	public String computeStringOfImage(Tuple aTuple) {
		List<String> values = aTuple.values();

		String aNumber = values.get(0);

		String aImage = values.get(aTuple.attributes().indexOfImage());
		String aThumbnail = values.get(aTuple.attributes().indexOfThumbnail());

		String imageTag = "<a name=\"" + aNumber + "\" href=\"" + aImage + "\"><img class=\"borderless\" src=\""
				+ aThumbnail + "\" width=\"25\" height=\"32\" alt=\"" + aNumber + ".jpg\"></a>";
		return imageTag;
	}

	/**
	 * 人物のCSVファイルをHTMLページへ変換する。 良好（2017年1月10日）
	 */
	public void perform() {

		Downloader aDownload = new Downloader(this.url, this.tittleName);

		aDownload.downloadCSV();

		System.out.println("画像をダウンロードします.");
		aDownload.downloadImages();

		aDownload.downloadThumbnails();

		this.inputTable = aDownload.table();

		for (Tuple inputTapule : inputTable.tuples()) {
			for (String stringValue : inputTapule.values()) {
				StringBuilder sb = new StringBuilder();
				sb.append(stringValue);
				sb.append(",");
				System.out.print(sb.toString());
			}
			System.out.println();
		}

		this.htmlTable = this.convertFromInputToHtmlTable(this.inputTable);

		Writer aWriter = new Writer(this.tittleName);
		aWriter.table(htmlTable);
		System.out.printf("%s%n", "人物のCSVファイルからHTMLページへの変換を無事に完了しました.");
		return;
	}

	/**
	 * 人物のCSVファイルを基にしたテーブルから、HTMLページを基にするテーブルに変換して、それを応答する。 良好（2017年1月10日）
	 *
	 * @param inputTable
	 *            入力用のテーブル
	 * @return htmlTable HTMLページを基にするテーブル
	 *
	 */
	public Table convertFromInputToHtmlTable(Table inputTable) {

		List<String> newAttributesCollection = new ArrayList<String>();

		for (String aString : inputTable.getAttributes().getAttributesCollection()) {
			if (!aString.equals("縮小画像")) {
				newAttributesCollection.add(aString);
			}

			if (aString.equals("在位期間")) {
				newAttributesCollection.add("在位日数");
			}
		}

		Table htmlTable = new Table();

		Attributes attributes = new Attributes(newAttributesCollection);

		htmlTable.setAttributes(attributes);

		for (Tuple aTuple : inputTable.tuples()) {
			List<String> values = aTuple.values();

			List<String> aRow = new ArrayList<String>();

			Iterator<String> newAttributesIterator = newAttributesCollection.iterator();
			Iterator<String> TuppleRowIterator = values.iterator();

			String daysOfResidence = "";

			while (newAttributesIterator.hasNext()) {
				String aNewAttributes = (String) newAttributesIterator.next();

				if (aNewAttributes.equals("在位日数")) {
					aRow.add(daysOfResidence);
				} else if (aNewAttributes.equals("画像")) {
					aRow.add(this.computeStringOfImage(aTuple));
					TuppleRowIterator.next();
					TuppleRowIterator.next();

				} else {
					String aTuppleRow = (String) TuppleRowIterator.next();
					aRow.add(aTuppleRow);

					if (aNewAttributes.equals("在位期間")) {
						daysOfResidence = computeNumberOfDays(aTuppleRow);
					}

				}
			}

			Tuple outputTuple = new Tuple(attributes, aRow);
			htmlTable.add(outputTuple);

		}

		return htmlTable;
	}

}
