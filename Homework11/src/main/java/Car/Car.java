package Car;

import java.util.Objects;

public class Car {

    private String model;
    private String color;
    private int year;
    private String transmission;

    public Car(String model, String color, int year, String transmission) {
        this.model = model;
        this.color = color;
        this.year = year;
        this.transmission = transmission;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", transmission='" + transmission + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color) &&
                Objects.equals(transmission, car.transmission);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
