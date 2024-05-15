package pl.dmagnuckibankapp.repository;

import org.springframework.web.client.RestClient;

public class FrankfurterConnection {

    public String getLatest() {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://api.frankfurter.app/latest")
                .retrieve()
                .body(String.class);
    }

    public String getLatest(String currencyCode) {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://api.frankfurter.app/latest")
                .retrieve()
                .body(String.class);
    }

    public String getByDate(String date) {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://api.frankfurter.app/" + date)
                .retrieve()
                .body(String.class);
    }


}
