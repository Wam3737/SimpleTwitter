package com.codepath.apps.simpleTwit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.simpleTwit.models.Tweet;

import java.util.List;


public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{
    Context context;
    List<Tweet> tweets;
    //pass in context and list of tweets
    public TweetsAdapter(Context context, List<Tweet> tweets){
        this.context = context;
        this.tweets = tweets;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet,  parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Tweet tweet= tweets.get(position);
       holder.bind(tweet);
    }

    @Override
    // Clean all elements of the recycler

    public int getItemCount() {
        return tweets.size();
    }

    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }



    //define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView profileImage;
        TextView body;
        TextView handle;
        TextView name;
        TextView timestamp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.ivProfile);
            body = itemView.findViewById(R.id.tvTweet);
            handle = itemView.findViewById(R.id.tvHandle);
            name = itemView.findViewById(R.id.tvName);
            timestamp = itemView.findViewById(R.id.timestamp);
        }

        public void bind(Tweet tweet) {
            body.setText(tweet.body);
            handle.setText(tweet.user.handle);
            Glide.with(context).load(tweet.user.imageUrl).into(profileImage);
            name.setText(tweet.user.name);
            timestamp.setText(TimeFormatter.getTimeDifference(tweet.createdAt));

        }
    }
}
