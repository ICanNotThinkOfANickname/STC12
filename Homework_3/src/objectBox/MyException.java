package objectBox;

public class MyException extends Exception {
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public String toString() {
        return "myException - wrong value" + message.toString();
    }
}