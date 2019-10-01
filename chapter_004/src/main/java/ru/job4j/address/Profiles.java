package ru.job4j.address;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profiles {
    List<Address> collect(List<Profile> profiles) {
    return profiles.stream().map(a -> a.getAddress()).collect(Collectors.toList());
    }
}
