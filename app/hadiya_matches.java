package com.group_d.ethiopianpremierleague;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hadiya_matches extends ListFragment {
    public hadiya_matches() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView listbunamatches;
        Resources resources=getResources();
        String fristclubname[]={resources.getString(R.string.sidama),resources.getString(R.string.bunna),resources.getString(R.string.sebeta),resources.getString(R.string.bunna),resources.getString(R.string.jimma),resources.getString(R.string.mekelakeya),resources.getString(R.string.bunna),resources.getString(R.string.bunna),resources.getString(R.string.hadiya),resources.getString(R.string.hawassa),resources.getString(R.string.bunna),resources.getString(R.string.bunna),resources.getString(R.string.arba),resources.getString(R.string.fasil),resources.getString(R.string.bunna)};
        String secondclubname[]={resources.getString(R.string.bunna),resources.getString(R.string.kidus),resources.getString(R.string.bunna),resources.getString(R.string.wolaita),resources.getString(R.string.bunna),resources.getString(R.string.bunna),resources.getString(R.string.dire),resources.getString(R.string.wolkite),resources.getString(R.string.bunna),resources.getString(R.string.bunna),resources.getString(R.string.adama),resources.getString(R.string.addis),resources.getString(R.string.bunna),resources.getString(R.string.bunna),resources.getString(R.string.bahir),};
        String matchesstadium[]={resources.getString(R.string.yirgalem),resources.getString(R.string.addisstadium),resources.getString(R.string.sebetastadium),resources.getString(R.string.addisstadium),resources.getString(R.string.jimmastadium),resources.getString(R.string.addisstadium),resources.getString(R.string.addisstadium),resources.getString(R.string.addisstadium),resources.getString(R.string.hadiyastadium),resources.getString(R.string.hadiyastadium),resources.getString(R.string.addisstadium),resources.getString(R.string.addisstadium),resources.getString(R.string.arbastadium),resources.getString(R.string.fasistadium),resources.getString(R.string.addisstadium),};
        String machesvs[]={resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs),resources.getString(R.string.vs)};
        String machesdatetime[] ={resources.getString(R.string.day3),resources.getString(R.string.day9),resources.getString(R.string.day19),resources.getString(R.string.day3),resources.getString(R.string.day9),resources.getString(R.string.day19),resources.getString(R.string.day3),resources.getString(R.string.day9),resources.getString(R.string.day19),resources.getString(R.string.day3),resources.getString(R.string.day9),resources.getString(R.string.day19),resources.getString(R.string.day3),resources.getString(R.string.day9),resources.getString(R.string.day19)};
        int fristclubimage[]={R.drawable.sidaama_bunna,R.drawable.ethiopian_coffe,R.drawable.sebeta_kenema,R.drawable.ethiopian_coffe,R.drawable.jimma_ketema,R.drawable.mekelakeyia,R.drawable.ethiopian_coffe,R.drawable.ethiopian_coffe,R.drawable.hadiya_hossana,R.drawable.hawassa_ketema, R.drawable.ethiopian_coffe, R.drawable.ethiopian_coffe, R.drawable.arbaminch_ketema, R.drawable.fasil_kenema, R.drawable.ethiopian_coffe};
        int secondclubimage[]={R.drawable.ethiopian_coffe,R.drawable.saint_george,R.drawable.ethiopian_coffe,R.drawable.welayta_dicha,R.drawable.ethiopian_coffe,R.drawable.ethiopian_coffe,R.drawable.dire_dawa_kenema,R.drawable.welkite_kenema,R.drawable.ethiopian_coffe,R.drawable.ethiopian_coffe,R.drawable.adama_ketema,R.drawable.addis_ababa_kenema, R.drawable.ethiopian_coffe,R.drawable.ethiopian_coffe,R.drawable.bahir_dar_kenema};
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < fristclubname.length; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("fristclubname", fristclubname[i]);
            map.put("secondclubname", secondclubname[i]);
            map.put("fristclubimage", Integer.toString(fristclubimage[i]));
            map.put("secondclubimage", Integer.toString(secondclubimage[i]));
            map.put("dateandtime", machesdatetime[i]);
            map.put("stadium", matchesstadium[i]);
            map.put("matchvs", machesvs[i]);
            aList.add(map);
        }
        // Keys used in Hashmap
        String[] from = {"fristclubname","secondclubname","fristclubimage","secondclubimage", "dateandtime", "stadium", "matchvs"};
        // Ids of views in listview_layout
        int[] to = {R.id.fristclubname, R.id.secondclubname, R.id.fristclubpicture, R.id.secondclubpicture, R.id.matches_day_time, R.id.match_stadium, R.id.vs_text};
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.matches_one_row, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

