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

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    private Context context;
    private List<Item> itemList;
    private OnItemClickListener listener;

    public FeedListAdapter(Context context, List<Item> itemList, OnItemClickListener listener) {
        this.context = context;
        this.itemList = itemList;
        this.listener = listener;
    }

    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_feed_item, parent, false);

        FeedItemViewHolder feedItemViewHolder = new FeedItemViewHolder(view);

        return feedItemViewHolder;
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {

        Item item = itemList.get(position);
        System.out.println(item);
        Picasso.with(context).load(item.getThumbnail().getUrl())
                .resizeDimen(R.dimen.thumbnail_size, R.dimen.thumbnail_size)
                .into(holder.ivThumbnail);
        holder.tvTitle.setText(item.getTitle());
        holder.bind(itemList.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
