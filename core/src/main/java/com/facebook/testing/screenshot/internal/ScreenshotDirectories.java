/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook.testing.screenshot.internal;

import android.content.Context;

import java.io.File;

/** Provides a directory for an Album to store its screenshots in. */
class ScreenshotDirectories {
  private final Context mContext;

  public ScreenshotDirectories(Context context) {
    mContext = context;
  }

  public File get(String type) {
    File dir = new File(new File(mContext.getFilesDir(), "screenshots"), type);
    dir.mkdirs();

    if (!dir.exists()) {
      throw new RuntimeException(
          "Failed to create the directory "
              + dir.getAbsolutePath()
              + " for screenshots.");
    }

    return dir;
  }
}
