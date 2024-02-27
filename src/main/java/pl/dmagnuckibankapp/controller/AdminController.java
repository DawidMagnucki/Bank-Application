package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.dto.AdminDto;
import pl.dmagnuckibankapp.service.AdminService;

@RequestMapping("/admin")
@RestController
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public void createAdmin(@RequestBody AdminDto adminDto) {
        adminService.createAdmin(adminDto);
    }

    @GetMapping("/get/{indexNumber}")
    public ResponseEntity<AdminDto> getAdmin(@PathVariable String indexNumber) {
        AdminDto adminDto = adminService.getAdmin(indexNumber);
        return ResponseEntity.ok(adminDto);
    }

    @PutMapping("/update/{indexNumber}")
    public void updateAdmin(@PathVariable String indexNumber, @RequestBody AdminDto adminDto) {
        adminService.updateAdmin(indexNumber, adminDto);
    }

    @DeleteMapping("/delete")
    public void deleteAdmin(@RequestBody AdminDto adminDto) {
        adminService.deleteAdmin(adminDto);
    }
}
