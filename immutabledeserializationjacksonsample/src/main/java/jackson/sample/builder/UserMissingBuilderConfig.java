package jackson.sample.builder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder")
class UserMissingBuilderConfig {

    private Long id;
    private String firstName;
    private String lastName;
}
