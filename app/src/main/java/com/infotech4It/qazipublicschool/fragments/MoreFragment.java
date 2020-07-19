package com.infotech4It.qazipublicschool.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentMoreBinding;
import com.infotech4It.qazipublicschool.dialogs.LogoutFragmentDialog;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.activities.ChangePasswordActivity;

import javax.inject.Inject;


public class MoreFragment extends Fragment {
    private FragmentMoreBinding binding;
    @Inject
    UIHelper uiHelper;

    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_more, container,false);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        initData();
        return binding.getRoot();
    }

    private void initData() {
        binding.setOnMoreClick(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.txtChangePassword:{
                uiHelper.openActivity(getActivity(), ChangePasswordActivity.class);
                break;
            }
            case R.id.txtLogout:{
                LogoutFragmentDialog logoutFragmentDialog = new LogoutFragmentDialog();
                uiHelper.replaceFragment(getContext(), R.id.parent, logoutFragmentDialog);
                break;
            }
            case R.id.txtPrivacyPolicy:{

                break;
            }
        }
    }
}