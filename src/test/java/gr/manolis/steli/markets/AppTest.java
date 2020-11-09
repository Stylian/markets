package gr.manolis.steli.markets;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes =
//        {
//                App.class,
//        },
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(properties = { "management.port=0" })
//@ActiveProfiles("test")
public class AppTest {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//    
//    @Test
//    public void exampleTest() {
//        
//        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" 
//                        + this.port + "/test/", Map.class);
//        
//        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
}
