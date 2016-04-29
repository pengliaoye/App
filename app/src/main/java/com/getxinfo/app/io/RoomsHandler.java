package com.getxinfo.app.io;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.net.Uri;

import com.getxinfo.app.io.model.Room;
import com.getxinfo.app.provider.ScheduleContract;
import com.getxinfo.app.provider.ScheduleContractHelper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.getxinfo.app.util.LogUtils.makeLogTag;

/**
 * Created by pgy on 2016/4/27.
 */
public class RoomsHandler extends JSONHandler {

    private static final String TAG = makeLogTag(RoomsHandler.class);

    // map from room ID to Room model object
    private Map<String, Room> mRooms = new HashMap<>();

    public RoomsHandler(Context context) {
        super(context);
    }

    @Override
    public void makeContentProviderOperations(List<ContentProviderOperation> list) {
        Uri uri = ScheduleContractHelper.setUriAsCalledFromSyncAdapter(ScheduleContract.Rooms.CONTENT_URI);
        // The list of rooms is not large, so for simplicity we delete all of them and repopulate
        list.add(ContentProviderOperation.newDelete(uri).build());
        for (Room room : mRooms.values()) {
            ContentProviderOperation.Builder builder = ContentProviderOperation.newInsert(uri);
            builder.withValue(ScheduleContract.Rooms.ROOM_ID, room.id);
            builder.withValue(ScheduleContract.Rooms.ROOM_NAME, room.name);
            builder.withValue(ScheduleContract.Rooms.ROOM_FLOOR, room.floor);
            list.add(builder.build());
        }
    }

    @Override
    public void process(JsonElement element) {
        for (Room room : new Gson().fromJson(element, Room[].class)) {
            mRooms.put(room.id, room);
        }
    }

}
