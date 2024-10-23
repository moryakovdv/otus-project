package otus.moryakovdv.meteoapi.web;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ProviderApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-21T20:43:10.963067927+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public interface ProviderApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /provider
     *
     * @return Все ОК (status code 200)
     *         or Неверные параметры (status code 400)
     *         or Что-то пошло не так (status code 500)
     * @see ProviderApi#createProvider
     */
    default ResponseEntity<Void> createProvider() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /provider/{providerId} : Удалить конкретного provider-а
     *
     * @param providerId ID providerId (required)
     * @return It works! (status code 200)
     *         or Что-то пошло не так (status code 500)
     * @see ProviderApi#deleteProviderById
     */
    default ResponseEntity<Void> deleteProviderById(Integer providerId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /provider/{providerId} : Загрузить конкретного provider-а
     *
     * @param providerId ID providerId (required)
     * @return It works! (status code 200)
     *         or Что-то пошло не так (status code 500)
     * @see ProviderApi#loadProviderById
     */
    default ResponseEntity<Void> loadProviderById(Integer providerId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /provider : Выгрузить всех provider-ов
     *
     * @return It works! (status code 200)
     *         or Что-то пошло не так (status code 500)
     * @see ProviderApi#providerGet
     */
    default ResponseEntity<Void> providerGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
