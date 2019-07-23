package unsw.Infs3605.Mydegree;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;


public class QuizTestActivity extends MainActivity {

    private QuizViewModel mQuizViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
        Intent intent = getIntent();
        final int topic = intent.getIntExtra("TOPIC_TEST", -1);
        appBarTxt.setText("Avo's Green Quiz");
        RecyclerView recyclerView = findViewById(R.id.recyclerview_quiz);
        final QuizTestAdapter adapter = new QuizTestAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mQuizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
        mQuizViewModel.getAllQuiz(topic).observe(this, new Observer<List<Quiz>>() {
            @Override
            public void onChanged(@Nullable final List<Quiz> quiz) {

                adapter.setQuiz(quiz);
            }
        });

        FloatingActionButton fab = findViewById(R.id.submit_answer);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[][] answerCheckArray = QuizTestAdapter.checkArray;

                int correctCount = 0;
                int questionCount = answerCheckArray.length;

                boolean[] correctArray = new boolean[answerCheckArray.length];
                for (int i = 0; i < correctArray.length; i++) {
                    correctArray[i] = false;
                }

                String s = "";
                for (int i = 0; i < answerCheckArray.length; i++) {
                    if (i != 0) {
                        s += "\n";
                    }
                    switch (answerCheckArray[i][0]) {
                        case R.id.radio_btn_a:
                            s += "Q" + (i + 1) + ": selection A |";
                            break;
                        case R.id.radio_btn_b:
                            s += "Q" + (i + 1) + ": selection B |";
                            break;
                        case R.id.radio_btn_c:
                            s += "Q" + (i + 1) + ": selection C |";
                            break;
                        case R.id.radio_btn_d:
                            s += "Q" + (i + 1) + ": selection D |";
                            break;
                        default:
                            s += "Q" + (i + 1) + ": selection none |";
                    }
                    switch (answerCheckArray[i][1]) {
                        case R.id.radio_btn_a:
                            s += " answer A";
                            break;
                        case R.id.radio_btn_b:
                            s += " answer B";
                            break;
                        case R.id.radio_btn_c:
                            s += " answer C";
                            break;
                        case R.id.radio_btn_d:
                            s += " answer D";
                            break;
                        case -1:
                            s += " empty";
                            break;
                        default:
                            s += " should not appear";
                    }

                    if (answerCheckArray[i][0] == answerCheckArray[i][1]) {
                        correctCount++;
                        correctArray[i] = true;
                    }
                }

                s += "\n" + correctCount;
                s += "\n" + questionCount;

                Intent intent = new Intent(QuizTestActivity.this, QuizResultsActivity.class);
                intent.putExtra("KEYCORRECT", correctCount);
                intent.putExtra("KEYTOTAL", questionCount);
                intent.putExtra("TOPIC_REVIEW", topic);
                intent.putExtra("KEYCORRECTARRAY", correctArray);
                startActivity(intent);
            }
        });

    }
    @Override public void onBackPressed() {
        startActivity(new Intent(QuizTestActivity.this, QuizSelectionActivity.class));
        finish();
    }
}


