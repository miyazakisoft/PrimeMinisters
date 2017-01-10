package primeministers;

/**
 * 例題プログラム：人物のCSVファイルをHTMLページへと変換する。
 * 
 * @version 1.0
 * @author 宮崎光
 */
public class Example extends Object {
	/**
	 * サンプルのメインプログラム。
	 * 
	 * @param arguments
	 *            配列 良好（2017年1月10日）
	 */
	public static void main(String[] arguments) {
		// トランスレータのインスタンスを生成する。

		if (arguments.length == 2) {

			String url = arguments[0];
			String tittleName = arguments[1];

			Translator aTranslator = new Translator(url, tittleName);

			// トランスレータに人物のCSVファイルをHTMLページへ変換するように依頼する。
			aTranslator.perform();
		}

		return;
	}
}
