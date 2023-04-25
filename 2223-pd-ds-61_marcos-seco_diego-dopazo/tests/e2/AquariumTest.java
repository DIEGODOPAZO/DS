package e2;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AquariumTest {

    @Test
    void addTank() {
        Aquarium aquarium = new Aquarium();
        assertEquals(0, aquarium.tanks.size());

        Tank tank1 = new Tank("Seals Swimming Pool", "Outside");
        aquarium.addTank(tank1);
        assertEquals(1, aquarium.tanks.size());
        assertSame(tank1, aquarium.tanks.get(0));

        Tank tank2 = new Tank("Dolphins Swimming Pool", "Inside");
        aquarium.addTank(tank2);
        assertEquals(2, aquarium.tanks.size());
        assertSame(tank1, aquarium.tanks.get(0));
        assertSame(tank2, aquarium.tanks.get(1));
    }

    @Test
    void addPerson() {
        Aquarium aquarium = new Aquarium();
        assertEquals(0, aquarium.personnel.size());

        Person person1 = new Person("John Doe");
        aquarium.addPerson(person1);
        assertEquals(1, aquarium.personnel.size());
        assertSame(person1, aquarium.personnel.get(0));

        Person person2 = new Person("Jane Doe");
        aquarium.addPerson(person2);
        assertEquals(2, aquarium.personnel.size());
        assertSame(person1, aquarium.personnel.get(0));
        assertSame(person2, aquarium.personnel.get(1));
    }

    @Test
    void writeReports() {
    }

    @Test
    void printReports() {
        Aquarium aquarium = new Aquarium();

        Tank tank = new Tank("Seals Swimming Pool", "Outside");
        aquarium.addTank(tank);


        //After creating the Aquarium and the tank, the sensor are created, TempObs will measure the temperature and OxyObs the oxygen
        Sensor TempObs = new Sensor("Temperature");
        Sensor OxyObs = new Sensor("Oxygen");
        tank.addSensor(TempObs);
        tank.addSensor(OxyObs);



        //Two alerts are created: one for the temperature and one for the oxygen and the valid ranges are established
        Alert tempAlert = new Alert("Control de temperatura", AlertType.NONE,new Range(15,20),new Range(10,30));
        Alert OxygenAlert = new Alert("Control de oxigeno", AlertType.NONE,new Range(10,20),new Range(0,30));

        //The alerts are attached to the sensors so that they are notified when there is a change
        TempObs.attach(tempAlert);
        OxyObs.attach(OxygenAlert);

        //A new person is created and subscribed to the alerts
        Person person = new Person("Paco");
        person.subscribeToAlert(tempAlert);
        person.subscribeToAlert(OxygenAlert);
        aquarium.addPerson(person);


        /*Two control devices are created one for the TempObs sensor and the other for the OxyObs sensor, the Control
         * devices will change the value to a random value inside the normal range if an alarm is activated */

        ControlDevice TempCtrl = new ControlDevice(TempObs,aquarium,tank);
        ControlDevice OxyCtrl = new ControlDevice(OxyObs,aquarium,tank);

        //The control devices are attached to the corresponding alert so that they are notified when an alert is activated
        tempAlert.attachCD(TempCtrl);
        OxygenAlert.attachCD(OxyCtrl);

        TempObs.setValue(25);
        OxyObs.setValue(31);


        aquarium.printReports();

        /*This test checks if the formatting of the output is correct and if the priority queue is working (it should print
         the RED alert before the ORANGE alert) */
        assertEquals("* RED Alert:\n" + "Seals Swimming Pool, Outside\nControl de oxigeno: parameter Oxygen, level 31.0\n" + new Date(), person.getReports().get(0).toString());

        //Finally this test checks if the control device has changed the value of the sensor so that it is inside a normal range
        boolean containsValue = tempAlert.getOrangeRange().contains(TempObs.getValue());
        assertTrue(containsValue);

        //The alerts are detached to the sensors so that they are notified when there is a change
        TempObs.detach(tempAlert);
        OxyObs.detach(OxygenAlert);
        //The control devices are detached to the corresponding alert so that they are notified when an alert is activated
        tempAlert.detachCD(TempCtrl);
        OxygenAlert.detachCD(OxyCtrl);
    }
}