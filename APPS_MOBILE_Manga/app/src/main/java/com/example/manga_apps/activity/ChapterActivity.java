package com.example.manga_apps.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.manga_apps.R;

public class ChapterActivity extends AppCompatActivity {
    private TextView txtTitle;
    private TextView txtChapterContent;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        // Khai báo các View
        txtTitle = findViewById(R.id.txtTitle);
        txtChapterContent = findViewById(R.id.txtChapterContent);
        btnBack = findViewById(R.id.btnBack);

        // Nhận dữ liệu từ Intent
        String mangaTitle = getIntent().getStringExtra("manga_title");
        String chapterTitle = getIntent().getStringExtra("manga_chapter");


        txtTitle.setText(mangaTitle + " - " + chapterTitle);


        loadChapterData();


        btnBack.setOnClickListener(v -> finish());
    }

    private void loadChapterData() {
        txtChapterContent.setText("Danh sách chapter");
    }

}