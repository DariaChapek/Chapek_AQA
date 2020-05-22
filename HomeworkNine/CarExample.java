package HomeworkEight;

public class CarExample {

    public static void main(String[] args) {

        Car car1 = new Car("BMW", "red", 2016, "Automatic");
        Car car2 = new Car("BMW", "red", 2016, "Automatic");
        Car car3 = new Car("Audi", "black", 2002, "Manual");
        Car car4 = new Car("VW", "silver", 2017, "Automatic");
        Car car5 = new Car("Bently", "red", 2012, "Manual");

        CarArray carList = new CarArray();

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        System.out.print("Начальный массив.");
        CarArray.printCars(carList.getCarList());
        System.out.println();
        System.out.print("Отсортированный массив по году.");
        CarArray.printCars(carList.sort());
        System.out.println();
        System.out.print("Массив с красными машинами.");
        CarArray.printCars(carList.getRedCars("red"));
        System.out.println();
        System.out.println("Статистика машин по цвету.");
        System.out.println(carList.getColorStatistic());
        System.out.println();
        System.out.print("Самые новые машины.");
        CarArray.printCars(carList.getNewCars(2));
        System.out.println();
        System.out.print("Только уникальные машины.");
        CarArray.printCars(carList.getUniqueCars());

    }

}
