package com.infotech4It.qazipublicschool.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentVideoBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.viewModel.SubjectViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import javax.inject.Inject;

import constants.Constants;

public class VideoFragment extends Fragment {
    ProgressDialog loading;
    @Inject
    UIHelper uiHelper;
    String videoStr = "";
    private FragmentVideoBinding binding;
    private SubjectViewModel subjectViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_video, container, false);
        subjectViewModel = ViewModelProviders.of(this).get(SubjectViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
        return binding.getRoot();
    }

    private void init() {
        getLoadingStatus();

        if (uiHelper.isNetworkAvailable(getContext())) {
            subjectViewModel.getLessonData(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                    PreferenceHelper.getInstance().getInt(Constants.subjectID, 0)
            );

            getSubjectListDetailData();
        }
    }

    private void getSubjectListDetailData() {
        subjectViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    if (response.getDataObject().getVideoLinkData() != null) {
                        videoStr = response.getDataObject().getVideoLinkData();
                        loadVideo();
//                        if (!response.getDataObject().getVideoLinkData().equals("")) {
//                            videoStr = response.getDataObject().getVideoLinkData();
//                        } else {
//                            binding.webViewvideo.setVisibility(View.GONE);
//                            binding.imgNotice.setVisibility(View.VISIBLE);
//                            binding.txtNotice.setVisibility(View.VISIBLE);
//                        }
                    }
                }
            }
        });
    }

    private void loadVideo() {
        //build your own src link with your video ID
//        String videoStr =
//                "<html><body><iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/47yJ2XCRLZs\"" +
//                        " frameborder=\"0\" allowfullscreen></iframe></body></html>";

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

    private void getLoadingStatus() {
        subjectViewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
            @Override
            public void onChanged(@Nullable ViewModelStatus viewModelStatus) {
                if (viewModelStatus.isLoadingList) {
                    showLoading();
                } else {
                    hideLoading();
                }
            }
        });
    }

    public void showLoading() {
        loading = ProgressDialog.show(getContext(), getString(R.string.loading), "", true, false);
    }

    public void hideLoading() {
        loading.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        subjectViewModel.clear();
    }
}