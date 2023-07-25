package org.qiwi.service;

import org.qiwi.entity.CommandLineArguments;

import java.time.LocalDate;

public class CommandLineParseService {
    public static CommandLineArguments parseArguments(String[] args) {
        String code;
        String date;
        if (args.length == 2) {
            code = args[0].substring(7);
            date = args[1].substring(7);
        }
        else {
            code = args[1].substring(7);
            date = args[2].substring(7);
        }
        return new CommandLineArguments(code, LocalDate.parse(date));
    }
}
