package Car;

import java.util.*;

public class CarArray {

    private static ArrayList<Car> carList = new ArrayList<>();

    public void add(Car car) {
        carList.add(car);
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public ArrayList<Car> sort() {
        ArrayList<Car> sortedCars = carList;
        sortedCars.sort(new YearComparator());
        return sortedCars;
    }

    public ArrayList<Car> getRedCars(String color) {
        ArrayList<Car> redCarsList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getColor().equals(color)) {
                redCarsList.add(car);
            }
        }
        return redCarsList;
    }

    public HashMap<String, Integer> getColorStatistic() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < carList.size(); i++) {
            int count = 0;
            if (hashMap.containsKey(carList.get(i).getColor())) {
                continue;
            }
            for (Car car : carList) {
                if (carList.get(i).getColor().equals(car.getColor())) {
                    count++;
                }
            }
            hashMap.put(carList.get(i).getColor(), count);
        }
        return hashMap;
    }

    public ArrayList<Car> getNewCars(int n) {
        ArrayList<Car> newCars = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            newCars.add(i, carList.get(i));
        }
        newCars.sort(new YearComparator());
        newCars.subList(0, newCars.size() - n).clear();
        return newCars;
    }

    public ArrayList<Car> getUniqueCars() {
        ArrayList<Car> uniqueCars = new ArrayList<Car>();
        for (int i = 0; i < carList.size(); i++) {
            uniqueCars.add(i, carList.get(i));
        }
        for (int i = 0; i < uniqueCars.size(); i++) {
            for (int j = i + 1; j < uniqueCars.size(); j++) {
                if (uniqueCars.get(i).equals(uniqueCars.get(j))) {
                    uniqueCars.remove(j);
                    j--;
                }
            }
        }
        return uniqueCars;
    }

    public static void printCars(ArrayList<Car> cars) {
        String list = "\nCarArray: ";
        for (int i = 0; i < cars.size(); i++) {
            list += "\n" + i +
                    ": model = '" + cars.get(i).getModel() + '\'' +
                    ", color = '" + cars.get(i).getColor() + '\'' +
                    ", year = " + cars.get(i).getYear() +
                    ", transmission = " + cars.get(i).getTransmission();
        }
        System.out.println(list);
    }
}
