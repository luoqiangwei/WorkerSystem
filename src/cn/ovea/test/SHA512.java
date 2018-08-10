package cn.ovea.test;

import org.junit.jupiter.api.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512 {

    @Test
    public void fun1() throws NoSuchAlgorithmException {
        String strType = "SHA-512"; //加密类型
        String strText = "ewffwefwe"; //加密文本

        // 创建加密对象
        MessageDigest messageDigest = MessageDigest.getInstance(strType);
        // 传入需要加密的字符串
        messageDigest.update(strText.getBytes());
        //得到加密byte类型
        byte byteBuffer[] = messageDigest.digest();

        //将bytes换成String
        StringBuffer strHexString = new StringBuffer();
        // 遍歷 byte buffer
        for (int i = 0; i < byteBuffer.length; i++)
        {
            String hex = Integer.toHexString(0xff & byteBuffer[i]);
            if (hex.length() == 1)
            {
                strHexString.append('0');
            }
            strHexString.append(hex);
        }
        // 得到返回結果
        String strResult = strHexString.toString();
        System.out.println(strResult);
    }
}
