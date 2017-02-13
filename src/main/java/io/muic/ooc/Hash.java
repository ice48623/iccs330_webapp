package io.muic.ooc;

import java.security.MessageDigest;

/**
 * Created by ice on 2/12/17.
 */
public class Hash {
    public static String genHash(String name, String passwd) throws Exception {
        String salts = "12,12,12";

        String salttmp[] = salts.split(",");
        byte salt[] = new byte[salttmp.length];

        for (int i = 0; i < salt.length; i++) {
            salt[i] = Byte.parseByte(salttmp[i]);
        }
        MessageDigest m = MessageDigest.getInstance("SHA-256");
        m.update(salt);
        m.update(name.getBytes("UTF8"));
        byte s[] = m.digest();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00).substring(6);
        }

        return result;
    }
}
