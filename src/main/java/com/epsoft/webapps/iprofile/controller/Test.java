package com.epsoft.webapps.iprofile.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by evgenyp on 5/11/2017.
 */
public class Test {
    public static void main(String[] args) throws IOException {

        String file = "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";
        String userDir = System.getProperty("user.dir");
        String allPathDir = userDir + "\\src\\main\\webapp\\resources\\img\\" + "1\\";
        File userDirectory = new File(allPathDir);
        userDirectory.mkdirs();
        File userAvatarFile = new File(allPathDir + "avatar1.jpg");
        if (userAvatarFile.exists()) {
            userAvatarFile.delete();
            System.out.println("delete");
        }


        File userAvatarFileMain = new File(allPathDir + "avatar.jpg");
        FileInputStream fis = new FileInputStream(userAvatarFileMain);
        String str = "";
        byte[] buffer = new byte[10 * 1024];
        int length;
        length = fis.read(buffer);

        fis.close();
        FileOutputStream fos = new FileOutputStream(userAvatarFile);
        fos.write(buffer, 0, length);
        fos.close();
    }
}
