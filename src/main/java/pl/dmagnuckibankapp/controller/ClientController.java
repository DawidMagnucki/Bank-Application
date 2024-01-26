package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dmagnuckibankapp.dto.ClientDto;
import pl.dmagnuckibankapp.exception.CrudOperationRequestException;
import pl.dmagnuckibankapp.service.ClientService;

@RestController
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/createClient")
    public void createClient(@RequestBody ClientDto clientDto) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla createClient
            System.out.println(clientDto);
        } catch (CrudOperationRequestException e) {
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }

    @PostMapping("/getClient")
    public ResponseEntity<ClientDto> getClient(@RequestBody String idCard) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla getClient
            ClientDto clientDto = null;
            return ResponseEntity.ok(clientDto);
        } catch (CrudOperationRequestException e) {
            System.err.println("Error while processing request. Please try again." + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/updateClient")
    public void updateClient(@RequestBody String idCard) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla updateClient
            System.out.println(idCard);
        } catch (CrudOperationRequestException e) {
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }

    @PostMapping("/deleteClient")
    public void deleteClient(@RequestBody ClientDto clientDto) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla deleteClient
            System.out.println(clientDto);
        } catch (CrudOperationRequestException e) {
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }
}
