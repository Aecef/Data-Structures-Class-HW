/**author acleofe */
public class MetricConversionTest {
    public static void main(String[] args) {
        System.out.println("\nPossible Conversion Requests:\n" +
                "Pound <-----> Gram, Kilogram\n" +
                "Ounce, Cup, Quart, Gallon <-----> Milliliter, Liter\n" +
                "Inch, Foot, Yard, Mile <-----> Centimeter, Meter, Kilometer\n");
        System.out.println("Enter Conversion Request: ");
        System.out.println("(Format: ('How many [Measurement Requested] are in [amount] [Measurement Provided]')");
        System.out.println("(EX: 'How many inches are in 2 meters?')");
        MetricConversion converter = new MetricConversion();
        converter.convert();
    }
}
