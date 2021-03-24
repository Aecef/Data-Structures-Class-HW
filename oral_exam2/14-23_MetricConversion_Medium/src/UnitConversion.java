import java.util.HashMap;

public class UnitConversion {

    /**
     *
     * @param whatEnglish What english metric you currently have the amount of
     * @param toWhat What you would like to convert the given english measurement to
     * @param amount The amount of the english measurement that was given
     * @return The converted amount
     */
    public static double englishToMetricLength(String whatEnglish, String toWhat, double amount) {
        if (toWhat.equals("centimeter")) {
            if (whatEnglish.equals("inch")) {
                return amount / 2.54;
            }
            if (whatEnglish.equals("feet")) {
                return amount / 30.48;
            }
            if (whatEnglish.equals("yard")) {
                return amount / 91.44;
            }
            if (whatEnglish.equals("mile")) {
                return amount / 160934;
            }
        } else if (toWhat.equals("meter")) {
            if (whatEnglish.equals("inch")) {
                return amount / .0254;
            }
            if (whatEnglish.equals("feet")) {
                return amount / .3048;
            }
            if (whatEnglish.equals("yard")) {
                return amount / .9144;
            }
            if (whatEnglish.equals("mile")) {
                return amount / 1609.34;
            }
        } else if (toWhat.equals("kilometer")) {
            if (whatEnglish.equals("inch")) {
                return amount / .0000254;
            }
            if (whatEnglish.equals("feet")) {
                return amount / .0003048;
            }
            if (whatEnglish.equals("yard")) {
                return amount / .0009144;
            }
            if (whatEnglish.equals("mile")) {
                return amount / 1.60934;
            }
        }
        return 0;
    }

    /**
     *
     * @param whatEnglish What english metric you currently have the amount of
     * @param toWhat What you would like to convert the given english measurement to
     * @param amount The amount of the english measurement that was given
     * @return The converted amount
     */
    public static double englishToMetricLiquid(String whatEnglish, String toWhat, double amount) {
        if (toWhat.equals("milliliter")) {
            if (whatEnglish.equals("cup")) {
                return amount / 240;
            }
            if (whatEnglish.equals("quart")) {
                return amount / 946.353;
            }
            if (whatEnglish.equals("gallon")) {
                return amount / 3785.41;
            }
            if (whatEnglish.equals("ounce")) {
                return amount / 29.5735;
            }
        }
        if (toWhat.equals("liter")) {
            if (whatEnglish.equals("cup")) {
                return amount / .24;
            }
            if (whatEnglish.equals("quart")) {
                return amount / .946355;
            }
            if (whatEnglish.equals("gallon")) {
                return amount / 3.78541;
            }
            if (whatEnglish.equals("ounce")) {
                return amount / .0295735;
            }
        }
        return 0;
    }

    /**
     *
     * @param whatEnglish What english metric you currently have the amount of
     * @param toWhat What you would like to convert the given english measurement to
     * @param amount The amount of the english measurement that was given
     * @return The converted amount
     */
    public static double englishToMetricWeight(String whatEnglish, String toWhat, double amount) {
        if (toWhat.equals("gram")) {
            if (whatEnglish.equals("pound")) {
                return amount / 453.592;
            }
        }
        if (toWhat.equals("kilogram")) {
            if (whatEnglish.equals("pound")) {
                return amount / .453592;
            }
        }
        return 0;
    }


    /**
     *
     * @param whatEnglish What metric you currently have the amount of
     * @param toWhat What you would like to convert the given metric to
     * @param amount The amount of the metric that was given
     * @return The converted amount
     */
    public static double metricToEnglishWeight(String whatEnglish, String toWhat, double amount) {
        if (toWhat.equals("pound")) {
            if (whatEnglish.equals("gram")) {
                return amount * 453.592;
            }
            if (whatEnglish.equals("kilogram")) {
                return amount * .453592;
            }
        }
        return 0;
    }

    /**
     *
     * @param whatEnglish What metric you currently have the amount of
     * @param toWhat What you would like to convert the given metric to
     * @param amount The amount of the metric that was given
     * @return The converted amount
     */
    public static double metricToEnglishLiquid(String whatEnglish, String toWhat, double amount) {
        if (toWhat.equals("cup")) {
            if (whatEnglish.equals("milliliter")) {
                return amount * 240.0;
            }
            if (whatEnglish.equals("liter")) {
                return amount * .240;
            }
        }
        if (toWhat.equals("quart")) {
            if (whatEnglish.equals("milliliter")) {
                return amount * 946.353;
            }
            if (whatEnglish.equals("liter")) {
                return amount * .946353;
            }
        }
        if (toWhat.equals("gallon")) {
            if (whatEnglish.equals("milliliter")) {
                return amount * 3785.41;
            }
            if (whatEnglish.equals("liter")) {
                return amount * 3.78541;
            }
        }
        if (toWhat.equals("ounce")) {
            if (whatEnglish.equals("milliliter")) {
                return amount * 29.5735;
            }
            if (whatEnglish.equals("liter")) {
                return amount * .0295735;
            }
        }
        return 0;
    }


    /**
     *
     * @param whatMetric What metric you currently have the amount of
     * @param toWhat What you would like to convert the given metric to
     * @param amount The amount of the metric that was given
     * @return The converted amount
     */
    public static double metricToEnglishLength(String whatMetric, String toWhat, double amount){
        if(toWhat.equals("inch")){
            if(whatMetric.equals("centimeter")){
                return amount * 2.54;
            }
            if(whatMetric.equals("meter")){
                return amount * .0254;
            }
            if(whatMetric.equals("kilometer")){
                return amount * .0000254;
            }
        }
        else if(toWhat.equals("feet")){
            if(whatMetric.equals("centimeter")){
                return amount * 30.48;
            }
            if(whatMetric.equals("meter")){
                return amount * .3048;
            }
            if(whatMetric.equals("kilometer")){
                return amount * .0003048;
            }
        }
        else if(toWhat.equals("yard")){
            if(whatMetric.equals("centimeter")){
                return amount * 91.44;
            }
            if(whatMetric.equals("meter")){
                return amount * .9144;
            }
            if(whatMetric.equals("kilometer")){
                return amount * .0009144;
            }
        }
        else if(toWhat.equals("mile")){
            if(whatMetric.equals("centimeter")){
                return amount * 160934.0;
            }
            if(whatMetric.equals("meter")){
                return amount * 1609.34;
            }
            if(whatMetric.equals("kilometer")){
                return amount * 1.60934;
            }
        }
        return 0;
    }
}
