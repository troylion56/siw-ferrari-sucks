package it.unitoma3.ferrarisucks.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.unitoma3.ferrarisucks.model.Strategia;
import it.unitoma3.ferrarisucks.repository.StrategiaRepository;

@Component
public class StrategiaValidator implements Validator {
	@Autowired
	private StrategiaRepository strategiaRepository;

	@Override
	public void validate(Object o, Errors errors) {
		Strategia strategia = (Strategia)o;
		if (strategia.getNome()!=null && strategiaRepository.existsByNomeAndCircuito(strategia.getNome(), strategia.getCircuito())) {
			errors.reject("stratgia.duplicate");
		}
	}
	@Override
	public boolean supports(Class<?> aClass) {
		return Strategia.class.equals(aClass);
	}
}