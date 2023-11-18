package su.xeonexus.service.service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import com.google.firebase.auth.UserRecord.UpdateRequest;


@Service
public class FirebaseService {

    public String createAdminUser(String email, String password) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);

        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);

        // Установка пользовательских параметров (ролей) после создания пользователя
        Map<String, Object> claims = new HashMap<>();
        claims.put("admin", true);

        UpdateRequest updateRequest = new UpdateRequest(userRecord.getUid())
                .setCustomClaims(claims);

        FirebaseAuth.getInstance().updateUser(updateRequest);

        return userRecord.getUid();
    }
}

