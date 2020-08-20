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
import com.infotech4It.qazipublicschool.databinding.FragmentRecentAssessmentsBinding;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.adapters.RecentAssessmentAdapter;
import com.infotech4It.qazipublicschool.view.models.RecentAssessmentModel;
import com.infotech4It.qazipublicschool.viewModel.SubjectViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

import constants.Constants;

public class RecentAssessmentsFragment extends Fragment {
    private FragmentRecentAssessmentsBinding binding;
    private RecentAssessmentAdapter adapter;
    private ArrayList<RecentAssessmentModel> data = new ArrayList<>();
    ProgressDialog loading;
    @Inject
    UIHelper uiHelper;
    private SubjectViewModel subjectViewModel;

    public RecentAssessmentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_recent_assessments, container, false);
        subjectViewModel = ViewModelProviders.of(this).get(SubjectViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        initData();
        return binding.getRoot();
    }

    private void initData() {

        getLoadingStatus();
        setRecyclerView();
        if (uiHelper.isNetworkAvailable(getContext())) {
            subjectViewModel.getStudentSubjectDetail(
            );
            getSubjectListDetailData();
        }
    }

    private void getSubjectListDetailData() {
        subjectViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    if (response.getDataObject().getRecentAssessments() != null) {
                        if (response.getDataObject().getRecentAssessments().size() != 0) {
                            data = (ArrayList<RecentAssessmentModel>) response.getDataObject().getRecentAssessments();
                            if (adapter != null && data != null) {
                                adapter.setList(data);
                            }
                        } else {
                            binding.recyclerview.setVisibility(View.GONE);
                            binding.imgNotice.setVisibility(View.VISIBLE);
                            binding.txtNotice.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
    }

    private void setRecyclerView() {
        adapter = new RecentAssessmentAdapter(getContext());
        adapter.setList(data);
        binding.recyclerview.setAdapter(adapter);
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