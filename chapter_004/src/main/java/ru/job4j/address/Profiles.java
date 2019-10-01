package ru.job4j.address;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    List<Address> collect(List<Profile> profiles) {
    List<Address> addressList = profiles.stream().map(Profile::getAddress).sorted(new Comparator<Address>() {
        @Override
        public int compare(Address address1, Address address2) {
            return address1.getCity().compareTo(address2.getCity());
        }
    }).collect(Collectors.toList());
        return addressList.stream().distinct().collect(Collectors.toList());
    }
}
