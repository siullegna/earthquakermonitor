package test.earthquakemonitor.dto;

/**
 * Created by luisangelgarcia on 05/02/15.
 */
public class DtoProperties {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private float mag;
    private String place;
    private long time;
    private long updated;
    private int tz;
    private String url;
    private String detail;

    private Object felt;
    private Object cdi;
    private Object mmi;
    private Object alert;

    private String status;
    private int tsunami;
    private int sig;
    private String net;
    private String code;
    private String ids;
    private String sources;
    private String types;
    private int nst;
    private float dmin;
    private float rms;
    private int gap;
    private String magType;
    private String type;
    private String title;
    // ===========================================================
    // Constructors
    // ===========================================================

    public DtoProperties() {
    }

    public DtoProperties(float mag, String place, long time, long updated, int tz, String url,
                         String detail, Object felt, Object cdi, Object mmi, Object alert, String status,
                         int tsunami, int sig, String net, String code, String ids, String sources, String types,
                         int nst, float dmin, float rms, int gap, String magType, String type, String title) {
        this.mag = mag;
        this.place = place;
        this.time = time;
        this.updated = updated;
        this.tz = tz;
        this.url = url;
        this.detail = detail;
        this.felt = felt;
        this.cdi = cdi;
        this.mmi = mmi;
        this.alert = alert;
        this.status = status;
        this.tsunami = tsunami;
        this.sig = sig;
        this.net = net;
        this.code = code;
        this.ids = ids;
        this.sources = sources;
        this.types = types;
        this.nst = nst;
        this.dmin = dmin;
        this.rms = rms;
        this.gap = gap;
        this.magType = magType;
        this.type = type;
        this.title = title;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public float getMag() {
        return mag;
    }

    public void setMag(float mag) {
        this.mag = mag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public int getTz() {
        return tz;
    }

    public void setTz(int tz) {
        this.tz = tz;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Object getFelt() {
        return felt;
    }

    public void setFelt(Object felt) {
        this.felt = felt;
    }

    public Object getCdi() {
        return cdi;
    }

    public void setCdi(Object cdi) {
        this.cdi = cdi;
    }

    public Object getMmi() {
        return mmi;
    }

    public void setMmi(Object mmi) {
        this.mmi = mmi;
    }

    public Object getAlert() {
        return alert;
    }

    public void setAlert(Object alert) {
        this.alert = alert;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTsunami() {
        return tsunami;
    }

    public void setTsunami(int tsunami) {
        this.tsunami = tsunami;
    }

    public int getSig() {
        return sig;
    }

    public void setSig(int sig) {
        this.sig = sig;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getNst() {
        return nst;
    }

    public void setNst(int nst) {
        this.nst = nst;
    }

    public float getDmin() {
        return dmin;
    }

    public void setDmin(float dmin) {
        this.dmin = dmin;
    }

    public float getRms() {
        return rms;
    }

    public void setRms(float rms) {
        this.rms = rms;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public String getMagType() {
        return magType;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public String toString() {
        return "- properties: {\n" +
                "mag: " + mag + ",\n" +
                "place: " + place + ",\n" +
                "time: " + time + ",\n" +
                "updated: " + updated + ",\n" +
                "tz: " + tz + ",\n" +
                "url: " + url + ",\n" +
                "detail: " + detail + ",\n" +
                "felt: " + felt + ",\n" +
                "cdi: " + cdi + ",\n" +
                "mmi: " + mmi + ",\n" +
                "alert: " + alert + ",\n" +
                "status: " + status + ",\n" +
                "tsunami: " + tsunami + ",\n" +
                "sig: " + sig + ",\n" +
                "net: " + net + ",\n" +
                "code: " + code + ",\n" +
                "ids: " + ids + ",\n" +
                "sources: " + sources + ",\n" +
                "types: " + types + ",\n" +
                "nst: " + nst + ",\n" +
                "dmin: " + dmin + ",\n" +
                "rms: " + rms + ",\n" +
                "gap: " + gap + ",\n" +
                "magType: " + magType + ",\n" +
                "type: " + type + ",\n" +
                "title: " + title + "\n" +
                "},";
    }
    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
