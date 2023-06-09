// Generated by view binder compiler. Do not edit!
package com.example.smarthome_ta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.smarthome_ta.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnmove;

  @NonNull
  public final RelativeLayout doorLock;

  @NonNull
  public final RelativeLayout header;

  @NonNull
  public final RelativeLayout kipas;

  @NonNull
  public final RelativeLayout lampu;

  @NonNull
  public final RelativeLayout movebtn;

  @NonNull
  public final Button offKipas;

  @NonNull
  public final Button offdoorLock;

  @NonNull
  public final Button offlampu;

  @NonNull
  public final Button onKipas;

  @NonNull
  public final Button ondoorLock;

  @NonNull
  public final Button onlampu;

  private ActivityMainBinding(@NonNull RelativeLayout rootView, @NonNull Button btnmove,
      @NonNull RelativeLayout doorLock, @NonNull RelativeLayout header,
      @NonNull RelativeLayout kipas, @NonNull RelativeLayout lampu, @NonNull RelativeLayout movebtn,
      @NonNull Button offKipas, @NonNull Button offdoorLock, @NonNull Button offlampu,
      @NonNull Button onKipas, @NonNull Button ondoorLock, @NonNull Button onlampu) {
    this.rootView = rootView;
    this.btnmove = btnmove;
    this.doorLock = doorLock;
    this.header = header;
    this.kipas = kipas;
    this.lampu = lampu;
    this.movebtn = movebtn;
    this.offKipas = offKipas;
    this.offdoorLock = offdoorLock;
    this.offlampu = offlampu;
    this.onKipas = onKipas;
    this.ondoorLock = ondoorLock;
    this.onlampu = onlampu;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnmove;
      Button btnmove = ViewBindings.findChildViewById(rootView, id);
      if (btnmove == null) {
        break missingId;
      }

      id = R.id.doorLock;
      RelativeLayout doorLock = ViewBindings.findChildViewById(rootView, id);
      if (doorLock == null) {
        break missingId;
      }

      id = R.id.header;
      RelativeLayout header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
        break missingId;
      }

      id = R.id.kipas;
      RelativeLayout kipas = ViewBindings.findChildViewById(rootView, id);
      if (kipas == null) {
        break missingId;
      }

      id = R.id.lampu;
      RelativeLayout lampu = ViewBindings.findChildViewById(rootView, id);
      if (lampu == null) {
        break missingId;
      }

      id = R.id.movebtn;
      RelativeLayout movebtn = ViewBindings.findChildViewById(rootView, id);
      if (movebtn == null) {
        break missingId;
      }

      id = R.id.offKipas;
      Button offKipas = ViewBindings.findChildViewById(rootView, id);
      if (offKipas == null) {
        break missingId;
      }

      id = R.id.offdoorLock;
      Button offdoorLock = ViewBindings.findChildViewById(rootView, id);
      if (offdoorLock == null) {
        break missingId;
      }

      id = R.id.offlampu;
      Button offlampu = ViewBindings.findChildViewById(rootView, id);
      if (offlampu == null) {
        break missingId;
      }

      id = R.id.onKipas;
      Button onKipas = ViewBindings.findChildViewById(rootView, id);
      if (onKipas == null) {
        break missingId;
      }

      id = R.id.ondoorLock;
      Button ondoorLock = ViewBindings.findChildViewById(rootView, id);
      if (ondoorLock == null) {
        break missingId;
      }

      id = R.id.onlampu;
      Button onlampu = ViewBindings.findChildViewById(rootView, id);
      if (onlampu == null) {
        break missingId;
      }

      return new ActivityMainBinding((RelativeLayout) rootView, btnmove, doorLock, header, kipas,
          lampu, movebtn, offKipas, offdoorLock, offlampu, onKipas, ondoorLock, onlampu);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
