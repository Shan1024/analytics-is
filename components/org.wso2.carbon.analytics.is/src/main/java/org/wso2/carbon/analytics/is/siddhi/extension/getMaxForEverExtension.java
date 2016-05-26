/*
 * Copyright (c)  2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.wso2.carbon.analytics.is.siddhi.extension;

import org.wso2.carbon.analytics.shared.geolocation.exception.GeoLocationResolverException;
import org.wso2.carbon.analytics.shared.geolocation.impl.GeoLocationResolverUDF;
import org.wso2.siddhi.core.config.ExecutionPlanContext;
import org.wso2.siddhi.core.executor.ExpressionExecutor;
import org.wso2.siddhi.core.executor.function.FunctionExecutor;
import org.wso2.siddhi.query.api.definition.Attribute;

public class getMaxForEverExtension extends FunctionExecutor {

    long maxValueUpToNow = 0;

    @Override
    protected void init(ExpressionExecutor[] expressionExecutors, ExecutionPlanContext executionPlanContext) {

    }

    @Override
    protected Object execute(Object[] objects) {
        return null;
    }

    @Override
    protected Object execute(Object o) {
        long currentTime = Long.parseLong(o.toString());
        if (maxValueUpToNow < currentTime) {
            maxValueUpToNow = currentTime;
        }
        return maxValueUpToNow;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public Attribute.Type getReturnType() {
        return Attribute.Type.LONG;
    }

    @Override
    public Object[] currentState() {
        return new Object[]{maxValueUpToNow};
    }

    @Override
    public void restoreState(Object[] objects) {
        maxValueUpToNow = (Long) objects[0];

    }
}