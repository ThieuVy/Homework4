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

public class MuseumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Famous Museums");

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        List<Fragment> fragments = new ArrayList<>();
        List<String> tabTitles = new ArrayList<>();

        // Louvre Museum
        fragments.add(ContentFragment.newInstance(
                "Louvre Museum",
                "The Louvre Museum is the world's most-visited museum and a historic landmark in Paris, France. It is the world's largest art museum and a former royal palace.\n\n" +
                        "Location: Paris, France\n" +
                        "Opened: 1793\n" +
                        "Annual Visitors: Over 9 million\n" +
                        "Collection Size: Over 380,000 objects\n\n" +
                        "History:\n" +
                        "Originally built as a fortress in the late 12th century, the Louvre became a royal residence before being converted into a public museum during the French Revolution. The iconic glass pyramid entrance was added in 1989.\n\n" +
                        "Famous Artworks:\n" +
                        "The Louvre houses some of the world's most famous artworks, including Leonardo da Vinci's Mona Lisa, the Venus de Milo, and the Winged Victory of Samothrace. The museum's collection spans from ancient civilizations to the mid-19th century.\n\n" +
                        "Architecture:\n" +
                        "The museum complex consists of the main palace and its courtyards, covering over 60,000 square meters of exhibition space. The modern glass pyramid designed by I.M. Pei serves as the main entrance.\n\n" +
                        "Cultural Impact:\n" +
                        "The Louvre is not just a museum but a symbol of French culture and artistic heritage. It has influenced museum design and curation practices worldwide and continues to be a major cultural destination.",
                R.drawable.louvre_museum
        ));
        tabTitles.add("Louvre");

        // British Museum
        fragments.add(ContentFragment.newInstance(
                "British Museum",
                "The British Museum is a public museum dedicated to human history, art and culture located in the Bloomsbury area of London. Its permanent collection of eight million works is among the largest and most comprehensive in existence.\n\n" +
                        "Location: London, United Kingdom\n" +
                        "Founded: 1753\n" +
                        "Annual Visitors: Over 6 million\n" +
                        "Collection Size: Over 8 million objects\n\n" +
                        "History:\n" +
                        "Founded in 1753, the British Museum was the first national public museum in the world. It began with the collection of Sir Hans Sloane and has grown through acquisitions, donations, and archaeological expeditions.\n\n" +
                        "Notable Collections:\n" +
                        "The museum houses treasures from around the world, including the Rosetta Stone, Egyptian mummies, the Elgin Marbles from the Parthenon, and the Lewis Chessmen. It covers two million years of human history and culture.\n\n" +
                        "The Great Court:\n" +
                        "The Queen Elizabeth II Great Court, designed by Norman Foster, is the largest covered square in Europe. The circular Reading Room at its center was once part of the British Library.\n\n" +
                        "Research and Education:\n" +
                        "Beyond its role as a museum, the British Museum is a leading research institution. It conducts archaeological expeditions, publishes scholarly works, and provides educational programs for all ages.",
                R.drawable.british_museum
        ));
        tabTitles.add("British Museum");

        // Metropolitan Museum
        fragments.add(ContentFragment.newInstance(
                "Metropolitan Museum of Art",
                "The Metropolitan Museum of Art, colloquially referred to as the Met, is an art museum in New York City. It is the largest art museum in the Americas and one of the most visited museums in the world.\n\n" +
                        "Location: New York City, USA\n" +
                        "Founded: 1870\n" +
                        "Annual Visitors: Over 6 million\n" +
                        "Collection Size: Over 2 million objects\n\n" +
                        "History:\n" +
                        "Founded in 1870 by a group of American citizens, the Met opened its doors to the public in 1872. It moved to its current location in Central Park in 1880 and has expanded numerous times since then.\n\n" +
                        "Collections:\n" +
                        "The Met's collection includes art from every part of the globe and every era of recorded history. Major collections include American art, arms and armor, Asian art, Egyptian art, European paintings, Greek and Roman art, Islamic art, medieval art, and modern and contemporary art.\n\n" +
                        "Architecture:\n" +
                        "The museum's Beaux-Arts facade on Fifth Avenue is iconic, but the building has grown organically with additions in various architectural styles. The museum covers over 2.2 million square feet.\n\n" +
                        "Special Features:\n" +
                        "The Met is famous for its period rooms, including the American Wing's courtyard, the Temple of Dendur in the Egyptian wing, and the Costume Institute. The annual Met Gala is one of the most prestigious fashion events in the world.",
                R.drawable.metropolitan_museum_of_art
        ));
        tabTitles.add("Met Museum");

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