package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps24.myapplication2.R;
import com.model.Setting;

import java.util.List;

public class SettingApiAdapter extends RecyclerView.Adapter<SettingApiAdapter.ViewHolder> {
    public  String Tag = "SettingApiActivity";
    public List<Setting> settingList;
    Context context;

    public void settingList(List<Setting> body) {
        settingList = body;
    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.setting_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

//        holder.stImage.setImageBitmap();
    }

    @Override
    public int getItemCount() {
        return settingList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView stImage;
        TextView stText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stImage = itemView.findViewById(R.id.setting_rowimage);
            stText = itemView.findViewById(R.id.txt_title);

        }
    }
}
