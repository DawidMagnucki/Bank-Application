package pl.dmagnuckibankapp.service;

import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.ClientDto;
@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public void createClient(ClientDto clientDto) {
        // TODO: Dodaj odpowiedni kod obsługi metody
        System.out.println(clientDto);
    }

    @Override
    public ClientDto getClient(String idCard) {
        // TODO: Dodaj odpowiedni kod obsługi metody
        return null;
    }

    @Override
    public void updateClient(String idCard) {
        // TODO: Dodaj odpowiedni kod obsługi metody
        System.out.println(idCard);
    }

    @Override
    public void deleteClient(ClientDto clientDto) {
        // TODO: Dodaj odpowiedni kod obsługi metody
        System.out.println(clientDto);
    }
}
