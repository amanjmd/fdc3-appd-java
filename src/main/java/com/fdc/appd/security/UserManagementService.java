/*
 * Copyright 2020 Fintech Open Source Foundation
 *
 * Distributed under the Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0).
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package com.fdc.appd.security;

public interface UserManagementService {

    default public boolean validateUser(String userName)  {
       return false;
    }
}
