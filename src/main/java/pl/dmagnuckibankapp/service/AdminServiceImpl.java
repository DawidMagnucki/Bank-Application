package pl.dmagnuckibankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.AdminDto;
import pl.dmagnuckibankapp.model.Admin;
import pl.dmagnuckibankapp.repository.AdminRepository;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override
    public AdminDto create(AdminDto adminDto) {
        Admin admin = Admin.builder()
                .username(adminDto.getUsername())
                .password(adminDto.getPassword())
                .indexNumber(adminDto.getIndexNumber())
                .build();
       return adminRepository.save(admin).toDto();
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
    public List<AdminDto> getAllAdmins() {
        return adminRepository.findAll()
                .stream()
                .map(Admin::toDto)
                .toList();
    }

    @Override
    public AdminDto update(String indexNumber, AdminDto adminDto) {
        Admin admin = adminRepository.findByIndexNumber(indexNumber);
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(admin.getPassword());
        return adminRepository.save(admin).toDto();
    }
    @Override
    public boolean delete(String indexNumber) {
        if (adminRepository.existsByIndexNumber(indexNumber)){ //TODO: Dopisać metodę
            adminRepository.deleteByIndexNumber(indexNumber); //TODO: Dopisać metodę
            return true;
        }
        return false;

    }
}