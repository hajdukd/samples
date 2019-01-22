package jackson.sample.customdeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

class UserDeserializer extends StdDeserializer<User> {

    UserDeserializer() {
        super(User.class);
    }

    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException,
                                                                                                         JsonProcessingException {
        JsonNode node = jsonParser.getCodec()
                                  .readTree(jsonParser);
        Long id = node.get("id")
                      .asLong();
        String firstName = node.get("firstName")
                               .asText();
        String lastName = node.get("lastName")
                              .asText();

        return new User(id, firstName, lastName);
    }
}
