package primeministers;

/**
 * 例題プログラム：総理大臣のCSVファイルをHTMLページへと変換する。
 * 
 * @version 1.0
 * @author 宮崎光
 */
public class Example extends Object {
	/**
	 * サンプルのメインプログラム。
	 */
	public static void main(String[] arguments) {
		// トランスレータのインスタンスを生成する。
		Translator aTranslator = new Translator();

		// トランスレータに総理大臣のCSVファイルをHTMLページへ変換するように依頼する。
		aTranslator.perform();

		return;
	}
}
