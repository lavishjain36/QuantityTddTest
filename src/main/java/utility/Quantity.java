package utility;

public class Quantity {

    private final double dimension;
    private final Unit unit;

    public Quantity(double dimension, Unit unit) throws InvalidMeasurementException {
        if (dimension <= 0)
            throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Quantity)) return false;

        Quantity quantity = (Quantity) object;
        return this.unit.dimensionInMeter(dimension) == quantity.unit.dimensionInMeter(quantity.dimension);
    }


    public Quantity add(Quantity quantity, Unit unit) throws InvalidMeasurementException {
        double sum = this.unit.dimensionInMeter(dimension) + quantity.unit.dimensionInMeter(quantity.dimension);
        double sumInSpecifiedUnit = unit.givenDimensionInMeterConvertToSpecificUnit(sum);

        return new Quantity(sumInSpecifiedUnit, unit);
    }


    public Quantity subtract(Quantity quantity, Unit unit) {

        double difference = this.unit.dimensionInMeter(dimension) - quantity.unit.dimensionInMeter(quantity.dimension);
        double differenceInSpecifiedUnit = unit.givenDimensionInMeterConvertToSpecificUnit(difference);

        try {
            return new Quantity(differenceInSpecifiedUnit, unit);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }
}