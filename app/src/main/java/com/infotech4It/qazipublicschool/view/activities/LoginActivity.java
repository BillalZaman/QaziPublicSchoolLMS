package com.infotech4It.qazipublicschool.view.activities;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.ActivityLoginBinding;
import com.infotech4It.qazipublicschool.helpers.UIHelper;

import java.util.ArrayList;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {
    @Inject
    UIHelper uiHelper;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        init();
    }

    private void init() {
        binding.setOnLoginClick(this);
        setSpinnerData();
    }

    private void setSpinnerData() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Please Select Branch");
        arrayList.add("Qazi Apex Grammar School (Venus Campus)");
        arrayList.add("Qazi Pilot High School");
        arrayList.add("Qazi Grammer Boys High School");
        arrayList.add("Qazi Girls High School");
        arrayList.add("Qazi Grammar Girls School");
        arrayList.add("Qazi Public Girls School");
        arrayList.add("Qazi Apex Grammar School (Pak Arab Campus)");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerBranches.setAdapter(arrayAdapter);
        binding.spinnerBranches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin: {
                uiHelper.openActivity(this, MainActivity.class);
            }
        }
    }
}