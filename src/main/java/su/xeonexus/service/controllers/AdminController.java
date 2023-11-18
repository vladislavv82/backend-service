package su.xeonexus.service.controllers;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import su.xeonexus.service.dto.UserCreateRequest;
import su.xeonexus.service.service.FirebaseService;

@RestController
public class AdminController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/create-admin")
    public ResponseEntity<String> createAdmin(@RequestBody UserCreateRequest request) {
        try {
            String uid = firebaseService.createAdminUser(request.getEmail(), request.getPassword());
            return ResponseEntity.ok("Admin user created with UID: " + uid);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to create admin user: " + e.getMessage());
        }
    }
}
