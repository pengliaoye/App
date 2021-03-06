package com.getxinfo.app.io;

import android.content.ContentProviderOperation;
import android.content.Context;

import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

/**
 * Created by pgy on 2016/4/26.
 */
public abstract class JSONHandler {

    protected  static  Context mContext;

    public JSONHandler(Context context) { mContext = context; }

    public abstract void makeContentProviderOperations(List<ContentProviderOperation> list);

    public abstract void process(JsonElement element);

    public static String parseResource(Context context, int resource) throws IOException {
        InputStream is = context.getResources().openRawResource(resource);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
            is.close();
        }

        return writer.toString();
    }

}
