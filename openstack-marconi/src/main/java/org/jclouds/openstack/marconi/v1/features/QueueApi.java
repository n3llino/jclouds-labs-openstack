/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.openstack.marconi.v1.features;

import org.jclouds.Fallbacks;
import org.jclouds.openstack.keystone.v2_0.filters.AuthenticateRequest;
import org.jclouds.rest.annotations.Fallback;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SkipEncoding;

import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * Provides access to Queues via their REST API.
 * 
 * @author Everett Toews
 */
@SkipEncoding({'/', '='})
@RequestFilters(AuthenticateRequest.class)
public interface QueueApi {
   /**
    * Creates a new Queue
    *
    * @param name Name of the Queue. The name must not exceed 64 bytes in length, and it is limited to US-ASCII
    *             letters, digits, underscores, and hyphens.
    */
   @Named("queue:create")
   @PUT
   @Path("queues/{name}")
   @Consumes(MediaType.APPLICATION_JSON)
   @Fallback(Fallbacks.FalseOnNotFoundOr404.class)
   boolean create(@PathParam("name") String name);
}