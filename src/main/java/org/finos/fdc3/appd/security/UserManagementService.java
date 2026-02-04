/*
 * Copyright 2020 Fintech Open Source Foundation
 *
 * Distributed under the Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.finos.fdc3.appd.security;

public interface UserManagementService {

    default boolean validateUser(String userName)  {
       return false;
    }
}
