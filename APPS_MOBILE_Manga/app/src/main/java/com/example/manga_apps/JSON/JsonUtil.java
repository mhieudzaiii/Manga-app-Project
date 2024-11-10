package com.example.manga_apps.JSON;

import android.content.Context;
import android.util.Log;

import com.example.manga_apps.object.Manga;

import org.json.JSONArray;
import org.json.JSONException;


import java.io.InputStream;
import java.util.ArrayList;

public class JsonUtil {
    public static ArrayList<Manga> loadMangaData(Context context) {
        ArrayList<Manga> mangaList = new ArrayList<>();

        try {
            // Đọc file JSON từ assets
            InputStream is = context.getAssets().open("manga_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Chuyển đổi nội dung file thành chuỗi
            String json = new String(buffer, "UTF-8");

            // Phân tích chuỗi JSON thành mảng
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                String title = jsonArray.getJSONObject(i).getString("title");
                String chapter = jsonArray.getJSONObject(i).getString("chapter");
                String image = jsonArray.getJSONObject(i).getString("image");

                // Thêm vào danh sách Manga
                mangaList.add(new Manga(title, chapter, image));
            }
        } catch (Exception e) {
            Log.e("JsonUtil", "Error loading JSON data", e);
        }

        return mangaList;
    }
}
