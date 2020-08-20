package com.infotech4It.qazipublicschool.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentHomeWorkBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.adapters.HomeWorkAdapter;
import com.infotech4It.qazipublicschool.view.models.HomeWorkModel;
import com.infotech4It.qazipublicschool.viewModel.SubjectViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

import constants.Constants;


public class HomeWorkFragment extends Fragment {
    private FragmentHomeWorkBinding binding;
    private ArrayList<HomeWorkModel> data = new ArrayList<>();
    private HomeWorkAdapter adapter;
    private SubjectViewModel subjectViewModel;
    ProgressDialog loading;
    @Inject
    UIHelper uiHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_work, container, false);
        subjectViewModel = ViewModelProviders.of(this).get(SubjectViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
        return binding.getRoot();
    }

    private void init() {
        setRecyclerView();
        getLoadingStatus();

        if (uiHelper.isNetworkAvailable(getContext())) {
            subjectViewModel.getLessonData(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                    PreferenceHelper.getInstance().getInt(Constants.subjectID, 0)
            );

            getSubjectListDetailData();
        } else {
            uiHelper.showLongToastInCenter(getContext(), getString(R.string.no_internet));
        }
    }

    private void getSubjectListDetailData() {
        subjectViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    if (response.getDataObject().getTodoList() != null) {
                        binding.textView4.setText(Html.fromHtml(response.getDataObject().getHomeWork()).toString());
                    }
                }
            }
        });
    }

    private void setRecyclerView() {
        adapter = new HomeWorkAdapter(getContext());
        adapter.setData(data);
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