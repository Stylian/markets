package gr.manolis.steli.markets;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalcExampleTest {

    @Test
    public void testAdd() {
        CalcExample calc = new CalcExample();
        double delta = .1;

        assertEquals(15, calc.add(5, 7, 3), delta);
        assertEquals(8, calc.add(5, 3), delta);

    }

    @Test
    public void testFailMe() {
        CalcExample calc = new CalcExample();
        double delta = .1;

        assertEquals(15, calc.add(5, 9, 3), delta);
        assertEquals(8, calc.add(5, 3), delta);

    }

}
