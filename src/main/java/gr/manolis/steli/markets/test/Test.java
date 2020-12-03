package gr.manolis.steli.markets.test;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Test {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private int counter;
    
    @Column(name = "VALUE1")
    private int value = 42;

    protected Test() { }
    
    public Test(int counter) {
        this.counter = counter;
    }
}
