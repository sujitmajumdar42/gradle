/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.internal.component.local.model;

import org.gradle.api.file.FileCollection;
import org.gradle.api.tasks.TaskDependency;
import org.gradle.internal.component.model.ConfigurationMetadata;

import java.util.Set;

public interface LocalConfigurationMetadata extends ConfigurationMetadata {

    String getDescription();

    Set<String> getExtendsFrom();

    /**
     * The task dependencies required to build any artifacts and self-resolving dependencies for this configuration.
     */
    TaskDependency getDirectBuildDependencies();

    /**
     * Returns the files attached to this configuration, if any. These should be represented as dependencies, but are represented as files as a migration step.
     */
    Set<FileCollection> getFiles();
}
