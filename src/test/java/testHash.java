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

//        String name2 = "name";
//        String passwd2 = "password";
//        String hash2 = genHash(name2, passwd2);

        System.out.println(hash1);
//        System.out.println(hash2);
//        System.out.println(hash1.equals(hash2));
//        System.out.println(hash1.length());
    }

    public static String genHash(String name, String passwd) throws Exception{
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
//        System.out.println(result);
        return result;
    }
}
