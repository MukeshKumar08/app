package com.gg.gg.CommonActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;

import androidx.annotation.RequiresPermission;
import androidx.core.app.ActivityCompat;

import java.lang.annotation.Annotation;

public class Services implements RequiresPermission {

    LocationManager locationManager;
    public static final int REQUEST_LOCATIION = 1;

    @Override
    public String value() {
        return null;
    }

    @Override
    public String[] allOf() {
        return new String[0];
    }

    @Override
    public String[] anyOf() {
        return new String[0];
    }

    @Override
    public boolean conditional() {
        return false;
    }

    @Override
    public Class<? extends Annotation> annotationType() {


        return null;
    }
}
