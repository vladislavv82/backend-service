package su.xeonexus.service.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("C:\\Users\\Владислав\\Desktop\\service\\react-auth-7a557-firebase-adminsdk-i6eok-fc9504289f.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://react-auth-7a557-default-rtdb.europe-west1.firebasedatabase.app")
                .build();

        return FirebaseApp.initializeApp(options);
    }
}
