package jackson.sample.builder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder")
@JsonDeserialize(builder = User.Builder.class)
class User {

    private Long id;
    private String firstName;
    private String lastName;

    @JsonPOJOBuilder(withPrefix = "")
    static class Builder {
    }
}
