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
        dbHelper.saveToLocalDatabase("Pacific Rim Sweet Riesling","Riesling","Between","Moderately sweet with flavors of pineapple, peach, and hints of honey. The finish is bright and crisp which cleanses the palate and provides good balance to the upfront fruit.", "Light", "White", "Columbia Valley, Washington", "Not Very", "Less than $50", "https://images.vivino.com/thumbs/uX9zZ6CqS8KIWIGtqK7gGA_pb_x960.png");
        dbHelper.saveToLocalDatabase("Savannah Rosé","Rosé","Between","This sweet Rose has bold flavors of strawberry, peaches, and rose petal. Fruit-forward and sweet, this would be the perfect summer and spring drink to sip on all day long!", "Light", "Red", "Texas", "Not Very", "Less than $50", "https://filemanager-dfw.orderport.net/FiestaVineyardWinery/Catalog/40f862a1-c4b0-42b6-9bfb-d19c1b1a9f0d-Large.png?ts=637097745979370000");
        dbHelper.saveToLocalDatabase("Hunt and Harvest Merlot","Merlot","Dry","The wine has lifted aromatics of red plum, dark cherry, and dusty milk chocolate. The fruit on the palate is bright with satsuma plum and red berries. The finish has touches of bitter dark chocolate.", "Light", "White", "Napa Valley, California", "Not Very", "Less than $50", "https://images.vivino.com/thumbs/uvX4ikh7QWqoRNHFbLJERA_pb_x600.png");
        dbHelper.saveToLocalDatabase("F Bomb","Red Blend","Dry","Juicy aromas of strawberry jam, raspberry, and red plum jump out of the glass, with a light framing of toasty vanilla oak.", "Light", "Red", "Santa Barbara County, California", "Not Very", "Less than $50", "https://images.vivino.com/thumbs/3AR_6eNgSRyJhtu2tvrbAA_pb_x960.png");
        dbHelper.saveToLocalDatabase("Lindeman's Bin 45 Cabernet","Cabernet Sauvignon","Dry","You can't go wrong with an affordable wine sporting deep color, good tannin structure, moderate acidity and aromas of blackcurrant, tomato leaf, dark spices and cedarwood.", "Light", "Red", "Australia", "Not Very", "Less than $50", "https://images.vivino.com/thumbs/YIaCtGWfSpOOQ-ZP9AmlOg_pb_x600.png");

        dbHelper.saveToLocalDatabase("Spier","Chenin Blanc","Dry","South Africa- Elegant, refreshing and well balanced, displaying aromas that are fresh and fragrant. Filled with tropical fruit, peach and mineral flavors graced with a touch of vanilla on the dry finish.","Light","Red","South Africa","Not Very","$50","https://www.totalwine.com/dynamic/490x/media/sys_master/twmmedia/ha1/h05/10272950124574.png");
        dbHelper.saveToLocalDatabase("Georgian Legend","Rkatsiteli","Sweet","The typical Rkatsiteli wine is best described as restrained and refreshing, with crisp green-apple flavors and hints of quince and white peach.","Light","White","Georgia","Very","Less than $50","https://www.bermansfinewines.com/images/sites/bermansfinewines/labels/georgian-legend-rkatsiteli_1.jpg");
        dbHelper.saveToLocalDatabase("Sierra Vista","Barbera","Dry","Wonderful aromas of cherry, strawberry and blackberry complimented by notes of dried lavender and baking spices from the oak.","Heavy","Red","Italy","Very","Less than $50","https://www.sierravistawinery.com/wp-content/uploads/2019/11/FINAL-Barbera-1.2.jpg");
        dbHelper.saveToLocalDatabase("Ring David","Concord","Between","The Concord wine is juicy and sweet, with an intense grape jam flavor and light finish.","Heavy","Red","Massachusetts","Somewhat","Less than $50","https://www.kosherwine.com/media/catalog/product/cache/a4b4b513774f9733fa68038d5e7329c4/c/a/carmel-king-david-concord-15522-base-5310a9985e214b8c6cca59f289e5b3499ead252d.jpg");
        dbHelper.saveToLocalDatabase("Grand Tokai","Muscat","Between","Muscat Blanc shows a range of citrus, floral and spice aromas, with a full, dry palate. Sparkling and slightly sparkling examples are typically sweeter and tend towards melon flavors, with sweet, grapey smells.","Light","White","Greece","Very","Less than $50","https://www.eurowinesandspirits.com.au/926-thickbox_default/muscat-blanc-2015-grand-tokaj.jpg");

        dbHelper.saveToLocalDatabase("Chateau Ste Michelle Harvest","Riesling","Between","This sweet Riesling offers rich flavors of ripe peaches balanced with crisp Washington Riesling acidity. It's like a bowl of fruit in a glass!","Light","White","Washington","Not Very","Less than $50","https://images.vivino.com/thumbs/VvbShQz_S4Gjlc6kYNlk-g_pb_x600.png");
        dbHelper.saveToLocalDatabase("Bacalhôa Moscatel de Setúbal","Moscatel","Dry","A rich fortified wine abound with orange tree flower,raisins and a smooth, sweet yet fresh finish. This wine pairs nicely with desserts made with dark chocolate or simply as a digestive with a good coffee.","Light","Red","Portugal","Not Very","Less than $50","https://images.vivino.com/thumbs/HcwOStCNRiK-yeDzXkC_Yw_pb_x600.png");
        dbHelper.saveToLocalDatabase("Cascinetta Vietti Moscato D'Asti","Moscato","Dry","This Moscato d’Asti has intense aromas of peaches, rose petals and ginger. It is delicately sweet and sparkling with balanced acidity, good complexity and a finish of fresh apricots.","Light","White","Italy","Not Very","Less than $50","https://images.vivino.com/thumbs/oFLBf2lSTiqefNRdHShgog_pb_x600.png");
        dbHelper.saveToLocalDatabase("Burmester Tawny Porto","Tawny Port","Between","This Tawny Port has candied fruit aromas, toasted caramel with notes of nuts, giving the wine a subtle elegance. It is full body, smooth, and on the sweet side.","Light","Red","Portugal","Not Very","Less than $50","https://images.vivino.com/thumbs/lamG2abMTqW37CzS3uTA_g_pb_x600.png");
        dbHelper.saveToLocalDatabase("Graham's 20 Year Old Tawny Port","Tawny Port","Between","An excellent bouquet, with a characteristic nutty character and delicious mature fruit with hints of orange peel that is both sweet and smooth on the palate.","Light","Red","Portugal","Not Very","Less than $50","https://images.vivino.com/thumbs/XSHqBiqMSN-OViOA4o8rJg_pb_x600.png");

        dbHelper.saveToLocalDatabase("Domaine Grand Veneur","Les Champions","Between","The red wines can be fruity, sweet, spicy and packed with ripe, red berries. The wines can be sweet, fruity and easy to drink.","Heavy","Red","France","Not Very","Greater than $50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/hf5/hcd/8815668854814.png");
        dbHelper.saveToLocalDatabase("Chateau D'Esclans","Blush Rose","Dry","This is full of mouthwatering flavor with a lovely texture. Lots of light fruit flavors with a clean finish, this wine does well to demonstrate the power of its grape.","Medium","White","France","Not Very","Less than $50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/ha9/hbf/12357383290910.png");
        dbHelper.saveToLocalDatabase("Valserrano Rioja Reserva","Tempranillo","Dry","An elegant , savoury cuvee of Tempranillo and 10% Graciano with savoury tannins and fine, graceful, red berry and fresh herb notes.","Heavy","Red","Spain","Not Very","Less than $50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/hec/h42/10069521858590.png");
        dbHelper.saveToLocalDatabase("Alta Nova Cabernet Napa","Cabernet Sauvigno","Dry","Aromas of concentrated red and black cherry, cassis, cranberry and pomegranate. Savory notes of olive tapenade, tar, licorice, graphite, and pepper.","Heavy","Red","Napa Valley California","Somewhat","Greater than $50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/ha9/hd5/13986845949982.png");
        dbHelper.saveToLocalDatabase("Trimbach Riesling","Cuvee Emile","Sweet","One of the firms flagship bottlings, this superb dry Riesling hails from 2 Grand Cru vineyards, Geisberg and Osterberg. Clearly one of Alsace's greatest wines.","Heavy","White","Alsace-France","Not Very","Greater than $50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/h9d/h87/8806085197854.png");

        dbHelper.saveToLocalDatabase("Castelfeder Mont Mes", "Pinot Grigio", "Dry", "This is a dry white wine with relatively high acidity. These characteristics are complemented by aromas of lemon, lime, green apple and blossoms.", "Light", "White", "Italy", "Not Very", "Less than $50", "https://dco67j8qsiydp.cloudfront.net/images/products/2020/07/2019_Castelfeder_Mont_Mes_Pinot_Grigio_Vignetti_delle_Dolomiti_IGT_bottle_compressed.jpg");
        dbHelper.saveToLocalDatabase("Domaine du Clos du Fief", "Gamay", "Dry", "A fruity, floral and sometimes earthy light-bodied red that is the main variety planted in Beaujolais. Outside of France, Gamay has a tiny but devoted following.", "Light", "Red", "France", "Not Very", "Less than $50", "https://dco67j8qsiydp.cloudfront.net/images/products/2020/12/2019_Domaine_du_Clos_du_Fief_Tradition_Cru_Julienas_Beaujolais_France_compressed.png");
        dbHelper.saveToLocalDatabase("Martin Codax Albarino", "Albarino", "Dry", "Albariño wine is a delightfully refreshing coastal white that grows on the Iberian Peninsula. It’s loved for its rich stone fruit flavors, a hint of salinity, and zippy acidity", "Light", "White", "Spain", "Not Very", "Less than $50", "https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/h78/h23/12343349870622.png");
        dbHelper.saveToLocalDatabase("Chateau Saint-Roch", "Grenache", "Dry", "Saturated dark ruby hue. Heaps of black fruit and earth on the nose. Voluptuous and layered on the palate with dark plum and blueberry fruit.", "Light", "Red", "France", "Not Very", "Less than $50", "https://dco67j8qsiydp.cloudfront.net/images/products/2020/03/saint-roch_Bottleshot_compressed.jpg");
        dbHelper.saveToLocalDatabase("Quinta do Noval Vintage", "Port", "Dry", "This wine boasts plenty of black cherry preserves, crushed blackberry, crushed violets, cracked peppercorn, cardamom, cedar, rose petal, and star anise character. Taut and lean, but still full-bodied.", "Light", "Red", "Portugal", "Not Very", "Greater than $50", "https://dco67j8qsiydp.cloudfront.net/images/products/2021/01/2018_Quinta_do_Noval_Vintage_Port_Douro_Valley_Portugal_bottle_compressed.png");
        dbHelper.saveToLocalDatabase("M. Chapoutier Banyuls", "Banyuls", "Dry", "Deep ruby-garnet. Dried fruits, crystallized orange peel and freshly cracked black pepper on the nose. Rich layers of dried plum, dark chocolate and a hint of baking spices on the palate.", "Light", "Red", "France", "Not Very", "Less than $50", "https://www.wine.com/product/images/w_480,h_600,c_fit,q_auto:good,fl_progressive/fs1gurtuqrwsvcp4zwzs.jpg");
        dbHelper.saveToLocalDatabase("Inniskillin Vidal Icewine", "Ice Wine", "Dry", "Aromatics of tropical fruit including mango and orange dominate, on the palate fruit flavors including peach, nectarine and lemon are balanced by crisp, lively acidity.", "Light", "White", "Canada", "Not Very", "Greater than $50", "https://images.vivino.com/thumbs/BCR0dcHqTgCyi9s_kBxOUw_pb_x600.png");
        dbHelper.saveToLocalDatabase("Weingut Stadt Krems", "Grüner Veltliner", "Dry", "Aromatic notes of crisp green apple, lime zest, freshly picked watercress, and radish race down the middle of the palate.", "Light", "White", "Austria", "Not Very", "Less than $50", "https://dco67j8qsiydp.cloudfront.net/images/products/2021/02/2019_Weingut_Stadt_Krems_Gruner_Veltliner_Kremstal_Austria_Bottleshot_compressed.png");

        dbHelper.saveToLocalDatabase("DISTRICT SERIES CABERNET ALEXANDER VALLEY, 2019","Cabernet Sauvignon","Between","The Tasting Panel-Alexander Valley, CA- Imagine an Alexander Valley Cab at this price that displays noticeably plush tannins with dark chocolate dust. Blueberry notes are generous and rich, and a dollop of Cabernet Franc adds a note of dried heather.","Heavy","Red","California","Somewhat","Less than $50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/hef/hd1/13771982667806.png");
        dbHelper.saveToLocalDatabase("MASCOTA VINEYARDS LA MASCOTA CABERNET SAUVIGNON, 2018","Cabernet Sauvignon","Dry","James Suckling-Mendoza, Argentina - Brambleberries, dried plums and spices with a hint of dried fruit. Fruity on the palate with juicy tannins and a medium-chewy finish. This fruitfilled Cabernet pairs well with steak.","Medium","Red","Mendoza","Not Very","Less than $50","https://www.totalwine.com/dynamic/x220,sq/media/sys_master/twmmedia/h1b/h78/12279044636702.png");
        dbHelper.saveToLocalDatabase("ANGELINE PINOT NOIR RESERVE, 2018","Pinot Noir","Dry","James Suckling-Mendocino County, California - Cool aromas of dried strawberries and fresh herbs. Medium body, very creamy tannins and a long, flavorful finish. Soft and fresh. Try pairing with salmon, chicken, or pasta dishes.","Medium","Red","Mendocino","Not Very","Less than $50","https://www.totalwine.com/dynamic/x220,sq/media/sys_master/twmmedia/hb9/hc4/12291914235934.png");
        dbHelper.saveToLocalDatabase("HALL RANCH ZINFANDEL PASO ROBLES, 2018","Zinfandel","Between","Beverage Dynamics-Paso Robles, California - If you haven't found a Zin you like, try this one! Dense, soft tannins with dark cherry and a hint of black bramble and cinnamon. Serve with something off the grill or a nice soft goat cheese.","Heavy","Red","Central Coast","Not Very","Less than $50","https://www.totalwine.com/dynamic/x220,sq/media/sys_master/twmmedia/h85/h4f/13376584515614.png");
        dbHelper.saveToLocalDatabase("FIREBRAND CHARDONNAY RESERVE, 2019","Chardonnay","Dry"," Beverage Dynamics-California - Green apple aromas jump out of the glass and follow onto the palate with oak vanilla flavors for structure. The wine is fun, energetic and approachable. Pairs well with seafood, pasta, and mild cheese.","Heavy","White","California","Somewhat","Less than $50","https://www.totalwine.com/dynamic/x490,sq/media/sys_master/twmmedia/h47/h51/13287128465438.png");
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