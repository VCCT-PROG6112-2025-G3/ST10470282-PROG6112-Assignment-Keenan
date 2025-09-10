package st10470282_prog6112_assignment;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {

    @Test
    public void TestSearchSeries() {
        ArrayList<SeriesModel> seriesList = new ArrayList<>();
        SeriesModel series = new SeriesModel(1, "Marvel", 18, 62);
        seriesList.add(series);

        boolean found = false;
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId() == 1) {
                found = true;
                assertEquals("Marvel", s.getSeriesName());
                assertEquals(18, s.getSeriesAge());
                assertEquals(62, s.getSeriesNumberOfEpisode());
            }
        }
        assertTrue(found);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        ArrayList<SeriesModel> seriesList = new ArrayList<>();
        seriesList.add(new SeriesModel(1, "Marvel", 18, 62));

        boolean found = false;
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId() == 99) {
                found = true;
            }
        }
        assertFalse(found);
    }

    @Test
    public void TestUpdateSeries() {
        ArrayList<SeriesModel> seriesList = new ArrayList<>();
        SeriesModel series = new SeriesModel(1, "Old Name", 16, 10);
        seriesList.add(series);

        // simulate update
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId() == 1) {
                s.setSeriesName("New Name");
                s.setSeriesAge(18);
                s.setSeriesNumberOfEpisodes(20);
            }
        }

        SeriesModel updated = seriesList.get(0);
        assertEquals("New Name", updated.getSeriesName());
        assertEquals(18, updated.getSeriesAge());
        assertEquals(20, updated.getSeriesNumberOfEpisode());
    }

    @Test
    public void TestDeleteSeries() {
        ArrayList<SeriesModel> seriesList = new ArrayList<>();
        seriesList.add(new SeriesModel(1, "Marvel", 18, 62));

        boolean deleted = false;
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesId() == 1) {
                seriesList.remove(i);
                deleted = true;
                break;
            }
        }
        assertTrue(deleted);
        assertEquals(0, seriesList.size());
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        ArrayList<SeriesModel> seriesList = new ArrayList<>();
        seriesList.add(new SeriesModel(1, "Marvel", 18, 62));

        boolean deleted = false;
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesId() == 99) {
                seriesList.remove(i);
                deleted = true;
                break;
            }
        }
        assertFalse(deleted);
        assertEquals(1, seriesList.size()); // still there
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        int validAge = 16;
        assertTrue(validAge >= 2 && validAge <= 18);
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        int invalidAge = 25;
        assertFalse(invalidAge >= 2 && invalidAge <= 18);
    }
}