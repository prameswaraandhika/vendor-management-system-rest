package org.prameswaradev.vendormanagementsystem.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime now, String message) {
}
