package com.example.mytask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private List<Response> dataList;
    private Context context;

    public DataAdapter(List<Response> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getFlag()).into(holder.flag);
        holder.name.setText("Country Name: "+dataList.get(position).getName());
        holder.capital.setText("Country Capital: "+dataList.get(position).getCapital());
        holder.region.setText("Country Region: "+dataList.get(position).getRegion());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView flag;
        private TextView name,capital,region,subRegion,population,borders,languagesList;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            flag=itemView.findViewById(R.id.flag);
            name=itemView.findViewById(R.id.name);
            capital=itemView.findViewById(R.id.capital);
            region=itemView.findViewById(R.id.region);
            subRegion=itemView.findViewById(R.id.sub_region);
            population=itemView.findViewById(R.id.population);
            borders=itemView.findViewById(R.id.borders);
            languagesList=itemView.findViewById(R.id.languages_list);
        }
    }
}
