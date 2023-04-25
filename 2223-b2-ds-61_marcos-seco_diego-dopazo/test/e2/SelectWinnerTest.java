package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class SelectWinnerTest {
    int kn;
    int k0;
    int k1;
    int k3;
    int k5;

    List<String> list5elementsA = new ArrayList<>();
    List <String> list5elementsB = new ArrayList<>();
    List <String> list1elementA = new ArrayList<>();
    List <String> list1elementB = new ArrayList<>();
    List <String> EmptyListA = new ArrayList<>();
    List <String> EmptyListB = new ArrayList<>();

    List<String> list5elementsC = new ArrayList<>();
    List <String> list5elementsD = new ArrayList<>();
    List <String> list3elementsA = new ArrayList<>();
    List <String> list3elementsB = new ArrayList<>();

    TVRealityList tv5eA;
    TVRealityList tv5eB;

    TVRealityList tv1eA;
    TVRealityList tv1eB;

    TVRealityList tvEmptyA;
    TVRealityList tvEmptyB;
    TVRealityList tv5eC;
    TVRealityList tv5eD;
    TVRealityList tv3eA;
    TVRealityList tv3eB;

    @BeforeEach
    void setUp(){
        kn = -1;
        k0 = 0;
        k1 = 1;
        k3 = 3;
        k5 = 5;

        list5elementsA.add("1");
        list5elementsA.add("2");
        list5elementsA.add("3");
        list5elementsA.add("4");
        list5elementsA.add("5");

        list5elementsB.add("1");
        list5elementsB.add("2");
        list5elementsB.add("3");
        list5elementsB.add("4");
        list5elementsB.add("5");

        list1elementA.add("1");

        list1elementB.add("1");

        list5elementsC.add("1");
        list5elementsC.add("2");
        list5elementsC.add("3");
        list5elementsC.add("4");
        list5elementsC.add("5");

        list5elementsD.add("1");
        list5elementsD.add("2");
        list5elementsD.add("3");
        list5elementsD.add("4");
        list5elementsD.add("5");

        list3elementsA.add("1");
        list3elementsA.add("2");
        list3elementsA.add("3");

        list3elementsB.add("1");
        list3elementsB.add("2");
        list3elementsB.add("3");

        tv5eA = new TVRealityList(list5elementsA, true);
        tv5eB = new TVRealityList(list5elementsB, false);

        tv1eA = new TVRealityList(list1elementA, true);
        tv1eB = new TVRealityList(list1elementB, false);

        tvEmptyA = new TVRealityList(EmptyListA, true);
        tvEmptyB = new TVRealityList(EmptyListB, false);

        tv5eC = new TVRealityList(list5elementsC, true);
        tv5eD = new TVRealityList(list5elementsD, false);

        tv3eA = new TVRealityList(list3elementsA, true);
        tv3eB = new TVRealityList(list3elementsB, false);
    }
    @Test
    void selectCandidates() {
        assertEquals(SelectWinner.selectCandidates(tv5eA, k3), "4");
        assertEquals(SelectWinner.selectCandidates(tv5eB, k3), "1");

        assertEquals(SelectWinner.selectCandidates(tv5eC, k1), "5");
        assertEquals(SelectWinner.selectCandidates(tv5eD, k1), "5");

        assertThrows(IllegalArgumentException.class,()->SelectWinner.selectCandidates(tvEmptyA, k1));
        assertThrows(IllegalArgumentException.class,()->SelectWinner.selectCandidates(tvEmptyB, k1));

        assertThrows(IllegalArgumentException.class,()->SelectWinner.selectCandidates(tv5eA, k0));
        assertThrows(IllegalArgumentException.class,()->SelectWinner.selectCandidates(tv5eA, k0));
        assertThrows(IllegalArgumentException.class,()->SelectWinner.selectCandidates(tv5eA, kn));

        assertEquals(SelectWinner.selectCandidates(tv1eA, k1), "1");
        assertEquals(SelectWinner.selectCandidates(tv1eB, k1), "1");

        assertEquals(SelectWinner.selectCandidates(tv1eA, k3), "1");
        assertEquals(SelectWinner.selectCandidates(tv1eB, k3), "1");

        assertEquals(SelectWinner.selectCandidates(tv3eA, k5), "1");
        assertEquals(SelectWinner.selectCandidates(tv3eB, k5), "3");



    }
}