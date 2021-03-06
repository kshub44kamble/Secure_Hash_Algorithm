  
import java.util.Scanner; 
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
  
public class SHA { 
    public static String encryptThisString(String input) 
    { 
        try { 
            
            MessageDigest md = MessageDigest.getInstance("SHA-1"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
  
    // Driver code 
    public static void main(String args[]) throws NoSuchAlgorithmException 
    { 
  		
        System.out.println("\nHashCode Generated by SHA-1 for:\n"); 
  
        Scanner sc = new Scanner(System.in); 

	System.out.println("\nEnter String 1 : "); 
        String s1 = sc.nextLine(); 
        System.out.println("\nHash Code-> " + s1 + " : " + encryptThisString(s1));

	System.out.println("\nEnter String 2 : "); 
        String s2 = sc.nextLine();  
	System.out.println("\nHash Code-> " + s2 + " : " + encryptThisString(s2)); 
     
    } 
} 


/* ---------------------- OUTPUT --------------------------

suraj@suraj-Vostro-15-3568:~$ javac SHA.java
suraj@suraj-Vostro-15-3568:~$ java SHA

HashCode Generated by SHA-1 for:


Enter String 1 : 
PVG

Hash Code-> PVG : da344c18a2aa39e1fc3aca17b858204a194b5dbc

Enter String 2 : 
COET

Hash Code-> COET : f84939bb2d65444e693b30e044e748634fe10550
suraj@suraj-Vostro-15-3568:~$ 


*/
