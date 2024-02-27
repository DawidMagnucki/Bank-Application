package pl.dmagnuckibankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.AdminDto;
import pl.dmagnuckibankapp.model.Admin;
import pl.dmagnuckibankapp.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override
    public void createAdmin(AdminDto adminDto) {
        Admin admin = Admin.builder()
                .username(adminDto.getUsername())
                .password(adminDto.getPassword())
                .indexNumber(adminDto.getIndexNumber())
                .build();
        adminRepository.save(admin);
    }
    @Override
    public AdminDto getAdmin(String indexNumber) {
        Admin admin = adminRepository.findByIndexNumber(indexNumber);
        return AdminDto.builder()
                .username(admin.getUsername())
                .password(admin.getPassword())
                .indexNumber(admin.getIndexNumber())
                .build();
    }
    @Override
    public void updateAdmin(String indexNumber, AdminDto adminDto) {
        Admin admin = adminRepository.findByIndexNumber(indexNumber);
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(admin.getPassword());
        adminRepository.save(admin);
    }
    @Override
    public void deleteAdmin(AdminDto adminDto) {
        Admin admin = adminRepository.findByIndexNumber(adminDto.getIndexNumber());
        adminRepository.delete(admin);
    }
}