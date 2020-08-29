package com.infotech4It.qazipublicschool.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentMCQSBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.adapters.QuizAdapter;
import com.infotech4It.qazipublicschool.view.models.MCQsAnswerModel;
import com.infotech4It.qazipublicschool.view.models.MCQsModel;
import com.infotech4It.qazipublicschool.view.models.McqlistModel;
import com.infotech4It.qazipublicschool.viewModel.SubjectivePartViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

import constants.Constants;

public class MCQSFragment extends Fragment {
    ProgressDialog loading;
    @Inject
    UIHelper uiHelper;
    MCQsAnswerModel answerModel;
    private FragmentMCQSBinding binding;
    private ArrayList<MCQsModel> data = new ArrayList<>();
    private QuizAdapter adapters;
    private SubjectivePartViewModel subjectivePartViewModel;
    private McqlistModel mcqlistModel;
    private ArrayList<MCQsAnswerModel> answerModels = new ArrayList<>();

    public MCQSFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_m_c_q_s, container, false);
        subjectivePartViewModel = ViewModelProviders.of(this).get(SubjectivePartViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        initData();
        return binding.getRoot();
    }

    public void setData(int questionID, String answer) {
        uiHelper.showLongToastInCenter(getContext(), questionID + answer);

        for (int i = 0; i < answerModels.size(); i++) {
            if (questionID == answerModels.get(i).getId()) {
                answerModels.get(i).setAns(answer);
            }
        }
    }

    private void initData() {
        getLoadingStatus();

        setRecyclerView();
        if (uiHelper.isNetworkAvailable(getContext())) {
            subjectivePartViewModel.getMCQSData(
                    PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                    PreferenceHelper.getInstance().getInt(Constants.testID, 0));
            getTestData();
        }

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                McqsFragmentDialog mcqsFragment = new McqsFragmentDialog();
//                uiHelper.replaceFragment(getContext(), R.id.parent, mcqsFragment);

                if (uiHelper.isNetworkAvailable(getContext())) {
//                    mcqlistModel = new McqlistModel(11789, 4356, answerModels);
                    mcqlistModel = new McqlistModel(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                            PreferenceHelper.getInstance().getInt(Constants.testID, 0), answerModels);
                    subjectivePartViewModel.getAssessmentNumber(
                            mcqlistModel);

                    getTestData();
                }
            }
        });
    }

    private void setRecyclerView() {
        adapters = new QuizAdapter(getContext());
        adapters.setList(data);
        binding.recyclerview.setAdapter(adapters);
    }

    private void getTestData() {
        subjectivePartViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    if (response.getDataObject().getMcQsModelList() != null) {
                        if (response.getDataObject().getMcQsModelList().size() != 0) {
                            data = (ArrayList<MCQsModel>) response.getDataObject().getMcQsModelList();
                            if (adapters != null && data != null) {
                                adapters.setList(data);
                            }
                            for (int i = 0; i < data.size(); i++) {
                                answerModels.add(new MCQsAnswerModel(data.get(i).getId(), ""));
                            }
                        } else {
                            binding.recyclerview.setVisibility(View.GONE);
                            binding.btnSave.setVisibility(View.GONE);
                            binding.imgNotice.setVisibility(View.VISIBLE);
                            binding.txtNotice.setVisibility(View.VISIBLE);
                        }
                    } else if (response.getDataObject().getTotalMarks() != null) {
                        Toast.makeText(getContext(), "working like a charm", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void getLoadingStatus() {
        subjectivePartViewModel.getIsLoading().observe(this, new Observer<ViewModelStatus>() {
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
        subjectivePartViewModel.clear();
    }
}