package otus.moryakovdv.meteoapi.web;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link TestApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T10:23:01.411391794+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public interface TestApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /test : Тестовый метод для контроля рботоспособности
     *
     * @return It works! (status code 200)
     *         or Что-то пошло не так (status code 500)
     * @see TestApi#testGet
     */
    default ResponseEntity<String> testGet() {
        return 
        		ResponseEntity.ok("It works!");

    }

}
