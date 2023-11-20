package su.xeonexus.service.controllers;

import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.xeonexus.service.dto.UserCreateRequest;
import su.xeonexus.service.dto.UserWithRole;
import su.xeonexus.service.service.FirebaseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://frontend.xeonexus.su/")
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

    // Создание менеджера
    // Создание менеджера
    @PostMapping("/create-manager")
    public ResponseEntity<String> createManager(@RequestBody UserCreateRequest request) {
        try {
            String uid = firebaseService.createManagerUser(request.getEmail(), request.getName(), request.getPassword());
            return ResponseEntity.ok("Manager user created with UID: " + uid);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to create manager user: " + e.getMessage());
        }
    }
    // Получение списка менеджеров
    @GetMapping("/get-managers")
    public ResponseEntity<List<UserWithRole>> getManagers() {
        try {
            List<UserWithRole> managers = firebaseService.getAllManagers();
            return ResponseEntity.ok(managers);
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Удаление менеджера по UID
    @DeleteMapping("/delete-manager/{uid}")
    public ResponseEntity<String> deleteManager(@PathVariable String uid) {
        try {
            firebaseService.deleteManagerUser(uid);
            return ResponseEntity.ok("Manager user with UID " + uid + " has been deleted.");
        } catch (FirebaseAuthException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to delete manager user: " + e.getMessage());
        }
    }

}
