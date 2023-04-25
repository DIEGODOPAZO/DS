package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {
    private Film Forest;

    @BeforeEach
    void setUp(){
        Forest = new Film("Forest Gump", 300000);
        Forest.addMusician("Lucas","Grandal","336456765", 655765434, "Canada", Forest.getBoxOffice(), 7);
        Forest.addActor("Thiago","Seijas", "387346723", 657874598, "Spain", true, 2);
        Forest.addActor("Thiago","Seijas", "387346723", 657874598, "Spain", false, 2);
        Forest.addDirector("Diego","Dopazo","365765987",634987234,"Spain", 7, Forest.getBoxOffice(), 4);
        Forest.addDubber("Xabi","Carricoba", "323456876", 687345234, "Spain", 8);
        Forest.addProducer("Javier","Miguel","345389784", 612340988, "Galician", Forest.getBoxOffice(), 3);
        Forest.addScreenwriter("Sergio","Puertas", "234567234", 698789567, "usa", true, Forest.getBoxOffice(), 3);
        Forest.addScreenwriter("Sergio","Puertas", "234567234", 698789567, "usa", false, Forest.getBoxOffice(), 3);
        Forest.addStuntPerformer("Pablo","Legide", "456356347", 623786234, "Spain", true, 7 );
        Forest.addStuntPerformer("Pablo","Legide", "456356347", 623786234, "Spain", false, 7 );
    }


    @Test
    void getBoxOffice() {
        assertEquals(300000,Forest.getBoxOffice());
    }


    @Test
    void printSalaries() {
        assertEquals("Lucas Grandal (Musician): 12420.0 euro\n" +
                "Diego Dopazo (Director, 7 years of experience): 22400.0 euro\n" +
                "Javier Miguel (Producer): 6270.0 euro\n" +
                "Sergio Puertas (Screenwriter, original screenplay): 19210.0 euro\n" +
                "Sergio Puertas (Screenwriter) 15210.0 euro\n" +
                "Thiago Seijas (Actor protagonist): 1200.0 euro\n" +
                "Thiago Seijas (Actor secondary): 400.0 euro\n" +
                "Xabi Carricoba (Dubber): 160.0 euro\n" +
                "Pablo Legide (Stunt performer with extra for danger): 1280.0 euro\n" +
                "Pablo Legide (Stunt performer with no extra for danger): 280.0 euro\n",Forest.printSalaries());
    }

    @Test
    void printRoyalties() {
        assertEquals("Lucas Grandal (Musician): 12000.0 euros\n" +
                "Diego Dopazo (Director): 15000.0 euros\n" +
                "Javier Miguel (Producer): 6000.0 euros\n" +
                "Sergio Puertas (Screenwriter): 15000.0 euros\n" +
                "Sergio Puertas (Screenwriter): 15000.0 euros\n", Forest.printRoyalties());
    }

    @Test
    void testExceptions(){
        assertThrows(IllegalArgumentException.class,() ->{
            Film Casablanca = new Film(null, 300000);
        })
        ;
        assertThrows(IllegalArgumentException.class,() ->{
            Film Casablanca = new Film("Casablanca", -300000);
        })
        ;
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addActor(null, "hola","hola",789234789,"spain", true, 4));
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addActor("hola", null,"hola",789234789,"spain", true, 4));
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addActor("hola", "hola",null,789234789,"spain", true, 4));
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addActor(null, "hola","hola",789234789,"spain", true, 4));
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addActor("hola", "hola","hola",-789234789,"spain", true, 4));
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addActor("hola", "hola","hola",789234789,null, true, 4));
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addActor("hola", "hola","hola",789234789,"spain", true, -4));
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addDirector("hola", "hola","hola",789234789,"spain", -2, Forest.getBoxOffice(), 7 ));
        assertThrows(IllegalArgumentException.class,() ->
                Forest.addActor("hola", "hola","hola",-789234789,"spain", true, 4));


    }

}