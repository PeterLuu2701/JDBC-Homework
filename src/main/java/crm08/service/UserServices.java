package crm08.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import crm08.repository.RoleRepository;
import crm08.repository.UserRepository;
import entity.RoleEntity;

//Xử lý logic code cho User Controller
public class UserServices {
	
	private UserRepository userRepository = new UserRepository();
	
	
	
	public boolean insertUser(String fullname, String password, String email, int roleId) {
		return userRepository.insertUser(fullname, getMd5(password), email, roleId) > 0;
	}
	
	public 
	
	public static String getMd5(String input)
    {
        try {
 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
