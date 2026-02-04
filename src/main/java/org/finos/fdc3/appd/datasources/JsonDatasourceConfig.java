/*
 * Copyright 2020 Fintech Open Source Foundation
 *
 * Distributed under the Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.finos.fdc3.appd.datasources;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * This is the main configuration holder for the application details JSON file .
 * The <fdc.appd.appJson> value should be included in the application properties.</Path>
 */
@Component
@ConfigurationProperties("fdc.appd.app-json")
public class JsonDatasourceConfig {

    public String path ;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
