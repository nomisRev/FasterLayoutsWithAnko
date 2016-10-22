package be.vergauwen.simon.fasterankolayouts.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import org.jetbrains.annotations.NotNull;

import be.vergauwen.simon.fasterankolayouts.R;
import be.vergauwen.simon.fasterankolayouts.ui.adapter.SimpleItemRecyclerViewAdapter;
import be.vergauwen.simon.fasterankolayouts.ui.detail.DetailActivity;
import be.vergauwen.simon.fasterankolayouts.ui.detail.ItemDetailFragment;
import be.vergauwen.simon.fasterankolayouts.ui.util.OnItemClickListener;
import be.vergauwen.simon.fasterankolayouts.ui.util.RecyclerViewExtKt;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    RecyclerView recycView;
    FrameLayout detailContainer;

    private MainLayout mainLayout = new MainLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mainLayout.bind(this));

        RecyclerViewExtKt.addItemClickListener(recycView, new OnItemClickListener() {
            @Override
            public void onItemClick(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
                if (detailContainer != null) {
                    Bundle arguments = new Bundle();
                    arguments.putString(ItemDetailFragment.ARG_ITEM_ID, ((SimpleItemRecyclerViewAdapter.ViewHolder) viewHolder).mItem.id);
                    ItemDetailFragment fragment = new ItemDetailFragment();
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction().replace(R.id.item_detail_container, fragment).commit();
                } else {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, ((SimpleItemRecyclerViewAdapter.ViewHolder) viewHolder).mItem.id);
                    startActivity(intent);
                }
            }
        });
    }


}
