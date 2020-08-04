package com.infotech4It.qazipublicschool.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentSubjectBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.adapters.SubjectAdapter;
import com.infotech4It.qazipublicschool.view.models.StudentSubjectModel;
import com.infotech4It.qazipublicschool.viewModel.SubjectViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

import constants.Constants;


public class SubjectFragment extends Fragment {
    ProgressDialog loading;
    @Inject
    UIHelper uiHelper;
    private FragmentSubjectBinding binding;
    private SubjectAdapter adapter;
    private ArrayList<StudentSubjectModel> dataList = new ArrayList<>();
    private SubjectViewModel subjectViewModel;
    private Boolean flag_loading = false;
    private int pageno = 0;

    public SubjectFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_subject, container, false);
        subjectViewModel = ViewModelProviders.of(this).get(SubjectViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        getLoadingStatus();
        setRecyclerView();
        if (uiHelper.isNetworkAvailable(getContext())) {
            subjectViewModel.getStudentSubjectList(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                    pageno
            );

            getSubjectListData();
        }


        binding.recyclerview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (flag_loading == false) {
                    flag_loading = true;
                    pageno = pageno + 1;
                    subjectViewModel.getStudentSubjectList(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                            pageno
                    );
                    getSubjectListData();
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {


            }
        });
    }

    private void getSubjectListData() {
        subjectViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    if (response.getDataObject().getStudentSubjects() != null) {
                        dataList = (ArrayList<StudentSubjectModel>) response.getDataObject().getStudentSubjects();
                        if (adapter != null && dataList != null) {
                            adapter.setList(dataList);
                        }
                    }
                }
            }
        });
    }

    private void setRecyclerView() {
        adapter = new SubjectAdapter(getContext());
        adapter.setList(dataList);
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