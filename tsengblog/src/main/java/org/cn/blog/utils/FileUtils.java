package org.cn.blog.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by WunHwanTseng on 2016/11/8.
 */
public class FileUtils {
    private int len=0;
    private byte[] bytes = new byte[1024 * 2];

    public static void upload(MultipartFile file,String path) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(PublicUtils.Public_Local_File, path)));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            System.out.println("success");
    }

    public static void upload(File file) throws Exception {
    }

}
