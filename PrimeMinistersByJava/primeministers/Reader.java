package primeministers;

import java.io.File;
import java.util.List;

/**
 * リーダ：人物の情報を記したCSVファイルを読み込んでテーブルに仕立て上げる。
 * 
 * @version 1.0
 * @author 宮崎光
 */

public class Reader extends IO {
	/**
	 * 人物の情報を記したCSVファイルを記憶するフィールド。
	 */
	private File file;

	/**
	 * リーダのコンストラクタ。 良好（2017年1月10日）
	 * @param tittleName タイトル名
	 * @param csvFileName CSVファイル名
	 */
	public Reader(String tittleName, String csvFileName) {
		super();
		this.file = new File(IO.directoryOfPages(tittleName), csvFileName);

	}

	/**
	 * ダウンロードしたCSVファイルを応答する。 良好（2017年1月10日）
	 * 
	 * @return file ファイル
	 */
	public File getFile() {
		return this.file;
	}

	/**
	 * ダウンロードしたCSVファイルのローカルなファイルを応答するクラスメソッド。 良好（2017年1月10日）
	 * 
	 * @return file.getAbsoluteFile() ダウンロードしたCSVファイルのローカルなファイル
	 */
	public File filenameOfCSV() {
		return this.file.getAbsoluteFile();
	}

	/**
	 * ダウンロードしたCSVファイルを読み込んでテーブルを応答する。 良好（2017年1月10日）
	 */
	@Override
	public Table table() {
		Boolean isFirstLine = true;
		Table inputTable = new Table();
		List<String> aCollection = IO.readTextFromFile(this.file);

		Integer columnNumTarget = 0;
		String aBuffString = "";
		Boolean columnNumTargetFlag = true;

		for (String aString : aCollection) {
			List<String> aRow = null;

			if (columnNumTargetFlag) {
				aRow = IO.splitString(aString.replaceAll("\"", ""), ",", true);
			} else {
				StringBuilder sb = new StringBuilder();
				sb.append(aBuffString);
				sb.append("<br>");
				sb.append(aString);
				aRow = IO.splitString(sb.toString().replaceAll("\"", ""), ",", true);
			}

			if (isFirstLine) {
				columnNumTarget = aRow.size();
				inputTable.setAttributes(new Attributes(aRow));
				isFirstLine = false;
			} else {
				columnNumTargetFlag = aRow.size() == columnNumTarget;

				if (columnNumTargetFlag) {
					Tuple inputTuple = new Tuple(inputTable.getAttributes(), aRow);
					inputTable.add(inputTuple);
					aBuffString = "";
				} else {
					aBuffString = new StringBuilder().append(aBuffString).append(aString).toString();
				}
			}

		}

		return inputTable;
	}

}
