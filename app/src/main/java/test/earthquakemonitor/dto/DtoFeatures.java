package test.earthquakemonitor.dto;

/**
 * Created by luisangelgarcia on 05/02/15.
 */
public class DtoFeatures {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private String type;
    private DtoProperties properties;
    private DtoGeometry geometry;
    private String id;

    // ===========================================================
    // Constructors
    // ===========================================================

    public DtoFeatures() {
    }

    public DtoFeatures(String type, DtoProperties properties, DtoGeometry geometry, String id) {
        this.type = type;
        this.properties = properties;
        this.geometry = geometry;
        this.id = id;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DtoProperties getProperties() {
        return properties;
    }

    public void setProperties(DtoProperties properties) {
        this.properties = properties;
    }

    public DtoGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(DtoGeometry geometry) {
        this.geometry = geometry;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public String toString() {
        return "- {\n" +
                "type: " + type + ",\n" +
                properties.toString() + "\n" +
                geometry.toString() + "\n" +
                "id: " + id + "\n" +
                "}";
    }
    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
