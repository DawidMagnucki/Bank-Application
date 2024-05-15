package pl.dmagnuckibankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private String currencyCode;
    private double value;

    public boolean setCurrencyCode (String currencyCode){
        String regex = "^[A-Z]{3}$";
        currencyCode = currencyCode.toUpperCase();

        if(currencyCode.matches(regex)){
            this.currencyCode = currencyCode;
            return true;
        } else {
            System.out.println("Invalid currency code. It must be a 3-letter code with uppercase.");
            return false;
        }
    }
}
