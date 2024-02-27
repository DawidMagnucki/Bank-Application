package pl.dmagnuckibankapp.service;

import pl.dmagnuckibankapp.dto.AdminDto;


public interface AdminService {
    void createAdmin(AdminDto adminDto);

    AdminDto getAdmin(String indexNumber);

    void updateAdmin(String indexNumber, AdminDto adminDto);

    void deleteAdmin(AdminDto adminDto);
}
