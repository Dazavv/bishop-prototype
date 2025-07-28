package org.example.prototype.web.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthorType {
    LIEUTENANT_ELLEN_RIPLEY("Лейтенант Эллен Рипли"),
    CAPTAIN_DALLAS("Капитан Даллас"),
    ENGINEER_SCOTT("Инженер Скотт"),
    SCIENTIST_WEYLAND("Учёный Уэйленд");

    private final String description;
}
