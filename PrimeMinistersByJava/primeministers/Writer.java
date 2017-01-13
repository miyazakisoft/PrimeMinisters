package primeministers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.List;

/**
 * ライタ：人物の情報のテーブルをHTMLページとして書き出す。
 *
 * @version 1.0
 * @author 宮崎光
 */

public class Writer extends IO {

	private String tittleName;

	/**
	 * ライタのコンストラクタ。
	 * 良好（2017年1月10日）
	 * @param anTittleName
	 *            タイトル名
	 */
	public Writer(String anTittleName) {
		super();
		this.tittleName = anTittleName;
		return;
	}

	/**
	 * 属性リストを応答する。
	 * 良好（2017年1月10日）
	 * @return table.getAttributes() 属性リスト
	 */
	public Attributes attributes() {
		return this.table.getAttributes();
	}

	/**
	 * ローカルなHTMLのインデックスファイル(index.html)を応答するクラスメソッド。
	 * 良好（2017年1月10日）
	 * @return aFile ファイル
	 */
	public File fileNameOfHTML() {
		File aFile = IO.directoryOfPages(this.tittleName);
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(aFile.getPath());
		stringBuilder.append(File.separator);
		stringBuilder.append("index.html");

		aFile = new File(stringBuilder.toString());
		return aFile;
	}

	/**
	 * HTMLページを基にするテーブルを受け取って、インデックスファイル(index.html)に書き出す。
	 * 良好（2017年1月10日）
	 * @param aTable
	 *            テーブル
	 * @return table テーブル
	 */
	public Table table(Table aTable) {
		this.table = aTable;

		try {
			// FileNotFoundExceptionが出るかもしれない
			OutputStream fileOutputStream = new FileOutputStream(this.fileNameOfHTML());

			// UnsupportedEncodingExceptionが出るかもしれない
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, IO.encodingSymbol());

			BufferedWriter aBufferedWriter = new BufferedWriter(outputStreamWriter);

			this.writeHeaderOn(aBufferedWriter);
			this.writeTableBodyOn(aBufferedWriter);
			this.writeFooterOn(aBufferedWriter);

			// IOExceptionが出るかもしれない
			aBufferedWriter.close();
		} catch (FileNotFoundException error) {
			error.printStackTrace();
		} catch (UnsupportedEncodingException error) {
			error.printStackTrace();
		} catch (IOException error) {
			error.printStackTrace();
		}
		return super.table();

	}

	/**
	 * タプル群を応答する。
	 * 良好（2017年1月10日）
	 * @return table.tuples() タプル群
	 */
	public List<Tuple> tuples() {
		return this.table.tuples();
	}

	/**
	 * 属性リストを書き出す。
	 * 良好（2017年1月10日）
	 * @param outputWriter
	 *            outputWriter
	 */
	public void writeAttributesOn(BufferedWriter outputWriter) {
		List<String> strings = this.attributes().getAttributesCollection();
		try {
			outputWriter.write("\t\t<tr>\n");
			for (String aString : strings) {
				outputWriter.write("\t\t\t<td class=\"center-pink\"><strong>");
				outputWriter.write(aString);
				outputWriter.write("</strong></td>\n");
			}
			outputWriter.write("\t\t</tr>\n");
		} catch (IOException anException) {
			anException.printStackTrace();
		}

		return;

	}

	/**
	 * フッタを書き出す。
	 * 良好（2017年1月10日）
	 * @param outputWriter
	 *            outputWriter
	 */
	public void writeFooterOn(BufferedWriter outputWriter) {
		Calendar aCalendar = Calendar.getInstance();

		int year = aCalendar.get(Calendar.YEAR);
		int month = aCalendar.get(Calendar.MONTH) + 1;
		int day = aCalendar.get(Calendar.DATE);
		int hour = aCalendar.get(Calendar.HOUR_OF_DAY);
		int minute = aCalendar.get(Calendar.MINUTE);
		int second = aCalendar.get(Calendar.SECOND);

		StringBuffer aBuffer = new StringBuffer();
		aBuffer.append(this.getClass().getName());
		aBuffer.append(" on ");
		aBuffer.append(String.format("%1$04d/", year));
		aBuffer.append(String.format("%1$02d/", month));
		aBuffer.append(String.format("%1$02d", day));
		aBuffer.append(" at ");
		aBuffer.append(String.format("%1$02d:", hour));
		aBuffer.append(String.format("%1$02d:", minute));
		aBuffer.append(String.format("%1$02d", second));
		String aString = aBuffer.toString();
		try {
			outputWriter
					.write("\t\t</tbody>\n\t  </table>\n\t  </td>\n\t</tr>\n  </tbody>\n</table>\n<hr>\n<div class=\"right-small\">Created by "
							+ aString + "</div>\n</body>\n</html>\n");
		} catch (IOException anException) {
			anException.printStackTrace();
		}
		return;
	}

	/**
	 * ヘッダを書き出す。
	 * 良好（2017年1月10日）
	 * @param outputWriter
	 *            outputWriter
	 */
	public void writeHeaderOn(BufferedWriter outputWriter) {
		try {
			outputWriter
					.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html lang=\"ja\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n<meta http-equiv=\"Content-Style-Type\" content=\"text/css\">\n<meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\">\n<meta name=\"keywords\" content=\"Smalltalk,Oriented,Programming\">\n<meta name=\"description\" content=\"Prime Ministers\">\n<meta name=\"author\" content=\"AOKI Atsushi\">\n<link rev=\"made\" href=\"http://www.cc.kyoto-su.ac.jp/~atsushi/\">\n<link rel=\"index\" href=\"index.html\">\n<style type=\"text/css\">\n<!--\nbody {\n\tbackground-color : #ffffff;\n\tmargin : 20px;\n\tpadding : 10px;\n\tfont-family : serif;\n\tfont-size : 10pt;\n}\na {\n\ttext-decoration : underline;\n\tcolor : #000000;\n}\na:link {\n\tbackground-color : #ffddbb;\n}\na:visited {\n\tbackground-color : #ccffcc;\n}\na:hover {\n\tbackground-color : #dddddd;\n}\na:active {\n\tbackground-color : #dddddd;\n}\ndiv.belt {\n\tbackground-color : #eeeeee;\n\tpadding : 0px 4px;\n}\ndiv.right-small {\n\ttext-align : right;\n\tfont-size : 8pt;\n}\nimg.borderless {\n\tborder-width : 0px;\n\tvertical-align : middle;\n}\ntable.belt {\n\tborder-style : solid;\n\tborder-width : 0px;\n\tborder-color : #000000;\n\tbackground-color : #ffffff;\n\tpadding : 0px 0px;\n\twidth : 100%;\n}\ntable.content {\n\tborder-style : solid;\n\tborder-width : 0px;\n\tborder-color : #000000;\n\tpadding : 2px 2px;\n}\ntd.center-blue {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ddeeff;\n}\ntd.center-pink {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ffddee;\n}\ntd.center-yellow {\n\tpadding : 2px 2px;\n\ttext-align : center;\n\tbackground-color : #ffffcc;\n}\n-->\n</style>\n<title>"
							+ this.tittleName + "</title>\n</head>\n<body>\n<div class=\"belt\">\n<h2>"
							+ this.tittleName
							+ "</h2>\n</div>\n<table class=\"belt\" summary=\"table\">\n\t<tbody>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<table class=\"content\" summary=\"table\">\n\t\t\t\t\t<tbody>\n");
		} catch (IOException anException) {
			anException.printStackTrace();
		}

		return;

	}

	/**
	 * ボディを書き出す。
	 * 良好（2017年1月10日）
	 * @param outputWriter
	 *            outputWriter
	 */
	public void writeTableBodyOn(BufferedWriter outputWriter) {
		this.writeAttributesOn(outputWriter);
		this.writeTuplesOn(outputWriter);
		return;
	}

	/**
	 * タプルを書き出す。
	 * 良好（2017年1月10日）
	 * @param outputWriter
	 *            outputWriter
	 */
	public void writeTuplesOn(BufferedWriter outputWriter) {

		int index = 0;
		List<Tuple> tuples = tuples();
		try {
			for (Tuple aTuple : tuples) {
				outputWriter.write("\t\t<tr>\n");

				List<String> values = aTuple.values();
				for (String aString : values) {
					if (index % 2 == 0) {
						outputWriter.write("\t\t\t<td class=\"center-blue\">");
					} else {
						outputWriter.write("\t\t\t<td class=\"center-yellow\">");
					}
					outputWriter.write(aString);
					outputWriter.write("</td>\n");
				}
				index++;
				outputWriter.write("\t\t</tr>\n");
			}
		} catch (IOException anException) {
			anException.printStackTrace();
		}

	}
}
