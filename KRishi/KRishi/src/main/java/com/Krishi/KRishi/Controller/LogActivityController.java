package com.Krishi.KRishi.Controller;

import com.Krishi.KRishi.Dto.LogActivityRequestDto;
import com.Krishi.KRishi.Model.LogActivity;
import com.Krishi.KRishi.Service.LogActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log-activity")
public class LogActivityController {
    @Autowired
    private LogActivityService service;

    LogActivityController(LogActivityService service){
        this.service = service ;}

        @PostMapping
        public ResponseEntity<String> addLogActivity( @RequestBody LogActivityRequestDto dto) {
            try {
                service.addLogActivity(dto);
                return ResponseEntity.ok("Log activity saved successfully");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error: " + e.getMessage());
            }

}
    @GetMapping("/{profileId}")
    public ResponseEntity<List<LogActivity>> getLogActivities(@PathVariable Long profileId) {
        List<LogActivity> activities = service.getLogActivitiesByProfile(profileId);
        if (activities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(activities);
    }
}
