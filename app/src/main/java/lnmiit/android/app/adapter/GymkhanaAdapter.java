package lnmiit.android.app.adapter;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import lnmiit.android.app.R;
/**
 * Created by Chanpreet on 20/9/16.
 */
public class GymkhanaAdapter extends RecyclerView.Adapter<GymkhanaAdapter.viewholder>  {

    private Context context;
    private String name[];
    private String designation[];
    private String imageLink[];
    private String email[];
    private String phone[];

   public GymkhanaAdapter(Context context1)
    {
        context =context1;
        getStringArray();
    }

    /**
     * function for getting the strings
     */
    private  void getStringArray()
    {
        name= context.getResources().getStringArray(R.array.name);
        designation= context.getResources().getStringArray(R.array.designation);
        imageLink = context.getResources().getStringArray(R.array.links);
        email = context.getResources().getStringArray(R.array.email);
        phone = context.getResources().getStringArray(R.array.phone);
    }
    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout_gymkhana,parent,false);
        viewholder viewholder = new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(viewholder holder, final int position) {
        holder.name.setText(name[position]);
        holder.designation.setText(designation[position]);
        Glide.with(context).load(imageLink[position]).into(holder.image);
        holder.mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { email[position]});
                context.startActivity(emailIntent);
            }
        }
        );
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:"+phone[position]));
                context.startActivity(phoneIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    protected class viewholder extends RecyclerView.ViewHolder{
        private TextView name ;
        private TextView designation;
        private ImageView image;
        private Button mail;
        private Button phone;

        viewholder(View view)
        {
            super(view);
            image=(ImageView) view.findViewById(R.id.gymkhana_image);
            phone =(Button) view.findViewById(R.id.phone);
            mail = (Button) view.findViewById(R.id.mail);
            name = (TextView) view.findViewById(R.id.name);
            designation = (TextView) view.findViewById(R.id.designation);
        }
    }
}
