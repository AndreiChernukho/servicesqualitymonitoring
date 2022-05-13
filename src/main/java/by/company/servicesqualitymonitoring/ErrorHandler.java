package by.company.servicesqualitymonitoring;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(
            HttpServletRequest request, MethodArgumentNotValidException exception) {


        String errorMessages = exception.getBindingResult().getAllErrors().stream()
                .map((error) -> String.format("Ошибка валидации: '%s'", error.getDefaultMessage()))
                .collect(Collectors.joining("; "));

        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(DATE_FORMATTER.format(new Date()))
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(errorMessages)
                .path(request.getServletPath())
                .build();

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @Data
    @Builder
    private static class ErrorMessage {
        private String timestamp;
        private int status;
        private String error;
        private String message;
        private String path;
    }
}
