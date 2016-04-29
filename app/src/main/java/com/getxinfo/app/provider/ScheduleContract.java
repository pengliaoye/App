package com.getxinfo.app.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by pgy on 2016/4/27.
 */
public final class ScheduleContract {

    interface RoomsColumns {

        /** Unique string identifying this room. */
        String ROOM_ID = "room_id";
        /** Name describing this room. */
        String ROOM_NAME = "room_name";
        /** Building floor this room exists on. */
        String ROOM_FLOOR = "room_floor";
    }

    public static final String CONTENT_AUTHORITY = "com.getxinfo.app";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private static final String PATH_ROOM = "room";

    private static  final String PATH_ROOMS = "rooms";

    public static class Rooms implements RoomsColumns, BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_ROOMS).build();

    }

}
