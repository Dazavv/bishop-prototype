package org.example.prototype.web.controller;

import lombok.RequiredArgsConstructor;
import org.example.prototype.web.model.AuthorType;
import org.example.prototype.web.model.CommandType;
import org.example.prototype.web.service.CommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "command")
@RequiredArgsConstructor
public class CommandController {
    private final CommandService commandService;

    @PostMapping
    public void runCommand(@RequestParam AuthorType authorType, @RequestParam CommandType commandType) {
        commandService.runCommand(authorType, commandType);
    }
}
