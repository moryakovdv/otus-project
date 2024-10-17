package otus.moryakovdv.meteohelpers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import otus.moryakovdv.meteohelpers.service.HelperService;

/** Контроллер, обеспечивающий вызов веб-методов **/
@Controller
@Slf4j
public class HelperController {

	

	@Autowired
	private HelperService helperService;

	

}
