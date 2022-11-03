package com.example.bonappetit.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bonappetit.R;
import com.example.bonappetit.models.HomeHorModel;
import com.example.bonappetit.models.HomeVerModel;
import java.util.ArrayList;

@SuppressWarnings({"ALL", "CanBeFinal"})
public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = 0;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int pos = holder.getAdapterPosition();
        holder.imageView.setImageResource(list.get(pos).getImage());
        holder.name.setText(list.get(pos).getName());
        if(check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.cheese_burger, "Cheese Burger", "10:00 - 23:00", "4.9", "80/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.vadapav_butter, "Vada Pav", "10:00 - 23:00", "4.5", "80/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.samosa, "Samosa ", "11:00 - 23:00", "4.9", "70/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.cheese_vadapav, "Cheese Vada Pav", "10:00 - 22:00", "4.1", "100/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.paneer_pizza, "Paneer Pizza", "10:00 - 23:00", "4.5", "100/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.choco_ice_cream, "Chocolate Ice Cream", "10:00 - 23:00", "4.9", "180/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.vanila_icecream, "Vanila Ice Cream", "10:00 - 23:00", "4.5", "100/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.vadapav_butter, "Butter Vada Pav", "10:00 - 23:00", "4.5", "100/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.cheese_pizza, "Cheese Pizza", "11:00 - 23:00", "4.2", "160/-"));
            homeVerModels.add(new HomeVerModel(R.drawable.mushroom_pizza, "Mushroom Pizza", "10:00 - 22:00", "4.5", "180/-"));

            updateVerticalRec.callBack(pos, homeVerModels);
            check = false;
        }
        //noinspection Convert2Lambda
        holder.cardView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    row_index = pos;
                    notifyDataSetChanged();

                    if(pos == 0) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.paneer_pizza,"Paneer Pizza","10:00 - 23:00","4.5","150/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cheese_pizza,"Cheese Pizza","11:00 - 23:00","4.2","160/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.mushroom_pizza,"Mushroom Pizza","10:00 - 22:00","4.1","180/-"));

                        updateVerticalRec.callBack(pos,homeVerModels);
                    }
                    else if(pos == 1) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.cheese_burger,"Cheese Burger","10:00 - 23:00","4.9","80/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.chicken_burger,"Chicken Burger","10:00 - 23:00","4.5","100/-"));

                        updateVerticalRec.callBack(pos,homeVerModels);
                    }
                    else if(pos == 2) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.vadapav_butter,"Butter Vadapav","10:00 - 23:00","4.9","90/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.cheese_vadapav,"Cheese Vadapav","10:00 - 23:00","4.5","100/-"));

                        updateVerticalRec.callBack(pos,homeVerModels);
                    }
                    else if(pos == 3) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.samosa,"Samosa","10:00 - 23:00","4.9","70/-"));

                        updateVerticalRec.callBack(pos,homeVerModels);
                    }
                    else if(pos == 4) {
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.choco_ice_cream,"Chocolate Ice Cream","10:00 - 23:00","4.9","180/-"));
                        homeVerModels.add(new HomeVerModel(R.drawable.vanila_icecream,"Vanila Ice Cream","10:00 - 23:00","4.5","100/-"));

                        updateVerticalRec.callBack(pos,homeVerModels);
                    }
                }
            });
            if(select) {
                if (pos == 0) {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                    select=false;
                }
            }
            else {
                if (row_index == pos) {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
                else {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }
            }
        }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @SuppressWarnings({"InnerClassMayBeStatic", "CanBeFinal"})
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);
            cardView=itemView.findViewById(R.id.cardView);

        }
    }
}