package com.hdgh0g.backend.services;

import com.hdgh0g.backend.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class AdminManagerImpl implements AdminManager {

    @Value("${security.admin.password.raw:}")
    private String adminPassword;

    @Value("${security.admin.password.file:}")
    private String adminPasswordFile;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostConstruct
    public void init() {
        if (adminPasswordFile != null) {
            try {
                adminPassword = Files.lines(new File(adminPasswordFile).toPath()).findFirst().orElse(adminPassword);
            } catch (IOException e) {
                log.error("Error while trying to read admin password file " + adminPasswordFile, e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void checkPassword(String password) throws ServiceException {
        if (adminPassword == null || !adminPassword.equals(password)) {
            throw new ServiceException(ServiceException.Reason.NOT_AUTHORIZED);
        }
    }
}