/*
 * Copyright 2009 the original author or authors.
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
package org.gradle.api.internal.artifacts.ivyservice;

import org.apache.ivy.core.module.id.ArtifactRevisionId;
import org.apache.ivy.core.module.id.ModuleRevisionId;
import org.gradle.api.artifacts.ArtifactIdentifier;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.Module;
import org.gradle.api.artifacts.ModuleVersionIdentifier;
import org.gradle.util.GUtil;

import java.util.Collections;
import java.util.Map;

public class IvyUtil {

    public static ModuleRevisionId createModuleRevisionId(Module module) {
        return createModuleRevisionId(module, Collections.<String, String>emptyMap());
    }

    public static ModuleRevisionId createModuleRevisionId(Module module, Map<String, String> extraAttributes) {
        return createModuleRevisionId(module.getGroup(), module.getName(), module.getVersion(), extraAttributes);
    }

    public static ModuleRevisionId createModuleRevisionId(Dependency dependency) {
        return createModuleRevisionId(dependency, Collections.<String, String>emptyMap());
    }

    public static ModuleRevisionId createModuleRevisionId(Dependency dependency, Map<String, String> extraAttributes) {
        return createModuleRevisionId(dependency.getGroup(), dependency.getName(), dependency.getVersion(), extraAttributes);
    }

    public static ModuleRevisionId createModuleRevisionId(String group, String name, String version, Map<String, String> extraAttributes) {
        return ModuleRevisionId.newInstance(emptyStringIfNull(group), name, emptyStringIfNull(version), extraAttributes);
    }

    public static ModuleRevisionId createModuleRevisionId(ModuleVersionIdentifier id) {
        return ModuleRevisionId.newInstance(id.getGroup(), id.getName(), id.getVersion());
    }

    public static ArtifactRevisionId createArtifactRevisionId(ArtifactIdentifier id) {
        ModuleRevisionId moduleRevisionId = createModuleRevisionId(id.getModuleVersionIdentifier());
        // TODO:DAZ Handle classifier
        return ArtifactRevisionId.newInstance(moduleRevisionId, id.getName(), id.getType(), id.getExtension());
    }

    private static String emptyStringIfNull(String value) {
        return GUtil.elvis(value, "");
    }
}
