package klasha.store.KlashaCourier.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LocationDoestNotExistException extends RuntimeException{


    public LocationDoestNotExistException() {
        super();
    }
    public LocationDoestNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public LocationDoestNotExistException(String message) {
        super(message);
    }
    public LocationDoestNotExistException(Throwable cause) {
        super(cause);
    }

}
