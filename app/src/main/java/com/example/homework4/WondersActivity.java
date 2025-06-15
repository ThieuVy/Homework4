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

public class WondersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Seven Wonders of the World");

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        List<Fragment> fragments = new ArrayList<>();
        List<String> tabTitles = new ArrayList<>();

        // Great Wall of China
        fragments.add(ContentFragment.newInstance(
                "Great Wall of China",
                "The Great Wall of China is a series of fortifications that were built along the northern borders of ancient Chinese states and Imperial China as protection against nomadic invasions from the north.\n\n" +
                        "Location: Northern China\n" +
                        "Built: 7th century BC - 1644 AD\n" +
                        "Length: Over 13,000 miles (21,000 km)\n" +
                        "UNESCO World Heritage Site: 1987\n\n" +
                        "Construction:\n" +
                        "The wall was built over many centuries by different Chinese dynasties. The most famous sections were built during the Ming Dynasty (1368-1644). It was constructed using various materials including brick, stone, wood, and compressed earth.\n\n" +
                        "Purpose:\n" +
                        "Originally built for defense against invasions, the wall also served to regulate trade along the Silk Road and control immigration and emigration. Watchtowers, garrison stations, and smoke signals were used for communication.\n\n" +
                        "Myths and Facts:\n" +
                        "Contrary to popular belief, the Great Wall is not visible from space with the naked eye. However, it remains one of the most impressive architectural achievements in human history.\n\n" +
                        "Modern Significance:\n" +
                        "Today, the Great Wall is a symbol of Chinese civilization and attracts millions of tourists annually. It represents the ingenuity, persistence, and strength of the Chinese people throughout history.\n\n" +
                        "Conservation:\n" +
                        "Many sections of the wall have deteriorated over time due to natural erosion and human damage. Conservation efforts are ongoing to preserve this magnificent structure for future generations.",
                R.drawable.great_wall_of_china
        ));
        tabTitles.add("Great Wall");

        // Petra
        fragments.add(ContentFragment.newInstance(
                "Petra",
                "Petra, originally known as Raqmu, is a historic and archaeological city in southern Jordan. Famous for its rock-cut architecture and water conduit system, Petra is also called the 'Rose City' due to the color of the stone from which it is carved.\n\n" +
                        "Location: Ma'an Governorate, Jordan\n" +
                        "Established: Around 300 BC\n" +
                        "Civilization: Nabataean Kingdom\n" +
                        "UNESCO World Heritage Site: 1985\n\n" +
                        "History:\n" +
                        "Petra was the capital city of the Nabataean Kingdom and later became a major trading hub that connected China, India, and southern Arabia with Egypt, Syria, Greece, and Rome. The city flourished from the 1st century BC to the 1st century AD.\n\n" +
                        "Architecture:\n" +
                        "The city is famous for its elaborate temples, tombs, and other buildings carved directly into the sandstone cliffs. The most famous structure is Al-Khazneh (The Treasury), which stands 40 meters high and was carved from a single piece of sandstone.\n\n" +
                        "Water Management:\n" +
                        "The Nabataeans were master engineers who created an intricate system of dams, cisterns, and water channels to collect and store rainwater in this desert environment.\n\n" +
                        "Rediscovery:\n" +
                        "After being abandoned for centuries, Petra was rediscovered by Swiss explorer Johann Ludwig Burckhardt in 1812. It has since become one of Jordan's most valuable tourist attractions.\n\n" +
                        "Cultural Impact:\n" +
                        "Petra has been featured in numerous films, most notably 'Indiana Jones and the Last Crusade,' and continues to fascinate visitors with its mysterious beauty and historical significance.",
                R.drawable.petra
        ));
        tabTitles.add("Petra");

        // Christ the Redeemer
        fragments.add(ContentFragment.newInstance(
                "Christ the Redeemer",
                "Christ the Redeemer is an Art Deco statue of Jesus Christ in Rio de Janeiro, Brazil. The statue stands atop Corcovado Mountain in the Tijuca National Forest, overlooking the city of Rio de Janeiro.\n\n" +
                        "Location: Rio de Janeiro, Brazil\n" +
                        "Completed: 1931\n" +
                        "Height: 98 feet (30 meters)\n" +
                        "Designer: Paul Landowski (sculptor), Heitor da Silva Costa (engineer)\n\n" +
                        "Construction:\n" +
                        "The statue was built between 1922 and 1931 and was a collaborative effort between French sculptor Paul Landowski and Brazilian engineer Heitor da Silva Costa. The statue is made of reinforced concrete and soapstone.\n\n" +
                        "Symbolism:\n" +
                        "The statue represents Jesus Christ with arms outstretched, symbolizing peace and welcome to all visitors to Rio de Janeiro. It has become an enduring symbol of Christianity and Brazilian culture.\n\n" +
                        "Engineering Marvel:\n" +
                        "The statue weighs 635 metric tons and its arms stretch 92 feet wide. Getting the materials to the mountaintop required the construction of a railway, and the statue was built piece by piece at the summit.\n\n" +
                        "Cultural Significance:\n" +
                        "Christ the Redeemer is not only a religious symbol but also an icon of Rio de Janeiro and Brazil. It has been featured in countless movies, photographs, and postcards, making it one of the most recognizable landmarks in the world.\n\n" +
                        "Tourism:\n" +
                        "The statue attracts nearly 2 million visitors annually who come to admire both the statue itself and the panoramic views of Rio de Janeiro from Corcovado Mountain.",
                R.drawable.christ_the_redeemer
        ));
        tabTitles.add("Christ Redeemer");

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