package com.retrolad.ch13;

import com.retrolad.ch13.entities.Developer;
import com.retrolad.ch13.services.DeveloperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping(value = "/rest/developer")
public class DeveloperController {

    private static final Logger logger = LoggerFactory.getLogger(DeveloperController.class);

    @Autowired
    private DeveloperService developerService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/listdata", method = RequestMethod.GET)
    @ResponseBody
    public List<Developer> listData() {
        return developerService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Developer findDeveloperById(@PathVariable Long id) {
        return developerService.findById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Developer create(@RequestBody Developer developer) {
        logger.info("Creating developer: " + developer);
        developerService.save(developer);
        logger.info("Developer created successfully");
        return developer;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public void update(@RequestBody Developer developer, @PathVariable Long id) {
        logger.info("Updating developer: " + developer);
        developerService.save(developer);
        logger.info("Developer updated successfully: " + developer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        logger.info("Deleting developer with id: " + id);
        Developer developer = developerService.findById(id);
        developerService.delete(developer);
        logger.info("Developer deleted successfully");
    }
}
