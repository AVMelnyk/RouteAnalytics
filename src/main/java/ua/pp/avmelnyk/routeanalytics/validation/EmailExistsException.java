package ua.pp.avmelnyk.routeanalytics.validation;


@SuppressWarnings("serial")
public class EmailExistsException extends Throwable {

    public EmailExistsException(final String message) {
        super(message);
    }

}