package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomepageActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        appBarTxt.setText("Home");

        ImageButton buttonlearn = findViewById(R.id.learn_btn);
        ImageButton buttonmgmt = findViewById(R.id.mg_btn);
        ImageButton buttoncourses = findViewById(R.id.course_btn);
        ImageButton buttontemplete = findViewById(R.id.df_btn);



        buttonlearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        buttonmgmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ManageFragment()).commit();


                Intent intent = new Intent(HomepageActivity.this, ManagementActivity.class);
                startActivity(intent);
            }
        });
//
//        buttoncourses.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(HomeActivity.this, QuizSelectionActivity.class);
//                    startActivity(intent);
//                }
//        });

        buttontemplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, DefaultTempleteActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override public void onBackPressed() {
        startActivity(new Intent(HomepageActivity.this, HomepageActivity.class));
        finish();
    }
}
