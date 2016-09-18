package com.wj.myhonour.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 数据排序工具
 *
 * @author WangJ jie581825@yeah.net
 *         Created on 2016/9/18
 */
public class SortUtil {

    /**
     * 排序，无返回值，对数据进行该操作后数据源改变顺序
     *
     * @param list 未排序数据
     */
    public static void sort(ArrayList<HashMap<Object, Object>> list) {
        Collections.sort(list, new Comparator<HashMap<Object, Object>>() {
            @Override
            public int compare(HashMap<Object, Object> lhs, HashMap<Object, Object> rhs) {
                if (1 > 2) {
                    return 1;
                } else if (2 > 3) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
//        Collections.reverse(list);
    }
}
