package com.getxinfo.app.sync;

import android.content.Context;

import com.getxinfo.app.io.JSONHandler;
import com.getxinfo.app.io.RoomsHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.getxinfo.app.util.LogUtils.LOGD;
import static com.getxinfo.app.util.LogUtils.makeLogTag;

/**
 * Created by pgy on 2016/4/27.
 */
public class ConferenceDataHandler {

    private static final String TAG = makeLogTag(ConferenceDataHandler.class);

    private static final String DATA_KEY_ROOMS = "rooms";

    Context mContext = null;

    // Handlers for each entity type:
    RoomsHandler mRoomsHandler = null;

    // Convenience map that maps the key name to its corresponding handler (e.g.
    // "blocks" to mBlocksHandler (to avoid very tedious if-elses)
    Map<String, JSONHandler> mHandlerForKey = new HashMap<>();

    public ConferenceDataHandler(Context ctx) { mContext = ctx; }

    /**
     * Parses the conference data in the given objects and imports the data into the
     * content provider. The format of the data is documented at https://code.google.com/p/iosched.
     *
     * @param dataBodies The collection of JSON objects to parse and import.
     * @param dataTimestamp The timestamp of the data. This should be in RFC1123 format.
     * @param downloadsAllowed Whether or not we are supposed to download data from the internet if needed.
     * @throws IOException If there is a problem parsing the data.
     */
    public void applyConferenceData(String[] dataBodies, String dataTimestamp, boolean downloadsAllowed) throws IOException{
        LOGD(TAG, "Applying data from " + dataBodies.length + " files, timestamp " + dataTimestamp);

        // create handlers for each data type
        mHandlerForKey.put(DATA_KEY_ROOMS, mRoomsHandler = new RoomsHandler(mContext));
    }

}
