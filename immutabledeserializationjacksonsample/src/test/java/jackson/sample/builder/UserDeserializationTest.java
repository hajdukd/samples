package jackson.sample.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import jackson.sample.UserDeserializationBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDeserializationTest extends UserDeserializationBase {

    @Test
    @DisplayName("Should deserialize user using builder")
    void deserialize() throws Exception {
        // given
        ObjectMapper mapper = new ObjectMapper();

        // and
        User user = User.builder()
                        .id(USER_ID)
                        .firstName(USER_FIRST_NAME)
                        .lastName(USER_LAST_NAME)
                        .build();
        String json = mapper.writeValueAsString(user);

        // when
        User deserializedUser = mapper.readValue(json, User.class);

        // then
        assertEquals(user, deserializedUser);
    }

    @Test
    @DisplayName("Should fail to deserialize without builder config")
    void failDeserialize() throws Exception {
        // given
        ObjectMapper mapper = new ObjectMapper();

        // and
        UserMissingBuilderConfig user = UserMissingBuilderConfig.builder()
                                                                .id(USER_ID)
                                                                .firstName(USER_FIRST_NAME)
                                                                .lastName(USER_LAST_NAME)
                                                                .build();
        String json = mapper.writeValueAsString(user);

        InvalidDefinitionException exception = assertThrows(InvalidDefinitionException.class, () -> {
            // when
            mapper.readValue(json, UserMissingBuilderConfig.class);
        });

        // then
        assertTrue(exception.getMessage()
                            .contains("Cannot construct instance of `jackson.sample.builder.UserMissingBuilderConfig`"));
    }
}
