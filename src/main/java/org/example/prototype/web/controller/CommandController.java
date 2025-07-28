package org.example.prototype.web.controller;

import org.example.prototype.web.model.AuthorType;
import org.example.prototype.web.model.CommandType;
import org.example.prototype.web.service.CommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {
    CommandService commandService;

    @PostMapping
    public void runCommand(AuthorType authorType, CommandType commandType) {
        commandService.runCommand(authorType, commandType);
    }
}
