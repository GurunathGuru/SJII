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

    private ImageView ivCall;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ivCall=view.findViewById(R.id.ivCall);
        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDial();
            }
        });
        return view;
    }
    public void getDial() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final CharSequence[] phone = new CharSequence[]{"+91 080 2212 6619", "+91 080 2221 2570", "+91 080 2229 2622"};
        final CharSequence[] optionsChosen = phone;
        builder.setItems(optionsChosen, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (optionsChosen[item].equals("+91 080 2212 6619")) {
                    String phone = "+91 080 2212 6619";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(callIntent);
                    startActivity(callIntent);

                } else if (optionsChosen[item].equals("+91 080 2221 2570")) {
                    String phone = "+91 080 2221 2570";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(callIntent);
                    startActivity(callIntent);

                } else if (optionsChosen[item].equals("+91 080 2229 2622")) {
                    String phone = "+91 080 2229 2622";
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(callIntent);
                    startActivity(callIntent);
                }
            }
        });
        builder.show();
    }

    public void sendEmail() {
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:?subject=" + " " + "&body=" + " " + "&to=" + "info@sjcc.edu.in");
        testIntent.setData(data);
        startActivity(testIntent);
    }

}
