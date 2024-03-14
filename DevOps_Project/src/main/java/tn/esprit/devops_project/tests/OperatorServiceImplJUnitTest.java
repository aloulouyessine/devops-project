package tn.esprit.devops_project.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.OperatorServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OperatorServiceImplJUnitTest {

    @Mock
    private OperatorRepository operatorRepository;

    @InjectMocks
    private OperatorServiceImpl operatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retrieveAllOperators() {
        List<Operator> operators = new ArrayList<>();
        operators.add(new Operator(1L, "Operator 1"));
        operators.add(new Operator(2L, "Operator 2"));

        when(operatorRepository.findAll()).thenReturn(operators);

        List<Operator> result = operatorService.retrieveAllOperators();

        assertEquals(2, result.size());
        verify(operatorRepository, times(1)).findAll();
    }

    @Test
    void addOperator() {
        Operator operator = new Operator(1L, "Operator 1");

        when(operatorRepository.save(operator)).thenReturn(operator);

        Operator result = operatorService.addOperator(operator);

        assertEquals(operator, result);
        verify(operatorRepository, times(1)).save(operator);
    }

    // Add more test methods for other operations similarly
}
