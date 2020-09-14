package com.example.newsapp;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MainArticleAdapter extends RecyclerView.Adapter<MainArticleAdapter.ViewHolder> {

    private List<Article> articleArrayList;
    private Context context;
    public MainArticleAdapter(List<Article> articleList) {
        this.articleArrayList = articleArrayList;

    }

    public void setOnRecyclerViewItemClickListener(MainActivity mainActivity) {

    }

    @NonNull
    @Override
    public MainArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main_article_adapter, parent, false);
        return new MainArticleAdapter.ViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull MainArticleAdapter.ViewHolder holder, int position) {
        final Article articleModel = articleArrayList.get(position);
        if(!TextUtils.isEmpty(articleModel.getTitle())) {
            holder.titleText.setText(articleModel.getTitle());
        }
        if(!TextUtils.isEmpty(articleModel.getDescription())) {
            holder.descriptionText.setText(articleModel.getDescription());
        }
        holder.artilceAdapterParentLinear.setTag(articleModel);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView titleText;
            private TextView descriptionText;
            private LinearLayout artilceAdapterParentLinear;
            ViewHolder(View view) {
                super(view);
                titleText = view.findViewById(R.id.article_adapter_tv_title);
                descriptionText = view.findViewById(R.id.article_adapter_tv_description);

        }
    }
}
