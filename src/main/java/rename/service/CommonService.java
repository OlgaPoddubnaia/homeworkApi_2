package rename.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.kohsuke.rngom.util.Uri;

import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CommonService {
    private RequestSpecification REQUEST_SPECIFICATION;
    String baseURI = new URI().getBaseUrl();

    public CommonService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    //Dto[] response = given(..).post(..).body().as(Dto[].class);

    public Response getNoParams(String uri) {
        Response response = given(REQUEST_SPECIFICATION).get(uri);
        response.then()
                .statusCode(Matchers.lessThan(300))
                .statusCode(Matchers.greaterThanOrEqualTo(200));
        return response;
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());

        return specification.get(uri);
    }


}
