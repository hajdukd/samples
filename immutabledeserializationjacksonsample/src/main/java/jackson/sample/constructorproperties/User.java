package jackson.sample.constructorproperties;

import lombok.Value;
import java.beans.ConstructorProperties;

@Value
class User {

    private Long id;
    private String firstName;
    private String lastName;

    @ConstructorProperties({"id", "firstName", "lastName"})
    User(Long id,
         String firstName,
         String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}