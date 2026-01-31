/*
 * Copyright 2020 Fintech Open Source Foundation
 *
 * Distributed under the Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.fdc.appd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * This is the factory class which provides the V2ApplicationReader  implementation based on the configuration (eg JSON , Database)
 * Here in , a default implementation for the JSON datasource for App details JSON is provided .
 */
@Component
public class ApplicationReaderFactory {

    @Autowired
    private V2ApplicationJsonReaderImpl v2ApplicationJsonReader;

    @Value("${fdc.application.readerType}")
    private String readerType;

    /**
     * Factory Method for creating the Application Details reader .
     * @return
     */
    public V2ApplicationReader createApplicationReader(){
        if(readerType.equalsIgnoreCase("JSON")){
            return v2ApplicationJsonReader;
        }
        else
            throw new RuntimeException("No valid reader entry found");
    }
}
