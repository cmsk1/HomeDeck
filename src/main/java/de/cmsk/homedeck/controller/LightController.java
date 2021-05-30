package de.cmsk.homedeck.controller;

import de.cmsk.homedeck.errors.ProgramNotFoundException;
import de.cmsk.homedeck.errors.SignalNotSendException;
import de.cmsk.homedeck.services.CommandLineService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/lights/")
public class LightController {

    private final CommandLineService commandLineService;

    public LightController(CommandLineService commandLineService) {
        this.commandLineService = commandLineService;
    }

    @RequestMapping(value = "/433/{groupID}/{action}", method = RequestMethod.GET)
    public int switchOn(@PathVariable int groupID, @PathVariable String action) throws IOException, InterruptedException, SignalNotSendException, ProgramNotFoundException {
        int code = commandLineService.execute433Control(groupID, action);
        if (code == 0) {
            return code;
        } else if (code == 1) {
            throw new SignalNotSendException();
        } else {
            throw new ProgramNotFoundException();
        }
    }
}
