package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.dto.AdminDto;
import pl.dmagnuckibankapp.service.AdminService;

@RequestMapping("/admin")
@RestController
public class AdminController {

    private AdminService adminService;

    @Autowired //opcjonalne - Spring wie, ze to ma sie dziac automatycznie, ale dla przejrzystosci
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public void createAdmin(@RequestBody AdminDto adminDto) {
        // TODO: Dodaj odpowiedni kod obsługi dla createAdmin
        adminService.createAdmin(adminDto);
    }
    @GetMapping("/get")
    public ResponseEntity<AdminDto> getAdmin(@RequestBody String indexNumber) {
        // TODO: Dodaj odpowiedni kod obsługi dla getAdmin
        adminService.getAdmin(indexNumber);
    }

    @PutMapping("/update")
    public void updateAdmin(@RequestBody String indexNumber, AdminDto adminDto) {
        // TODO: Dodaj odpowiedni kod obsługi dla updateAdmin
        adminService.updateAdmin(indexNumber, adminDto);
    }

    @DeleteMapping("/delete")
    public void deleteAdmin(@RequestBody String indexNumber) {
        // TODO: Dodaj odpowiedni kod obsługi dla deleteAdmin
        adminService.deleteAdmin(indexNumber);
    }
}
