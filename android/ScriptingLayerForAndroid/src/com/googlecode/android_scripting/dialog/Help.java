/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.googlecode.android_scripting.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import com.googlecode.android_scripting.R;

public class Help {
  private Help() {
    // Utility class.
  }

  public static void show(final Activity activity) {
    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
    builder.setItems(new CharSequence[] { "Wiki Documentation", "YouTube Screencasts" },
        new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            if (which == 0) {
              intent.setData(Uri.parse(activity.getString(R.string.wiki_url)));
            } else {
              intent.setData(Uri.parse(activity.getString(R.string.youtube_url)));
            }
            activity.startActivity(intent);
          }
        });
    builder.show();
  }
}