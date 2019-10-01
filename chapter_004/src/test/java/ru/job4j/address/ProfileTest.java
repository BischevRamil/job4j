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
    Profile profile1 = new Profile(adr1);
    Profile profile2 = new Profile(adr2);
    List<Profile> profileList = new ArrayList<>(List.of(profile1, profile2));

    @Test
    public void profileTest() {
        List<Address> expected = new ArrayList<>(List.of(adr1, adr2));
        assertThat(expected, is(this.profiles.collect(profileList)));
    }
}
