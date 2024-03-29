package com.hoxtonr.crypto.ftx.signature;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Locale;

public class SignatureGenerator {


    public String generateSignature(String secretkey, String body) throws Exception {
        return HMACSHA256(body, secretkey).toLowerCase(Locale.ROOT);
    }

    private String HMACSHA256(String data, String key) throws Exception {

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");

        sha256_HMAC.init(secret_key);

        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();

        for (byte item : array) {

            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));

        }

        return sb.toString().toUpperCase();

    }
}