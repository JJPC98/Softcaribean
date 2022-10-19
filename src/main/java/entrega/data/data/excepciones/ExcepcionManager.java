package entrega.data.data.excepciones;

public class ExcepcionManager extends Exception {

    public ExcepcionManager() {
        super();
    }

    public ExcepcionManager(String message) {
        super(message);
    }

    public ExcepcionManager(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionManager(Throwable cause) {
        super(cause);
    }

    protected ExcepcionManager(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
