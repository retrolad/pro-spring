package com.retrolad.ch13.mockito;

import com.retrolad.ch13.DeveloperController;
import com.retrolad.ch13.entities.Developer;
import com.retrolad.ch13.services.DeveloperService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeveloperControllerTest {

    private final List<Developer> developers = new ArrayList<>();

    @Before
    public void initDevelopers() {
        Developer developer = new Developer();
        developer.setId(1L);
        developer.setName("EA");
        developers.add(developer);
    }

    @Test
    public void testList() throws Exception {
        DeveloperService developerService = mock(DeveloperService.class);
        // Imitate findAll method, it returns developers list
        when(developerService.findAll()).thenReturn(developers);

        DeveloperController developerController = new DeveloperController();

        // Set private developerService field of DeveloperController class
        ReflectionTestUtils.setField(developerController, "developerService", developerService);

        ExtendedModelMap uiModel = new ExtendedModelMap();
        uiModel.addAttribute("developers", developerController.listData());

        // Imitate client call to developer controller
        List<Developer> modelDevelopers = (List<Developer>)uiModel.get("developers");
        assertEquals(1, modelDevelopers.size());
    }

    @Test
    public void testCreate() {
        Developer developer = new Developer();
        developer.setId(999L);
        developer.setName("Bethesda");

        // Imitate DeveloperService
        DeveloperService developerService = mock(DeveloperService.class);
        // Imitate services save method
        when(developerService.save(developer)).then(new Answer<Developer>() {
            // Imitate returned value
            @Override
            public Developer answer(InvocationOnMock invocation) throws Throwable {
                developers.add(developer);
                return developer;
            }
        });

        DeveloperController developerController = new DeveloperController();

        // Inject DeveloperService to DeveloperController
        ReflectionTestUtils.setField(developerController, "developerService", developerService);

        Developer createdDeveloper = developerController.create(developer);
        assertEquals(Long.valueOf(999L), createdDeveloper.getId());
        assertEquals("Bethesda", createdDeveloper.getName());
        assertEquals(2, developers.size());
    }
}
