package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    EditText textIDSV, textNameSV;
    Button btnBack, btnSave;
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mData = FirebaseDatabase.getInstance().getReference();

        AnhXa();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add();
            }
        });
    }

    private void Add(){
        SinhVien sv = new SinhVien();
        sv.idSV = textIDSV.getText().toString();
        sv.nameSV = textNameSV.getText().toString();

        mData.child("SinhVien").push().setValue(sv);
    }

    private void AnhXa(){
        textIDSV = findViewById(R.id.editTextIdSV_AddOrEdit);
        textNameSV = findViewById(R.id.editTextHoTen_AddOrEdit);
        btnBack = findViewById(R.id.buttonBack);
        btnSave = findViewById(R.id.buttonSave);
    }
}