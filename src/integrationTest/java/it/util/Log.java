package it.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Log {

    public static boolean isLogAllActive() {
        return Boolean.valueOf(System.getProperty("restLogAll"));
    }

    public static void addSeparator() {
        log.info("###################################################################################");
    }

    public static void addRightArrows(String title) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + title + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    public static void addLeftArrows(String title) {
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + title + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    public static void addBlankLine() {
        log.info(StringUtils.EMPTY);
    }

    public static void addBlankLine(int quantity) {
        for (int i = 0; i < quantity; i++) {
            log.info(StringUtils.EMPTY);
        }
    }

}
