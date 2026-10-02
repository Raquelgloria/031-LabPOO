public class RpgException extends RuntimeException {

    public RpgException(String mensaje) {
        super(mensaje);
    }

    public RpgException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}