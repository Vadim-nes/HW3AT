import DeliveryCalc.Delivery;
import DeliveryCalc.Dimensions;
import DeliveryCalc.Fragile;
import DeliveryCalc.Traffic;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DeliveryTest {

    @Test(description = "This is a payment calculation test",dataProvider = "testDataMethod", groups = {"regression"})
    public void calculationDeliveryTest(double a, Dimensions dimensions, Fragile fragile, Traffic traffic, double expected) {

        Delivery delivery = new Delivery(a, dimensions, fragile, traffic);

        double actualValue = delivery.calculateDelivery();
        Assert.assertEquals(actualValue, expected);


    }

    @DataProvider(name = "testDataMethod")
    public Object[][] testDataMethod() {
        return new Object[][]{

                {11, Dimensions.LARGE, Fragile.YES, Traffic.MEDIUM, 840},
                {3, Dimensions.SMALL, Fragile.YES, Traffic.STANDARD, 500},
                {0.1, Dimensions.SMALL, Fragile.NO, Traffic.MEDIUM, 400},
                {3, Dimensions.LARGE, Fragile.NO, Traffic.HIGHEST, 480},
                {31, Dimensions.LARGE, Fragile.NO, Traffic.STANDARD, 500}

        };
    }

    @Test(groups ={"negative"}, expectedExceptions = ArithmeticException.class, expectedExceptionsMessageRegExp = "Fragile package can't be delivered so far > 30 km" )

    public void moreThan30FragileTest(){
        Delivery delivery = new Delivery(31, Dimensions.LARGE, Fragile.YES, Traffic.STANDARD);

        delivery.calculateDelivery();

    }

    @Test(groups ={"negative"}, expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "It can't be negative value or 0")
    public void negativeDistanceTest(){

        Delivery delivery = new Delivery(-1, Dimensions.LARGE, Fragile.YES, Traffic.STANDARD);

        delivery.calculateDelivery();

    }
}


