package com.dww.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;


public class FileUplode {




    public String uploadFile(MultipartFile file,String filePath) {
        String picname="";
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                //mime类型
                String ext = FilenameUtils.getExtension(file.getOriginalFilename());
                //更改后的文件名
                picname=UUID.randomUUID().toString().replaceAll("-","")+"."+ext;
                // 文件保存路径


                String returnfilePath = Thread.currentThread().getContextClassLoader().getResource("").toString().substring(6);
                // 转存文件
                file.transferTo(new File("/"+returnfilePath+filePath+"/"+picname));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return filePath+"/"+picname;
    }
}
