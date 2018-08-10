package cn.ovea.test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {
    @Test
    public void fun1() throws IOException {
//        FileInputStream fi = new FileInputStream("/config/Skey_RSA_pub");
//        System.out.println(fi);
        File f = new File("./test/Test_Skey_RSA_pub");
        System.out.println(f.getCanonicalPath());
        System.out.println(f.getCanonicalPath().replace(File.separator, "/"));

        String[] tmp = f.getCanonicalPath().split(File.separator.equals("\\") ? "\\\\" : File.separator);

        for(int i = 0; i < tmp.length; i++)
            System.out.print(tmp[i] + "  ");
    }
}
