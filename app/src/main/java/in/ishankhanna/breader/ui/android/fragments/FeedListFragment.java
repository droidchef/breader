package in.ishankhanna.breader.ui.android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.ishankhanna.UberProgressView;
import in.ishankhanna.breader.R;
import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.presenters.main.FeedListPresenter;
import in.ishankhanna.breader.ui.android.adapters.FeedListAdapter;
import in.ishankhanna.breader.ui.views.main.FeedListMvpView;

/**
 * @author Ishan Khanna
 */
public class FeedListFragment extends Fragment implements FeedListMvpView,
        FeedListAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view_feed_list)
    RecyclerView recyclerViewFeedList;

    @BindView(R.id.progress_view)
    UberProgressView uberProgressView;

    private FeedListPresenter feedListPresenter;

    private FeedListAdapter feedListAdapter;

    public static FeedListFragment newInstance() {

        FeedListFragment feedListFragment = new FeedListFragment();
        Bundle dataToBePassedToTheFragment = new Bundle();
        feedListFragment.setArguments(dataToBePassedToTheFragment);
        return feedListFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feedListPresenter = new FeedListPresenter(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_feed_list, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        feedListPresenter.attachView(this);
        feedListPresenter.showFeed();
    }

    @Override
    public void onPause() {
        feedListPresenter.detachView();
        super.onPause();
    }

    @Override
    public void showProgress() {
        uberProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        uberProgressView.setVisibility(View.GONE);
    }

    @Override
    public void addItemsToRecyclerViewAdapter(List<Item> items) {

        recyclerViewFeedList.setLayoutManager(new LinearLayoutManager(getContext()));
        feedListAdapter = new FeedListAdapter(getContext(), items, this);
        recyclerViewFeedList.setAdapter(feedListAdapter);

    }

    @Override
    public void showRecyclerView() {
        recyclerViewFeedList.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRecyclerView() {
        recyclerViewFeedList.setVisibility(View.GONE);
    }

    @Override
    public void onItemClick(Item item) {
        feedListPresenter.requestDetailedStory(item);
    }
}
