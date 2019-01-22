package jackson.sample.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;

abstract class UserMixIn {

    UserMixIn(@JsonProperty("id") Long id,
                     @JsonProperty("firstName") String firstName,
                     @JsonProperty("lastName") String lastName) {
    }
}
