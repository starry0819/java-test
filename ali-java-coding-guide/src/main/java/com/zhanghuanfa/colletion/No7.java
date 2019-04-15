package com.zhanghuanfa.colletion;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhanghuanfa 2019-02-27 23:24
 */
public class No7 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            if ("1".equals(next)) {
//                iterator.remove();
//            }
//        }
        // 注意: 下面的for-each中的if条件如果将"1"换成"2", 则会报运行时异常java.util.ConcurrentModificationException
        // 故: 不要在foreach循环里进行元素的remove/add操作。
        // remove元素请使用Iterator方式(即上面的形式), 如果并发操作，需要对Iterator对象加锁。
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);

        String s = "https://genshuixue.com/v1/connect/callback/wechat?state=481adad8726a6275e61d8d0e60378cc6259e3414bef249765111b3cded9d7b62";
        String encode = URLEncoder.encode(s, "UTF-8");
        System.out.println(encode);
    }
}
