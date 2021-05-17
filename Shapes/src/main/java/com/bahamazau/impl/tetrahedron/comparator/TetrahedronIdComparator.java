package com.bahamazau.impl.tetrahedron.comparator;

import com.bahamazau.impl.tetrahedron.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Comparator;

public class TetrahedronIdComparator implements Comparator<Tetrahedron> {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(Tetrahedron tetrahedron1, Tetrahedron tetrahedron2) {
        int result = Long.compare(tetrahedron1.getId(), tetrahedron2.getId());

        log(result);
        return result;
    }

    private void log(int result) {
        String textResult = "";
        if (result == -1) {
            textResult = "greater then";
        } else if (result == 0) {
            textResult = "equal to";
        } else if (result == 1) {
            textResult = "less then";
        }

        LOGGER.info(String.join(" ", "First is", textResult, "second."));
    }

}
