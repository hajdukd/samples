package jackson.sample.jsoncreator;

import lombok.Value;

@Value
public class UserMissingJsonCreatorConfig {

    private Long id;
    private String firstName;
    private String lastName;
}
