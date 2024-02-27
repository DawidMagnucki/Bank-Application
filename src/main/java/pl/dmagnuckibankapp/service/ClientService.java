package pl.dmagnuckibankapp.service;

import pl.dmagnuckibankapp.dto.ClientDto;

public interface ClientService {
    void createClient(ClientDto clientDto);
    ClientDto getClient(String indexNumber);
    void updateClient(ClientDto clientDto, String indexNumber);
    void deleteClient(ClientDto clientDto);

}
