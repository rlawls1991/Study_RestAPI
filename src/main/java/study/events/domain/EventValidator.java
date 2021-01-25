package study.events.domain;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors) {
        comparePrice(eventDto, errors);
        compareDate(eventDto, errors);
    }

    private void comparePrice(EventDto eventDto, Errors errors) {
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            errors.rejectValue("basePrice", "wrongValue", "BasePrice is worng.");
            errors.rejectValue("maxPrice", "wrongValue", "MaxPrice is worng.");
        }
    }

    private void compareDate(EventDto eventDto, Errors errors) {
        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();

        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
                endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
                endEventDateTime.isBefore(eventDto.getBeginEventDateTime())
        ) {
            errors.rejectValue("endEventDateTime", "wrongValue", "EndEventDateTime is worng.");
        }
    }
}
