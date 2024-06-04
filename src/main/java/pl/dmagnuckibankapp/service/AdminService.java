package pl.dmagnuckibankapp.service;
import pl.dmagnuckibankapp.dto.AdminDto;

import java.util.List;

public interface AdminService {
    AdminDto create(AdminDto adminDto);
    AdminDto getAdmin(String indexNumber);
    List<AdminDto> getAllAdmins();
    AdminDto update(String indexNumber, AdminDto adminDto);
    boolean delete(String indexNumber);
}
