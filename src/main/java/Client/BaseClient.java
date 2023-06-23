package Client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseClient {
    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .setBaseUri("https://stellarburgers.nomoreparties.site/")
                .build();
    }
}
