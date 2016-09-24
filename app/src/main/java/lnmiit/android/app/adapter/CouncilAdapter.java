package lnmiit.android.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lnmiit.android.app.R;

/**
 * Created by Chanpreet on 20-09-2016.
 */
public class CouncilAdapter extends RecyclerView.Adapter<CouncilAdapter.ViewHolder> {
    private Context context;
    private String councilName[];
    private String councilDesscription[];

    public CouncilAdapter(Context context1) {
        context = context1;
        getStringArray();
    }

    /**
     * function for getting the strings
     */
    private void getStringArray() {
        councilName = context.getResources().getStringArray(R.array.council);
        councilDesscription = context.getResources().getStringArray(R.array.description);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_counci_festl, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text1.setText(councilName[position]);
        holder.text2.setText(councilDesscription[position]);
    }

    @Override
    public int getItemCount() {
        return councilName.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text1;
        private TextView text2;

        ViewHolder(View view) {
            super(view);
            text1 = (TextView) view.findViewById(R.id.council_name);
            text2 = (TextView) view.findViewById(R.id.council_content);
        }
    }
}
