/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package otus.moryakovdv.meteoapi.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-17T10:23:01.411391794+03:00[Europe/Moscow]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "InformationController", description = "the InformationController API")
public interface AllmeteotypesApi {

    default AllmeteotypesApiDelegate getDelegate() {
        return new AllmeteotypesApiDelegate() {};
    }

    /**
     * GET /allmeteotypes : Выгрузить все типы метеоинформации
     *
     * @param limit limit records (required)
     * @return It works! (status code 200)
     *         or Что-то пошло не так (status code 500)
     */
    @Operation(
        operationId = "loadAllMeteoTypes",
        summary = "Выгрузить все типы метеоинформации",
        tags = { "InformationController" },
        responses = {
            @ApiResponse(responseCode = "200", description = "It works!"),
            @ApiResponse(responseCode = "500", description = "Что-то пошло не так")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/allmeteotypes"
    )
    
    default ResponseEntity<Void> loadAllMeteoTypes(
        @Parameter(name = "limit", description = "limit records", required = true, in = ParameterIn.PATH) @PathVariable("limit") List<Integer> limit
    ) {
        return getDelegate().loadAllMeteoTypes(limit);
    }

}