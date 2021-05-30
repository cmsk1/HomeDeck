package de.cmsk.homedeck.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class CommandLineService {

    public int execute433Control(int groupID, String action) throws InterruptedException, IOException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh", "-c", "/home/pi/433Utils/RPi_utils/control433 " + groupID + " " + action.trim().toLowerCase());
        builder.directory(new File(System.getProperty("user.home")));
        Process process = builder.start();
        return process.waitFor();
    }
}
