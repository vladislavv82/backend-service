package su.xeonexus.service.service;

import com.google.firebase.auth.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.firebase.auth.UserRecord.UpdateRequest;
import su.xeonexus.service.dto.UserWithRole;


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

    public String createManagerUser(String email, String name, String password) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);

        // Установка имени пользователя (displayName)
        request.setDisplayName(name);

        UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);

        // Установка пользовательских параметров (ролей) после создания пользователя
        Map<String, Object> claims = new HashMap<>();
        claims.put("manager", true); // Установка роли "менеджер"

        UpdateRequest updateRequest = new UpdateRequest(userRecord.getUid())
                .setCustomClaims(claims);

        FirebaseAuth.getInstance().updateUser(updateRequest);

        return userRecord.getUid();
    }

    public List<UserWithRole> getAllManagers() throws FirebaseAuthException {
        List<UserWithRole> managers = new ArrayList<>();

        ListUsersPage page = FirebaseAuth.getInstance().listUsers(null);

        for (ExportedUserRecord userRecord : page.getValues()) {
            Map<String, Object> customClaims = userRecord.getCustomClaims();
            if (customClaims != null && customClaims.get("manager") != null && (Boolean) customClaims.get("manager")) {
                UserWithRole userWithRole = new UserWithRole();
                userWithRole.setUid(userRecord.getUid());
                userWithRole.setName(userRecord.getDisplayName());
                userWithRole.setEmail(userRecord.getEmail());
                userWithRole.setRole("manager");
                managers.add(userWithRole);
            }
        }
        return managers;
    }

    public void deleteManagerUser(String uid) throws FirebaseAuthException {
        // Проверка, что пользователь существует
        UserRecord userRecord = FirebaseAuth.getInstance().getUser(uid);

        // Проверка, что пользователь имеет роль "менеджер"
        Map<String, Object> customClaims = userRecord.getCustomClaims();
        if (customClaims != null && customClaims.get("manager") != null && (Boolean) customClaims.get("manager")) {
            // Удаление пользователя
            FirebaseAuth.getInstance().deleteUser(uid);
        } else {
            throw new RuntimeException("User is not a manager");
        }
    }
}