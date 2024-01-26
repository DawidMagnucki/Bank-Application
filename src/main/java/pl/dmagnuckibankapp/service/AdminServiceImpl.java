package pl.dmagnuckibankapp.service;

import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.AdminDto;
@Service
public class AdminServiceImpl implements AdminService{
    @Override
    public void createAdmin(AdminDto adminDto) {
        // TODO: Dodaj odpowiedni kod obsługi metody
        System.out.println(adminDto);
    }

    @Override
    public AdminDto getAdmin(String indexNumber) {
        // TODO: Dodaj odpowiedni kod obsługi metody
        return null;
    }

    @Override
    public void updateAdmin(String indexNumber, AdminDto adminDto) {
        // TODO: Dodaj odpowiedni kod obsługi metody
        System.out.println(adminDto);
    }

    @Override
    public void deleteAdmin(String indexNumber) {
        // TODO: Dodaj odpowiedni kod obsługi metody
        System.out.println(indexNumber);
    }
}
