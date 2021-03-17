package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class QuantityTest {

    @Test
    public void CheckIf1CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double dimension1 = 1;
        double dimension2 = 1;
        Quantity firstQuantity = new Quantity(dimension1, Unit.Centimeter);
        Quantity secondQuantity = new Quantity(dimension2, Unit.Centimeter);

        boolean actual = firstQuantity.equals(secondQuantity);

        assertTrue(actual);
    }
    @Test
    public void CheckIf1CentimeterNotEquals2Centimeter() throws InvalidMeasurementException {
        double firstDimension = 1;
        double secondDimension = 2;
        Quantity firstQuantity = new Quantity(firstDimension, Unit.Centimeter);
        Quantity secondQuantity = new Quantity(secondDimension, Unit.Centimeter);

        boolean actual = firstQuantity.equals(secondQuantity);

        assertFalse(actual);
    }



    @Test
    public void CheckIsEqualsIsFalseForNonMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        Quantity firstQuantity = new Quantity(dimension, Unit.Centimeter);
        Integer secondMeasurement = 1;

        boolean actual = firstQuantity.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void CheckIfEqualsIsTrueForSameMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        Quantity quantity = new Quantity(dimension, Unit.Centimeter);

        boolean actual = quantity.equals(quantity);

        assertTrue(actual);
    }

    @Test
    public void CheckIfThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new Quantity(dimension, Unit.Centimeter));
    }

    @Test
    public void CheckIfThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new Quantity(dimension, Unit.Centimeter));
    }

    @Test
    public void CheckIfEqualsIsTrueFor1MeterEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInMeter = new Quantity(dimensionInMeter, Unit.Meter);

        boolean actual = quantityInCentimeter.equals(quantityInMeter);

        assertTrue(actual);
    }

    @Test
    public void CheckIfEqualsIsTrueFor100CentimeterEquals1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInMeter = new Quantity(dimensionInMeter, Unit.Meter);

        boolean actual = quantityInMeter.equals(quantityInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void CheckIfEqualsIsTrueFor100CentimeterEqualsOneThousandthKilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInKilometer = new Quantity(dimensionInKilometer, Unit.Kilometer);

        boolean actual = quantityInCentimeter.equals(quantityInKilometer);

        assertTrue(actual);
    }

    @Test
    public void CheckIfEqualsIsTrueForOneThousandthKilometerEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInKilometer = new Quantity(dimensionInKilometer, Unit.Kilometer);

        boolean actual = quantityInKilometer.equals(quantityInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void CheckIfAddIs2MeterFor1MeterAnd100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInMeter = new Quantity(dimensionInMeter, Unit.Meter);
        Quantity expected = new Quantity(2, Unit.Meter);

        Quantity actual = quantityInMeter.add(quantityInCentimeter, Unit.Meter);

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIfAddIs100200CentimeterFor200CentimeterAnd1Kilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 200;
        double dimensionInKilometer = 1;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInKilometer = new Quantity(dimensionInKilometer, Unit.Kilometer);
        Quantity expected = new Quantity(100200, Unit.Centimeter);

        Quantity actual = quantityInKilometer.add(quantityInCentimeter, Unit.Centimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIfAddIs2KilometerFor100000CentimeterAnd1000Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100000;
        double dimensionInMeter = 1000;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInMeter = new Quantity(dimensionInMeter, Unit.Meter);
        Quantity expected = new Quantity(2, Unit.Kilometer);

        Quantity actual = quantityInMeter.add(quantityInCentimeter, Unit.Kilometer);

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIfSubtractIsHalfMeterForRemoving50CentimeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInMeter = new Quantity(dimensionInMeter, Unit.Meter);
        Quantity expected = new Quantity(0.5, Unit.Meter);

        Quantity actual = quantityInMeter.subtract(quantityInCentimeter, Unit.Meter);

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIfSubtractIs1900CentimeterForRemoving1MeterFrom2000Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 2000;
        double dimensionInMeter = 1;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInMeter = new Quantity(dimensionInMeter, Unit.Meter);
        Quantity expected = new Quantity(1900, Unit.Centimeter);

        Quantity actual = quantityInCentimeter.subtract(quantityInMeter, Unit.Centimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void CheckIfSubtractThrowsExceptionForRemoving1MeterFrom50Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        Quantity quantityInCentimeter = new Quantity(dimensionInCentimeter, Unit.Centimeter);
        Quantity quantityInMeter = new Quantity(dimensionInMeter, Unit.Meter);

        assertThrows(IllegalArgumentException.class, () -> quantityInCentimeter.subtract(quantityInMeter, Unit.Meter));
    }

    @Test
    public void CheckIfSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInMeter = 1;
        Quantity quantityInMeter = new Quantity(dimensionInMeter, Unit.Meter);

        assertThrows(IllegalArgumentException.class, () -> quantityInMeter.subtract(quantityInMeter, Unit.Meter));
    }


}
