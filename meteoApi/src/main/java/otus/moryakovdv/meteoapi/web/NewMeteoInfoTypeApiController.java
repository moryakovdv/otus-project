package otus.moryakovdv.meteoapi.web;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-21T20:43:10.963067927+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.meteo.base-path:/api/v1}")
public class NewMeteoInfoTypeApiController implements NewMeteoInfoTypeApi {

    private final NewMeteoInfoTypeApiDelegate delegate;

    public NewMeteoInfoTypeApiController(@Autowired(required = false) NewMeteoInfoTypeApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new NewMeteoInfoTypeApiDelegate() {});
    }

    @Override
    public NewMeteoInfoTypeApiDelegate getDelegate() {
        return delegate;
    }

}
