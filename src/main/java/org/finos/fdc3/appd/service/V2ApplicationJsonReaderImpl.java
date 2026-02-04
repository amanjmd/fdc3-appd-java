/*
 * Copyright 2020 Fintech Open Source Foundation
 *
 * Distributed under the Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.finos.fdc3.appd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finos.fdc3.appd.datasources.JsonDatasourceConfig;
import org.finos.fdc3.appd.model.AllApplicationsResponse;
import org.finos.fdc3.appd.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * This is the implementation for the reading the Application data from a JSON file.
 */
@Service
public class V2ApplicationJsonReaderImpl implements  V2ApplicationReader{

    @Autowired
    JsonDatasourceConfig jsonDatasourceConfig;

    private List<Application> allApplications;


    /**
     *
     * @param appId
     * @return Application
     * @throws IOException
     */

    @Override
    public Application getApplication(String appId) throws IOException {

        if(Objects.isNull(allApplications))
            this.allApplications=readApplicationData();

        return  this.allApplications.stream().filter(application -> application.getAppId().equals(appId)).findFirst().orElseThrow(()-> new RuntimeException("Application Not found with the given appId"));

    }

    /**
     *
     * @return AppApplicationResponse
     * @throws IOException
     */
    @Override
    public AllApplicationsResponse getAllApplication() throws IOException {
        if(Objects.isNull(allApplications))
            this.allApplications=readApplicationData();
        AllApplicationsResponse response = new AllApplicationsResponse();
        response.setApplications(this.allApplications);
        return response;
    }

    /**
     *
     * @return List of <Application> from the Json
     * @throws IOException
     */
    private List<Application> readApplicationData() throws IOException {

        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        ClassPathResource resource = new ClassPathResource(jsonDatasourceConfig.getPath());
        return objectMapper.readValue(resource.getInputStream(),AppJson.class).getApplications();


    }

    private static class AppJson{

        List<Application> applications;

        public List<Application> getApplications() {
            return applications;
        }

        public void setApplications(List<Application> applications) {
            this.applications = applications;
        }
    }


}
