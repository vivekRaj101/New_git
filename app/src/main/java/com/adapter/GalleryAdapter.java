package com.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps24.myapplication2.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    List<String> myList;

    public GalleryAdapter(List<String> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       // here is inflate single row item.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.singleImage.setVisibility(View.VISIBLE);
        Bitmap bitmap= BitmapFactory.decodeFile(myList.get(position));
        holder.singleImage.setImageBitmap(bitmap);
//        holder.singleImage.setImageURI(Uri.parse(myList.get(position)));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       public ImageView singleImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            singleImage = itemView.findViewById(R.id.documents_data);

        }
    }
}
