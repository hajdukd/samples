package jackson.sample.jsoncreator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
class User {

    private Long id;
    private String firstName;
    private String lastName;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    User(@JsonProperty("id") Long id,
         @JsonProperty("firstName") String firstName,
         @JsonProperty("lastName") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}