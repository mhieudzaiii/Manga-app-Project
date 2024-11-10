package com.example.manga_apps.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.manga_apps.R;
import com.example.manga_apps.object.Manga;

import java.util.ArrayList;
import java.util.List;

public class MangaAdapter extends ArrayAdapter<Manga> {
    private Context ct;
    private ArrayList<Manga> arr;
    public MangaAdapter(@NonNull Context context, int resource, @NonNull List<Manga> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }


    public void sortTruyen(String s) {
        s = s.toUpperCase();
        ArrayList<Manga> filteredList = new ArrayList<>();

        for (Manga t : arr) {
            String ten = t.getTenManga().toUpperCase();
            if (ten.contains(s)) {
                filteredList.add(t);
            }
        }

        arr.clear();
        arr.addAll(filteredList);

        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_truyen, null);
        }
        if (arr.size()>0){
            Manga manga = this.arr.get(position);
            TextView tenTenTruyen = convertView.findViewById(R.id.txvTenTruyen);
            TextView tenTenChap = convertView.findViewById(R.id.txvTenChap);
            ImageView imgAnhTruyen = convertView.findViewById(R.id.imgAnhTruyen);

            tenTenTruyen.setText(manga.getTenManga());
            tenTenChap.setText(manga.getTenchap());
            Glide.with(this.ct).load(manga.getLinkAnh()).into(imgAnhTruyen);

        }
        return convertView;
    }
}