import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.util.Random;

/**
 * Created by ice on 2/12/17.
 */
public class testHash {
    public static void main(String args[]) throws Exception{
        String name = "admin";
        String passwd = "pass";
        String hash1 = genHash(name, passwd);

//        String name2 = "admin";
//        String passwd2 = "asd";
//        String hash2 = genHash(name2, passwd2);
//
        System.out.println(hash1);
//        System.out.println(hash2);
//        System.out.println(hash1.equals(hash2));
//        System.out.println(hash1.length());
    }

    public static String genHash(String name, String passwd) throws Exception{

        String salt = "salty salt";
        String hashed = DigestUtils.sha256Hex(name + passwd);
        return DigestUtils.sha256Hex(hashed + salt);
    }
}
