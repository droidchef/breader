package in.ishankhanna.breader.ui.android.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.ishankhanna.breader.R;
import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.ui.android.viewholders.FeedItemViewHolder;

/**
 * @author Ishan Khanna
 */
public class FeedListAdapter extends RecyclerView.Adapter<FeedItemViewHolder> {

    private Context context;
    private List<Item> itemList;

    public FeedListAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feed_item, null);

        FeedItemViewHolder feedItemViewHolder = new FeedItemViewHolder(view);

        return feedItemViewHolder;
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {

        Item item = itemList.get(position);
        System.out.println(item);
        Picasso.with(context).load(item.getThumbnail().getUrl())
                .into(holder.ivThumbnail);
        holder.tvTitle.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
