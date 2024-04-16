package edu.bzu.two_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private Button btn;
private EditText editTxtForMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnSend);
        editTxtForMessage=findViewById(R.id.editTextForMessage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickSend(View view) {
        String msg =editTxtForMessage.getText().toString();

        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("data",msg);
        startActivity(intent);

    }

    public void onClick2Send(View view) {
        Intent intent2 = new Intent(Intent.ACTION_SEND);
        intent2.putExtra(Intent.EXTRA_TEXT, "This is a sample message");
        intent2.putExtra(Intent.EXTRA_SUBJECT,"Hello");
        intent2.setType("text/plain");
        Intent chooser =Intent.createChooser(intent2,null);
        startActivity(chooser);
    }
}