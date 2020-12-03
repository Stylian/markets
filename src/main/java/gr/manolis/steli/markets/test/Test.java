package gr.manolis.steli.markets.test;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Test {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private int counter;
    private int value = 42;

    protected Test() { }
    
    public Test(int counter) {
        this.counter = counter;
    }
}
