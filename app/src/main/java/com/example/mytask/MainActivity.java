package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=(SearchView)findViewById(R.id.search_view);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                recyclerView.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                GetData getData=ClientInstance.getRetrofitInstance().create(GetData.class);
                Call<List<Response>> call=getData.getAllData(query);
                call.enqueue(new Callback<List<Response>>() {
                    @Override
                    public void onResponse(Call<List<Response>> call, retrofit2.Response<List<Response>> response) {
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        if(response.body().size()>0){
                            dataAdapter=new DataAdapter(response.body(),MainActivity.this);
                            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(dataAdapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Response>> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}