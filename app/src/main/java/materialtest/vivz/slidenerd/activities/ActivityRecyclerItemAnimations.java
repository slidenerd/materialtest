package materialtest.vivz.slidenerd.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import materialtest.vivz.slidenerd.adapters.AdapterRecyclerItemAnimations;
import materialtest.vivz.slidenerd.materialtest.R;

public class ActivityRecyclerItemAnimations extends ActionBarActivity {

    private EditText mInput;
    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private AdapterRecyclerItemAnimations mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_item_animations);
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mInput = (EditText) findViewById(R.id.text_input);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerAnimatedItems);
        mAdapter = new AdapterRecyclerItemAnimations(this);
        FlipInTopXAnimator animator = new FlipInTopXAnimator();
        animator.setAddDuration(2000);
        animator.setRemoveDuration(2000);
        mRecyclerView.setItemAnimator(animator);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public void addItem(View view) {
        if (mInput.getText() != null) {
            String text = mInput.getText().toString();
            if (text != null && text.trim().length() > 0) {
                mAdapter.addItem(mInput.getText().toString());
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_recycler_item_animations, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (android.R.id.home == id) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}
