package com.jh.rental.user.bean;



import java.io.File;

/**
 * Created by 俊辉出行 on 2017/6/1.
 */

public class Ted {
    static	String  string="E:\\work\\src\\android\\AndroidApp\\user\\src\\main\\res\\scenphoto1-xxxhdpi";
    public static void main(String[] asr){
        File file =new File(string);

        int  a=0;
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            for (int i = 0; i < listFiles.length; i++) {
                System.out.println(listFiles[i].getAbsolutePath());
                if (listFiles[i].getName().contains("xxx")) {
                    //		 String  name =listFiles[i].getAbsolutePath().replace("xxx", "xx");
                    String  strings =listFiles[i].getName().replace("xxx", "xx");
                    listFiles[i].renameTo(new File(string+"\\"+strings));
                    a++;
		/*	 listFiles[i].renameTo(new File(name));
			 a++;*/
                }

            }
            System.out.println(a);

        }


    }
}
