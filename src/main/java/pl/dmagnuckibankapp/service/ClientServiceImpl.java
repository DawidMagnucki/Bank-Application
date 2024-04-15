package pl.dmagnuckibankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.ClientDto;
import pl.dmagnuckibankapp.model.Client;
import pl.dmagnuckibankapp.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
    public ClientDto create(ClientDto clientDto) {
        Client client = Client.builder()
                .name(clientDto.getName())
                .phoneNumber(clientDto.getPhoneNumber())
                .indexNumber(clientDto.getIndexNumber())
                .build();
        return clientRepository.save(client).toDto();
    }
    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(Client::toDto)
                .toList();
    }

    @Override
    public ClientDto getClient(String indexNumber) {
        Client client = clientRepository.findByIndexNumber(indexNumber);
        return ClientDto.builder()
                .name(client.getName())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }
    @Override
    public ClientDto update(ClientDto clientDto, String indexNumber) {
        Client client = clientRepository.findByIndexNumber(clientDto.getIndexNumber());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        return clientRepository.save(client).toDto();
    }
    @Override
    public boolean delete(String indexNumber) {
        if (clientRepository.existsByIndexNumber(indexNumber)){
            clientRepository.deleteByIndexNumber(indexNumber);
            return true;
        }
        return false;
    }
}