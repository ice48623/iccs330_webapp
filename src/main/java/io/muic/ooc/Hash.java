package io.muic.ooc;

import org.apache.commons.codec.digest.DigestUtils;

public class Hash {
    public static String genHash(String name, String passwd) throws Exception {
        String salt = "salty salt";
        String hashed = DigestUtils.sha256Hex(name + passwd);
        return DigestUtils.sha256Hex(hashed + salt);
    }
}
