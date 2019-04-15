package com.zhanghuanfa.logger;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 敏感信息脱敏处理
 *
 * @author zhanghuanfa 2019-04-03 18:00
 */
public class SensitiveDataConverter extends ClassicConverter {

    @Override
    public void start() {
        List<String> optionList = getOptionList();
        super.start();
    }

    @Override
    public String convert(ILoggingEvent event) {
        // 获取原始日志
        String originMessage = event.getFormattedMessage();
        // 获取脱敏后的日志
        return invokeMsg(originMessage);
    }

    /**
     * 日志脱敏开关
     */
    private static String converterCanRun = "true";
    /**
     * 日志脱敏关键字
     */
    private static String sensitiveDataKeys = "idcard,realname,bankcard,mobile,password,username";

    /**
     * 处理日志字符串，返回脱敏后的字符串
     *
     * @param oriMsg
     * @return
     */
    public String invokeMsg(final String oriMsg) {
        String tempMsg = oriMsg;
        String trueString = "true";
        if (trueString.equalsIgnoreCase(converterCanRun)) {
            // 处理字符串
            if (sensitiveDataKeys != null && sensitiveDataKeys.length() > 0) {
                String[] keysArray = sensitiveDataKeys.split(",");
                for (String key : keysArray) {
                    int index = -1;
                    do {
                        index = tempMsg.indexOf(key, index + 1);
                        if (index != -1) {
                            // 判断key是否为单词字符
                            if (isWordChar(tempMsg, key, index)) {
                                continue;
                            }
                            // 寻找值的开始位置
                            int valueStart = getValueStartIndex(tempMsg, index + key.length());

                            // 查找值的结束位置（逗号，分号）........................
                            int valueEnd = getValueEndIndex(tempMsg, valueStart);

                            // 对获取的值进行脱敏
                            String subStr = tempMsg.substring(valueStart, valueEnd);
                            subStr = tuomin(subStr, key);
                            ///////////////////////////
                            tempMsg = tempMsg.substring(0, valueStart) + subStr + tempMsg.substring(valueEnd);
                        }
                    } while (index != -1);
                }
            }
        }
        return tempMsg;
    }


    private static Pattern pattern = Pattern.compile("[0-9a-zA-Z]");

    /**
     * 判断从字符串msg获取的key值是否为单词 ， index为key在msg中的索引值
     *
     * @return
     */
    private boolean isWordChar(String msg, String key, int index) {

        // 必须确定key是一个单词............................
        if (index != 0) {
            // 判断key前面一个字符
            char preCh = msg.charAt(index - 1);
            Matcher match = pattern.matcher(preCh + "");
            if (match.matches()) {
                return true;
            }
        }
        // 判断key后面一个字符
        char nextCh = msg.charAt(index + key.length());
        Matcher match = pattern.matcher(nextCh + "");
        if (match.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 获取value值的开始位置
     *
     * @param msg        要查找的字符串
     * @param valueStart 查找的开始位置
     * @return
     */
    private int getValueStartIndex(String msg, int valueStart) {
        // 寻找值的开始位置.................................
        do {
            char ch = msg.charAt(valueStart);
            if (ch == ':' || ch == '=') {
                // key与 value的分隔符
                valueStart++;
                while (true) {
                    ch = msg.charAt(valueStart);
                    if (ch == '"' || ch == '[' || ch == ' ') {
                        valueStart++;
                    } else {
                        break;
                    }
                }
                break;    // 找到值的开始位置
            } else {
                valueStart++;
            }
        } while (true);
        return valueStart;
    }

    /**
     * 获取value值的结束位置
     *
     * @return
     */
    private int getValueEndIndex(String msg, int valueEnd) {
        do {
            if (valueEnd == msg.length()) {
                break;
            }
            char ch = msg.charAt(valueEnd);
            // value结束判断
            if (ch == ';' || ch == ',' || ch == '}' || ch == ']' || ch == '"') {
                break;
            } else {
                valueEnd++;
            }

        } while (true);
        return valueEnd;
    }
    private String tuomin(String submsg, String key) {
        // idcard：身份证号, realname：姓名, bankcard：银行卡号, mobile：手机号
        submsg = submsg.trim();
        if ("idcard".equals(key)) {
            return SensitiveInfoUtils.idCardNum(submsg);
        }
        if ("realname".equals(key)) {
            return SensitiveInfoUtils.chineseName(submsg);
        }
        if ("bankcard".equals(key)) {
            return SensitiveInfoUtils.bankCard(submsg);
        }
        if ("mobile".equals(key)) {
            return SensitiveInfoUtils.mobilePhone(submsg);
        }
        if ("password".equals(key)) {
            return SensitiveInfoUtils.password(submsg);
        }
        return "";
    }
}