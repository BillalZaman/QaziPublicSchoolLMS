package com.infotech4It.qazipublicschool.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.FragmentLogoutDialogBinding;
import com.infotech4It.qazipublicschool.interfaces.LogoutInterface;


public class LogoutFragmentDialog extends Fragment {
    private FragmentLogoutDialogBinding binding;
    private LogoutInterface logoutInterface;

    public LogoutFragmentDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_logout_dialog, container, false);
        logoutInterface = (LogoutInterface) getContext();
        initData();
        return binding.getRoot();
    }

    private void initData() {
        binding.setOnLogoutClick(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnYes: {
                logoutInterface.onLogout("logout");
            }
            case R.id.btnCancel: {
                logoutInterface.onLogout("cancel");
            }
        }
    }
}