package com.example.user.youtubelibrarypageclone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LibraryFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int headerItemType = 0;
    private static final int videoItemType = 1;

    private Context context;
    private ArrayList<String> titlesList;
    private ArrayList<String> authorList;
    private ArrayList<String> imageUrl;

    public LibraryFragmentRecyclerViewAdapter(Context context, ArrayList<String> titlesList,
                                              ArrayList<String> authorList, ArrayList<String> imageUrl) {
        this.context = context;
        this.titlesList = titlesList;
        this.authorList = authorList;
        this.imageUrl = imageUrl;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        private TextView title, username, noOfVideos;
        private ImageView shuffle, download, lock;
        private FloatingActionButton play;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recyclerview_item_header_title);
            username = itemView.findViewById(R.id.recyclerview_item_header_username);
            noOfVideos = itemView.findViewById(R.id.recyclerview_item_header_noofvideos);
            shuffle = itemView.findViewById(R.id.recyclerview_item_header_shuffle);
            download = itemView.findViewById(R.id.recyclerview_item_header_download);
            lock = itemView.findViewById(R.id.recyclerview_item_header_lock);
            play = itemView.findViewById(R.id.recyclerview_item_header_playfab);
            
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show();
                }
            });
            shuffle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Shuffle clicked", Toast.LENGTH_SHORT).show();
                }
            });
            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Download clicked", Toast.LENGTH_SHORT).show();
                }
            });
            lock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Lock clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private ImageView videoImageView;
        private TextView title;
        private TextView author;
        private ImageButton dropDownButton;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoImageView = itemView.findViewById(R.id.video_item_image);
            title = itemView.findViewById(R.id.video_item_title);
            author = itemView.findViewById(R.id.video_item_author);
            dropDownButton = itemView.findViewById(R.id.video_item_dropdown_button);

            dropDownButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Drop down pressed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        // If header item, return 0
        if (position == 0) {
            return headerItemType;
        } else {
            return videoItemType;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case headerItemType:
                view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_header,viewGroup,false);
                return new HeaderViewHolder(view);
            case videoItemType:
                view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_video,viewGroup,false);
                return new VideoViewHolder(view);
        }
        // Default case
        view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_header,viewGroup,false);
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()){
            case headerItemType:
                // All data in headerItemType is hardcoded for simplicity
                HeaderViewHolder headerViewHolder = (HeaderViewHolder)viewHolder;
                break;
            case videoItemType:
                VideoViewHolder videoViewHolder = (VideoViewHolder)viewHolder;
                videoViewHolder.title.setText(titlesList.get(i));
                videoViewHolder.author.setText(authorList.get(i));
                // Set default image for simplicity
                videoViewHolder.videoImageView.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount() {
        return titlesList.size();
    }

}
