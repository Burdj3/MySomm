package com.example.mysomm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StarchWineRecommendations extends AppCompatActivity {

    private RecyclerView wineRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starch_wine_recommendations);

        wineRecyclerView = findViewById(R.id.starchWineDishRecyclerView);

        ArrayList<Wine> wines = new ArrayList<>();
        wines.add(new Wine("Cabernet Sauvignon", "Color of Black-Berry", "Highly acidic and savory character", "Its primary flavor is that of black currant, with overtones of several other flavors, like mint, cherry, vanilla, tobacco, and even other overtones, like coffee, spice, cedar, cassis, etc. This complex and layered wine is prized for its high tannin content, which makes it perfect for pasta prepared with thick tomato-based sauces. The high acidic content complements the acidity from the tomatoes, giving the entire meal the harmony it requires."));
        wines.add(new Wine("Pinor Noir", "Red", "Light Structure", "This light red wine variety goes well with tomato-based pastas because of its lighter structure. Its fragrant, earthy character complements light tomato-based sauces like marinara. However, the fruitier versions of this wine complement cream-based pasta sauces, so it’s a versatile wine. Moreover, it also goes well with basil; thus, it can also be had with basil pesto sauce-based pasta. It also goes well with mushroom pastas. Strawberry and black cherry are common Pinot Noir flavors consumed, with the more earthy flavors being comparatively more expensive. Since Pinot Noir is also known as the sensual wine, it’s perfect for a romantic dinner!"));
        wines.add(new Wine("Zinfandel", "White", "Rich Dark Color", "This wine is known for its rich, dark color and high tannin and alcohol content. It’s available in light, medium, and full-bodied varieties, varying on the basis of the spice and tannin content. The tannin content makes it a suitable candidate to be served with tomato-based pastas. Moreover, its spicy, peppery flavor, with a hint of berries and cherries complements the tomato sauce well. However, the lighter versions, like the white Zinfandel variety, can also be had with the cream-based pastas. This wine also goes well with spaghetti and meatballs, sausage-based sauces, and bolognese."));
        wines.add(new Wine("Chardonnay", "White", "Terroir and Oak", "America’s number 1 white wine variety, Chardonnay is the most consumed variety in the world. This world-famous wine pairs well with pasta dishes prepared with creamy sauces. In fact, this wine complements cream-based pastas better than any other pasta variety. Classic Italian pasta dishes, like spaghetti carbonara also go well with lightly oaked or oaked Chardonnay. This wine also goes well with mushroom-based pastas and vegetable lasagnas. If you’re preparing vegetarian pasta, young Chardonnay is the wine for you! There’s no need to look any further, as Chardonnay and vegetable pastas are just made for each other. Light Chardonnay also goes well with cheese-based sauces and green pesto sauces."));


        WineRecyclerViewAdapter adapter = new WineRecyclerViewAdapter(this);
        adapter.setWines(wines);

        wineRecyclerView.setAdapter(adapter);
        wineRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
