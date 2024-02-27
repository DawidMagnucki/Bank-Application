package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.dto.ClientDto;
import pl.dmagnuckibankapp.service.ClientService;

@RequestMapping("/client")
@RestController
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/create")
    public void createClient(@RequestBody ClientDto clientDto) {
        clientService.createClient(clientDto);
    }

    @GetMapping("/get/{indexNumber}")
    public ResponseEntity<ClientDto> getClient(@PathVariable String indexNumber) {
        ClientDto clientDto = clientService.getClient(indexNumber);
        return ResponseEntity.ok(clientDto);
    }

    @PutMapping("/update/{indexNumber}")
    public void updateClient(@RequestBody ClientDto clientDto, @PathVariable String indexNumber) {
        clientService.updateClient(clientDto, indexNumber);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestBody ClientDto clientDto) {
        clientService.deleteClient(clientDto);
    }
}
