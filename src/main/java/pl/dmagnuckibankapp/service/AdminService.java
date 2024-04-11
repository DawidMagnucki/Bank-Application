package pl.dmagnuckibankapp.service;
import pl.dmagnuckibankapp.dto.AdminDto;

import java.util.List;

public interface AdminService {
    void createAdmin(AdminDto adminDto);
    AdminDto getAdmin(String indexNumber);
    List<AdminDto> getAllAdmins();
    void updateAdmin(String indexNumber, AdminDto adminDto);
    void deleteAdmin(AdminDto adminDto);
}
