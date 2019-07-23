package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ManagementActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage1page);
        appBarTxt.setText("Manage");

        Button buttonY1 = findViewById(R.id.button);
        Button buttonY2 = findViewById(R.id.button2);
        Button buttonY3 = findViewById(R.id.button3);



        buttonY1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementActivity.this, year1_mgmtActivity.class);
                startActivity(intent);
            }
        });

        buttonY2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CourseDatabaseHelper dbHelper = new CourseDatabaseHelper(ManagementActivity.this);
                int remainingCore = dbHelper.getRemainingCoreCourses();
                int remainingBC = dbHelper.getRemainingBusCoreCourses();
                int remainingFElective = dbHelper.getRemainingFECourses();
                int remainingPE = dbHelper.getRemainingPECourses();
                int remainingGen = dbHelper.getRemainingGECourses();
                int total = remainingCore + remainingFElective + remainingGen + remainingBC + remainingPE;

                if (total <= 15) {
                    Intent intent = new Intent(ManagementActivity.this, year2_mgmtActivity.class);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(ManagementActivity.this, "This stage is locked. Please complete your Year 1 enrolment."+"remaining course: "+total, Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonY3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CourseDatabaseHelper dbHelper = new CourseDatabaseHelper(ManagementActivity.this);
                int remainingCore = dbHelper.getRemainingCoreCourses();
                int remainingBC = dbHelper.getRemainingBusCoreCourses();
                int remainingFElective = dbHelper.getRemainingFECourses();
                int remainingPE = dbHelper.getRemainingPECourses();
                int remainingGen = dbHelper.getRemainingGECourses();
                int total = remainingCore + remainingFElective + remainingGen + remainingBC + remainingPE;

                if (total <= 6) {
                    Intent intent = new Intent(ManagementActivity.this, year3_mgmtActivity.class);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(ManagementActivity.this, "This stage is locked. Please complete your Year 1 enrolment."+"remaining course: "+total, Toast.LENGTH_SHORT).show();
                }

            }
        });
//
//        buttonQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, QuizSelectionActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    @Override public void onBackPressed() {
        startActivity(new Intent(ManagementActivity.this, HomepageActivity.class));
        finish();
    }
}
