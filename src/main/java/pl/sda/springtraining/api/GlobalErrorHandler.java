package pl.sda.springtraining.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.springtraining.exception.AlreadyExistException;

import java.time.LocalDateTime;
import java.util.UUID;

@ControllerAdvice
@ResponseBody
public class GlobalErrorHandler {

    @ExceptionHandler(value = AlreadyExistException.class)
    public ResponseEntity<Error> handleAlreadyExists(AlreadyExistException ex) {
        String errorCode = UUID.randomUUID().toString();
        System.out.println("Error code " + errorCode);
        ex.printStackTrace();

        return ResponseEntity.status(409).body(new Error(ex.getMessage(), LocalDateTime.now(), errorCode));
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Error> handleAnyRuntimeException(RuntimeException ex) {
        String errorCode = UUID.randomUUID().toString();
        System.out.println("Error code " + errorCode);
        ex.printStackTrace();

        return ResponseEntity.status(500).body(new Error(ex.getMessage(), LocalDateTime.now(), errorCode));
    }

    @AllArgsConstructor
    @Getter
    public class Error {
        private final String message;
        private final LocalDateTime errorTime;
        private final String errorCode;
    }
}
