package com.example.homework4;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ContentFragment extends Fragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";
    private static final String ARG_IMAGE_RESOURCE = "image_resource";

    private String title;
    private String content;
    private int imageResourceId;

    public static ContentFragment newInstance(String title, String content, int imageResourceId) {
        ContentFragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_CONTENT, content);
        args.putInt(ARG_IMAGE_RESOURCE, imageResourceId);
        fragment.setArguments(args);
        return fragment;
    }

    // Overload method for backward compatibility (without image)
    public static ContentFragment newInstance(String title, String content) {
        return newInstance(title, content, 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            content = getArguments().getString(ARG_CONTENT);
            imageResourceId = getArguments().getInt(ARG_IMAGE_RESOURCE, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvContent = view.findViewById(R.id.tvContent);
        ImageView ivFlag = view.findViewById(R.id.ivFlag);
        ScrollView scrollView = view.findViewById(R.id.scrollView);
        View loadingLayout = view.findViewById(R.id.loadingLayout);

        tvTitle.setText(title);
        tvContent.setText(content);

        // Set image if provided
        if (imageResourceId != 0) {
            ivFlag.setImageResource(imageResourceId);
            ivFlag.setVisibility(View.VISIBLE);
        } else {
            ivFlag.setVisibility(View.GONE);
        }

        // Show loading for 2 seconds
        new Handler().postDelayed(() -> {
            loadingLayout.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }, 2000);

        return view;
    }
}