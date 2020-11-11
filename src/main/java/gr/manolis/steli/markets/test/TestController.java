package gr.manolis.steli.markets.test;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

/**
 * an example api , also counts how many times it run
 */
@RestController
@RequestMapping("/test")
@Log4j
public class TestController {
    
    @Autowired
    private TestRepository repository;

    @PostMapping("/")
    public Test addTest() {
        log.info("addTest");
        
        int counter = (int) repository.count();
        log.debug("counter: " + counter);
        
        Test test = new Test(counter);
        return repository.save(test);
    }
    
    @GetMapping("/")
    public List<Test> getTests() {
        log.info("getTests");
        return repository.findAll();
    }

}
