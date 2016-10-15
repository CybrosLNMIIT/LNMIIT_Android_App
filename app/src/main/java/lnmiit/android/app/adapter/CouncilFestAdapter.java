package lnmiit.android.app.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import lnmiit.android.app.R;
import lnmiit.android.app.model.CouncilFestDetail;

/**
 * Created by Chanpreet on 20-09-2016.
 */
public class CouncilFestAdapter extends RecyclerView.Adapter<CouncilFestAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CouncilFestDetail> list = new ArrayList();

    public CouncilFestAdapter(Context context1, ArrayList<CouncilFestDetail> list1) {
        context = context1;
        list = list1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_council_fest, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CouncilFestDetail detail = list.get(position);
        holder.text1.setText(detail.getTitle());
        holder.text2.setText(detail.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text1;
        private TextView text2;

        ViewHolder(View view) {
            super(view);
            text1 = (TextView) view.findViewById(R.id.tv1);
            text2 = (TextView) view.findViewById(R.id.tv2);
        }
    }
}
