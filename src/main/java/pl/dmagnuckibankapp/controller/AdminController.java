package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dmagnuckibankapp.dto.AdminDto;
import pl.dmagnuckibankapp.exception.CrudOperationRequestException;
import pl.dmagnuckibankapp.service.AdminService;

@RestController
public class AdminController {

    private AdminService adminService;

    @Autowired //opcjonalne - Spring wie, ze to ma sie dziac automatycznie, ale dla przejrzystosci
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping ("/createAdmin")
    public void createAdmin(@RequestBody AdminDto adminDto) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla createAdmin
            adminService.createAdmin(adminDto);
        } catch (CrudOperationRequestException e){
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }

    @PostMapping ("/getAdmin")
    public ResponseEntity<AdminDto> getAdmin(@RequestBody String indexNumber) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla getAdmin
            AdminDto adminDto = null;
            return ResponseEntity.ok(adminDto);
        } catch (CrudOperationRequestException e){
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping ("/updateAdmin")
    public void updateAdmin(@RequestBody String indexNumber, AdminDto adminDto) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla updateAdmin
            adminService.updateAdmin(indexNumber, adminDto);
        } catch (CrudOperationRequestException e){
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }

    @PostMapping ("/deleteAdmin")
    public void deleteAdmin(@RequestBody String indexNumber) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla deleteAdmin
            adminService.deleteAdmin(indexNumber);
        } catch (CrudOperationRequestException e){
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }
}
