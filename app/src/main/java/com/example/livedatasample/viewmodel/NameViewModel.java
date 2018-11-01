package com.example.livedatasample.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.livedatasample.model.NameModel;

public class NameViewModel extends ViewModel {

    // Create a LiveData with a String
    private MutableLiveData<NameModel> mCurrentName;

    public MutableLiveData<NameModel> getNameModelData() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }

// Rest of the ViewModel...
}