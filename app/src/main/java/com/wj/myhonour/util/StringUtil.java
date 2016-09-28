package com.wj.myhonour.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * WangJ jie581825@yeah.net
 * Created on 2016/9/18
 * Modified:
 * Modified on
 */
public class StringUtil {
    /**
     * 判断字符串是否为空：true-空；false-不空
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 金钱货币化显示(西方货币数量格式，如 12,345.00)
     *
     * @param moneyStr
     */
    public static String formatMoney(String moneyStr) {
        if (!isEmpty(moneyStr)) {
            if (moneyStr.contains(",")) {
                moneyStr = formatMoneyForRequest(moneyStr);
            }
            BigDecimal amount = new BigDecimal(moneyStr);
            DecimalFormat df = new DecimalFormat("###,##0.00");
            return df.format(amount);
        }
        return "0.00";
    }

    /**
     * 金钱货币化报文传递(如 12340.00)
     *
     * @param moneyStr
     */
    public static String formatMoneyForRequest(String moneyStr) {
        if (!isEmpty(moneyStr)) {
            StringBuilder sb = new StringBuilder(moneyStr);
            int lp = sb.lastIndexOf(",");
            while (0 < lp) {
                sb.delete(lp, lp + 1);
                lp = sb.lastIndexOf(",");
            }
            BigDecimal amount = new BigDecimal(sb.toString());
            DecimalFormat df = new DecimalFormat("##0.00");
            return df.format(amount);
        }
        return "0.00";
    }
}
