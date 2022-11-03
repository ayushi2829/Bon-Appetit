package com.example.bonappetit.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bonappetit.R;
import com.example.bonappetit.activities.DetailedDailyMealActivity;
import com.example.bonappetit.models.DailyMealModel;
import com.example.bonappetit.models.RecipesModel;
import com.squareup.picasso.Picasso;

import java.util.List;

@SuppressWarnings("ALL")
public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewHolder> {

    Context context;
    List<DailyMealModel> list;

    public DailyMealAdapter(Context context, List<DailyMealModel> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_meal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int pos = holder.getAdapterPosition();

        Picasso.get().load(list.get(pos).getImage()).error(R.drawable.aloo_lunch).into(holder.imageView);
        holder.name.setText(list.get(pos).getName());
        holder.description.setText(list.get(pos).getDescription());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedDailyMealActivity.class);
                intent.putExtra("type",list.get(pos).getType());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.dinner);
            name = itemView.findViewById(R.id.dinner_txt);
            description = itemView.findViewById(R.id.description);

        }
    }
}
