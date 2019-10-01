package ru.job4j.address;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {
    Profiles profiles = new Profiles();
    Address adr1 = new Address("msk", "str1", 1, 2);
    Address adr2 = new Address("spb", "str2", 2, 5);
    Address adr3 = new Address("msk", "str1", 1, 2);
    Address adr4 = new Address("omsk", "str3", 5, 8);
    Profile profile1 = new Profile(adr1);
    Profile profile2 = new Profile(adr2);
    Profile profile3 = new Profile(adr3);
    Profile profile4 = new Profile(adr4);


    @Test
    public void addressMapTest() {
        List<Profile> profileList = new ArrayList<>(List.of(profile1, profile2));
        List<Address> expected = new ArrayList<>(List.of(adr1, adr2));
        assertThat(expected, is(this.profiles.collect(profileList)));
    }

    @Test
    public void addressDistinctTest() {
        List<Profile> profileList = new ArrayList<>(List.of(profile1, profile2, profile3, profile4));
        List<Address> expected = new ArrayList<>(List.of(adr1, adr4, adr2));
        assertThat(expected, is(this.profiles.collect(profileList)));
    }
}
