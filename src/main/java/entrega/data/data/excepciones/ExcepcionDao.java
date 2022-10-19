package entrega.data.data.excepciones;

public class ExcepcionDao extends Exception{
    public ExcepcionDao() {
        super();
    }

    public ExcepcionDao(String message) {
        super(message);
    }

    public ExcepcionDao(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionDao(Throwable cause) {
        super(cause);
    }

    protected ExcepcionDao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
