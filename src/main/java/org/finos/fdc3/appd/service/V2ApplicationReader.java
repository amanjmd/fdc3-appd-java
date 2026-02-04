/*
 * Copyright 2020 Fintech Open Source Foundation
 *
 * Distributed under the Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.finos.fdc3.appd.service;

import org.finos.fdc3.appd.model.AllApplicationsResponse;
import org.finos.fdc3.appd.model.Application;

import java.io.IOException;




public interface V2ApplicationReader {

    /**
     *
     * @param appId
     * @return com.fdc.appd.model.Application
     * @throws IOException
     */
    public Application getApplication(String appId) throws IOException;

    /**
     *
     * @return com.fdc.appd.model.AllApplicationsResponse
     * @throws IOException
     */
    public AllApplicationsResponse getAllApplication() throws IOException;
}
