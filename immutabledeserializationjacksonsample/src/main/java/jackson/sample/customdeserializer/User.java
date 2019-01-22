package jackson.sample.customdeserializer;

import lombok.Value;

@Value
class User {

    private Long id;
    private String firstName;
    private String lastName;
}
