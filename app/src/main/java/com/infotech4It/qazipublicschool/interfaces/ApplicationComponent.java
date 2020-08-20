package com.infotech4It.qazipublicschool.interfaces;

import com.infotech4It.qazipublicschool.fragments.AllAssessmentsFragment;
import com.infotech4It.qazipublicschool.fragments.AllLessonsFragment;
import com.infotech4It.qazipublicschool.fragments.CommentFragment;
import com.infotech4It.qazipublicschool.fragments.FragmentNavigationDrawer;
import com.infotech4It.qazipublicschool.fragments.HomeWorkFragment;
import com.infotech4It.qazipublicschool.fragments.ImageFragment;
import com.infotech4It.qazipublicschool.fragments.MoreFragment;
import com.infotech4It.qazipublicschool.fragments.QuestionAnswerFragment;
import com.infotech4It.qazipublicschool.fragments.TodoListFragment;
import com.infotech4It.qazipublicschool.fragments.VideoFragment;
import com.infotech4It.qazipublicschool.repository.SubjectivePartRepo;
import com.infotech4It.qazipublicschool.view.activities.ProfileActivity;
import com.infotech4It.qazipublicschool.fragments.RecentAssessmentsFragment;
import com.infotech4It.qazipublicschool.fragments.RecentLessonsFragment;
import com.infotech4It.qazipublicschool.fragments.SubjectFragment;
import com.infotech4It.qazipublicschool.module.internetModule.InternetModule;
import com.infotech4It.qazipublicschool.module.uiHelperModule.UIHelperModule;
import com.infotech4It.qazipublicschool.repository.StudentRepo;
import com.infotech4It.qazipublicschool.repository.SubjectRepo;
import com.infotech4It.qazipublicschool.view.activities.ChangePasswordActivity;
import com.infotech4It.qazipublicschool.view.activities.LoginActivity;
import com.infotech4It.qazipublicschool.view.activities.MainActivity;
import com.infotech4It.qazipublicschool.view.activities.ReleatedSubjectListActivity;
import com.infotech4It.qazipublicschool.view.activities.SplashActivity;
import com.infotech4It.qazipublicschool.view.activities.SubjectDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Bilal Zaman on 17/07/2020.
 */
@Singleton
@Component(modules = {InternetModule.class, UIHelperModule.class})
public interface ApplicationComponent {

    void injectInternet(LoginActivity loginActivity);

    void injectUIHelper(SplashActivity splashActivity);

    void injectUIHelper(MainActivity mainActivity);

    void injectUIHelper(LoginActivity loginActivity);

    void injectUIHelper(ReleatedSubjectListActivity releatedSubjectListActivity);

    void injectUIHelper(SubjectDetailActivity releatedSubjectListActivity);

    void injectUIHelper(MoreFragment moreFragment);

    void injectUIHelper(StudentRepo studentRepo);

    void injectUIHelper(SubjectRepo subjectRepo);

    void injectUIHelper(SubjectFragment subjectFragment);

    void injectUIHelper(RecentLessonsFragment recentLessonsFragment);

    void injectUIHelper(AllLessonsFragment allLessonsFragment);

    void injectUIHelper(RecentAssessmentsFragment recentAssessmentsFragment);

    void injectUIHelper(AllAssessmentsFragment allAssessmentsFragment);

    void injectUIHelper(ChangePasswordActivity allAssessmentsFragment);

    void injectUIHelper(FragmentNavigationDrawer fragmentNavigationDrawer);

    void injectUIHelper(ProfileActivity allAssessmentsFragment);

    void injectUIHelper(VideoFragment videoFragment);

    void injectUIHelper(ImageFragment videoFragment);

    void injectUIHelper(TodoListFragment videoFragment);

    void injectUIHelper(HomeWorkFragment videoFragment);

    void injectUIHelper(CommentFragment videoFragment);

    void injectUIHelper(QuestionAnswerFragment videoFragment);

    void injectUIHelper(SubjectivePartRepo subjectivePartRepo);
}
