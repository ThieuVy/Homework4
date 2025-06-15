package com.example.homework4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Countries");

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        List<Fragment> fragments = new ArrayList<>();
        List<String> tabTitles = new ArrayList<>();

        // United Kingdom
        fragments.add(ContentFragment.newInstance(
                "United Kingdom",
                "The United Kingdom, officially known as the United Kingdom of Great Britain and Northern Ireland, is a sovereign country located off the northwestern coast of continental Europe.\n\n" +
                        "Capital: London\n" +
                        "Population: Approximately 67 million people\n" +
                        "Currency: British Pound Sterling (GBP)\n" +
                        "Official Language: English\n\n" +
                        "Geography:\n" +
                        "The UK consists of four countries: England, Scotland, Wales, and Northern Ireland. It is surrounded by the Atlantic Ocean, North Sea, English Channel, and Irish Sea. The landscape varies from the Scottish Highlands to the rolling hills of England.\n\n" +
                        "History:\n" +
                        "The UK has a rich history spanning thousands of years. From ancient Celtic tribes to Roman occupation, from medieval kingdoms to the British Empire, the UK has played a significant role in world history. The Industrial Revolution began here in the 18th century.\n\n" +
                        "Culture:\n" +
                        "British culture is known for its literature (Shakespeare, Dickens), music (The Beatles, Queen), and traditions like afternoon tea. The monarchy is an important cultural institution.\n\n" +
                        "Economy:\n" +
                        "The UK has the world's fifth-largest economy by GDP. Key industries include financial services, manufacturing, and technology. London is a major global financial center.",
                R.drawable.uk_flag
        ));
        tabTitles.add("UK");

        // Italy
        fragments.add(ContentFragment.newInstance(
                "Italy",
                "Italy, officially the Italian Republic, is a country located in Southern Europe, comprising the boot-shaped Italian Peninsula and several islands including Sicily and Sardinia.\n\n" +
                        "Capital: Rome\n" +
                        "Population: Approximately 60 million people\n" +
                        "Currency: Euro (EUR)\n" +
                        "Official Language: Italian\n\n" +
                        "Geography:\n" +
                        "Italy is bordered by France, Switzerland, Austria, and Slovenia. The country is home to the Alps in the north and the Apennine Mountains running down the peninsula. It has extensive coastlines along the Mediterranean Sea.\n\n" +
                        "History:\n" +
                        "Italy is the birthplace of the Roman Empire and the Renaissance. Ancient Rome was one of the most powerful civilizations in history. The Renaissance period saw remarkable achievements in art, science, and literature.\n\n" +
                        "Culture:\n" +
                        "Italian culture is renowned worldwide for its art, architecture, cuisine, and fashion. Home to masterpieces by Leonardo da Vinci, Michelangelo, and countless other artists. Italian cuisine, including pasta and pizza, is beloved globally.\n\n" +
                        "Economy:\n" +
                        "Italy has the third-largest economy in the Eurozone. Key industries include manufacturing, fashion, automotive (Ferrari, Fiat), and tourism. The country is famous for luxury goods and design.\n\n" +
                        "Famous Landmarks:\n" +
                        "The Colosseum, Vatican City, Leaning Tower of Pisa, Venice canals, and the ruins of Pompeii are among Italy's most famous attractions.",
                R.drawable.italy_flag
        ));
        tabTitles.add("Italy");

        // France
        fragments.add(ContentFragment.newInstance(
                "France",
                "France, officially the French Republic, is a country located in Western Europe, known for its rich history, culture, and contributions to art, philosophy, and cuisine.\n\n" +
                        "Capital: Paris\n" +
                        "Population: Approximately 68 million people\n" +
                        "Currency: Euro (EUR)\n" +
                        "Official Language: French\n\n" +
                        "Geography:\n" +
                        "France is bordered by Belgium, Luxembourg, Germany, Switzerland, Italy, Spain, and the Atlantic Ocean and Mediterranean Sea. The country features diverse landscapes from the Alps to the Atlantic beaches.\n\n" +
                        "History:\n" +
                        "France has a rich history including the reign of powerful monarchs, the French Revolution of 1789, and Napoleon's empire. It has been a major European power for centuries and played crucial roles in both World Wars.\n\n" +
                        "Culture:\n" +
                        "French culture is synonymous with sophistication, art, and cuisine. The country is home to the Louvre Museum, Gothic cathedrals, and the Palace of Versailles. French cuisine is considered among the world's finest.\n\n" +
                        "Economy:\n" +
                        "France has the world's seventh-largest economy. Key industries include aerospace, automotive, luxury goods, and agriculture. It's a major tourist destination and a leader in nuclear energy.\n\n" +
                        "Famous Landmarks:\n" +
                        "The Eiffel Tower, Notre-Dame Cathedral, Palace of Versailles, Mont Blanc, and the châteaux of the Loire Valley are among France's most iconic landmarks.",
                R.drawable.france_flag
        ));
        tabTitles.add("France");

        TabAdapter adapter = new TabAdapter(this, fragments, tabTitles);
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(adapter.getTabTitle(position))
        ).attach();
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}