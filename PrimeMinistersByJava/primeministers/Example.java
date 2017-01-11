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

		String url;
		String tittleName;


		if (arguments.length == 2) {
			url = arguments[0];
			tittleName = arguments[1];
		}else{
			url = "http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/VisualWorks/CSV2HTML/PrimeMinisters/PrimeMinisters.csv";
			tittleName = "PrimeMinisters";
		}



		Translator aTranslator = new Translator(url, tittleName);

		// トランスレータに人物のCSVファイルをHTMLページへ変換するように依頼する。
		aTranslator.perform();

		return;
	}
}
