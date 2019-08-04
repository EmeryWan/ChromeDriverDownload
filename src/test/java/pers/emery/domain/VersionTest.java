package pers.emery.domain;

import org.junit.Test;
import pers.emery.util.Version;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VersionTest {

    @Test
    public void winTest() {
        Version v = new Version();
        System.out.println(v.windowLocalChromeVersion());
    }

    @Test
    public void linuxText() {
        Version v = new Version();
//        System.out.println(v.linuxLocalChromeVersion());
        String[] strs = v.linuxLocalChromeVersion().split(" ");
        System.out.println(strs.length);
        Arrays.stream(strs).peek(System.out::println).filter(s -> s.trim().matches("[0-9|.]+")).forEach(System.out::println);

        //System.out.println(first.isEmpty());

        System.out.println("75.0.3770.142".matches("[0-9|.]+"));

    }

    @Test
    public void versionTest() {
        Version v = new Version();
        // String driverVersion = v.getDriverVersion("https://npm.taobao.org/mirrors/chromedriver/LATEST_RELEASE_70");
        // System.out.println(driverVersion);

        System.out.println(v.getDriverVersionLegacy("68"));
    }

    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("one", "first");
        System.out.println(map.get("two"));


    }

}