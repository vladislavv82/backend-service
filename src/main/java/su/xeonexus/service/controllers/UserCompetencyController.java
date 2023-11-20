package su.xeonexus.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import su.xeonexus.service.model.UserCompetency;
import su.xeonexus.service.service.UserCompetencyService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserCompetencyController {

    @Autowired
    private UserCompetencyService service;

    //создание компетенций
    @PostMapping("/competencies")
    public ResponseEntity<UserCompetency> createOrUpdateUserCompetency(@RequestBody UserCompetency userCompetency) {
        return ResponseEntity.ok(service.saveOrUpdateUserCompetency(userCompetency));
    }

    // Получение списка всех компетенций
    @GetMapping("/competencies")
    public ResponseEntity<List<UserCompetency>> getAllUserCompetencies() {
        List<UserCompetency> competencies = service.getAllUserCompetencies();
        return ResponseEntity.ok(competencies);
    }

    // Получение компетенции по ID
    @GetMapping("/competencies/uid/{uid}")
    public ResponseEntity<UserCompetency> getUserCompetencyByUid(@PathVariable String uid) {
        UserCompetency competency = service.getUserCompetencyByUid(uid);
        return competency != null ? ResponseEntity.ok(competency) : ResponseEntity.notFound().build();
    }
}