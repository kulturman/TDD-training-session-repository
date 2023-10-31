package com.kulturman.climax;

import java.time.LocalDateTime;

public record Transaction(LocalDateTime date, int amount) {
}
