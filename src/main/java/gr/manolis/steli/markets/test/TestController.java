package gr.manolis.steli.markets.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping("/test")
public class TestController {
    
    private static final Logger log = Logger.getLogger(TestController.class);

    @Autowired
    private TestRepository repository;

    @RequestMapping("/")
    public String getIfItWorks() {
        return "it works!";
    }

    @RequestMapping("/add")
    public Test add() {
        return repository.save(new Test("test 2"));
    }
    
    @RequestMapping("/get")
    public List<Test> get() {
        return repository.findAll();
    }

}
