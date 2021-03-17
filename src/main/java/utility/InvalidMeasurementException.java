package utility;

public class InvalidMeasurementException extends Exception{

    public InvalidMeasurementException(){
        super("Zero or negative values values is not applicable");
    }
}
