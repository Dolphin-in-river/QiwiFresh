package org.qiwi.service;

import org.qiwi.entity.CommandLineArguments;

import java.time.LocalDate;

public class CommandLineParseService {
    public static CommandLineArguments parseArguments(String[] args) {
        if (args.length == 2) {
            String code = args[0].substring(7);
            String date = args[1].substring(7);
            return new CommandLineArguments(code, LocalDate.parse(date));
        }
        else {
            String code = args[1].substring(7);
            String date = args[2].substring(7);
            return new CommandLineArguments(code, LocalDate.parse(date));
        }
    }
}
