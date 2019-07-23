package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends MainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        appBarTxt.setText("Learn");

        Button buttonContent = findViewById(R.id.learn_btn);
        Button buttonVideos = findViewById(R.id.videos_btn);
        Button buttonQuiz = findViewById(R.id.quiz_btn);


        buttonContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        buttonVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });

        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, QuizSelectionActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override public void onBackPressed() {
        startActivity(new Intent(HomeActivity.this, HomepageActivity.class));
        finish();
    }




}
