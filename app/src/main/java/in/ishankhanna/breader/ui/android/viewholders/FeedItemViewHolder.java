package in.ishankhanna.breader.ui.android.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.ishankhanna.breader.R;

/**
 * @author Ishan Khanna
 */
public class FeedItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_story_thumbnail)
    public ImageView ivThumbnail;
    @BindView(R.id.tv_story_title)
    public TextView tvTitle;

    public FeedItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
