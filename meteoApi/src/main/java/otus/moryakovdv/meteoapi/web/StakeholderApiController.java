package otus.moryakovdv.meteoapi.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T10:18:23.532897349+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.meteo.base-path:/api/v1}")
public class StakeholderApiController implements StakeholderApi {

    private final StakeholderApiDelegate delegate;

    public StakeholderApiController(@Autowired(required = false) StakeholderApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new StakeholderApiDelegate() {});
    }

    @Override
    public StakeholderApiDelegate getDelegate() {
        return delegate;
    }

}
