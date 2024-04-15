package pl.dmagnuckibankapp.service;

import pl.dmagnuckibankapp.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto create(ClientDto clientDto);
    List<ClientDto> getAll();
    ClientDto getClient(String indexNumber);
    ClientDto update(ClientDto clientDto, String indexNumber);
    boolean delete (String indexNumber);
}
