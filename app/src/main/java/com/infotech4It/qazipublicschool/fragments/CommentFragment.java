package com.infotech4It.qazipublicschool.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentCommentBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.adapters.CommentingAdapter;
import com.infotech4It.qazipublicschool.view.models.CommentingModel;
import com.infotech4It.qazipublicschool.viewModel.SubjectViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

import constants.Constants;

public class CommentFragment extends Fragment {
    ProgressDialog loading;
    @Inject
    UIHelper uiHelper;
    private FragmentCommentBinding binding;
    private ArrayList<CommentingModel> data = new ArrayList<>();
    private CommentingAdapter adapter;
    private SubjectViewModel subjectViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comment, container, false);
        subjectViewModel = ViewModelProviders.of(this).get(SubjectViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        getLoadingStatus();
        setRecyclerView();
        loadLocallyData();

        if (uiHelper.isNetworkAvailable(getContext())) {
            subjectViewModel.getLessonComment(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                    PreferenceHelper.getInstance().getInt(Constants.subjectID, 0)
            );

            getSubjectListDetailData();
        }
    }

    private void loadLocallyData() {
        binding.txtUserName.setText(PreferenceHelper.getInstance().getString(Constants.userName,""));
        binding.txtClassName.setText(PreferenceHelper.getInstance().getString(Constants.className,""));
        binding.txtSubject.setText(PreferenceHelper.getInstance().getString(Constants.subjectName,""));
        binding.txtLecTopic.setText(PreferenceHelper.getInstance().getString(Constants.lessonName,""));
    }

    private void setRecyclerView() {
        adapter = new CommentingAdapter(getContext());
        adapter.setData(data);
        binding.recyclerview.setAdapter(adapter);
    }

    private void getSubjectListDetailData() {
        subjectViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    if (response.getDataObject() != null) {
//                        videoStr = response.getDataObject().getVideoLinkData();
//                        loadVideo();
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