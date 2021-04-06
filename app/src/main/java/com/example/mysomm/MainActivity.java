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

        dbHelper.saveToLocalDatabase("Chateau Ste Michelle Harvest","Riesling","4","This sweet Riesling offers rich flavors of ripe peaches balanced with crisp Washington Riesling acidity. It's like a bowl of fruit in a glass!","2","White","Washington","2","11","https://images.vivino.com/thumbs/VvbShQz_S4Gjlc6kYNlk-g_pb_x600.png");
        dbHelper.saveToLocalDatabase("Bacalhôa Moscatel de Setúbal","Moscatel","3","A rich fortified wine abound with orange tree flower,raisins and a smooth, sweet yet fresh finish. This wine pairs nicely with desserts made with dark chocolate or simply as a digestive with a good coffee.","2","Amber","Portugal","2","10","https://images.vivino.com/thumbs/HcwOStCNRiK-yeDzXkC_Yw_pb_x600.png");
        dbHelper.saveToLocalDatabase("Cascinetta Vietti Moscato D'Asti","Moscato","3","This Moscato d’Asti has intense aromas of peaches, rose petals and ginger. It is delicately sweet and sparkling with balanced acidity, good complexity and a finish of fresh apricots.","1","White","Italy","2","15","https://images.vivino.com/thumbs/oFLBf2lSTiqefNRdHShgog_pb_x600.png");
        dbHelper.saveToLocalDatabase("Burmester Tawny Porto","Tawny Port","5","This Tawny Port has candied fruit aromas, toasted caramel with notes of nuts, giving the wine a subtle elegance. It is full body, smooth, and on the sweet side.","3","Ruby Red","Portugal","1","15","https://images.vivino.com/thumbs/lamG2abMTqW37CzS3uTA_g_pb_x600.png");
        dbHelper.saveToLocalDatabase("Graham's 20 Year Old Tawny Port","Tawny Port","5","An excellent bouquet, with a characteristic nutty character and delicious mature fruit with hints of orange peel that is both sweet and smooth on the palate.","3","Ruby Red","Portugal","1","44","https://images.vivino.com/thumbs/XSHqBiqMSN-OViOA4o8rJg_pb_x600.png");

        dbHelper.saveToLocalDatabase("Domaine Grand Veneur","Les Champions","5","The red wines can be fruity, sweet, spicy and packed with ripe, red berries. The wines can be sweet, fruity and easy to drink.","8","Red","France","3","50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/hf5/hcd/8815668854814.png");
        dbHelper.saveToLocalDatabase("Chateau D'Esclans","Blush Rose","2","This is full of mouthwatering flavor with a lovely texture. Lots of light fruit flavors with a clean finish, this wine does well to demonstrate the power of its grape.","5","White","France","3","40","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/ha9/hbf/12357383290910.png");
        dbHelper.saveToLocalDatabase("Valserrano Rioja Reserva","Tempranillo","2","An elegant , savoury cuvee of Tempranillo and 10% Graciano with savoury tannins and fine, graceful, red berry and fresh herb notes.","8","Red","Spain","3.5","30","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/hec/h42/10069521858590.png");
        dbHelper.saveToLocalDatabase("Alta Nova Cabernet Napa","Cabernet Sauvigno","3","Aromas of concentrated red and black cherry, cassis, cranberry and pomegranate. Savory notes of olive tapenade, tar, licorice, graphite, and pepper.","8","Red","Napa Valley California","3.7","70","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/ha9/hd5/13986845949982.png");
        dbHelper.saveToLocalDatabase("Trimbach Riesling","Cuvee Emile","8","One of the firms flagship bottlings, this superb dry Riesling hails from 2 Grand Cru vineyards, Geisberg and Osterberg. Clearly one of Alsace's greatest wines.","12","White","Alsace-France","3","50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/h9d/h87/8806085197854.png");

        dbHelper.saveToLocalDatabase("Castelfeder Mont Mes", "Pinot Grigio", "1", "This is a dry white wine with relatively high acidity. These characteristics are complemented by aromas of lemon, lime, green apple and blossoms.", "2", "White", "Italy", "2", "15", "https://dco67j8qsiydp.cloudfront.net/images/products/2020/07/2019_Castelfeder_Mont_Mes_Pinot_Grigio_Vignetti_delle_Dolomiti_IGT_bottle_compressed.jpg");
        dbHelper.saveToLocalDatabase("Domaine du Clos du Fief", "Gamay", "1", "A fruity, floral and sometimes earthy light-bodied red that is the main variety planted in Beaujolais. Outside of France, Gamay has a tiny but devoted following.", "1", "Red", "France", "2", "22", "https://dco67j8qsiydp.cloudfront.net/images/products/2020/12/2019_Domaine_du_Clos_du_Fief_Tradition_Cru_Julienas_Beaujolais_France_compressed.png");
        dbHelper.saveToLocalDatabase("Martin Codax Albarino", "Albarino", "1", "Albariño wine is a delightfully refreshing coastal white that grows on the Iberian Peninsula. It’s loved for its rich stone fruit flavors, a hint of salinity, and zippy acidity", "2", "White", "Spain", "3", "15", "https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/h78/h23/12343349870622.png");
        dbHelper.saveToLocalDatabase("Chateau Saint-Roch", "Grenache", "2", "Saturated dark ruby hue. Heaps of black fruit and earth on the nose. Voluptuous and layered on the palate with dark plum and blueberry fruit.", "2", "Red", "France", "1", "25", "https://dco67j8qsiydp.cloudfront.net/images/products/2020/03/saint-roch_Bottleshot_compressed.jpg");
        dbHelper.saveToLocalDatabase("Quinta do Noval Vintage", "Port", "3", "This wine boasts plenty of black cherry preserves, crushed blackberry, crushed violets, cracked peppercorn, cardamom, cedar, rose petal, and star anise character. Taut and lean, but still full-bodied.", "3", "Red", "Portugal", "2", "125", "https://dco67j8qsiydp.cloudfront.net/images/products/2021/01/2018_Quinta_do_Noval_Vintage_Port_Douro_Valley_Portugal_bottle_compressed.png");
        dbHelper.saveToLocalDatabase("M. Chapoutier Banyuls", "Banyuls", "3", "Deep ruby-garnet. Dried fruits, crystallized orange peel and freshly cracked black pepper on the nose. Rich layers of dried plum, dark chocolate and a hint of baking spices on the palate.", "3", "Red", "France", "2", "28", "https://www.wine.com/product/images/w_480,h_600,c_fit,q_auto:good,fl_progressive/fs1gurtuqrwsvcp4zwzs.jpg");
        dbHelper.saveToLocalDatabase("Inniskillin Vidal Icewine", "Ice Wine", "3", "Aromatics of tropical fruit including mango and orange dominate, on the palate fruit flavors including peach, nectarine and lemon are balanced by crisp, lively acidity.", "3", "White", "Canada", "3", "72", "https://images.vivino.com/thumbs/BCR0dcHqTgCyi9s_kBxOUw_pb_x600.png");
        dbHelper.saveToLocalDatabase("Weingut Stadt Krems", "Grüner Veltliner", "1", "Aromatic notes of crisp green apple, lime zest, freshly picked watercress, and radish race down the middle of the palate.", "2", "White", "Austria", "3", "15", "https://dco67j8qsiydp.cloudfront.net/images/products/2021/02/2019_Weingut_Stadt_Krems_Gruner_Veltliner_Kremstal_Austria_Bottleshot_compressed.png");

        dbHelper.saveToLocalDatabase("DISTRICT SERIES CABERNET ALEXANDER VALLEY","Cabernet Sauvignon","4","The Tasting Panel-Alexander Valley, CA- Imagine an Alexander Valley Cab at this price that displays noticeably plush tannins with dark chocolate dust.","Full-Bodied","Red","California","4","$14.99","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/hef/hd1/13771982667806.png");
        dbHelper.saveToLocalDatabase("MASCOTA VINEYARDS LA MASCOTA","Cabernet Sauvignon","3","James Suckling-Mendoza, Argentina - Brambleberries, dried plums and spices with a hint of dried fruit. Fruity on the palate with juicy tannins and a medium-chewy finish. This fruitfilled Cabernet pairs well with steak.","Meduim","Red","Mendoza","2","$14.99","https://www.totalwine.com/dynamic/x220,sq/media/sys_master/twmmedia/h1b/h78/12279044636702.png");
        dbHelper.saveToLocalDatabase("ANGELINE","Pinot Noir","2","James Suckling-Mendocino County, California - Cool aromas of dried strawberries and fresh herbs. Medium body, very creamy tannins and a long, flavorful finish. Soft and fresh. Try pairing with salmon, chicken, or pasta dishes.","Medium","Red","Mendocino","2","$16.00","https://www.totalwine.com/dynamic/x220,sq/media/sys_master/twmmedia/hb9/hc4/12291914235934.png");
        dbHelper.saveToLocalDatabase("HALL RANCH ZINFANDEL PASO ROBLES","Zinfandel","4","Beverage Dynamics-Paso Robles, California - If you haven't found a Zin you like, try this one! Dense, soft tannins with dark cherry and a hint of black bramble and cinnamon. Serve with something off the grill or a nice soft goat cheese.","Full-Bodied","Red","Central COast","3","$19.99","https://www.totalwine.com/dynamic/x220,sq/media/sys_master/twmmedia/h85/h4f/13376584515614.png");
        dbHelper.saveToLocalDatabase("FIREBRAND CHARDONNAY RESERVE, 2019","Chardonnay","1"," Beverage Dynamics-California - Green apple aromas jump out of the glass and follow onto the palate with oak vanilla flavors for structure. The wine is fun, energetic and approachable. Pairs well with seafood, pasta, and mild cheese.","Full-Bodied","White","California","4","$12.99","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/h47/h51/13287128465438.png");

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