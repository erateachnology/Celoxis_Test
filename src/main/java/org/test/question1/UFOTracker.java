package org.test.question1;
import java.util.*;

public class UFOTracker {
    public Map<String, Integer> printUfoSightings(List<Calendar> sightings) {
        Map<String, Integer> sightingsByDay = new HashMap<>();

        // Loop through each sighting
        for (Calendar sighting : sightings) {
            // Get day and month information
            int day = sighting.get(Calendar.DAY_OF_MONTH);
            int month = sighting.get(Calendar.MONTH);

            // Form a string representing day-month pair
            String dayMonth = String.format("%d-%s", day, getMonthName(month));

            // Increment count for that day in the HashMap
            sightingsByDay.put(dayMonth, sightingsByDay.getOrDefault(dayMonth, 0) + 1);
        }

        // Print each day and its sighting count
        int currentMonth = 0;  // Start with January

        while (currentMonth <= Calendar.DECEMBER) {  // Loop through months
            // Create a Calendar object for the current month
            Calendar monthCalendar = Calendar.getInstance();
            monthCalendar.set(Calendar.MONTH, currentMonth);  // Set month in the calendar

            int maxDay = monthCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);  // Get max days for current month

            String dayMonth;

            for (int day = 1; day <= maxDay; day++) {  // Loop through days (adjusted for each month)
                dayMonth = String.format("%d-%s", day, getMonthName(currentMonth));

                // Check if the day-month has any sightings before printing
                if (sightingsByDay.containsKey(dayMonth)) {
                    int count = sightingsByDay.get(dayMonth);
                    System.out.println(dayMonth + ": " + count);
                } else {
                    System.out.println(dayMonth + ": 0");
                }
            }

            // Increment month
            currentMonth++;
        }
        return sightingsByDay;
    }

    // Method to get month name from its number
    private String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }
}
