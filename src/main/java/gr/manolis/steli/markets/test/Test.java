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
    
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    protected Test() { }
    
    public Test(String name) {
        this.name = name;
    }
}
