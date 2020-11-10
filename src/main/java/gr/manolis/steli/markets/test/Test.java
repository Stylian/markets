package gr.manolis.steli.markets.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private int counter;

    public Long getId() {
        return id;
    }

    public int getCounter() {
        return counter;
    }

    protected Test() { }
    
    public Test(int counter) {
        this.counter = counter;
    }
}
