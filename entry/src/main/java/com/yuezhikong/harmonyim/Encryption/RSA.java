package com.yuezhikong.harmonyim.Encryption;

import java.util.Base64;

import com.yuezhikong.harmonyim.utils.FileUtils;

import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;

public class RSA {
    public static KeyData loadPublicKeyFromFile(String filePath)
    {
        try {
            String keyString = FileUtils.readTxt(filePath).toString();
            KeyData keyData = new KeyData();
            keyData.PublicKey = keyString;
            return keyData;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static KeyData generateKeyToReturn()
    {
        KeyData keyData = new KeyData();
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        keyData.privateKey = pair.getPrivate();
        keyData.publicKey = pair.getPublic();
        return keyData;
    }

    public static String encrypt(String Message, String PublicKey)
    {
        cn.hutool.crypto.asymmetric.RSA rsa = new cn.hutool.crypto.asymmetric.RSA(null,PublicKey);
        return Base64.getEncoder().encodeToString(rsa.encrypt(Message, KeyType.PublicKey));
    }

    public static String decrypt(String message, PrivateKey privateKey) {
        cn.hutool.crypto.asymmetric.RSA rsa = new cn.hutool.crypto.asymmetric.RSA(privateKey, null);
        return rsa.decryptStr(message, KeyType.PrivateKey);
    }

}