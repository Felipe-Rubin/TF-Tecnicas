import java.util.*;
//import sun.misc.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
public class SecurityLayer{
	private SecurityLayer sl;
    private static String alg;
	private SecurityLayer(){
		 alg = "AES";
	}
	public SecurityLayer getInstance(){
		if(sl == null) sl = new SecurityLayer();
		return sl;
	}


	public static String encrypt(String value,String keyValue) throws Exception{
	
		Key key = new SecretKeySpec(keyValue.getBytes(),alg);
		Cipher ci = Cipher.getInstance(alg);
		ci.init(Cipher.ENCRYPT_MODE,key);

		//Cipher ci = Cipher.getInstance(Cipher.ENCRYPT_MODE,alg);
		byte encodedV[] = ci.doFinal(value.getBytes());

		return new String(encodedV);
		//return new String(Base64.getEncoder().encode(encodedV));
	}

	public static String decrypt(String value,String keyValue) throws Exception{
		Key key = new SecretKeySpec(keyValue.getBytes(),alg);
		Cipher ci = Cipher.getInstance(alg);
		ci.init(Cipher.DECRYPT_MODE,key);
		return new String(ci.doFinal(value.getBytes()));
	}


}