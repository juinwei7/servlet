package org.example.user.domain;

import java.util.ArrayList;
import java.util.List;

public class Address {

    public static List<String> getAddressLines() {
        List<String> address = new ArrayList<>();
        address.add("桃園");
        address.add("台北");
        address.add("嘉義");
        address.add("新北");
        address.add("台南");
        address.add("花蓮");
        address.add("高雄");
        address.add("苗栗");
        address.add("南投");
        address.add("宜蘭");
        address.add("台中");
        return address;
    }

}
