package pl.dmagnuckibankapp.service;

import pl.dmagnuckibankapp.dto.ClientDto;

public interface ClientService {
    void createClient(ClientDto clientDto);
    ClientDto getClient(String idCard);
    void updateClient(String idCard);
    void deleteClient(ClientDto clientDto);

}
