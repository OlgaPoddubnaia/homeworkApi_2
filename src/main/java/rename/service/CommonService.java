package rename.service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

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


    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = RestAssured.given(REQUEST_SPECIFICATION);

        for (Map.Entry<String, Object> param : params.entrySet())
            specification.param(param.getKey(), param.getValue());

        return specification.get(uri);
    }
}
