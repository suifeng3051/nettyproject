/*
 * Created on 2007-1-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package util;

import java.util.ResourceBundle;

/**
 * 
 * @author Paul Jiang.
 * @createDate 2007-1-26.
 * @version 1.0.0.
 */
public class ConfigUtil {

    private static ResourceBundle prb = null;
    private static boolean loaded = false;

    /**
     * ���캯��.
     * 
     * @author Paul Jiang.
     * @createDate 2006-12-25.
     * @version 1.0.0.
     */
    private ConfigUtil() {

    }

    /**
     * ��ȡ�����ļ���ʼ��.
     * 
     * @author Paul Jiang.
     * @createDate 2006-12-25.
     * @version 1.0.0.
     */
    public final static void loadRes() {
        prb = ResourceBundle.getBundle("Global");
    }

    /**
     * ��ݲ����key��ȡ���Ӧ��ֵ.
     * 
     * @param key-Ҫ��ѯ�Ĺؼ���.
     * @return �ؼ��ֶ�Ӧ��ֵ.
     * @author Paul Jiang.
     * @createDate 2006-12-25.
     * @version 1.0.0.
     */
    public static String get(String key) {

    	if (!loaded) {
    		loadRes();
    		loaded = true;
    	}
        String result = null;
        if (prb != null)
            result = prb.getString(key);
        if (result == null)
            result = "";
        try {
            return new String(result.trim().getBytes("ISO8859_1"), "GBK");
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * ������Դ��һ��key=value.
     * 
     * @return. @author Paul Jiang.
     * @createDate 2006-12-25.
     * @version 1.0.0.
     */
    public ResourceBundle getResourceBundle() {
        return prb;
    }

    /**
     * 
     * @param s
     * @param separator
     * @return. @author Paul Jiang.
     * @createDate 2007-3-5.
     * @version 1.0.0.
     */
    public static String[] parseValues(String s, String separator) {
        char internalSeparator = separator.charAt(0);
        int size = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == internalSeparator)
                size++;
        }
        String[] prop = new String[size];
        String tmp = s;
        while (hasMoreElement(tmp, internalSeparator)) {
            prop[index] = tmp.substring(0, tmp.indexOf(separator));
            tmp = tmp.substring(tmp.indexOf(separator) + 1);
            index++;
        }
        prop[index] = tmp;
        return prop;
    }

    /**
     * 
     * @param s
     * @param separator
     * @return. @author Paul Jiang.
     * @createDate 2007-3-5.
     * @version 1.0.0.
     */
    private static boolean hasMoreElement(String s, char separator) {
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == separator)
                size++;
        }
        return size > 0;
    }
}
