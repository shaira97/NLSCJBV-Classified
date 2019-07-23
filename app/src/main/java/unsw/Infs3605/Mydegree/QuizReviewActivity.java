package unsw.Infs3605.Mydegree;

import android.os.Bundle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import unsw.Infs3605.Mydegree.R;

public class QuizReviewActivity extends MainActivity {

    private QuizViewModel mQuizViewModel;

    int correctCount;
    int questionCount;
    int topic;
    boolean[] correctArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_review);

        appBarTxt.setText("Avo's Explanation");

        Intent intent = getIntent();
        correctCount = intent.getIntExtra("KEYCORRECT", 0);
        questionCount = intent.getIntExtra("KEYTOTAL", 0);
        topic = intent.getIntExtra("TOPIC_REVIEW", -1);
        correctArray = intent.getBooleanArrayExtra("KEYCORRECTARRAY");


        RecyclerView recyclerView = findViewById(R.id.recyclerview_review);
        final QuizReviewAdapter adapter = new QuizReviewAdapter(this, correctArray);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        mQuizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);



        mQuizViewModel.getAllQuiz(topic).observe(this, new Observer<List<Quiz>>() {
            @Override
            public void onChanged(@Nullable final List<Quiz> quiz) {
                adapter.setQuiz(quiz);
            }
        });
    }

    @Override public void onBackPressed() {
        Intent intent = new Intent(QuizReviewActivity.this, QuizResultsActivity.class);
        intent.putExtra("KEYCORRECT", correctCount);
        intent.putExtra("KEYTOTAL", questionCount);
        intent.putExtra("TOPIC_REVIEW", topic);
        intent.putExtra("KEYCORRECTARRAY", correctArray);
        startActivity(intent);
        finish();
    }

}



