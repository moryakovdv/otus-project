package otus.moryakovdv.meteoapi.web;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link StakeholderApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-21T20:43:10.963067927+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
public interface StakeholderApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /stakeholder
     *
     * @return Все ОК (status code 200)
     *         or Неверные параметры (status code 400)
     *         or Что-то пошло не так (status code 500)
     * @see StakeholderApi#createStakeholder
     */
    default ResponseEntity<Void> createStakeholder() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /stakeholder/{stakeholderId} : Удалить конкретного stakehlder-а
     *
     * @param stakeholderId ID stakeholderId (required)
     * @return It works! (status code 200)
     *         or Что-то пошло не так (status code 500)
     * @see StakeholderApi#deleteStakeholderById
     */
    default ResponseEntity<Void> deleteStakeholderById(Integer stakeholderId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /stakeholder/{stakeholderId} : Загрузить конкретного stakehlder-а
     *
     * @param stakeholderId ID stakeholderId (required)
     * @return It works! (status code 200)
     *         or Что-то пошло не так (status code 500)
     * @see StakeholderApi#loadStakeholderById
     */
    default ResponseEntity<Void> loadStakeholderById(Integer stakeholderId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /stakeholder : Выгрузить всех stakeholder-ов
     *
     * @return It works! (status code 200)
     *         or Что-то пошло не так (status code 500)
     * @see StakeholderApi#stakeholderGet
     */
    default ResponseEntity<Void> stakeholderGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
