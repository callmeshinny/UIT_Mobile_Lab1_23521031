package com.example.mobile_lab1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtMessage;
    private Button btnSend, btnContactTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);
        btnContactTop = findViewById(R.id.btnContactTop);

        btnContactTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Scroll down to contact section", Toast.LENGTH_SHORT).show();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSend();
            }
        });
    }

    private void handleSend() {
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String message = edtMessage.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            edtName.setError("Please enter your name");
            edtName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            edtEmail.setError("Please enter your email");
            edtEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(message)) {
            edtMessage.setError("Please enter your message");
            edtMessage.requestFocus();
            return;
        }

        Toast.makeText(this, "Message sent successfully!", Toast.LENGTH_LONG).show();

        edtName.setText("");
        edtEmail.setText("");
        edtMessage.setText("");
    }
}