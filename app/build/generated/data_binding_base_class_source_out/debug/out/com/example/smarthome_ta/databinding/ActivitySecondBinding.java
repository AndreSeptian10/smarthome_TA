// Generated by view binder compiler. Do not edit!
package com.example.smarthome_ta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.smarthome_ta.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySecondBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnmove;

  @NonNull
  public final RelativeLayout gas;

  @NonNull
  public final RelativeLayout header2;

  @NonNull
  public final RelativeLayout humi;

  @NonNull
  public final RelativeLayout movebtn1;

  @NonNull
  public final RelativeLayout temp;

  @NonNull
  public final TextView textgas;

  @NonNull
  public final TextView texthumi;

  @NonNull
  public final TextView texttemp;

  private ActivitySecondBinding(@NonNull RelativeLayout rootView, @NonNull Button btnmove,
      @NonNull RelativeLayout gas, @NonNull RelativeLayout header2, @NonNull RelativeLayout humi,
      @NonNull RelativeLayout movebtn1, @NonNull RelativeLayout temp, @NonNull TextView textgas,
      @NonNull TextView texthumi, @NonNull TextView texttemp) {
    this.rootView = rootView;
    this.btnmove = btnmove;
    this.gas = gas;
    this.header2 = header2;
    this.humi = humi;
    this.movebtn1 = movebtn1;
    this.temp = temp;
    this.textgas = textgas;
    this.texthumi = texthumi;
    this.texttemp = texttemp;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySecondBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySecondBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_second, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySecondBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnmove;
      Button btnmove = ViewBindings.findChildViewById(rootView, id);
      if (btnmove == null) {
        break missingId;
      }

      id = R.id.gas;
      RelativeLayout gas = ViewBindings.findChildViewById(rootView, id);
      if (gas == null) {
        break missingId;
      }

      id = R.id.header2;
      RelativeLayout header2 = ViewBindings.findChildViewById(rootView, id);
      if (header2 == null) {
        break missingId;
      }

      id = R.id.humi;
      RelativeLayout humi = ViewBindings.findChildViewById(rootView, id);
      if (humi == null) {
        break missingId;
      }

      id = R.id.movebtn1;
      RelativeLayout movebtn1 = ViewBindings.findChildViewById(rootView, id);
      if (movebtn1 == null) {
        break missingId;
      }

      id = R.id.temp;
      RelativeLayout temp = ViewBindings.findChildViewById(rootView, id);
      if (temp == null) {
        break missingId;
      }

      id = R.id.textgas;
      TextView textgas = ViewBindings.findChildViewById(rootView, id);
      if (textgas == null) {
        break missingId;
      }

      id = R.id.texthumi;
      TextView texthumi = ViewBindings.findChildViewById(rootView, id);
      if (texthumi == null) {
        break missingId;
      }

      id = R.id.texttemp;
      TextView texttemp = ViewBindings.findChildViewById(rootView, id);
      if (texttemp == null) {
        break missingId;
      }

      return new ActivitySecondBinding((RelativeLayout) rootView, btnmove, gas, header2, humi,
          movebtn1, temp, textgas, texthumi, texttemp);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
