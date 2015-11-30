/*
 * Syrup Pay Token Library
 *
 * Copyright (C) 2015 SK PLANET. ALL Rights Reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the SK PLANET., Bundang-gu, 264,
 * Pangyo-ro The Planet SK planet co., Ltd., Seongnam-si, Gyeonggi-do, Korea
 * or see https://www.syruppay.co.kr/
 */

package com.skplanet.syruppay.client;

import java.util.HashMap;
import java.util.Map;

/**
 * 시럽페이 리소스에 대한 {@link com.skplanet.syruppay.client.SyrupPayEnvironment} 정보를 매칭하여 관리한다.
 *
 * @author 임형태
 * @since 0.1
 */
public class ResourceMapToServer {
    private static final Map<Environment, SyrupPayEnvironment> SYRUP_PAY_ENVIRONMENT_MAP = new HashMap<Environment, SyrupPayEnvironment>();

    public SyrupPayEnvironment map(final String uri) {
        // TODO 코드 구현 필요
        return null;
    }

    public static enum Environment {
        DEVELOPMENT, STAGING_DEVELOPMENT, STAGING_SERVICE, SERVICE
    }
}
