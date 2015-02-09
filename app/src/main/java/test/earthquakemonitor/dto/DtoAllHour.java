package test.earthquakemonitor.dto;

/**
 * Created by luisangelgarcia on 05/02/15.
 */
public class DtoAllHour {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private String type;
    private DtoMetadata metadata;
    private DtoFeatures[] features;
    private double[] bbox;
    // ===========================================================
    // Constructors
    // ===========================================================
    public DtoAllHour() {

    }
    public DtoAllHour(String type, DtoMetadata metadata, DtoFeatures[] features, double[] bbox) {
        this.type = type;
        this.metadata = metadata;
        this.features = features;
        this.bbox = bbox;
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

    public DtoMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(DtoMetadata metadata) {
        this.metadata = metadata;
    }

    public DtoFeatures[] getFeatures() {
        return features;
    }

    public void setFeatures(DtoFeatures[] features) {
        this.features = features;
    }

    public double[] getBbox() {
        return bbox;
    }

    public void setBbox(double[] bbox) {
        this.bbox = bbox;
    }
    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public String toString() {
        String fea = "";
        for(int i = 0; i < features.length; i++) {
            if(i < features.length - 1) {
                fea += features[i].toString() + ",\n";
            } else {
                fea += features[i].toString() + "\n";
            }
        }
        String bbx = "";
        for(int i = 0; i < bbox.length; i++) {
            if(i < bbox.length - 1) {
                bbx += bbox[i] + ",\n";
            } else {
                bbx += bbox[i] + "\n";
            }
        }

        return "{" + "\n" +
                "type: " + type + ",\n" +
                this.metadata.toString() + "\n" +
                "- features: [" + "\n" +
                fea + "\n" +
                "]," + "\n" +
                "- bbox: [" + "\n" +
                bbx + "\n" +
                "]" + "\n" +
                "}";
    }
    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
