package unsw.Infs3605.Mydegree;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends AppCompatActivity implements YouTubeThumbnailView.OnInitializedListener, YouTubeThumbnailLoader.OnThumbnailLoadedListener, YouTubePlayer.OnInitializedListener {

    private static final String TAG_Y = "Youtube video";
    List<Drawable> thumbnailList;
    List<String> VideoId;
    YouTubePlayerFragment playerFragment;
    YouTubePlayer Player;
    YouTubeThumbnailView thumbnailView;
    YouTubeThumbnailLoader thumbnailLoader;
    RecyclerView playlist;
    RecyclerView.Adapter adapter;
    String API_KEY = "AIzaSyAirBdt0dF51ZdR3IY4j5TdNJBv5JT6FNo";


    String PLAYLIST_ID =  "PLuoHs1UfMtol8ZqUodhHl62mah0fA6pTa";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

//        appBarTxt.setText("Avo's Private Playlist");
        thumbnailList = new ArrayList<>();
        VideoId = new ArrayList<>();
        playlist = findViewById(R.id.youtube_videolist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        playlist.setLayoutManager(layoutManager);
        adapter = new VideoListAdapter();
        playlist.setAdapter(adapter);
        thumbnailView = new YouTubeThumbnailView(this);
        thumbnailView.initialize(API_KEY, this);
        playerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
        playerFragment.initialize(API_KEY, this);



    }


    @Override
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

        thumbnailLoader = youTubeThumbnailLoader;
        youTubeThumbnailLoader.setOnThumbnailLoadedListener(VideoActivity.this);
        thumbnailLoader.setPlaylist(PLAYLIST_ID);
        Log.i(TAG_Y, "Playlist assigned");
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

        Toast toast1 = Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_LONG);
        toast1.show();
        Log.e(TAG_Y, "displayed from error.");
    }


    public void add() {
        adapter.notifyDataSetChanged();
        if (thumbnailLoader.hasNext())
            thumbnailLoader.next();
        Log.i(TAG_Y, "Traversing through data.");
    }


    @Override

    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
        thumbnailList.add(youTubeThumbnailView.getDrawable());
        VideoId.add(s);
        add();
        Log.i(TAG_Y, "Thumbnails added in.");

    }

    @Override
    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

        thumbnailLoader.release();
        Log.e(TAG_Y, "Thumbnail loader error.");
    }

    @Override

    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Player = youTubePlayer;
        Player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
        Player.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
            @Override
            public void onFullscreen(boolean b) {
                playlist.setVisibility(b ? View.GONE : View.VISIBLE);
            }
        });

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Log.e(TAG_Y, "Player failed to initialize.");
    }

    public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.MyView> {

        public class MyView extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textview;

            public MyView(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.thumbnailView);
                textview = itemView.findViewById(R.id.description);

            }

        }

        @Override

        public VideoListAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_video_row, parent, false);
            return new MyView(itemView);

        }


        @Override

        public void onBindViewHolder(VideoListAdapter.MyView holder, final int position) {
            holder.imageView.setImageDrawable(thumbnailList.get(position));
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Player.cueVideo(VideoId.get(position));
                }
            });

        }

        @Override
        public int getItemCount() {
            return thumbnailList.size();

        }



    }
}
