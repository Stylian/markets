package gr.manolis.steli.markets;

public class CalcExample {

    public double add(double... numbers) {
        double sum = 0;
        for(double num: numbers) {
            sum += num;
        }
        return sum;
    }




}
