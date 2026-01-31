/*
 * Copyright 2020 Fintech Open Source Foundation
 *
 * Distributed under the Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.fdc.appd.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

public class ApplicationReaderFactoryTest {

    @Mock
    private V2ApplicationJsonReaderImpl v2ApplicationJsonReader;

    @InjectMocks
    public ApplicationReaderFactory applicationReaderFactory;

    @BeforeEach 
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        
       
    }

    @Test
    void testCreateApplicationReader() {
        ReflectionTestUtils.setField(applicationReaderFactory, "readerType", "JSON");
        assertEquals(applicationReaderFactory.createApplicationReader(),v2ApplicationJsonReader);
    }

    @Test
    void testCreateApplicationReaderFailure() {
        RuntimeException returnValue = assertThrows(RuntimeException.class, ()->{
            ReflectionTestUtils.setField(applicationReaderFactory, "readerType", "JSONB");
            assertEquals(applicationReaderFactory.createApplicationReader(),v2ApplicationJsonReader);
        });
        
        assertEquals("No valid reader entry found", returnValue.getMessage());
    }


}
