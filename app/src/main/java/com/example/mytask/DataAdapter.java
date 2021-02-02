package com.example.mytask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


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
        String neighbour="",language="";
        for(int i=0;i<dataList.get(position).getBorders().size();i++){
            if(i==dataList.get(position).getBorders().size()-1){
                neighbour=neighbour+dataList.get(position).getBorders().get(i);
            }else {
                neighbour=neighbour+dataList.get(position).getBorders().get(i)+",";
            }
        }
        for(int i=0;i<dataList.get(position).getLanguagesList().size();i++){
            if(i==dataList.get(position).getLanguagesList().size()-1){
                language=language+dataList.get(position).getLanguagesList().get(i).getName();
            } else{
                language=language+dataList.get(position).getLanguagesList().get(i).getName()+",";
            }
        }
        Utils.fetchSvg(context,dataList.get(position).getFlag(),holder.flag);
        holder.name.setText("Country Name: "+dataList.get(position).getName());
        holder.capital.setText("Country Capital: "+dataList.get(position).getCapital());
        holder.region.setText("Country Region: "+dataList.get(position).getRegion());
        holder.subRegion.setText("Country Subregion: "+dataList.get(position).getSubRegion());
        holder.population.setText("Country Population: "+String.valueOf(dataList.get(position).getPopulation()));
        holder.borders.setText("Neighbouring Countries: "+neighbour);
        holder.languagesList.setText("Languages in the Country: "+language);
    }

    @Override
    public int getItemCount() {
        if(dataList.size()==0){
            return 0;
        }
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
