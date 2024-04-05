package org.test.question1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
class UFOTrackerTests {
  @Test
  @DisplayName("Empty calender list test")
  void printUfoSightingsForEmptyCalenderList(){
      UFOTracker tracker = new UFOTracker();
      List<Calendar> emptyList = new ArrayList<>();
      Map<String, Integer> daysAndCount = tracker.printUfoSightings(emptyList);
      Assertions.assertTrue(daysAndCount.isEmpty());
  }

    @Test
    @DisplayName("Not empty calender list test")
    void printUfoSightingsForNotEmptyCalenderList(){
        UFOTracker tracker = new UFOTracker();
        List<Calendar> sightings = new ArrayList<>();
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2024, Calendar.JANUARY, 1);
        sightings.add(cal1);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2024, Calendar.JANUARY, 1);
        sightings.add(cal2);
        Calendar cal3 = Calendar.getInstance();
        cal3.set(2024, Calendar.JANUARY, 2);
        sightings.add(cal3);
        Calendar cal4 = Calendar.getInstance();
        cal4.set(2024, Calendar.JANUARY, 3);
        sightings.add(cal4);
        Map<String, Integer> daysAndCount =  tracker.printUfoSightings(sightings);
        Assertions.assertEquals(2, daysAndCount.get("1-January"));
    }

    @Test
    @DisplayName("Not empty calender list test for out of bound month date")
    void printUfoSightingsForOutOfBoundDate(){
        UFOTracker tracker = new UFOTracker();
        List<Calendar> sightings = new ArrayList<>();
        Calendar cal1 = Calendar.getInstance();
        // January 32 considering as February 1
        cal1.set(2024, Calendar.JANUARY, 32);
        sightings.add(cal1);
        Map<String, Integer> daysAndCount =  tracker.printUfoSightings(sightings);
        Assertions.assertNotEquals(1, daysAndCount.get("1-January"));
        Assertions.assertEquals(1, daysAndCount.get("1-February"));
    }
}
