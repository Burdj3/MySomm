package com.example.mysomm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button wineDishButton;
    private Button wineCollectionButton;
    private Button wineSurveyButton;

    DbHelper dbHelper = new DbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wineDishButton = findViewById(R.id.wineDishButton);
        wineCollectionButton = findViewById(R.id.wineCollectionButton);
        wineSurveyButton = findViewById(R.id.wineSurveyButton);

        fillDatabase();

        wineDishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWineDishes();
            }
        });

        wineCollectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWineCollection();
            }
        });

        wineSurveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWineSurvery();
            }
        });
        }

    public void fillDatabase()
    {
        dbHelper.deleteAllRows();
        dbHelper.saveToLocalDatabase("Pacific Rim Sweet Riesling","Riesling","4","Moderately sweet with flavors of pineapple, peach, and hints of honey. The finish is bright and crisp which cleanses the palate and provides good balance to the upfront fruit.", "2", "White", "Columbia Valley, Washington", "3", "9", "https://images.vivino.com/thumbs/uX9zZ6CqS8KIWIGtqK7gGA_pb_x960.png");
        dbHelper.saveToLocalDatabase("Savannah Rosé","Rosé","5","This sweet Rose has bold flavors of strawberry, peaches, and rose petal. Fruit-forward and sweet, this would be the perfect summer and spring drink to sip on all day long!", "1", "Rosé", "Texas", "1", "15", "https://filemanager-dfw.orderport.net/FiestaVineyardWinery/Catalog/40f862a1-c4b0-42b6-9bfb-d19c1b1a9f0d-Large.png?ts=637097745979370000");
        dbHelper.saveToLocalDatabase("Hunt and Harvest Merlot","Merlot","1","The wine has lifted aromatics of red plum, dark cherry, and dusty milk chocolate. The fruit on the palate is bright with satsuma plum and red berries. The finish has touches of bitter dark chocolate.", "3", "White", "Napa Valley, California", "1", "25", "https://images.vivino.com/thumbs/uvX4ikh7QWqoRNHFbLJERA_pb_x600.png");
        dbHelper.saveToLocalDatabase("F Bomb","Red Blend","2","Juicy aromas of strawberry jam, raspberry, and red plum jump out of the glass, with a light framing of toasty vanilla oak.", "3", "Red", "Santa Barbara County, California", "2", "20", "https://images.vivino.com/thumbs/3AR_6eNgSRyJhtu2tvrbAA_pb_x960.png");
        dbHelper.saveToLocalDatabase("Lindeman's Bin 45 Cabernet","Cabernet Sauvignon","1","You can't go wrong with an affordable wine sporting deep color, good tannin structure, moderate acidity and aromas of blackcurrant, tomato leaf, dark spices and cedarwood.", "3", "Red", "Australia", "2", "7", "https://images.vivino.com/thumbs/YIaCtGWfSpOOQ-ZP9AmlOg_pb_x600.png");

        dbHelper.saveToLocalDatabase("Spier","Chenin Blanc","3","South Africa- Elegant, refreshing and well balanced, displaying aromas that are fresh and fragrant. Filled with tropical fruit, peach and mineral flavors graced with a touch of vanilla on the dry finish.","5","White","South Africa","8","10","https://www.totalwine.com/dynamic/490x/media/sys_master/twmmedia/ha1/h05/10272950124574.png");
        dbHelper.saveToLocalDatabase("Georgian Legend","Rkatsiteli","8","The typical Rkatsiteli wine is best described as restrained and refreshing, with crisp green-apple flavors and hints of quince and white peach.","2","White","Georgia","9","20","https://www.bermansfinewines.com/images/sites/bermansfinewines/labels/georgian-legend-rkatsiteli_1.jpg");
        dbHelper.saveToLocalDatabase("Sierra Vista","Barbera","3","Wonderful aromas of cherry, strawberry and blackberry complimented by notes of dried lavender and baking spices from the oak.","8","Red","Italy","10","35","https://www.sierravistawinery.com/wp-content/uploads/2019/11/FINAL-Barbera-1.2.jpg");
        dbHelper.saveToLocalDatabase("Ring David","Concord","5","The Concord wine is juicy and sweet, with an intense grape jam flavor and light finish.","8","Red","Massachusetts","5","15","https://www.kosherwine.com/media/catalog/product/cache/a4b4b513774f9733fa68038d5e7329c4/c/a/carmel-king-david-concord-15522-base-5310a9985e214b8c6cca59f289e5b3499ead252d.jpg");
        dbHelper.saveToLocalDatabase("Grand Tokai","Muscat","5","Muscat Blanc shows a range of citrus, floral and spice aromas, with a full, dry palate. Sparkling and slightly sparkling examples are typically sweeter and tend towards melon flavors, with sweet, grapey smells.","2","White","Greece","8","17","https://www.eurowinesandspirits.com.au/926-thickbox_default/muscat-blanc-2015-grand-tokaj.jpg");

        dbHelper.saveToLocalDatabase("Chateau Ste Michelle Riesling Harvest","Riesling","4","This sweet Riesling offers rich flavors of ripe peaches balanced with crisp Washington Riesling acidity. It's like a bowl of fruit in a glass!","2","White","Washington","2","11","https://images.vivino.com/thumbs/VvbShQz_S4Gjlc6kYNlk-g_pb_x600.png");
        dbHelper.saveToLocalDatabase("Bacalhôa Moscatel de Setúbal","Moscatel","3","A rich fortified wine abound with orange tree flower,raisins and a smooth, sweet yet fresh finish. This wine pairs nicely with desserts made with dark chocolate or simply as a digestive with a good coffee.","2","Amber","Portugal","2","10","https://images.vivino.com/thumbs/HcwOStCNRiK-yeDzXkC_Yw_pb_x600.png");
        dbHelper.saveToLocalDatabase("Cascinetta Vietti Moscato D'Asti","Moscato","3","This Moscato d’Asti has intense aromas of peaches, rose petals and ginger. It is delicately sweet and sparkling with balanced acidity, good complexity and a finish of fresh apricots.","1","White","Italy","2","15","https://images.vivino.com/thumbs/oFLBf2lSTiqefNRdHShgog_pb_x600.png");
        dbHelper.saveToLocalDatabase("Burmester Tawny Porto","Tawny Port","5","This Tawny Port has candied fruit aromas, toasted caramel with notes of nuts, giving the wine a subtle elegance. It is full body, smooth, and on the sweet side.","3","Ruby Red","Portugal","1","15","https://images.vivino.com/thumbs/lamG2abMTqW37CzS3uTA_g_pb_x600.png");
        dbHelper.saveToLocalDatabase("W. & J. Graham's 20 Year Old Tawny Port","Tawny Port","5","An excellent bouquet, with a characteristic nutty character and delicious mature fruit with hints of orange peel that is both sweet and smooth on the palate.","3","Ruby Red","Portugal","1","44","https://images.vivino.com/thumbs/XSHqBiqMSN-OViOA4o8rJg_pb_x600.png");
    }

    public void openWineDishes()
    {
        Intent intent = new Intent(this, WineDishes.class);
        startActivity(intent);
    }

    public void openWineCollection()
    {
        Intent intent = new Intent(this, WineDatabaseCollection.class);
        startActivity(intent);
    }

    public void openWineSurvery()
    {
        Intent intent = new Intent(this, Wine_Survey.class);
        startActivity(intent);
    }
}