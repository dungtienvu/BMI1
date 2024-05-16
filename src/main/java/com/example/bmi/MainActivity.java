package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnChuanDoan;
    EditText editTen, editChieucao, editCannang, editBMI, editChuandoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnChuanDoan = findViewById(R.id.btnBMI);
        editTen = findViewById(R.id.edtten);
        editChieucao = findViewById(R.id.edtchieucao);
        editCannang = findViewById(R.id.edtcannang);
        editBMI = findViewById(R.id.edtBMI);
        editChuandoan = findViewById(R.id.edtChuanDoan);
        btnChuanDoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double H = Double.parseDouble(editChieucao.getText()+"");
                double W = Double.parseDouble(editCannang.getText()+"");
                double BMI = W/Math.pow(H,2);
                String chuandoan = "";
                if(BMI < 18){
                    chuandoan = "Bạn gầy";
                }else if(BMI <= 24.9){
                    chuandoan = "Bạn bình thường";
                }else if(BMI <= 29.9){
                    chuandoan = "Bạn béo phì mức 1";
                }else if(BMI <= 34.9){
                    chuandoan = "Bạn béo phì mức 2";
                }else{
                    chuandoan = "Bạn béo phì mức 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                editBMI.setText(dcf.format(BMI));
                editChuandoan.setText(chuandoan);
            }
        });

    }
}