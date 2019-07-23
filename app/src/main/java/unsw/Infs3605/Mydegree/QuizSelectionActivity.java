package unsw.Infs3605.Mydegree;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;

public class QuizSelectionActivity extends MainActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes_list);

        appBarTxt.setText("Avo's Green Quizzes");

        final String[] topicHeadingLevelOneArray = {
                "Quiz 1: The Truth about Metabolism",
                "Quiz 2: Exercise, Heart and Blood",
                "Quiz 3: Know about Your Muscle",
                "Quiz 4: Fitness and Diet",
                "Quiz 5: Fitness Dos and Don'ts I",
                "Quiz 6: Fitness Dos and Don'ts II",
                "Quiz 7: Fitness Dos and Don'ts III",
                "Quiz 8: Do You Know The Benefits of Walking?",

        };

        final String[] topicHeadingLevelTwoArray = {
                "5 Questions --> ",
                "5 Questions --> ",
                "5 Questions --> ",
                "5 Questions --> ",
                "5 Questions --> ",
                "5 Questions --> ",
                "5 Questions --> ",
                "5 Questions --> ",

        };

        QuizSelectionAdapter newQuizSelectionAdapter = new QuizSelectionAdapter(this, topicHeadingLevelOneArray, topicHeadingLevelTwoArray);
        listView = (ListView) findViewById(R.id.quizzes_list);
        listView.setAdapter(newQuizSelectionAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QuizSelectionActivity.this, QuizTestActivity.class);
                intent.putExtra("TOPIC_TEST", (position + 1));
                startActivity(intent);

            }
        });

    }
}