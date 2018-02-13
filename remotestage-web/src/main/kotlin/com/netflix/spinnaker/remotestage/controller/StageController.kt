/*
 * Copyright 2018 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.spinnaker.remotestage.controller

import com.netflix.spinnaker.orca.pipeline.tasks.NoOpTask
import com.netflix.spinnaker.orca.remotestage.api.TaskGraphRequest
import com.netflix.spinnaker.orca.remotestage.api.TaskGraphResponse
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stage")
class StageController {

  @RequestMapping(value = ["/taskGraph"], method = [(RequestMethod.POST)])
  fun taskGraph(@RequestBody request: TaskGraphRequest): TaskGraphResponse {
    request.builder.withTask("addSomeOutputs", NoOpTask::class.java)

    return TaskGraphResponse(
      serviceVersion = "0.1.0",
      builder = request.builder
    )
  }
}
