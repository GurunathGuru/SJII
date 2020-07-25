package com.integro.sjii.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.integro.sjii.AboutUsActivity;
import com.integro.sjii.AnnouncementsActivity;
import com.integro.sjii.FacilitiesActivity;
import com.integro.sjii.FacultyActivity;
import com.integro.sjii.InstitutionActivity;
import com.integro.sjii.NewsActivity;
import com.integro.sjii.NotificationActivity;
import com.integro.sjii.R;
import com.integro.sjii.VisionActivity;
import com.integro.sjii.WebActivity;

public class HomeFragment extends Fragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

}
