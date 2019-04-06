package encodePassword;

import java.util.Base64;

public class EncodePassword {
		
        static String passcode = encodePassword();
        
        String pass=decodePassword(passcode);
        
		public static String encodePassword() {
			String password = "prajrohan181112";
			byte[] passwordInBytes = password.getBytes();
			String password1 = Base64.getEncoder().encodeToString(passwordInBytes);
			return password1;
		}
		
		public static String decodePassword(String password1) {
				byte[] bytesPassword = Base64.getDecoder().decode(passcode);
				String password2 = new String(bytesPassword);
				return password2;
			}
}
