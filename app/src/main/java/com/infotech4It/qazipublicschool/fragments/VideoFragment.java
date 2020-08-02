package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentVideoBinding;

public class VideoFragment extends Fragment {
    private FragmentVideoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_video, container, false);
        loadVideo();
        return binding.getRoot();
    }

    private void loadVideo() {
        //build your own src link with your video ID
        String videoStr =
                "<html><body><iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/47yJ2XCRLZs\"" +
                        " frameborder=\"0\" allowfullscreen></iframe></body></html>";

        binding.webViewvideo.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings ws = binding.webViewvideo.getSettings();
        ws.setJavaScriptEnabled(true);
        binding.webViewvideo.loadData(videoStr, "text/html", "utf-8");
    }
}