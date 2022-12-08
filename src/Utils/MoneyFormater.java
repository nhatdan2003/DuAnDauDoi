package Utils;

import java.text.DecimalFormat;

/**
 *
 * @author haoireal
 */
public class MoneyFormater {
	static final DecimalFormat formatter = new DecimalFormat("###,###,###");
	
	public static String VNDFormat(Double money){
		return formatter.format(money)+" VNĐ";
	}
	
	public static Double DoubleFormat(String vnd){
		Double vndDB = Double.parseDouble(vnd.substring(0,vnd.lastIndexOf(" ")).replaceAll(",",""));
		return vndDB;
	}

}
