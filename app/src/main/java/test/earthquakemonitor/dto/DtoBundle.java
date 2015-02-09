package test.earthquakemonitor.dto;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luisangelgarcia on 06/02/15.
 */
public class DtoBundle implements Parcelable {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private String title;
    private float mag;
    private long time;
    private long updated;
    private String place;
    private double lat;
    private double lon;
    private double depth;
    // ===========================================================
    // Constructors
    // ===========================================================
    public DtoBundle(Parcel parcel) {
        title = parcel.readString();
        mag = parcel.readFloat();
        time = parcel.readLong();
        updated = parcel.readLong();
        place = parcel.readString();
        lat = parcel.readDouble();
        lon = parcel.readDouble();
        depth = parcel.readDouble();
    }
    public DtoBundle(String title, float mag, long time, long updated, String place, double lat, double lon, double depth) {
        this.title = title;
        this.mag = mag;
        this.time = time;
        this.updated = updated;
        this.place = place;
        this.lat = lat;
        this.lon = lon;
        this.depth = depth;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public String getTitle() {
        return title;
    }

    public float getMag() {
        return mag;
    }

    public long getTime() {
        return time;
    }

    public long getUpdated() {
        return updated;
    }

    public String getPlace() { return place; }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getDepth() {
        return depth;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeFloat(mag);
        dest.writeLong(time);
        dest.writeLong(updated);
        dest.writeString(place);
        dest.writeDouble(lat);
        dest.writeDouble(lon);
        dest.writeDouble(depth);
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nMag: " + mag + "\nTime: " + time + "\nUpdate: " + updated +
                "\nPlace: " + place + "\nLat: " + lat + "\nLon: " + lon + "\nDepth: " + depth;
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
    public static final Creator<DtoBundle> CREATOR = new Creator<DtoBundle>() {
        @Override
        public DtoBundle createFromParcel(Parcel source) {
            return new DtoBundle(source);
        }

        @Override
        public DtoBundle[] newArray(int size) {
            return new DtoBundle[0];
        }
    };
}
