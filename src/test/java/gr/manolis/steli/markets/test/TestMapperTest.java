package gr.manolis.steli.markets.test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.Assert.assertEquals;

public class TestMapperTest {
    
    @Test
    public void shouldMapTestToDTO() {

        gr.manolis.steli.markets.test.Test test = 
                new gr.manolis.steli.markets.test.Test(5);
        
        TestDTO testDTO = TestMapper.INSTANCE.toDTO(test);
        
        assertThat(testDTO).isNotNull();
        assertThat(testDTO.getText()).isEqualTo("test " + test.getCounter());
    }
    
}
