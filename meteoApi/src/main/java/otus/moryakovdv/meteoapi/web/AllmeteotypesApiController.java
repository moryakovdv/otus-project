package otus.moryakovdv.meteoapi.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T10:18:23.532897349+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.meteo.base-path:/api/v1}")
public class AllmeteotypesApiController implements AllmeteotypesApi {

    private final AllmeteotypesApiDelegate delegate;

    public AllmeteotypesApiController(@Autowired(required = false) AllmeteotypesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new AllmeteotypesApiDelegate() {});
    }

    @Override
    public AllmeteotypesApiDelegate getDelegate() {
        return delegate;
    }

}
