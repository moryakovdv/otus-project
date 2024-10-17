package otus.moryakovdv.meteoinformation.model;

public enum MeteoProductType {

		METAR, SPECI, TAF, SIGMET, VA; 
	
	@Override
	public String toString() {
		switch (this) {
		case METAR:
			return "Регулярная сводка по аэродрому";
		case SPECI:
			return "Срочная сводка по аэродрому";
		case TAF:
			return "Прогноз по аэродрому";
		case SIGMET:
			return "Опасные явления";
		case VA:
			return "Вулканический пепел";
			
			default:
				return "Не определено";
		}
	}
}
