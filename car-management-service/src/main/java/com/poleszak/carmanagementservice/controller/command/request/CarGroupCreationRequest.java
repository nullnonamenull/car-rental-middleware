package com.poleszak.carmanagementservice.controller.command.request;

import com.poleszak.carmanagementservice.model.enumerated.CarGroupVisibilityStatus;

public record CarGroupCreationRequest(String name,
                                      CarGroupVisibilityStatus visibilityStatus) {
}
