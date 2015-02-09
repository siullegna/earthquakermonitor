package test.earthquakemonitor.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import test.earthquakemonitor.R;
import test.earthquakemonitor.dto.DtoFeatures;
import test.earthquakemonitor.holder.HolderQuake;

/**
 * Created by luisangelgarcia on 06/02/15.
 */
public class AdapterQuake extends ArrayAdapter<DtoFeatures> {
    // ===========================================================
    // Constants
    // ===========================================================
    private final int layout;
    // ===========================================================
    // Fields
    // ===========================================================
    private Context context;
    private View view;
    // ===========================================================
    // Constructors
    // ===========================================================
    public AdapterQuake(Context context, ArrayList<DtoFeatures> items) {
        super(context, -1, items);
        this.layout = R.layout.row_magnitude;
        this.context = context;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        view = convertView;
        HolderQuake holderQuake = null;
        LinearLayout ll_row = null;
        if(view == null) {
            view = LayoutInflater.from(this.context).inflate(this.layout, parent, false);
            TextView txtPlace = (TextView) view.findViewById(R.id.txt_place);
            TextView txtMagnitude = (TextView) view.findViewById(R.id.txt_magnitude);
            holderQuake = new HolderQuake(txtPlace, txtMagnitude);
            ll_row = (LinearLayout) view.findViewById(R.id.ll_row);
            view.setTag(holderQuake);
        }
        if(view != null && holderQuake == null) {
            Object obj = view.getTag();
            if(obj instanceof HolderQuake) {
                holderQuake = (HolderQuake) obj;
            }
        }
        DtoFeatures dtoFeatures = getItem(position);
        if(holderQuake.txtPlace != null) {
            holderQuake.txtPlace.setText(dtoFeatures.getProperties().getPlace());
        }
        if(holderQuake.txtMagnitude != null) {
            holderQuake.txtMagnitude.setText(String.valueOf(dtoFeatures.getProperties().getMag()));
        }
        if(ll_row != null) {
            try {
                ll_row.setBackground(getSelector(dtoFeatures.getProperties().getMag()));
            } catch(NullPointerException e) {

            } catch(Exception e) {

            }
        }
        return view;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private Drawable getSelector(float magnitude) {
        if(magnitude >= 0.0f && magnitude < 1.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_00_09);
        } else if(magnitude >= 1.0f && magnitude < 2.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_10_19);
        } else if(magnitude >= 2.0f && magnitude < 3.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_20_29);
        } else if(magnitude >= 3.0f && magnitude < 4.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_30_39);
        } else if(magnitude >= 4.0f && magnitude < 5.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_40_49);
        } else if(magnitude >= 5.0f && magnitude < 6.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_50_59);
        } else if(magnitude >= 6.0f && magnitude < 7.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_60_69);
        } else if(magnitude >= 7.0f && magnitude < 8.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_70_79);
        } else if(magnitude >= 8.0f && magnitude < 9.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_80_89);
        } else if(magnitude >= 9.0f && magnitude < 10.0f) {
            return getContext().getResources().getDrawable(R.drawable.selector_90_99);
        }
        return null;
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
