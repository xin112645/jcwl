package com.dww.util;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {

    public static String getPropertiesValue(String fileName,String key){
        String strResult = null;
        Properties props = new Properties();
        if (System.getProperty("os.name").toLowerCase().indexOf("window") > -1) {
            strResult = PropertiesUtil.class.getResource("/").toString().replace("file:/", "")
                    .replace("%20", " ");
        } else {
            strResult = PropertiesUtil.class.getResource("/").toString().replace("file:", "")
                    .replace("%20", " ");
        }
        String filePath=strResult + fileName;

        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            //关闭资源
            in.close();
            // return props.getProperty(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key);
    }



    public static boolean setPropertiesValue(String fileName ,String keyName,String valueName){
        boolean result = false;
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        String strResult = null;
        if (System.getProperty("os.name").toLowerCase().indexOf("window") > -1) {
            strResult = PropertiesUtil.class.getResource("/").toString().replace("file:/", "")
                    .replace("%20", " ");
        } else {
            strResult = PropertiesUtil.class.getResource("/").toString().replace("file:", "")
                    .replace("%20", " ");
        }

        String path = strResult;
        try {
            bufferedReader = new BufferedReader(new FileReader(path+fileName));
            properties.load(bufferedReader);
            properties.setProperty(keyName, valueName);
            bufferedWriter = new BufferedWriter(new FileWriter(path+fileName));
            properties.store(bufferedWriter, null);
            bufferedWriter.close();// 关闭流
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        }

        return result;
    }
}
