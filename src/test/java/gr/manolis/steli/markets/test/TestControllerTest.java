package gr.manolis.steli.markets.test;

import gr.manolis.steli.markets.App;
import gr.manolis.steli.markets.DerbyTestDbConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes =
        {
                App.class,
                DerbyTestDbConfig.class
        },
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TestControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testAddTest() throws Exception {
        mockMvc.perform(post("/test/")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }
    
}
