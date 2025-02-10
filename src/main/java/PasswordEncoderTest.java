import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Κωδικός για κρυπτογράφηση
        String rawPassword = "superadmin";

        // Κρυπτογράφηση
        String encodedPassword = encoder.encode(rawPassword);

        // Εκτύπωση του κρυπτογραφημένου κωδικού
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
