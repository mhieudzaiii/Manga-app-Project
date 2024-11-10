package com.example.manga_apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.manga_apps.JSON.JsonUtil;
import com.example.manga_apps.activity.ChapterActivity;
import com.example.manga_apps.adapter.MangaAdapter;
import com.example.manga_apps.object.Manga;

import java.util.ArrayList;

public class Seed1 extends AppCompatActivity {

    GridView gdvDSTruyen;
    MangaAdapter adapter;
    ArrayList<Manga> mangaArrayList;
    EditText edtTimKiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seed1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        anhXa();
        setUp();
        setClik();


    }
    private void init(){

        mangaArrayList = JsonUtil.loadMangaData(this);

        adapter = new MangaAdapter(this, 0, mangaArrayList);

        mangaArrayList = new ArrayList<>();
        mangaArrayList.add(new Manga("Smiley - Cười Lên","Chapter 90","https://ddntcthcd.com/nettruyen/thumb/smiley-cuoi-len.jpg"));
        mangaArrayList.add(new Manga("Kuchi Ga Saketemo Kimi Ni Wa (2020)","Chapter 50","https://ddntcthcd.com/nettruyen/thumb/kuchi-ga-saketemo-kimi-ni-wa-2020.jpg"));
        mangaArrayList.add(new Manga("Lai Sinh Bất Kiến","Chapter 151","https://ddntcthcd.com/nettruyen/thumb/lai-sinh-bat-kien.jpg"));
        mangaArrayList.add(new Manga("Shounen No Abyss","Chapter 167","https://ddntcthcd.com/nettruyen/thumb/shounen-no-abyss.jpg"));
        mangaArrayList.add(new Manga("Shikabane-Ze","Chapter 15","https://ddntcthcd.com/nettruyen/thumb/shikabane-ze.jpg"));
        mangaArrayList.add(new Manga("Rồi anh sẽ phải muốn yêu em","Chapter 37","https://ddntcthcd.com/nettruyen/thumb/roi-anh-se-phai-muon-yeu-em.jpg"));
        mangaArrayList.add(new Manga("Tiền Đạo Số 1","Chapter 258","https://ddntcthcd.com/nettruyen/thumb/tien-dao-so-1.jpg"));
        mangaArrayList.add(new Manga("Tokyo Ghoul:re","Chapter 179","https://ddntcthcd.com/nettruyen/thumb/tokyo-ghoulre.jpg"));
        mangaArrayList.add(new Manga("Ma Nữ Cứng Đầu","Chapter 209.5","https://ddntcthcd.com/nettruyen/thumb/ma-nu-cung-dau.jpg"));
        mangaArrayList.add(new Manga("Kimi No Okasan O Boku Ni Kudasai!","Chapter 29","https://ddntcthcd.com/nettruyen/thumb/kimi-no-okasan-o-boku-ni-kudasai.jpg"));
        mangaArrayList.add(new Manga("Rekkyou Sensen","Chapter 8","https://ddntcthcd.com/nettruyen/thumb/rekkyou-sensen.jpg"));
        mangaArrayList.add(new Manga("Tôi Có Thể Nhìn Thấy Chúng...","Chapter 65","https://ddntcthcd.com/nettruyen/thumb/toi-co-the-nhin-thay-chung.jpg"));

        adapter = new MangaAdapter(this,0,mangaArrayList);
    }
    private void anhXa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
        edtTimKiem = findViewById(R.id.edtTimKiem);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClik(){
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTimKiem.getText().toString();
                adapter.sortTruyen(s);
            }
        });

        gdvDSTruyen.setOnItemClickListener((parent, view, position, id) -> {
            Manga selectedManga = mangaArrayList.get(position);

            // Tạo intent để chuyển đến ChapterActivity
            Intent intent = new Intent(Seed1.this, ChapterActivity.class);
            intent.putExtra("manga_title", selectedManga.getTenManga());
            intent.putExtra("manga_chapter", selectedManga.getTenchap());



            startActivity(intent);
        });
    }
}