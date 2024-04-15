package pl.dmagnuckibankapp.service;
import pl.dmagnuckibankapp.dto.AdminDto;

import java.util.List;

public interface AdminService {
    AdminDto create(AdminDto adminDto); // TODO: dlaczego mam metodę na szaro, skoro w AdminServiceImpl ją implementuję?
    AdminDto getAdmin(String indexNumber);
    List<AdminDto> getAllAdmins();
    AdminDto update(String indexNumber, AdminDto adminDto);
    boolean delete(String indexNumber);
}
