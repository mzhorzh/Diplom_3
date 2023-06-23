package Dataprovider;

import API.CreateUserRequest;
import org.apache.commons.lang3.RandomStringUtils;

public class UserProvider {
    public static CreateUserRequest getRandomUser() {
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(8) + "@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(8);
        return new CreateUserRequest(email, password, name);
    }
}
