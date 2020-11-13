package gr.manolis.steli.markets.test;

import gr.manolis.steli.markets.App;
import gr.manolis.steli.markets.DerbyTestDbConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes =
        {
                App.class,
                DerbyTestDbConfig.class
        },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
@ActiveProfiles("test")
public class TestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Test
    void testAddTest() {
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
        ResponseEntity<Map> entity = this.testRestTemplate
                .postForEntity("http://localhost:" + this.port 
                + "/tests/", parts, Map.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
}
