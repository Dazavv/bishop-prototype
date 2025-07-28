package org.example.prototype.web.service;

import lombok.RequiredArgsConstructor;
import org.example.prototype.web.model.AuthorType;
import org.example.prototype.web.model.CommandType;
import org.example.starter.audit.annotation.WeylandWatchingYou;
import org.example.starter.command.model.Command;
import org.example.starter.command.model.CommandPriority;
import org.example.starter.command.service.executors.CommandQueueService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CommandService {
    private final CommandQueueService commandQueueService;

    @WeylandWatchingYou
    public void runCommand(AuthorType authorType, CommandType commandType) {
        Command newCommand = new Command();

        newCommand.setDescription(commandType.getDescription());
        newCommand.setPriority(choosePriority(authorType));
        newCommand.setAuthor(authorType.getDescription());
        newCommand.setTime(DateTimeFormatter.ISO_INSTANT.format(Instant.now()));

        commandQueueService.processCommand(newCommand);
    }
    private CommandPriority choosePriority(AuthorType author) {
        return switch (author) {
            case LIEUTENANT_ELLEN_RIPLEY, CAPTAIN_DALLAS -> CommandPriority.CRITICAL;
            default -> CommandPriority.COMMON;
        };
    }
}
