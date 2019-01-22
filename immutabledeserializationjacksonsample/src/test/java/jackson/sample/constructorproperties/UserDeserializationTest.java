package jackson.sample.constructorproperties;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import jackson.sample.UserDeserializationBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDeserializationTest extends UserDeserializationBase {

    @Test
    @DisplayName("Should deserialize user using constructor properties config")
    void deserialize() throws Exception {
        // given
        ObjectMapper mapper = new ObjectMapper();

        // and
        User user = new User(USER_ID, USER_FIRST_NAME, USER_LAST_NAME);
        String json = mapper.writeValueAsString(user);

        // when
        User deserializedUser = mapper.readValue(json, User.class);

        // then
        Assertions.assertEquals(user, deserializedUser);
    }

    @Test
    @DisplayName("Should fail to deserialize user without constructor properties config")
    void failDeserialize() throws Exception {
        // given
        ObjectMapper mapper = new ObjectMapper();

        // and
        UserMissingConstructorPropertiesConfig user = new UserMissingConstructorPropertiesConfig(USER_ID, USER_FIRST_NAME, USER_LAST_NAME);
        String json = mapper.writeValueAsString(user);

        InvalidDefinitionException exception = assertThrows(InvalidDefinitionException.class, () -> {
            // when
            mapper.readValue(json, UserMissingConstructorPropertiesConfig.class);
        });

        // then
        assertTrue(exception.getMessage()
                            .contains("Cannot construct instance of `jackson.sample.constructorproperties.UserMissingConstructorPropertiesConfig`"));
    }
}
