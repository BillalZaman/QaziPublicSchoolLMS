package com.infotech4It.qazipublicschool.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.infotech4It.qazipublicschool.ApplicationState;
import com.infotech4It.qazipublicschool.R;
import com.infotech4It.qazipublicschool.databinding.NavHeaderMainBinding;
import com.infotech4It.qazipublicschool.helpers.PreferenceHelper;
import com.infotech4It.qazipublicschool.helpers.UIHelper;
import com.infotech4It.qazipublicschool.view.activities.ProfileActivity;
import com.infotech4It.qazipublicschool.view.adapters.NavigationDrawerAdapter;
import com.infotech4It.qazipublicschool.view.models.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import constants.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNavigationDrawer extends Fragment {

    private static Integer[] imgDrawer = {R.drawable.ic_baseline_school_24, R.drawable.ic_menu_notifications,
            R.drawable.ic_baseline_lock_24, R.drawable.ic_logout, R.drawable.ic_privacy_policy};
    private static String[] titles = null;
    @Inject
    UIHelper uiHelper;
    private NavHeaderMainBinding binding;
    private FragmentDrawerListener drawerListener;
    private Context context;
    private NavigationDrawerAdapter adapter;
    private DrawerLayout drawerLayout;
    private View containerView;
    private ActionBarDrawerToggle mDrawerToggle;

    public FragmentNavigationDrawer() {
        // Required empty public constructor
    }

    public static List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<NavDrawerItem>();

        int len = titles.length;

        // preparing navigation drawer items
        for (int i = 0; i < len; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(titles[i]);
            navItem.setImgItem(imgDrawer[i]);

            data.add(navItem);
        }
        return data;
    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.nav_header_main, container, false);
        ApplicationState.getApp().getApplicationComponent().injectUIHelper(this);
        View view = binding.getRoot();
        View parentLayout = view.findViewById(R.id.nav_header);
        parentLayout.setOnClickListener(null);

        setNavigationRecyclerView();

        binding.navHeader2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiHelper.openActivity(getActivity(), ProfileActivity.class);
                drawerLayout.closeDrawers();
            }
        });

        binding.txtUserName.setText(PreferenceHelper.getInstance().getString(Constants.userName, ""));
        binding.txtStudentFatherName.setText(PreferenceHelper.getInstance().getString(Constants.userFather, ""));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setNavigationRecyclerView() {
        adapter = new NavigationDrawerAdapter(getActivity(), getData());
        binding.recyclerviewNavigation.setAdapter(adapter);

        binding.recyclerviewNavigation.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),
                binding.recyclerviewNavigation, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                // Toast.makeText(context, "position: "+position, Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(containerView);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    public void setUp(int fragmentId, DrawerLayout mdrawerLayout) {
        containerView = getActivity().findViewById(fragmentId);
        drawerLayout = mdrawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (getActivity() != null)
                    getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (getActivity() != null)
                    getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                // toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        drawerLayout.setDrawerListener(mDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public void aditionalCount(int count) {
        if (adapter != null) {
            adapter.aditionalCount(count);
        }
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public interface FragmentDrawerListener {
        void onDrawerItemSelected(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
