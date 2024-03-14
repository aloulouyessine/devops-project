package tn.esprit.devops_project.tests;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OperatorServiceImplMockitoTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @Test
    void retrieveOperator() {
        Long id = 1L;
        Operator operator = new Operator(id, "Operator 1");

        when(operatorRepository.findById(id)).thenReturn(Optional.of(operator));

        Operator result = operatorService.retrieveOperator(id);

        assertEquals(operator, result);
        verify(operatorRepository, times(1)).findById(id);
    }

    @Test
    void deleteOperator() {
        Long id = 1L;

        operatorService.deleteOperator(id);

        verify(operatorRepository, times(1)).deleteById(id);
    }

    // Add more test methods for other operations similarly
}

