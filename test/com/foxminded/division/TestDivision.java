package com.foxminded.division;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDivision {

    Division division = new Division();

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenDivisorZero() {
        division.divide(78945, 0);
    }

    @Test
    public void shouldMakeDivisionWhenDevidendMoreDivisor() {
        String expected =   "_78945│4\n" + 
                            " 4    │--------\n" + 
                            " -    │19736.25\n" + 
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" + 
                            " _29\n" + 
                            "  28\n" + 
                            "  --\n" + 
                            "  _14\n" + 
                            "   12\n" + 
                            "   --\n" +
                            "   _25\n" +
                            "    24\n" +
                            "    --\n" +
                            "    _10\n"+
                            "      8\n" +
                            "      -\n" +
                            "     _20\n" +
                            "      20\n" + 
                            "      --\n" +
                            "       0\n";
        String actual = division.divide(78945, 4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenNegativeDevidend() {
        String expected =   "_78945│4\n" + 
                            " 4    │--------\n" + 
                            " -    │19736.25\n" + 
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" + 
                            " _29\n" + 
                            "  28\n" + 
                            "  --\n" + 
                            "  _14\n" + 
                            "   12\n" + 
                            "   --\n" +
                            "   _25\n" +
                            "    24\n" +
                            "    --\n" +
                            "    _10\n"+
                            "      8\n" +
                            "      -\n" +
                            "     _20\n" +
                            "      20\n" + 
                            "      --\n" +
                            "       0\n";
        String actual = division.divide(-78945, 4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenNegativeDivisor() {
        String expected =   "_78945│4\n" + 
                            " 4    │--------\n" + 
                            " -    │19736.25\n" + 
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" + 
                            " _29\n" + 
                            "  28\n" + 
                            "  --\n" + 
                            "  _14\n" + 
                            "   12\n" + 
                            "   --\n" +
                            "   _25\n" +
                            "    24\n" +
                            "    --\n" +
                            "    _10\n"+
                            "      8\n" +
                            "      -\n" +
                            "     _20\n" +
                            "      20\n" + 
                            "      --\n" +
                            "       0\n";
        String actual = division.divide(78945, -4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenNegativeArguments() {
        String expected =   "_78945│4\n" + 
                            " 4    │--------\n" + 
                            " -    │19736.25\n" + 
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" + 
                            " _29\n" + 
                            "  28\n" + 
                            "  --\n" + 
                            "  _14\n" + 
                            "   12\n" + 
                            "   --\n" +
                            "   _25\n" +
                            "    24\n" +
                            "    --\n" +
                            "    _10\n"+
                            "      8\n" +
                            "      -\n" +
                            "     _20\n" +
                            "      20\n" + 
                            "      --\n" +
                            "       0\n";
        String actual = division.divide(-78945, -4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenQuotientWhole() {
        String expected =   "_78944│4\n" + 
                            " 4    │-----\n" + 
                            " -    │19736\n" + 
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" + 
                            " _29\n" + 
                            "  28\n" + 
                            "  --\n" + 
                            "  _14\n" + 
                            "   12\n" + 
                            "   --\n" +
                            "   _24\n" +
                            "    24\n" +
                            "    --\n" +
                            "     0\n";
        String actual = division.divide(78944, 4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenDivisorMoreOneNumber() {
        String expected =   "_14789│20\n" + 
                            " 140  │------\n" + 
                            " ---  │739.45\n" + 
                            "  _78\n" + 
                            "   60\n" + 
                            "   --\n" + 
                            "  _189\n" + 
                            "   180\n" + 
                            "   ---\n" + 
                            "    _90\n" +
                            "     80\n" + 
                            "     --\n" + 
                            "    _100\n" + 
                            "     100\n" + 
                            "     ---\n" + 
                            "       0\n";
        String actual = division.divide(14789, 20);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenDevidendEqualDivisor() {
        String expected =   "_4│4\n" + 
                            " 4│-\n" + 
                            " -│1\n" + 
                            " 0\n" ;
        String actual = division.divide(4, 4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenDevidendEndsZero() {
        String expected =   "_40│4\n" + 
                            " 4 │--\n" + 
                            " - │10\n" + 
                            "  0\n" ;
        String actual = division.divide(40, 4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenDevidendContainZero() {
        String expected =   "_404│4\n" + 
                            " 4  │---\n" + 
                            " -  │101\n" + 
                            "  _4\n" + 
                            "   4\n" +
                            "   -\n" +
                            "   0\n";
        String actual = division.divide(404, 4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenDevidendLessDivisor() {
        String expected =   "_4 │40\n" + 
                            " 40│---\n" + 
                            " --│0.1\n" +                             
                            "  0\n";
        String actual = division.divide(4, 40);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenExsistWholeAndFractionalPart() {
        String expected =   "_78459│4\n" + 
                            " 4    │--------\n" + 
                            " -    │19614.75\n" +                             
                            "_38\n" + 
                            " 36\n" + 
                            " --\n" +
                            " _24\n" +
                            "  24\n" +
                            "  --\n" +
                            "   _5\n" + 
                            "    4\n" + 
                            "    -\n" +
                            "   _19\n" +
                            "    16\n" +
                            "    --\n" +
                            "    _30\n" + 
                            "     28\n" + 
                            "     --\n" +
                            "     _20\n" +
                            "      20\n" +
                            "      --\n" +
                            "       0\n";
        String actual = division.divide(78459, 4);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenPeriodContainOneNumber() {
        String expected =   "_1000│3\n" + 
                            "  9  │-------\n" + 
                            "  -  │333.(3)\n" +                             
                            " _10\n" + 
                            "   9\n" + 
                            "   -\n" +
                            "  _10\n" +
                            "    9\n" +
                            "    -\n" +
                            "   _10\n" + 
                            "     9\n" + 
                            "     -\n" +
                            "     1\n";
        String actual = division.divide(1000, 3);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenQuotientContainNumberAndPeriod() {
        String expected =   "_7 │12\n" + 
                            " 60│-------\n" + 
                            " --│0.58(3)\n" +                             
                            "_100\n" + 
                            "  96\n" + 
                            "  --\n" +
                            "  _40\n" +
                            "   36\n" +
                            "   --\n" +
                            "    4\n";
        String actual = division.divide(7, 12);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenPeriodMoreOneNumber() {
        String expected =   "_25 │39\n" + 
                            " 234│----------\n" + 
                            " ---│0.(641025)\n" +                             
                            " _160\n" + 
                            "  156\n" + 
                            "  ---\n" +
                            "   _40\n" +
                            "    39\n" +
                            "    --\n" +
                            "    _100\n" + 
                            "      78\n" + 
                            "      --\n" +
                            "     _220\n" +
                            "      195\n" +
                            "      ---\n" +
                            "      _250\n" + 
                            "       234\n" + 
                            "       ---\n" +
                            "        16\n";
        String actual = division.divide(25, 39);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenFractionalMoreTenNumber() {
        String expected =   "_9  │856\n" + 
                            " 856│------------\n" + 
                            " ---│0.0105140187\n" +                             
                            " _4400\n" + 
                            "  4280\n" + 
                            "  ----\n" +
                            "  _1200\n" +
                            "    856\n" +
                            "    ---\n" +
                            "   _3440\n" + 
                            "    3424\n" + 
                            "    ----\n" +
                            "     _1600\n" +
                            "       856\n" +
                            "       ---\n" +
                            "      _7440\n" + 
                            "       6848\n" + 
                            "       ----\n" +
                            "       _5920\n" +
                            "        5136\n" +
                            "        ----\n" +
                            "        _7840\n" + 
                            "         7704\n" + 
                            "         ----\n" +
                            "         _1360\n" +
                            "           856\n" +
                            "           ---\n" +
                            "          _5040\n" + 
                            "           4280\n" + 
                            "           ----\n" +
                            "            760\n";
        String actual = division.divide(9, 856);
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldMakeDivisionWhenPeriodEqualsTenNumber() {
        String expected =   "_17598 │100001\n" + 
                            " 100001│--------------\n" + 
                            " ------│0.(1759782402)\n" +                             
                            " _759790\n" + 
                            "  700007\n" + 
                            "  ------\n" +
                            "  _597830\n" +
                            "   500005\n" +
                            "   ------\n" +
                            "   _978250\n" + 
                            "    900009\n" + 
                            "    ------\n" +
                            "    _782410\n" +
                            "     700007\n" +
                            "     ------\n" +
                            "     _824030\n" + 
                            "      800008\n" + 
                            "      ------\n" +
                            "      _240220\n" +
                            "       200002\n" +
                            "       ------\n" +
                            "       _402180\n" + 
                            "        400004\n" + 
                            "        ------\n" +
                            "         _217600\n" +
                            "          200002\n" +
                            "          ------\n" +
                            "          _175980\n" + 
                            "           100001\n" + 
                            "           ------\n" +
                            "            75979\n";
        String actual = division.divide(17598, 100001);
        assertEquals(expected, actual);
    }
}
