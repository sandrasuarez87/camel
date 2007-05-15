/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.bam.model;

import org.apache.camel.Exchange;
import org.apache.camel.bam.ProcessDefinition;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * Represents a activity which is typically a system or could be an endpoint
 *
 * @version $Revision: $
 */
@Entity
@NamedQuery(name = "findByName",
        query = "select x from org.apache.camel.bam.model.Activity where x.name = ?1")
public class Activity {
    private int expectedMessages = 1;
    private String name;
    private ProcessDefinition process;

    public Activity(ProcessDefinition process) {
        this.process = process;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpectedMessages() {
        return expectedMessages;
    }

    public void setExpectedMessages(int expectedMessages) {
        this.expectedMessages = expectedMessages;
    }

    /**
     * Perform any assertions after the state has been updated
     */
    public void process(ActivityState activityState, Exchange exchange) {
        // TODO
    }
}
