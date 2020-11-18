package Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//This classe is used to hash and check the password 


public class Password {

    
    //get the input password and we hashit 
    public String hashpassword(String input) {

        StringBuilder sb;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] data = md.digest(input.getBytes());
            sb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                sb.append(String.format("%02x", data[i]));

            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {

            System.out.print(e.getMessage());

        }

        return " ";

    }

    /// We compare the input and the hash that come from the data base 
    boolean checkpassword(String input, String hash_database) {

        String tmp = hashpassword(input);

        if (hash_database == null ? tmp == null : hash_database.equals(tmp)) {

            return true;

        } else {
            return false;
        }

    }

}
