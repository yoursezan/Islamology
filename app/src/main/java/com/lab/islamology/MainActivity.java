package com.lab.islamology;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Collapsing Toolbar
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Islamology");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set Profile Photo Click Listener
        ImageView profilePhoto = findViewById(R.id.profile_photo);
        profilePhoto.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });


        // RecyclerView setup
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Card data
        List<CardItem> cardItems = new ArrayList<>();
        cardItems.add(new CardItem("Ramadan", "card_ramadan"));
        cardItems.add(new CardItem("Namaz", "card_namaz"));
        cardItems.add(new CardItem("99 Names of Allah", "card_99_names"));
        cardItems.add(new CardItem("Al-Quran", "card_al_quran"));
        cardItems.add(new CardItem("Dua & Dhikr", "card_dua_dhikr"));
        cardItems.add(new CardItem("I am Feeling", "card_i_am_feeling"));
        cardItems.add(new CardItem("Prophet Muhammad Saw", "card_prophet_muhammad"));
        cardItems.add(new CardItem("All Hadis", "card_all_hadis"));
        cardItems.add(new CardItem("Islamic Calendar", "card_islamic_calendar"));
        cardItems.add(new CardItem("History of Prophets", "card_history_prophets"));

        // Set adapter
        CardAdapter adapter = new CardAdapter(cardItems);
        recyclerView.setAdapter(adapter);
    }
}

class CardItem {
    private final String name;
    private final String id;

    public CardItem(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private final List<CardItem> items;

    public CardAdapter(List<CardItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardItem item = items.get(position);
        holder.cardTitle.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        private final TextView cardTitle;
        private final CardView cardView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            cardTitle = itemView.findViewById(R.id.card_title);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}