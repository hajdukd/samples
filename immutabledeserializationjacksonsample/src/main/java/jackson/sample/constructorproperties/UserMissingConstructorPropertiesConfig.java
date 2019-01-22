package jackson.sample.constructorproperties;

import lombok.Value;
import java.beans.ConstructorProperties;

@Value
class UserMissingConstructorPropertiesConfig {

    private Long id;
    private String firstName;
    private String lastName;

    // FYI: @Value provides AllArgumentsConstructor
}