package pl.dmagnuckibankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.ClientDto;
import pl.dmagnuckibankapp.model.Client;
import pl.dmagnuckibankapp.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl (ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(ClientDto clientDto) {
        Client client = Client.builder()
                .name(clientDto.getName())
                .phoneNumber(clientDto.getPhoneNumber())
                .indexNumber(clientDto.getIndexNumber())
                .build();
        clientRepository.save(client);
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
    public void updateClient(ClientDto clientDto, String indexNumber) {
        Client client = clientRepository.findByIndexNumber(clientDto.getIndexNumber());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(client);

    }

    @Override
    public void deleteClient(ClientDto clientDto) {
        Client client = clientRepository.findByIndexNumber(clientDto.getIndexNumber());
        clientRepository.delete(client);
    }
}