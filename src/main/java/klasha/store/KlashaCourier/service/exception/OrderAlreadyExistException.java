package klasha.store.KlashaCourier.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class OrderAlreadyExistException  extends RuntimeException{





    public OrderAlreadyExistException() {
        super();
    }
    public OrderAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
    public OrderAlreadyExistException(String message) {
        super(message);
    }
    public OrderAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
