package gr.manolis.steli.markets.test;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TestMapper {

    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);
    
    TestDTO toDTO(Test test);
    
    @AfterMapping
    default void afterMapping(@MappingTarget TestDTO testDTO, Test test) {
        testDTO.setText("test " + test.getCounter());
    }
}
