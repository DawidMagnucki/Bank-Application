package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.dto.ClientDto;
import pl.dmagnuckibankapp.service.ClientService;

@RequestMapping("/client")
@RestController
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public void createClient(@RequestBody ClientDto clientDto) {
        // TODO: Dodaj odpowiedni kod obsługi dla createClient
        System.out.println(clientDto);
    }

    @GetMapping("/get")
    public ResponseEntity<ClientDto> getClient(@RequestBody String idCard) {
        // TODO: Dodaj odpowiedni kod obsługi dla getClient
        ClientDto clientDto = null;
        return ResponseEntity.ok(clientDto);
    }

    @PutMapping("/update")
    public void updateClient(@RequestBody String idCard) {
        // TODO: Dodaj odpowiedni kod obsługi dla updateClient
        System.out.println(idCard);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestBody ClientDto clientDto) {
        // TODO: Dodaj odpowiedni kod obsługi dla deleteClient
        System.out.println(clientDto);
    }
}
