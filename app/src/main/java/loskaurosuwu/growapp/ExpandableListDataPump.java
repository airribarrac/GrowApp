package loskaurosuwu.growapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> plasticos = new ArrayList<String>();
        plasticos.add("PETE");
        plasticos.add("HDPE");
        plasticos.add("V");
        plasticos.add("LDPE");
        plasticos.add("PP");
        plasticos.add("PS");
        plasticos.add("OTROS");

        List<String> vidrios = new ArrayList<String>();
        vidrios.add("Botellas");

        List<String> papeleria = new ArrayList<String>();
        papeleria.add("cartones");
        papeleria.add("papeles");

        List<String> aluminio = new ArrayList<String>();
        aluminio.add("latas");
        aluminio.add("laminas");

        expandableListDetail.put("Plasticos", plasticos);
        expandableListDetail.put("Vidrios", vidrios);
        expandableListDetail.put("Papeleria", papeleria);
        expandableListDetail.put("Aluminio", aluminio);

        return expandableListDetail;
    }
}

