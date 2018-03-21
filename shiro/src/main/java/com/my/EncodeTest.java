package com.my;

import java.security.Key;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.After;
import org.junit.Test;

import junit.framework.Assert;

public class EncodeTest {
    //base64加密
    @Test
    public void test() {
        String string="before encode";
        byte[] cryptText=Base64.encode(string.getBytes());
        String string2=Base64.decodeToString(cryptText);
        Assert.assertEquals(string, string2);
        System.out.println("测试加密");
    }
    //散列算法：一般用于生成数据的摘要信息，不可逆算法，常见散列算法：MD5，SHA,一般进行散列算法，最好提供一个salt
    @Test
    public void testHash() {
        String plainText="before encode";
        String salt="salt";
        String md5=new Md5Hash(plainText, salt).toString();
        System.out.println("md5 cyptText:"+md5+" cyptLength:"+md5.length());
        
        String shaHash=new Sha256Hash(plainText, salt).toString();
        System.out.println("hash cyptText:"+shaHash+"cyptLength:"+shaHash.length());
        
        String simpleHash=new SimpleHash("SHA-1",plainText,salt).toString();
        System.out.println("simpleHash cyptText:"+shaHash+"cyptLength:"+simpleHash.length());
    }
    
    @After
    public void testHashService() {
        DefaultHashService hashService=new DefaultHashService();
        hashService.setHashAlgorithmName("SHA-512");//设置算法
        hashService.setPrivateSalt(new SimpleByteSource("123"));//私盐，默认没有
        hashService.setGeneratePublicSalt(true);//是否生成公盐，默认是false
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐
        hashService.setHashIterations(1);//生成Hash值得迭次数
        HashRequest request=new HashRequest.Builder().setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("helllo"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex=hashService.computeHash(request).toHex();
        System.out.println("Hex Hash:"+hex+" cyptLength:"+hex.length());
    }
    
    //对称加密算法：AES
    @Test
    public void AESTest() {
        AesCipherService aesCipherService=new AesCipherService();
        aesCipherService.setKeySize(128);
         Key key = aesCipherService.generateNewKey();
        String plainText="plain text";
        String cyptText=aesCipherService.encrypt(plainText.getBytes(),key.getEncoded()).toHex();
        String text=new String(aesCipherService.decrypt(Hex.decode(cyptText), key.getEncoded()).getBytes());
        Assert.assertEquals(plainText, text);
        System.out.println("AES crypt:"+cyptText+" length:"+cyptText.length());
        
    }
    
}
