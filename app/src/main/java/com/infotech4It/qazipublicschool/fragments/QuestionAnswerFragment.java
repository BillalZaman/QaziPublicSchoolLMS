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
import com.infotech4It.qazipublicschool.databinding.FragmentQuestionAnswerBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.adapters.FillBlankAdapter;
import com.infotech4It.qazipublicschool.view.models.FillBlankModel;
import com.infotech4It.qazipublicschool.view.models.MCQsAnswerModel;
import com.infotech4It.qazipublicschool.view.models.McqlistModel;
import com.infotech4It.qazipublicschool.viewModel.SubjectivePartViewModel;
import com.infotech4It.qazipublicschool.viewModel.ViewModelStatus;
import com.infotech4It.qazipublicschool.webservices.response.Response;

import java.util.ArrayList;

import javax.inject.Inject;

import constants.Constants;

public class QuestionAnswerFragment extends Fragment {
    ProgressDialog loading;
    @Inject
    UIHelper uiHelper;
    private FragmentQuestionAnswerBinding binding;
    private ArrayList<FillBlankModel> data = new ArrayList<>();
    private FillBlankAdapter adapter;
    private SubjectivePartViewModel subjectivePartViewModel;
    private McqlistModel mcqlistModel;
    private ArrayList<MCQsAnswerModel> answerModels = new ArrayList<>();

    public QuestionAnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question_answer, container, false);
        subjectivePartViewModel = ViewModelProviders.of(this).get(SubjectivePartViewModel.class);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        initData();
        return binding.getRoot();
    }

    public void setData(int questionID, String answer) {
//        uiHelper.showLongToastInCenter(getContext(), questionID + answer);
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
            subjectivePartViewModel.getFillBlanksData(
                    PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                    PreferenceHelper.getInstance().getInt(Constants.testID, 0));
            getTestData();
        } else {
            uiHelper.showLongToastInCenter(getContext(), getString(R.string.no_internet));
        }

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                uiHelper.showLongToastInCenter(getContext(), "Working is in progress");
                if (uiHelper.isNetworkAvailable(getContext())) {
                    mcqlistModel = new McqlistModel(PreferenceHelper.getInstance().getInt(Constants.userInfo, 0),
                            PreferenceHelper.getInstance().getInt(Constants.testID, 0), answerModels);
                    subjectivePartViewModel.getAssessmentNumber(mcqlistModel);
                    getTestData();
                } else {
                    uiHelper.showLongToastInCenter(getContext(), getString(R.string.no_internet));
                }
            }
        });
    }

    private void getTestData() {
        subjectivePartViewModel.getStudentLogin().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                if (response.getCode() == Constants.SUCCESS_CODE) {
                    if (response.getDataObject().getQuestionsData() != null) {
                        if (response.getDataObject().getQuestionsData().size() != 0) {
                            data = (ArrayList<FillBlankModel>) response.getDataObject().getQuestionsData();
                            if (adapter != null && data != null) {
                                adapter.setList(data);
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
                    } else if (response.getDataObject().getTotalMarks()!=null){
                        McqsFragmentDialog mcqsFragmentDialog = new McqsFragmentDialog();
                        PreferenceHelper.getInstance().setString(Constants.TOTAL_NUMBER,
                               ""+ response.getDataObject().getTotalMarks());
                        PreferenceHelper.getInstance().setString(Constants.OBTAINED_NUMBER,
                              ""+  response.getDataObject().getObtainedMarks());
                        uiHelper.replaceFragment(getContext(), R.id.parent_a, mcqsFragmentDialog);
                    }
                }
            }
        });
    }

    private void setRecyclerView() {
//        for (int i=0; i<=10; i++){
//            data.add(new FillBlankModel("What is your favourite color"));
//        }
        adapter = new FillBlankAdapter(getContext());
        adapter.setList(data);
        binding.recyclerview.setAdapter(adapter);
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