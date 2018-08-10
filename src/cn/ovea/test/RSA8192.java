package cn.ovea.test;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSA8192 {
    @Test
    public void fun1() throws NoSuchAlgorithmException, IOException {
        //创建密钥对生成器，指定加密和解密算法为RSA
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        //指定密钥长度，初始化密钥对生成器
        kpg.initialize(8192);
        //生成密钥对
        KeyPair kp = kpg.genKeyPair();

        //获取公钥
        PublicKey pbKey = kp.getPublic();
        //获取私钥
        PrivateKey prKey = kp.getPrivate();

//        System.err.println(pbKey.toString());
        //保存公钥到文件
        FileOutputStream f1 = new FileOutputStream("./test/Test_Skey_RSA_pub");
        ObjectOutputStream b1 = new ObjectOutputStream(f1);
        b1.writeObject(pbKey);
        b1.writeObject(null);

        //保存私钥到文件
        FileOutputStream f2 = new FileOutputStream("./test/Test_Skey_RSA_priv");
        ObjectOutputStream b2 = new ObjectOutputStream(f2);
        b2.writeObject(prKey);
        b2.writeObject(null);
    }

    @Test
    public void fun2() throws IOException, ClassNotFoundException {
        //需要加密的明文 可以存6万字 约定最多存3万
        String s = "0" + "我试试674D6186AB3B3我试试";
        //从文件中读取公钥
        FileInputStream f = new FileInputStream("./test/Test_Skey_RSA_pub");
        ObjectInputStream b = new ObjectInputStream(f);
        RSAPublicKey pbk = (RSAPublicKey) b.readObject();

        //RSA算法是使用整数进行加密的，再RSA公钥中包含有两个整数信息：e和n。对于明文数字m，计算密文的公式是m的e次方再与n求模。
        BigInteger e = pbk.getPublicExponent();
        BigInteger n = pbk.getModulus();
        System.out.println("e=" + e);
        System.out.println("n=" + n);

        //获取明文的大整数
        byte ptext[] = s.getBytes("UTF8");
        BigInteger m = new BigInteger(ptext);

        //加密明文
        BigInteger c = m.modPow(e, n);

        //打印密文c
        System.out.println("c=" + c.toString(16));

        //将密文以字符串的方式保存在文件中
        String cs = c.toString();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./test/Test_Enc_RSA.txt")));
        out.write(cs, 0, cs.length());
        out.close();
    }

    @Test
    public void fun3() throws IOException, ClassNotFoundException {
        // 读取密文
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("./test/Test_Enc_RSA.txt")));
        String ctext = in.readLine();
        BigInteger c = new BigInteger(ctext);

        //获取私钥
        FileInputStream f = new FileInputStream("./test/Test_Skey_RSA_priv");
        ObjectInputStream b = new ObjectInputStream(f);
        RSAPrivateKey prk = (RSAPrivateKey) b.readObject();

        //获取私钥的参数d，n
        BigInteger d = prk.getPrivateExponent();
        BigInteger n = prk.getModulus();
        System.out.println("d=" + d);
        System.out.println("n=" + n);

        //解密明文
        BigInteger m = c.modPow(d, n);
        System.out.println("m=" + m);

        //计算明文对应的字符串并输出
        byte[] mt = m.toByteArray();
        System.out.println("PlainText is ");
//        for(int i = 0; i < mt.length; i++){
//            System.out.print((char)mt[i]);
//        }
        StringBuilder sb = new StringBuilder(new String(mt));
        System.out.println(sb.deleteCharAt(0));
    }
}
