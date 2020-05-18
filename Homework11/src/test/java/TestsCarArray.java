import Car.Car;
import Car.CarArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class TestsCarArray {

    Car car1 = new Car("BMW", "red", 2016, "Automatic");
    Car car2 = new Car("BMW", "red", 2016, "Automatic");
    Car car3 = new Car("Audi", "black", 2002, "Manual");

    private CarArray carArray;

    @BeforeClass
    public void testAddCars() {
        carArray = new CarArray();
        carArray.add(car1);
        carArray.add(car2);
        carArray.add(car3);
    }

    @Test
    public void testGetCarList() {
        System.out.println("testGetCarList()");
        assertThat(carArray.getCarList(), containsInAnyOrder(car1, car2, car3));
    }

    @Test
    public void testSortedCars() {
        System.out.println("testSortedCars()");
        ArrayList<Car> expectedList = new ArrayList<Car>();
        expectedList.add(car3);
        expectedList.add(car1);
        expectedList.add(car2);
        Assert.assertEquals(carArray.sort(), expectedList);
    }

    @Test
    public void testGetRedCars() {
        System.out.println("testGetRedCars()");
        ArrayList<Car> expectedList = new ArrayList<Car>();
        expectedList.add(car1);
        expectedList.add(car2);
        Assert.assertEquals(carArray.getRedCars("red"), expectedList);
    }

    @Test
    public void testGetColorStatistic() {
        System.out.println("testGetColorStatistic()");
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("red", 2);
        expectedMap.put("black", 1);
        Assert.assertEquals(carArray.getColorStatistic(), expectedMap);
    }

    @Test
    public void testGetNewCars() {
        System.out.println("testGetNewCars()");
        ArrayList<Car> expectedList = new ArrayList<Car>();
        expectedList.add(car2);
        Assert.assertEquals(carArray.getNewCars(1), expectedList);
    }

    @Test
    public void testGetUniqueCars() {
        System.out.println("testGetUniqueCars()");
        LinkedHashSet<Car> expectedList = new LinkedHashSet<>();
        expectedList.add(car1);
        expectedList.add(car3);
        Assert.assertEquals(carArray.getUniqueCars(), expectedList);
    }


}
