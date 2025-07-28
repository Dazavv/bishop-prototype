package org.example.prototype.web.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommandType {
    CHECK_BLOCK("Проверить состояние энергоблока космического корабля"),
    ACTIVATE_SHIELDS("Активировать защитные щиты корабля"),
    DEACTIVATE_SHIELDS("Деактивировать защитные щиты"),
    LAUNCH_DRONES("Запустить разведывательные дроны"),
    ABORT_MISSION("Отменить текущую миссию"),
    INITIATE_REPAIR("Начать ремонт систем"),
    REPORT_STATUS("Отправить отчет о текущем состоянии систем"),
    ENGAGE_WARP_DRIVE("Включить варп-двигатель"),
    CALIBRATE_SENSORS("Калибровать сенсоры корабля"),
    EMERGENCY_LAND("Выполнить аварийную посадку");

    private final String description;
}
