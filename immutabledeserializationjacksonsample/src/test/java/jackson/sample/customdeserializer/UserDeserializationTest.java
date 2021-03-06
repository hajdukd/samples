package jackson.sample.customdeserializer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jackson.sample.UserDeserializationBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDeserializationTest extends UserDeserializationBase {

    @Test
    @DisplayName("Should deserialize user using custom deserializer config")
    void deserialize() throws Exception {
        // given
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(User.class, new UserDeserializer());
        mapper.registerModule(module);

        // and
        User user = new User(USER_ID, USER_FIRST_NAME, USER_LAST_NAME);
        String json = mapper.writeValueAsString(user);

        // when
        User deserializedUser = mapper.readValue(json, User.class);

        // then
        assertEquals(user, deserializedUser);
    }

    @Test
    @DisplayName("Should fail to deserialize user without custom deserializer config")
    void failDeserialize() throws Exception {
        // given
        ObjectMapper mapper = new ObjectMapper();

        // and
        User user = new User(USER_ID, USER_FIRST_NAME, USER_LAST_NAME);
        String json = mapper.writeValueAsString(user);

        InvalidDefinitionException exception = assertThrows(InvalidDefinitionException.class, () -> {
            // when
            mapper.readValue(json, User.class);
        });

        // then
        assertTrue(exception.getMessage()
                            .contains("Cannot construct instance of `jackson.sample.customdeserializer.User`"));
    }
}
