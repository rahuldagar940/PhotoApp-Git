package Rahul.com.example.PhotoApp.exception;

public class RestrictedInfoException extends Exception{
    @Override
    public String getMessage() {
        return "Error : Classified Info";
    }
}
