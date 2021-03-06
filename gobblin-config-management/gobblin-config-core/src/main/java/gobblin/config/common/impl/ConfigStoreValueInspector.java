/*
 * Copyright (C) 2015 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the
 * License at  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied.
 */

package gobblin.config.common.impl;

import com.typesafe.config.Config;

import gobblin.config.store.api.ConfigKeyPath;

/**
 * The ConfigStoreValueInspector interface used to inspect the {@link com.typesafe.config.Config} for a given
 * {@link gobblin.config.store.api.ConfigKeyPath} in {@link ConfigStore}
 * 
 * @author mitu
 *
 */

public interface ConfigStoreValueInspector {

  /**
   * Obtains the configuration properties directly associated with a given config keys. These <b>
   * will not</b> include any properties/values which can be obtained from the ancestors or imported
   * config keys.
   *
   * @param  configKey      the config key path whose properties are needed.
   * @return the directly specified configuration in {@link Config} format for input configKey
   */
  public Config getOwnConfig(ConfigKeyPath configKey);
  
  /**
   * Obtains a {@link Config} object with all implicit and explicit imports resolved, i.e. specified
   * using the {@link Config#withFallback(com.typesafe.config.ConfigMergeable)} API.
   *
   * @param  configKey       the path of the configuration key to be resolved
   * @return the {@link Config} object associated with the specified config key with all direct
   *         and indirect imports resolved.
   */
  public Config getResolvedConfig(ConfigKeyPath configKey);
}
