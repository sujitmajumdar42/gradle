/*
 * Copyright 2012 the original author or authors.
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

package org.gradle.api.internal.artifacts.repositories.resolver;

import org.apache.ivy.core.module.id.ArtifactRevisionId;
import org.gradle.api.artifacts.ArtifactIdentifier;
import org.gradle.api.artifacts.ModuleIdentifier;

public interface ResourcePattern {
    /**
     * Returns the path to the given artifact.
     */
    String toPath(ArtifactRevisionId artifact);

    /**
     * Returns the pattern which can be used to search for versions of the given artifact.
     * The returned pattern should include at least one [revision] placeholder.
     */
    String toVersionListPattern(ArtifactIdentifier artifact);

    /**
     * Returns the path to the given module.
     */
    String toModulePath(ModuleIdentifier moduleIdentifier);

    /**
     * Returns the path to the module version for the given artifact.
     */
    String toModuleVersionPath(ArtifactRevisionId artifact);
}
