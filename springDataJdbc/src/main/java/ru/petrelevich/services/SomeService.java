package ru.petrelevich.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.petrelevich.repository.SomeObjectRepository;

import javax.annotation.PostConstruct;

@Service
public class SomeService {
    private static final Logger logger = LoggerFactory.getLogger(SomeService.class);
    private final SomeObjectRepository someObjectRepository;

    public SomeService(SomeObjectRepository someObjectRepository) {
        this.someObjectRepository = someObjectRepository;
    }

    @PostConstruct
    public void someAction() {
        var someObjectList = someObjectRepository.findAll();
        logger.info("someAction");
        someObjectList.forEach(someObject -> logger.info("someObject:{}", someObject));
    }
}
