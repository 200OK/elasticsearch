/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.client.action.admin.indices.settings;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.settings.UpdateSettingsRequest;
import org.elasticsearch.action.admin.indices.settings.UpdateSettingsResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.action.admin.indices.support.BaseIndicesRequestBuilder;
import org.elasticsearch.common.settings.Settings;

import java.util.Map;

/**
 * @author kimchy (shay.banon)
 */
public class UpdateSettingsRequestBuilder extends BaseIndicesRequestBuilder<UpdateSettingsRequest, UpdateSettingsResponse> {

    public UpdateSettingsRequestBuilder(IndicesAdminClient indicesClient, String... indices) {
        super(indicesClient, new UpdateSettingsRequest(indices));
    }

    public UpdateSettingsRequestBuilder setIndices(String... indices) {
        request.indices(indices);
        return this;
    }

    /**
     * The settings update.
     */
    public UpdateSettingsRequestBuilder setSettings(Settings settings) {
        request.settings(settings);
        return this;
    }

    /**
     * The settings to update.
     */
    public UpdateSettingsRequestBuilder setSettings(Settings.Builder settings) {
        request.settings(settings);
        return this;
    }

    /**
     * The settings to update (either json/yaml/properties format)
     */
    public UpdateSettingsRequestBuilder setSettings(String source) {
        request.settings(source);
        return this;
    }

    /**
     * The settings to update (either json/yaml/properties format)
     */
    public UpdateSettingsRequestBuilder setSettings(Map<String, Object> source) {
        request.settings(source);
        return this;
    }

    @Override protected void doExecute(ActionListener<UpdateSettingsResponse> listener) {
        client.updateSettings(request, listener);
    }
}
