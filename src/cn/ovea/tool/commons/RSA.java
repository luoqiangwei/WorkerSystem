package cn.ovea.tool.commons;

import cn.ovea.tool.commons.exception.RSAException;

import java.io.*;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author QiangweiLuo
 */
public class RSA {
    private String publicKeyFilePath;
    private String privateKeyFilePath;
    private static int keyLong = 8192;

    /**
     *
     * @param publicKeyFilePath
     * @param privateKeyFilePath
     * @param keyLong
     * @throws RSAException
     */
    public RSA(String publicKeyFilePath, String privateKeyFilePath, int keyLong) throws RSAException {
        this(publicKeyFilePath, privateKeyFilePath);
        //判断密钥长度是否可用
        if(keyLong % 64 != 0 || keyLong <= 0) throw new RSAException("key long ERROR!");
        this.keyLong = keyLong;
    }

    public RSA(String publicKeyFilePath, String privateKeyFilePath) throws RSAException {
        //测试路径是否可用
        FileInputStream f1 = null;
        FileInputStream f2 = null;
        try {
            f1 = new FileInputStream(publicKeyFilePath);
            f1.close();
        } catch (FileNotFoundException e) {
            throw new RSAException("publicKey File Path ERROR!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            f2 = new FileInputStream(privateKeyFilePath);
            f2.close();
        } catch (FileNotFoundException e) {
            throw new RSAException("privateKey File Path ERROR!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.privateKeyFilePath = privateKeyFilePath;
        this.publicKeyFilePath = publicKeyFilePath;
    }

    /**
     * 警告：该方法使用过一次后就不要再使用了！否则密钥变了后无法解密
     * 注意：为了安全起见，该方法已被关闭
     */
//    public void createKey(){
//        //创建密钥对生成器，指定加密和解密算法为RSA
//        KeyPairGenerator kpg = null;
//        try {
//            kpg = KeyPairGenerator.getInstance("RSA");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        //指定密钥长度，初始化密钥对生成器
//        kpg.initialize(keyLong);
//        //生成密钥对
//        KeyPair kp = kpg.genKeyPair();
//
//        //获取公钥
//        PublicKey pbKey = kp.getPublic();
//        //获取私钥
//        PrivateKey prKey = kp.getPrivate();
//
////        System.err.println(pbKey.toString());
//        //保存公钥到文件
//        FileOutputStream f1 = null;
//        ObjectOutputStream b1 = null;
//        FileOutputStream f2 = null;
//        ObjectOutputStream b2 = null;
//        try {
//            f1 = new FileOutputStream("publicKeyFilePath");
//            b1 = new ObjectOutputStream(f1);
//            b1.writeObject(pbKey);
//            b1.writeObject(null);
//
//            //保存私钥到文件
//            f2 = new FileOutputStream("privateKeyFilePath");
//            b2 = new ObjectOutputStream(f2);
//            b2.writeObject(prKey);
//            b2.writeObject(null);
//        } catch (exception e) {
//            e.printStackTrace();
//        }
//    }

    public String enCoding(String text){
        // 首部加入0，防止数据变成负数，负数加解密时会出问题
        text = "0" + text;
        try {
            //从文件中读取公钥
            FileInputStream f = new FileInputStream(publicKeyFilePath);
            ObjectInputStream b = new ObjectInputStream(f);
            RSAPublicKey pbk = (RSAPublicKey) b.readObject();

            //RSA算法是使用整数进行加密的，再RSA公钥中包含有两个整数信息：e和n。对于明文数字m，计算密文的公式是m的e次方再与n求模。
            BigInteger e = pbk.getPublicExponent();
            BigInteger n = pbk.getModulus();

            //获取明文的大整数
            byte ptext[] = text.getBytes("UTF8");
            BigInteger m = new BigInteger(ptext);

            //加密明文
            BigInteger c = m.modPow(e, n);
            b.close();
            f.close();
            //返回c
            return c.toString(16);
        }catch (EOFException  e){
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String deCoding(String text){
        BigInteger c = new BigInteger(text, 16);
        try{
            //获取私钥
            FileInputStream f = new FileInputStream(privateKeyFilePath);
            ObjectInputStream b = new ObjectInputStream(f);
            RSAPrivateKey prk = (RSAPrivateKey) b.readObject();

            //获取私钥的参数d，n
            BigInteger d = prk.getPrivateExponent();
            BigInteger n = prk.getModulus();

            //解密明文
            BigInteger m = c.modPow(d, n);

            //计算明文对应的字符串并输出
            byte[] mt = m.toByteArray();
            //System.out.println("PlainText is ");

            StringBuilder sb = new StringBuilder(new String(mt, "UTF-8"));
            b.close();
            f.close();
            // 去除添加在首部的0
            return sb.deleteCharAt(0).toString();
        }catch (EOFException  e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
