package kmo.java14;

import java.util.Objects;

public class RecordExample {

    public static void main(String[] args) {
        final var car1 = new Car("model101", "vin1");
        final var car2 = new Car("model101", "vin1");

        System.out.println(car1.equals(car2));

        final var auto = new Auto("model1337", "vin2");

        System.out.println(auto);
    }

}

record Car(String model, String vin) {

}

record Auto(String model, String vin, String name) {
    public Auto(String model, String vin) {
        this(model, vin, null);
    }
}

class Porsche /*extends Car*/ {

}

class Audi {
    private final String model;
    private final String vin;

    public Audi(final String model, final String vin) {
        this.model = model;
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Audi audi = (Audi) o;
        return Objects.equals(model, audi.model) && Objects.equals(vin, audi.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, vin);
    }

    @Override
    public String toString() {
        return "Audi{" +
                "model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
