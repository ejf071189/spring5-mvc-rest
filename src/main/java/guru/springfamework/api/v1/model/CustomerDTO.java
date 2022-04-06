package guru.springfamework.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jt on 9/24/17.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String firstname;
    private String lastname;
    @JsonProperty("customer_url")
    private String url;
}
