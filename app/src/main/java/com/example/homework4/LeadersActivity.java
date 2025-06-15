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

public class LeadersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("World Leaders");

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        List<Fragment> fragments = new ArrayList<>();
        List<String> tabTitles = new ArrayList<>();

        // Nelson Mandela
        fragments.add(ContentFragment.newInstance(
                "Nelson Mandela",
                "Nelson Rolihlahla Mandela (18 July 1918 – 5 December 2013) was a South African anti-apartheid revolutionary, political leader, and philanthropist who served as President of South Africa from 1994 to 1999.\n\n" +
                        "Born: July 18, 1918, Mvezo, South Africa\n" +
                        "Died: December 5, 2013, Johannesburg, South Africa\n" +
                        "Spouse: Winnie Mandela (1958-1996), Graça Machel (1998-2013)\n\n" +
                        "Early Life:\n" +
                        "Born into the Thembu royal family, Mandela attended Fort Hare University and the University of the Witwatersrand, where he studied law. He became involved in anti-colonial politics and joined the African National Congress (ANC) in 1943.\n\n" +
                        "Activism and Imprisonment:\n" +
                        "Mandela led the ANC's armed wing and was arrested in 1962. He was sentenced to life imprisonment in 1964 for conspiring to overthrow the government. He spent 27 years in prison, mostly on Robben Island.\n\n" +
                        "Presidency and Legacy:\n" +
                        "Released in 1990, Mandela led negotiations to end apartheid and became South Africa's first black president in 1994. He focused on reconciliation and was awarded the Nobel Peace Prize in 1993.\n\n" +
                        "Impact:\n" +
                        "Mandela is revered worldwide as a symbol of resistance to oppression, reconciliation, and human rights. His life and work continue to inspire people around the globe.",
                R.drawable.nelson_mandela
        ));
        tabTitles.add("Mandela");

        // Mahatma Gandhi
        fragments.add(ContentFragment.newInstance(
                "Mahatma Gandhi",
                "Mohandas Karamchand Gandhi (2 October 1869 – 30 January 1948) was an Indian lawyer, anti-colonial nationalist, and political ethicist who employed nonviolent resistance to lead the successful campaign for India's independence from British rule.\n\n" +
                        "Born: October 2, 1869, Porbandar, India\n" +
                        "Died: January 30, 1948, New Delhi, India\n" +
                        "Spouse: Kasturba Gandhi (1883-1944)\n\n" +
                        "Early Life:\n" +
                        "Born into a Hindu merchant caste family, Gandhi trained as a lawyer in London. He first employed nonviolent civil disobedience as an expatriate lawyer in South Africa in the resident Indian community's struggle for civil rights.\n\n" +
                        "Indian Independence Movement:\n" +
                        "Returning to India in 1915, Gandhi organized peasants, farmers, and urban laborers to protest against discrimination and excessive land-tax. He led nationwide campaigns for various social causes and ultimately for independence.\n\n" +
                        "Philosophy:\n" +
                        "Gandhi's philosophy of nonviolence (ahimsa) and civil disobedience (satyagraha) influenced movements for civil rights and freedom across the world. He advocated for simple living and self-sufficiency.\n\n" +
                        "Legacy:\n" +
                        "Known as the 'Father of the Nation' in India, Gandhi's methods of nonviolent protest inspired civil rights movements worldwide, including Martin Luther King Jr.'s work in the United States. His birthday is celebrated as the International Day of Nonviolence.",
                R.drawable.mahatma_gandhi
        ));
        tabTitles.add("Gandhi");

        // Winston Churchill
        fragments.add(ContentFragment.newInstance(
                "Winston Churchill",
                "Sir Winston Leonard Spencer Churchill (30 November 1874 – 24 January 1965) was a British statesman, soldier, and writer who served as Prime Minister of the United Kingdom twice, from 1940 to 1945 during the Second World War, and again from 1951 to 1955.\n\n" +
                        "Born: November 30, 1874, Blenheim Palace, England\n" +
                        "Died: January 24, 1965, London, England\n" +
                        "Spouse: Clementine Churchill (1908-1965)\n\n" +
                        "Early Career:\n" +
                        "Churchill served as a British Army officer, war correspondent, and Member of Parliament. He held various government positions before becoming Prime Minister.\n\n" +
                        "World War II Leadership:\n" +
                        "As Prime Minister during WWII, Churchill led Britain's resistance against Nazi Germany. His speeches and radio broadcasts helped inspire British resistance during the darkest hours of the war.\n\n" +
                        "Writer and Nobel Prize:\n" +
                        "Churchill was also a prolific writer and won the Nobel Prize in Literature in 1953. He wrote numerous books including 'The Second World War' and 'A History of the English-Speaking Peoples'.\n\n" +
                        "Legacy:\n" +
                        "Widely regarded as one of the most significant leaders of the 20th century, Churchill is remembered for his wartime leadership, oratory skills, and his role in shaping the modern world.",
                R.drawable.winston_churchill
        ));
        tabTitles.add("Churchill");

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