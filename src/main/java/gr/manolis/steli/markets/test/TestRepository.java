package gr.manolis.steli.markets.test;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepository extends CrudRepository<Test, Long> {
    
    Test findById(long id);
    List<Test> findAll();
    
}
