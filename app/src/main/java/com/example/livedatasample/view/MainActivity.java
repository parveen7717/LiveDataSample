package com.example.livedatasample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.livedatasample.viewmodel.NameViewModel;
import com.example.livedatasample.R;
import com.example.livedatasample.model.NameModel;

public class MainActivity extends AppCompatActivity {
    private NameViewModel mModel;
    TextView mNameTextView,email;
    Button mButton;
    NameModel nameModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameTextView = findViewById(R.id.mNameTextView);
        email = findViewById(R.id.email);
        mButton = findViewById(R.id.mButton);
        nameModel = new NameModel();
        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(NameViewModel.class);


        // Create the observer which updates the UI.
        final Observer<NameModel> nameObserver = new Observer<NameModel>() {
            @Override
            public void onChanged(@Nullable final NameModel newName) {
                // Update the UI, in this case, a TextView.
                assert newName != null;
                mNameTextView.setText(newName.getName());
                email.setText(newName.getEmail());
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getNameModelData().observe(this, nameObserver);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameModel.setName("John Doe");
                nameModel.setEmail("johm@example.com");
                mModel.getNameModelData().setValue(nameModel);
            }
        });

    }

}


