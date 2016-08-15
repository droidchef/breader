package in.ishankhanna.breader.ui.android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.ishankhanna.breader.R;
import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.presenters.main.StoryDetailPresenter;
import in.ishankhanna.breader.ui.views.main.StoryDetailMvpView;

/**
 * @author Ishan Khanna
 */
public class StoryDetailFragment extends Fragment implements StoryDetailMvpView {

    public static final String KEY_ITEM = "KEY_ITEM";

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.iv_story_image)
    ImageView ivStoryImage;

    private StoryDetailPresenter storyDetailPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            throw new RuntimeException("Bundle with Item Required!");
        } else {
            final Item item = getArguments().getParcelable(StoryDetailFragment.KEY_ITEM);
            if (item != null) {
                storyDetailPresenter = new StoryDetailPresenter(getContext(), item);
            } else {
                throw new RuntimeException("Item was null!");
            }
        }
    }

    public static StoryDetailFragment newInstance(Item item) {

        StoryDetailFragment storyDetailFragment = new StoryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(KEY_ITEM, item);
        storyDetailFragment.setArguments(args);
        return storyDetailFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_story_detail, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        storyDetailPresenter.attachView(this);
        storyDetailPresenter.presentStory();
    }

    @Override
    public void onPause() {
        storyDetailPresenter.detachView();
        super.onPause();
    }

    @Override
    public void showDetailedStory(Item item) {
        tvTitle.setText(item.getTitle());
        tvDescription.setText(item.getDescription());
        Picasso.with(getContext()).load(item.getThumbnail().getUrl())
                .into(ivStoryImage);
    }
}
