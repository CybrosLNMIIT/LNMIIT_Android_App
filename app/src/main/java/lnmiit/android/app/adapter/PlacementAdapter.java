package lnmiit.android.app.adapter;

/**
 * Created by hp on 12-Nov-16.
 */
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.util.List;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import lnmiit.android.app.R;
import lnmiit.android.app.model.ContactDetails;
import lnmiit.android.app.model.FacultyDetails;


public class PlacementAdapter extends RecyclerView.Adapter<PlacementAdapter.MyViewHolder> {

    private Context mContext;
    private List<ContactDetails> contactList;

    public PlacementAdapter(Context mContext, List<ContactDetails> contactList) {
        this.mContext = mContext;
        this.contactList = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_card, parent, false);

        return new MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, name, number, email;
        private ImageView imageViewContact;

        public MyViewHolder(View view) {
            super(view);
            imageViewContact = (ImageView) view.findViewById(R.id.imageViewContact1);
            title = (TextView) view.findViewById(R.id.title1);
            name = (TextView) view.findViewById(R.id.name1);
            number = (TextView) view.findViewById(R.id.number1);
            email = (TextView) view.findViewById(R.id.email1);


        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final ContactDetails contact = contactList.get(position);

        holder.title.setText(contact.getTitle());
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getPhone());
        holder.email.setText(contact.getEmail());


        //remove it



        /*
         *   loading faculty pictures
         *   making them cirular
         *   using Glide library
         */
//        Glide.with(mContext).load(faculty.getUrl()).placeholder(R.drawable.ic_person).into(holder.thumbnail);

        try {
            Glide.with(mContext).load(contact.getUrl()).placeholder(R.drawable.ic_person).into(holder.imageViewContact);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    /**
     * This method will return boolean value
     * depending on email packages availbale
     * on the device
     * @param context
     * @return
     */


}