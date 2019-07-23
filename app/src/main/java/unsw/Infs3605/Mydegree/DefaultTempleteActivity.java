package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;

public class DefaultTempleteActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_templete);
        appBarTxt.setText("Default Templete");
    }

    @Override public void onBackPressed() {
        startActivity(new Intent(DefaultTempleteActivity.this, HomepageActivity.class));
        finish();
    }
}
