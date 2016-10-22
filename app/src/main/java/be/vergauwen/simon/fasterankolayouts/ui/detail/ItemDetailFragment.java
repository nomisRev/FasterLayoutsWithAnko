package be.vergauwen.simon.fasterankolayouts.ui.detail;


import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import be.vergauwen.simon.fasterankolayouts.R;
import be.vergauwen.simon.fasterankolayouts.dummy.DummyContent;


public class ItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private DummyContent.DummyItem mItem;
    TextView textView;
    private DetailFragmentLayout detailFragmentLayout = new DetailFragmentLayout();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            //Do something like this with DI
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = detailFragmentLayout.bind(this);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            textView.setText(mItem.details);
        }

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        detailFragmentLayout.unbind(this);
    }
}
