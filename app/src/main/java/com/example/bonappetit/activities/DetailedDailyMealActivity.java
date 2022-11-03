package com.example.bonappetit.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bonappetit.R;
import com.example.bonappetit.adapters.DetailedDailyAdapter;
import com.example.bonappetit.models.DetailedDailyModel;
import com.example.bonappetit.ui.MyCartFragment;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_image);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);

        if(type != null && type.equalsIgnoreCase("breakfast")) {

            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.coffee,"Coffee","description","70/-","4.0","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.tea,"Tea","description","80/-","5.0","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.poha,"Poha","description","90/-","4.5","10:00 to 9:00"));
            dailyAdapter.notifyDataSetChanged();
        }

        if(type != null && type.equalsIgnoreCase("lunch")) {

            imageView.setImageResource(R.drawable.lunch);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.aloo_lunch,"Aloo Sabji","description","120/-","4.0","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.tawa_roti_lunch,"Tawa Roti","description","20/-","5.0","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.dal_lunch,"Dal","description","130/-","4.5","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.rice_lunch,"Rice","description","120/-","4.5","10:00 to 9:00"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("dinner")) {

            imageView.setImageResource(R.drawable.dinner);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.paneer_sabji_dinner,"Paneer Tikka Masala","description","150/-","4.0","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.tandoori_roti_dinner,"Tandoori Roti","description","30/-","5.0","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.dal_dinner,"Dal Fry","description","140/-","4.5","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.rice_dinner,"Jeera Rice","description","130/-","4.5","10:00 to 9:00"));
            dailyAdapter.notifyDataSetChanged();
        }
        if(type != null && type.equalsIgnoreCase("dessert")) {

            imageView.setImageResource(R.drawable.dessert);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.vanila_icecream,"Vanila Ice Cream","description","100/-","4.0","10:00 to 9:00"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.choco_ice_cream,"Chocolate Ice Cream","description","180/-","5.0","10:00 to 9:00"));
            dailyAdapter.notifyDataSetChanged();
        }

    }
    public void addto(View view) {
        Toast.makeText(DetailedDailyMealActivity.this,
                "Added to a Cart",
                Toast.LENGTH_SHORT).show();
    }
}