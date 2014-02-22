package weixin.util;

import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by chenyingxi on 14-2-19.
 * 这个类用来放处理String的辅助函数
 * 欢迎大家补充
 */
public class StringHandler {
    /**
     * 将两个以逗号为分隔符的String字符串，进行合并并且取出重复
     *
     * @param Str1 传入要处理的字符串 格式Str1=“001,002,003,004,006"
     * @param Str2 传入要处理的字符串 格式str2 = "001,002,005"
     * @return 返回处理后的结果 "001,002,003,004,005,006"
     * -- 陈映西
     */
    public static String MergeTwoString(String Str1, String Str2) {
        String str = "";
        TreeSet ts = new TreeSet();
        StringTokenizer st = new StringTokenizer(Str1, ",");
        while (st.hasMoreTokens()) {
            ts.add(st.nextToken());
        }
        st = new StringTokenizer(Str2, ",");
        while (st.hasMoreTokens()) {
            ts.add(st.nextToken());
        }
        Iterator it = ts.iterator();
        while (it.hasNext())
            str = str + it.next() + ",";
        if (str.contains(",")) {
            return str.substring(0, str.lastIndexOf(",") - 1);
        }
        return str;
    }

    /**
     * 将两个以reg为分隔符的String字符串，进行合并并且取出重复
     *
     * @param reg  传入分隔符 ","
     * @param Str1 传入要处理的字符串 格式Str1=“001,002,003,004,006"
     * @param Str2 传入要处理的字符串 格式str2 = "001,002,005"
     * @return 返回处理后的结果 "001,002,003,004,005,006"
     * -- 陈映西
     */
    public static String MergeTwoString(String Str1, String Str2, String reg) {
        String str = "";
        TreeSet ts = new TreeSet();
        StringTokenizer st = new StringTokenizer(Str1, reg);
        while (st.hasMoreTokens()) {
            ts.add(st.nextToken());
        }
        st = new StringTokenizer(Str2, reg);
        while (st.hasMoreTokens()) {
            ts.add(st.nextToken());
        }
        Iterator it = ts.iterator();
        while (it.hasNext())
            str = str + it.next() + reg;
        if (str.contains(reg)) {
            return str.substring(0, str.lastIndexOf(",") - 1);
        }
        return str;
    }

    /**
     * 将以逗号为分隔符的String字符串，进行出去重复的字段
     *
     * @param Str 输入"OCM0000,TIM0000,OCM0000,ACM0000,BSM0000"
     * @return 返回"OCM0000,TIM0000,ACM0000,BSM0000"
     * --陈映西
     */
    public static String DistintString(String Str) {
        String str = "";
        TreeSet ts = new TreeSet();
        StringTokenizer st = new StringTokenizer(Str, ",");
        while (st.hasMoreTokens()) {
            ts.add(st.nextToken());
        }
        Iterator it = ts.iterator();
        while (it.hasNext())
            str = str + it.next() + ",";
        if (str.contains(",")) {
            return str.substring(0, str.lastIndexOf(",") - 1);
        }
        return str;
    }

    /**
     * 将以分隔符的String字符串，进行出去重复的字段
     *
     * @param reg 分割符类型 ","
     * @param Str 输入"OCM0000,TIM0000,OCM0000,ACM0000,BSM0000"
     * @return 返回"OCM0000,TIM0000,ACM0000,BSM0000"
     * --陈映西
     */
    public static String DistintString(String Str, String reg) {
        String str = "";
        TreeSet ts = new TreeSet();
        StringTokenizer st = new StringTokenizer(Str, reg);
        while (st.hasMoreTokens()) {
            ts.add(st.nextToken());
        }
        Iterator it = ts.iterator();
        while (it.hasNext())
            str = str + it.next() + reg;
        if (str.contains(reg)) {
            return str.substring(0, str.lastIndexOf(",") - 1);
        }
        return str;
    }


}
